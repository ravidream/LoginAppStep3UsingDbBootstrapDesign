package com.ravi.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ravi.dao.LoginDao;
import com.ravi.dbutil.DBConnection;
import com.ravi.model.Login;

/**
 * 
 * @author Ravi Thapa
 *
 */
public class LoginDaoImpl implements LoginDao{
	
	DBConnection dbConnection = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection con = null;
	
	@Override
	public Login authenticate(Login login) {
		dbConnection = new DBConnection();
		Login loginModel= new Login();
		try {
			con = dbConnection.getConnection();
			ps = con.prepareStatement("SELECT * FROM LOGIN login where login.username = ? and login.password = ?");
			ps.setString(1, login.getUsername());
			ps.setString(2, login.getPassword());
			rs = ps.executeQuery();			
			
			while(rs.next()){
				loginModel.setResult(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally {
			if (con != null) {
				dbConnection.close(con);
			}
			if (ps != null) {
				dbConnection.close(ps);
			}
			if (rs != null) {
				dbConnection.close(rs);
			}
		}//END OF FINALLY
		return loginModel;
	}

}
