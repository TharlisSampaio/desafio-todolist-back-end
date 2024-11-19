package br.com.desafio_todolist.service;

import br.com.desafio_todolist.model.Todo;

import java.util.List;

public interface TodoService {
    Todo findById(Long id);
    List<Todo> createTodo(List<Todo> toCreateTodo);
    List<Todo> getAllTodo();
    List<Todo> deleteTodo(Long id);
    List<Todo> updateTodo(Long id, Todo toUpdateTodo);

}
