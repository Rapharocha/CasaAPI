package com.trabalho.casadeshow.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trabalho.casadeshow.api.model.Role;

public interface RoleRepository extends JpaRepository <Role,String> {

	Role findByNomeRole(String string);

}
