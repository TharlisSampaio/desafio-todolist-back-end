package br.com.desafio_todolist.service.impl;

import br.com.desafio_todolist.model.Todo;
import br.com.desafio_todolist.repository.TodoRepository;
import br.com.desafio_todolist.service.TodoService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ImplTodoService implements TodoService {

    private final TodoRepository todoRepository;

    public ImplTodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Todo> createTodo(Todo toCreateTodo) {
        todoRepository.save(toCreateTodo);
        return getAllTodo();
    }

    @Override
    public List<Todo> getAllTodo() {
        Sort sort = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return todoRepository.findAll(sort);
    }

    @Override
    public List<Todo> deleteTodo(Long id) {
        todoRepository.deleteById(id);
        return getAllTodo();
    }

    @Override
    public List<Todo> updateTodo(Long id, Todo toUpadateTodo) {
        var todoEntity = todoRepository.findById(id);

        if (todoEntity.isPresent()) {
            var todo = todoEntity.get();

            if(toUpadateTodo.getNome() != null){
                todo.setNome(toUpadateTodo.getNome());
            }
            if(toUpadateTodo.getDescricao() != null){
                todo.setDescricao(toUpadateTodo.getDescricao());
            }
            if(toUpadateTodo.getRealizado() != null){
                todo.setRealizado(toUpadateTodo.getRealizado());
            }
            if(toUpadateTodo.getPrioridade() != null){
                todo.setPrioridade(toUpadateTodo.getPrioridade());
            }
            todoRepository.save(todo);
        }

        return getAllTodo();
    }
}
