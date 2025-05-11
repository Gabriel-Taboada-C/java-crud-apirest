package com.gabtaboada.apirest.apirest.Repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabtaboada.apirest.apirest.Entities.User;

public interface UserRepository extends JpaRepository <User, UUID>{

}
