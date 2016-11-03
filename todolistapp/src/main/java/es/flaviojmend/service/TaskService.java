package es.flaviojmend.service;

import es.flaviojmend.persistence.entity.Task;
import es.flaviojmend.persistence.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by flavio.mendes on 23/08/2016.
 */
@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

    public void updateTask(Task task) throws Exception {
        if(task.getIdTask() == null) {
            throw new Exception("Não é possível atualizar uma task com Id nulo.");
        }

        taskRepository.save(task);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public Iterable<Task> listTasks(){
        return taskRepository.findAll();
    }

    public void deleteTask(Task task) {
        taskRepository.delete(task);
    }

}
