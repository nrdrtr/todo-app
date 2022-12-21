package todoapp.dataAccess;

import todoapp.entities.TodoSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoSchemaDao extends JpaRepository<TodoSchema, Integer> {
}

