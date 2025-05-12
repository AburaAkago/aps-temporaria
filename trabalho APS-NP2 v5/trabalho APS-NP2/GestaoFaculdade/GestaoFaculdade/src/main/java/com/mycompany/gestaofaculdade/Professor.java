package com.mycompany.gestaofaculdade;

/**
 *
 * 
 */
class Professor {
    private String nome;
    private String cpf;

    public Professor(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    // Get do CPF e Nome do professor
    public String getCpf() {
        return cpf;
    }    
    
    public String getNome() {
        return nome;
    }
}
