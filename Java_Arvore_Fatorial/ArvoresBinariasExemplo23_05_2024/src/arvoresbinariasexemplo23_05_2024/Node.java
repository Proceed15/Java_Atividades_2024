/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arvoresbinariasexemplo23_05_2024;

/**
 *
 * @author 0031432412016
 */
public class Node {
    int info;                   // Informação tipo inteiro
    Node left;                  // Filho à esquerda
    Node right;                 // FIlho à direita
    Node(int info) {            // Inicializa os atributos da classe
        this.info = info;       // Inicializa a informação com o parâmetro recebido
        this.left = null;       // Inicializa o filho à esquerda como vazio
        this.right = null;      // Inicializa o filho à direita como vazio
    }
}

