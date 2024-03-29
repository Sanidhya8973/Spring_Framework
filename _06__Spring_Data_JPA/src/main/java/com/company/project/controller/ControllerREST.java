package com.company.project.controller;

import java.util.List;

import com.company.project.exception.ExceptionController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.company.project.entity.User;
import com.company.project.service.UserServiceImp;
import org.springframework.http.*;

@RestController
@RequestMapping(path = "/rest")
public class ControllerREST {

    private final UserServiceImp userServiceImp;

    @Autowired
    public ControllerREST(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping(path = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUser(@RequestBody User user) {
        try {
            HttpStatus responseStatus = HttpStatus.CREATED;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-success", "value-success");
            User responseBody = userServiceImp.createUser(user);
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        } catch (Exception exception) {
            HttpStatus responseStatus = HttpStatus.BAD_REQUEST;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-failure", "value-failure");
            String responseBody = exception.getLocalizedMessage();
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        }
    }

    @GetMapping(path = "/users/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> readUser(@PathVariable(value = "id") Long id) {
        try {
            HttpStatus responseStatus = HttpStatus.OK;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-success", "value-success");
            User responseBody = userServiceImp.readUser(id);
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        } catch (Exception exception) {
            HttpStatus responseStatus = HttpStatus.NOT_FOUND;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-failure", "value-failure");
            String responseBody = exception.getLocalizedMessage();
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        }
    }

    @GetMapping(path = "/users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> readUsers() {
        try {
            HttpStatus responseStatus = HttpStatus.OK;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-success", "value-success");
            List<User> responseBody = userServiceImp.readUsers();
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        } catch (Exception exception) {
            HttpStatus responseStatus = HttpStatus.NOT_FOUND;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-failure", "value-failure");
            String responseBody = exception.getLocalizedMessage();
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        }
    }

    @PutMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        try {
            HttpStatus responseStatus = HttpStatus.ACCEPTED;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-success", "value-success");
            User responseBody = userServiceImp.updateUser(id, user);
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        } catch (Exception exception) {
            HttpStatus responseStatus = HttpStatus.NOT_FOUND;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-failure", "value-failure");
            String responseBody = exception.getLocalizedMessage();
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        }
    }

    @DeleteMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {
        HttpStatus responseStatus;
        HttpHeaders responseHeaders = new HttpHeaders();
        String responseBody;
        try {
            responseStatus = HttpStatus.GONE;
            responseHeaders.add("key-success", "value-success");
            responseBody = userServiceImp.deleteUser(id);
        } catch (Exception exception) {
            responseStatus = HttpStatus.NOT_FOUND;
            responseHeaders.add("key-failure", "value-failure");
            responseBody = exception.getLocalizedMessage();
        }
        return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
    }

    @PatchMapping(path = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> patchUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
        try {
            HttpStatus responseStatus = HttpStatus.GONE;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-success", "value-success");
            User responseBody = userServiceImp.patchUser(id, user);
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        } catch (Exception exception) {
            HttpStatus responseStatus = HttpStatus.NOT_FOUND;
            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.add("key-failure", "value-failure");
            String responseBody = exception.getLocalizedMessage();
            return ResponseEntity.status(responseStatus).headers(responseHeaders).body(responseBody);
        }
    }

}
