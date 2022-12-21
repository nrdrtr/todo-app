package todoapp.controllers;

import todoapp.dataAccess.TodoSchemaDao;
import todoapp.entities.TodoSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo-schema")
public class TodoSchemaController {
    private TodoSchemaDao todoSchemaDao;

    @Autowired
    public TodoSchemaController(TodoSchemaDao todoSchemaDao) {
        this.todoSchemaDao = todoSchemaDao;
    }
    @GetMapping("/getAll")
    ResponseEntity<Object>  getAll() {
        List<TodoSchema> todoSchemas = todoSchemaDao.findAll();
        this.todoSchemaDao.findAll();
        return  new ResponseEntity<>(todoSchemaDao.findAll(),HttpStatus.OK);
    }
    @GetMapping("/getById/{id}")
    public Optional<TodoSchema> getSchema(@PathVariable ("id") int id) {
        return this.todoSchemaDao.findById(id);
    }

    @PostMapping("/save")
    ResponseEntity<String> save(@RequestBody TodoSchema todoSchema) {
        this.todoSchemaDao.save(todoSchema);
        return new ResponseEntity<>("kayıt başarılı", HttpStatus.OK);
    }
    @DeleteMapping("/deleteById/{id}")
    ResponseEntity<String> delete(@PathVariable("id") int id) {
        this.todoSchemaDao.deleteById(id);
        return new ResponseEntity<>(id+" numaralı iş başarıyla silindi", HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<HashMap<String, Object>> update(@PathVariable("id") int id, @RequestBody TodoSchema todoSchema) {
        Optional<TodoSchema> todoSchemaOptional = this.todoSchemaDao.findById(id);
        if (!todoSchemaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        todoSchema.setId(id);
        this.todoSchemaDao.save(todoSchema);
        HashMap<String, Object> hashmapExample = new HashMap<>();
        hashmapExample.put("message", "iş başarıyla güncellendi");
        return ResponseEntity.ok(hashmapExample);
    }
}
