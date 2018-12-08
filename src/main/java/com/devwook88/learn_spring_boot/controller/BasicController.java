package com.devwook88.learn_spring_boot.controller;

import com.devwook88.learn_spring_boot.model.Todo;
import com.devwook88.learn_spring_boot.model.TodoResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/basic")
public class BasicController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/todo")
    public Todo basic() {
        return new Todo(counter.incrementAndGet(), "라면사오기");
    }

    @RequestMapping(value = "/todop", method = RequestMethod.POST)
    public Todo postBasic(@RequestParam(value = "todoTitle") String todoTitle) {
        return new Todo(counter.incrementAndGet(), todoTitle);
    }

    @RequestMapping(value = "/todor", method = RequestMethod.POST)
    public ResponseEntity<Todo> postBasicResponseEntity(@RequestParam(value = "todoTitle") String todoTitle) {
        return new ResponseEntity(new Todo(counter.incrementAndGet(), todoTitle), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/todoh", method = RequestMethod.GET)
    public ResponseEntity<TodoResource> geth(@RequestParam(value = "todoTitle") String todoTitle) {
        TodoResource todoResource = new TodoResource(todoTitle);
        todoResource.add(linkTo(methodOn(BasicController.class).geth(todoTitle)).withSelfRel());

        return new ResponseEntity(todoResource, HttpStatus.OK);
    }

    @RequestMapping(value = "/todos/{todoId}", method = RequestMethod.GET)
    public Todo getPath(@PathVariable int todoId) {
        // pr
        Todo todo1 = new Todo(1L, "문서쓰기");
        Todo todo2 = new Todo(2L, "공부하기");
        Todo todo3 = new Todo(3L, "잠자기");

        Map<Integer, Todo> todoMap = new HashMap<>();
        todoMap.put(1, todo1);
        todoMap.put(2, todo2);
        todoMap.put(3, todo3);

        return todoMap.get(todoId);
    }
}
