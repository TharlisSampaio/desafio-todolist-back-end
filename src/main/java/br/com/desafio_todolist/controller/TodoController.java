package br.com.desafio_todolist.controller;

import br.com.desafio_todolist.model.Todo;
import br.com.desafio_todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable("id") Long id){
        var todo = todoService.findById(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodo(){
        var listTodo = todoService.getAllTodo();
        return ResponseEntity.ok(listTodo);
    }

    @PostMapping
    public ResponseEntity<List<Todo>> createTodo(@RequestBody Todo toCreateTodo){
        var todoCreated = todoService.createTodo(toCreateTodo);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("")
                .buildAndExpand()
                .toUri();
        return ResponseEntity.created(location).body(todoCreated);
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<Todo>> updateTodo(@PathVariable("id") Long id, @RequestBody Todo toUpdateTodo){
        System.out.println("Executei o metodo updateTodo");
        var todoUpdated = todoService.updateTodo(id, toUpdateTodo);
        return ResponseEntity.ok(todoUpdated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Todo>> deleteTodo(@PathVariable("id") Long id){
        var todoList = todoService.deleteTodo(id);
        return ResponseEntity.ok(todoList);
    }
}
