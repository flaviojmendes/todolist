package es.flaviojmend.persistence.repo;

import es.flaviojmend.persistence.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, String> {



}

