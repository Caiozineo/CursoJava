package repositories;

import java.util.List;

public interface Repositorio<T> {
    void adicionar(T obj);
    void atualizar(T obj);
    void remover(T obj);
    T buscarPorId(int id);
    List<T> buscarTodos();
}

