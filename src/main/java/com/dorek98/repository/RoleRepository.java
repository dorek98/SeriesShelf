package com.dorek98.repository;

import com.dorek98.dto.RoleDto;
import com.dorek98.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

}
