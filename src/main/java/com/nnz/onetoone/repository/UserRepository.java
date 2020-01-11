package com.nnz.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nnz.onetoone.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
