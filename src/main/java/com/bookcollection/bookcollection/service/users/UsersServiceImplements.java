package com.bookcollection.bookcollection.service.users;
import com.bookcollection.bookcollection.entity.Users;
import com.bookcollection.bookcollection.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImplements implements UsersService  {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }
    @Override
    public Optional<Users> getUserById(Long id){
        return usersRepository.findById(id);
    }

    @Override
    public Users createUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users updateUsers(Long id, Users user) {
        Optional<Users> registeredUser = usersRepository.findById(id);
        if (registeredUser.isPresent()) {
            Users updatedUser = registeredUser.get();
            updatedUser.setUserName(user.getUserName());
            updatedUser.setEmail(user.getEmail());
            updatedUser.setUserPassword(user.getUserPassword());
            updatedUser.setUserRol(user.getUserRol());
            updatedUser.setRoles(user.getRoles());
            updatedUser.setActive(user.getActive());
            return usersRepository.save(updatedUser);
        } else {
            return null;
        }
    }
}


