package com.bookcollection.bookcollection.service.rol;


import com.bookcollection.bookcollection.entity.Role;
import com.bookcollection.bookcollection.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImplements implements RolService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role updateRole(Long id, Role role) {
        Optional<Role> existingRole = roleRepository.findById(id);
        if (existingRole.isPresent()) {
            Role updatedRole = existingRole.get();
            updatedRole.setNameRol(role.getNameRol());
            return roleRepository.save(updatedRole);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
