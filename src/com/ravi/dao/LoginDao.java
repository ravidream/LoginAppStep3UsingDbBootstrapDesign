package com.ravi.dao;

import com.ravi.model.Login;


/**
 * 
 * @author Ravi Thapa
 *
 */
public interface LoginDao {
	public Login authenticate(Login login);
}
