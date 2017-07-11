package com.example.demo.Repositories;

import com.example.demo.Models.Role;
import org.springframework.data.repository.CrudRepository;
/**
 * Created by daylinhenry on 7/11/17.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRole(String role);
}
