package com.veer.studentdb.Interface;

import com.veer.studentdb.entity.User;

public interface UserControllerIntrf {

	public void initRoleAndUser();

	public User registerNewUser(User user);

	public String forAdmin();

	public String forUser();

}
