package com.project.construction.service;

import com.project.construction.modal.AllUserModal;
import com.project.construction.modal.EndUserModal;

public interface EndUserService {
	

	public Integer createUser(EndUserModal endUserModal, String password);
	
	public EndUserModal getUser(Integer id);
	
	public EndUserModal login(String email, String password) throws Exception;
	
	public AllUserModal getAllUsers();

	public Integer deleteUser(Integer id);
	

}
