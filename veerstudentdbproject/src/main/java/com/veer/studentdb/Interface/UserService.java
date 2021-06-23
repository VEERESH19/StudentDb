package com.veer.studentdb.Interface;

import com.veer.studentdb.entity.User;

public interface UserService {

	public void initRoleAndUser();

	public User registerNewUser(User user);

}
