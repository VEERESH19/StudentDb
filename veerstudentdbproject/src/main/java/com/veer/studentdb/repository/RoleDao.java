package com.veer.studentdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.veer.studentdb.entity.Role;

@Repository
public interface RoleDao extends CrudRepository<Role, String> {

}
