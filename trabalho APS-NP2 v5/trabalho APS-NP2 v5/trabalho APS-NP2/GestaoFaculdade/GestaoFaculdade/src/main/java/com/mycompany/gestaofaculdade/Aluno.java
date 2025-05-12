
package com.mycompany.gestaofaculdade;

/**
 *
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Aluno { //Variáveis e lista para armazenar as notas
    private String nome;
    private String cpf;
    private List<Double> notas = new ArrayList<>();

    public Aluno(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
    
    // Get para CPF, nome e notas
    public String getCpf() {
        return cpf;
    }
    
    public String getNome() {
        return nome;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void adicionarNota(double nota) {
        notas.add(nota);
    }
    
    // Método para calcular Media
    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}

