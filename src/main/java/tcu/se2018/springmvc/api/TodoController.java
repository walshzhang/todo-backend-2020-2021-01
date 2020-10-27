package tcu.se2018.springmvc.api;

import org.springframework.web.bind.annotation.*;
import tcu.se2018.springmvc.domain.Todo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("http://localhost:8081")
public class TodoController {
    private List<Todo> todos;

    public TodoController() {
        todos = new ArrayList<>();
    }

    @GetMapping("/api/todos")
    public List<Todo> listAll() {
        return todos;
    }

    @PostMapping("/api/todos")
    public Todo create(@RequestBody Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        todo.setCreateDate(LocalDateTime.now());
        todo.setDone(false);
        todos.add(todo);
        return todo;
    }

    @DeleteMapping("/api/todos/{id}")
    public void removeById(@PathVariable String id) {
        this.todos.removeIf(todo -> id.equals(todo.getId()));
    }

    @PutMapping("/api/todos/{id}/toggle")
    public void update(@PathVariable String id) {
        this.todos.forEach(todo -> {
            if (todo.getId().equals(id)) {
                todo.setDone(!todo.isDone());
            }
        });
    }
}
