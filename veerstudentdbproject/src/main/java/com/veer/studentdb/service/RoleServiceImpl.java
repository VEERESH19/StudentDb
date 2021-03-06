package com.veer.studentdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.veer.studentdb.Interface.RoleService;
import com.veer.studentdb.entity.Role;
import com.veer.studentdb.repository.RoleDao;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	public Role createNewRole(Role role) {
		return roleDao.save(role);
	}
}
