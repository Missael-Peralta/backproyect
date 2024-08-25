package com.bookcollection.bookcollection.controller;

import com.bookcollection.bookcollection.entity.Users;
import com.bookcollection.bookcollection.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @GetMapping
    public List<Users> getAllUsers(){
        return usersService.getAllUsers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById (@PathVariable Long id){
        Optional<Users> user = usersService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }
    @PostMapping
    public Users createUser (@RequestBody Users users){
        return usersService.createUser(users);
    }
    @PutMapping("/{id}/details")
    public ResponseEntity<Users> updateUserDetails (@PathVariable Long id, @RequestBody Users user){
        Users updatedUser = usersService.updateUsers(id, user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
        return  ResponseEntity.noContent().build();
    }
}
