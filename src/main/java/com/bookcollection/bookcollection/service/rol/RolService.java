package com.bookcollection.bookcollection.service.rol;

import com.bookcollection.bookcollection.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Role> getAllRoles();
    Optional<Role> getRoleById(Long id);
    Role createRole(Role role);
    Role updateRole(Long id, Role role);
    void deleteRole(Long id);
}
