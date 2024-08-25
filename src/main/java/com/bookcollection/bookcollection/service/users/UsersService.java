package com.bookcollection.bookcollection.service.users;

import com.bookcollection.bookcollection.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<Users>getAllUsers();
    Optional<Users>getUserById(Long id);
    Users createUser(Users user);
    Users updateUsers (Long id, Users user);
    void deleteUser(Long id);
}
