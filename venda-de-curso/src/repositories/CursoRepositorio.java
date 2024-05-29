package repositories;

import inheritance.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepositorio implements Repositorio<Curso> {
    private List<Curso> cursos = new ArrayList<>();

    @Override
    public void adicionar(Curso curso) {
        cursos.add(curso);
    }

    @Override
    public void atualizar(Curso curso) {
        int index = buscarIndexPorId(curso.getId());
        if (index >= 0) {
            cursos.set(index, curso);
        }
    }

    @Override
    public void remover(Curso curso) {
        int index = buscarIndexPorId(curso.getId());
        if (index >= 0) {
            cursos.remove(index);
        }
    }

    @Override
    public Curso buscarPorId(int id) {
        for (Curso curso : cursos) {
            if (curso.getId() == id) {
                return curso;
            }
        }
        return null;
    }

    @Override
    public List<Curso> buscarTodos() {
        return new ArrayList<>(cursos);
    }

    private int buscarIndexPorId(int id) {
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }
}
