package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Variáveis para armazenar o resultado do sorteio, a pontuação do jogador
    private var resultado = 0
    private var score = 0

    // Elementos da interface do usuário
    private lateinit var txtResultado: TextView
    private lateinit var btnNovo: Button
    private lateinit var txtNumerosSorteados: TextView

    // Lista para armazenar os números sorteados
    private val numerosSorteados = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Vincula elementos da interface do usuário às variáveis
        txtResultado = findViewById(R.id.txtResultado)
        btnNovo = findViewById(R.id.btnNovo)
        txtNumerosSorteados = findViewById(R.id.txtNumerosSorteados)

        // Inicia um novo jogo quando a atividade é criada
        novoJogo()
    }

    // Inicia um novo jogo: exibe a mensagem, gera um novo número aleatório e oculta o botão
    private fun novoJogo(){
        txtResultado.text = "Par ou Impar?"
        resultado = Random.nextInt(0, 10)
        btnNovo.visibility = View.INVISIBLE
    }

    // Função chamada quando o botão "Novo Jogo" é clicado
    fun novoJogo(view: View){
        novoJogo()
    }

    // Função chamada quando um botão de jogada é clicado
    fun jogada(view: View){
        // Verifica se a escolha do jogador está correta
        if(resultado % 2 == view.tag.toString().toInt()) {
            // Incrementa a pontuação se a escolha estiver correta e o botão Novo Jogo estiver invisível
            if(btnNovo.visibility == View.INVISIBLE) {
                score++
            }
        }

        // Adiciona o número sorteado à lista
        numerosSorteados.add(resultado)
        // Atualiza a exibição da lista de números sorteados
        exibirNumerosSorteados()

        // Atualiza o título da atividade com a pontuação do jogador
        title = "Score: $score"
        // Exibe o resultado atual
        txtResultado.text = "$resultado"

        // Torna o botão Novo Jogo visível
        btnNovo.visibility = View.VISIBLE
    }

    // Atualiza a exibição da lista de números sorteados
    private fun exibirNumerosSorteados() {
        val numerosFormatados = numerosSorteados.joinToString("- ")
        txtNumerosSorteados.text = "Números sorteados: $numerosFormatados"
    }
}
