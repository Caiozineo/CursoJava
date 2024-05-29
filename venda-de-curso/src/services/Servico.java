package services;

import java.util.List;

public interface Servico<T> {
    void adicionar(T obj);
    void atualizar(T obj);
    void remover(T obj);
    T buscarPorId(int id);
    List<T> buscarTodos();
}

