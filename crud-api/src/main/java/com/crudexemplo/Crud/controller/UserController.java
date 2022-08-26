package com.crudexemplo.Crud.controller;

import com.crudexemplo.Crud.dto.person.PersonPostRequestBody;
import com.crudexemplo.Crud.dto.person.PersonResponse;
import com.crudexemplo.Crud.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<PersonResponse> createUser(@Valid @RequestBody PersonPostRequestBody personPostRequestBody) {
        return new ResponseEntity<>(userService.create(personPostRequestBody), HttpStatus.CREATED);
    }

    @GetMapping
    public List<PersonResponse> getAll() {
        return userService.findAll();
    }

//    @GetMapping(path = "/find/id/{id}")
//    public ResponseEntity<PersonResponse> findUserById(@PathVariable Long id) {
//        return ResponseEntity.ok(userService.findById(id));
//    }
//
//    @GetMapping(path = "/find/name/{name}")
//    public ResponseEntity<List<PersonResponse>> findUserByName(@PathVariable String name) {
//        return ResponseEntity.ok(userService.findByName(name));
//    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>(ACCEPTED);
    }

//    @PutMapping(path = "replace/{id}")
//    public ResponseEntity<Void> editUser(@RequestBody PersonPutRequestBody personPutRequestBody) {
//        userService.edit(personPutRequestBody);
//        return new ResponseEntity<>(ACCEPTED);
//    }

}
