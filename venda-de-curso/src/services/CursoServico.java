package services;

import inheritance.Curso;
import repositories.CursoRepositorio;
import repositories.Repositorio;

import java.util.List;

public class CursoServico implements Servico<Curso> {
    private Repositorio<Curso> repositorio;

    public CursoServico(Repositorio<Curso> repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void adicionar(Curso curso) {
        repositorio.adicionar(curso);
    }

    @Override
    public void atualizar(Curso curso) {
        repositorio.atualizar(curso);
    }

    @Override
    public void remover(Curso curso) {
        repositorio.remover(curso);
    }

    @Override
    public Curso buscarPorId(int id) {
        return repositorio.buscarPorId(id);
    }

    @Override
    public List<Curso> buscarTodos() {
        return repositorio.buscarTodos();
    }
}

