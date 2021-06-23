package com.veer.studentdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.veer.studentdb.Interface.RoleControllerIntr;
import com.veer.studentdb.Interface.RoleService;
import com.veer.studentdb.entity.Role;

@RestController
public class RoleController implements RoleControllerIntr {

	@Autowired
	private RoleService roleService;

	@PostMapping({ "/createNewRole" })
	public Role createNewRole(@RequestBody Role role) {
		System.out.println("New Role is Created.................");
		return roleService.createNewRole(role);
	}
}
