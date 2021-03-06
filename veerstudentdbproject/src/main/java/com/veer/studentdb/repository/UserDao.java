package com.veer.studentdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veer.studentdb.entity.User;

@Repository
public interface UserDao extends CrudRepository<User, String> {
}
