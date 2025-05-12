
package com.mycompany.gestaofaculdade;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
/**
 *
 * 
 */
public class SalvarCSV {
    public static void salvarProfessores(List<Professor> professores) { // metodo publico e estatico que recebe a lista [professores]
        // cria ou sobrescreve o objeto [PrintWriter] que escreve em arquivos de texto
        try (PrintWriter writer = new PrintWriter(new File("professores.csv"))) {
            writer.println("Nome,CPF"); //Escreve a primeira linha que é o cabeçalho
            for (Professor prof : professores) { //for-each para percorrer todos os objetos [Professor] na lista
                writer.println(prof.getNome() + "," + prof.getCpf());
            } // Para cada [Professor], dá um [getNome]+coloca virgula+[getCpf] e concatena tudo numa linha do arquivo
              // Cada [printIn] escreve uma nova linha no arquivo
            JOptionPane.showMessageDialog(null, "Professores salvos com sucesso!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar professores.");
        }
    }

    public static void salvarAlunos(List<Aluno> alunos) { //Método que recebe Aluno da lista de alunos
        try (PrintWriter writer = new PrintWriter(new File("alunos.csv"))) { //Escreve num arquivo de texto
            writer.println("Nome,CPF,Notas"); //Cabeçalho do arquivo de texto
            for (Aluno aluno : alunos) { // loop para percorrar a lista toda
                String notasStr = aluno.getNotas().stream() //Pega a lista de notas do aluno e transofrma em uma única string e [.stream] transforma em um fluxo de dados
                    .map(n -> String.format("%.2f", n)) //formata cada nota pra 2 casas decimais depois da virgula
                    .collect(Collectors.joining(";")); //junta tudo em uma unica string
                // Exemplo: Lisa,84257486,8.50;9.10;4
                writer.println(aluno.getNome() + "," + aluno.getCpf() + "," + notasStr); //pega nome, cpf e nota do aluno e escreve no arquivo CSV
            }
            JOptionPane.showMessageDialog(null, "Alunos salvos com sucesso!");
        } catch (FileNotFoundException e) { //file not found = exception para arquivo não encontrado
            JOptionPane.showMessageDialog(null, "Erro ao salvar alunos.");
        }
    }
    // Os comentarios de [salvarAlunos] servem para esse também.
    public static void salvarCursos(List<Curso> cursos) {
        try (PrintWriter writer = new PrintWriter(new File("cursos.csv"))) {
            writer.println("Curso,Professor,Alunos");
            for (Curso curso : cursos) {
                String alunosNomes = curso.getAlunos().stream()
                    .map(Aluno::getNome)
                    .collect(Collectors.joining(";"));
                writer.println(curso.getNome() + "," + curso.getProfessor().getNome() + "," + alunosNomes);
            }
            JOptionPane.showMessageDialog(null, "Cursos salvos com sucesso!");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar cursos.");
        }
    }
}
