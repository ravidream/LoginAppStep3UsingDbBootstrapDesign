package com.ravi.services.impl;

import com.ravi.dao.LoginDao;
import com.ravi.dao.impl.LoginDaoImpl;
import com.ravi.model.Login;
import com.ravi.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	LoginDao loginDao = null;
	@Override
	public Login authenticate(Login login) {
		loginDao = new LoginDaoImpl();
		return loginDao.authenticate(login);
	}

}
