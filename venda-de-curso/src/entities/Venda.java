package entities;

import inheritance.Curso;

import java.time.LocalDate;

public class Venda {
    private Aluno aluno;
    private Curso curso;
    private LocalDate dataVenda;

    public Venda(Aluno aluno, Curso curso, LocalDate dataVenda) {
        this.aluno = aluno;
        this.curso = curso;
        this.dataVenda = dataVenda;
    }

    // Getters e Setters


    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}

