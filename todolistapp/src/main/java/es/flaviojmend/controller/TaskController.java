package es.flaviojmend.controller;

import es.flaviojmend.persistence.entity.Task;
import es.flaviojmend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by flavio.mendes on 22/08/2016.
 */

@RestController
@RequestMapping("/task")
public class TaskController {


    @Autowired
    TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Task> get() {
        return taskService.listTasks();
    }


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> post(@RequestBody Task task) {
        taskService.addTask(task);

        HttpHeaders httpHeaders = new HttpHeaders();

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> put(@RequestBody Task task) {
        HttpHeaders httpHeaders = new HttpHeaders();

        try {
            taskService.updateTask(task);
        } catch (Exception e) {
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody Task task) {
        taskService.deleteTask(task);
        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
    }

}