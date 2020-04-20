package com.Course.RegisterationProgram.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Course.RegisterationProgram.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}

