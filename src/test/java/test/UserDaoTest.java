package test;

import org.junit.Test;

import jxau.dao.UserDao;

public class UserDaoTest {
	
	UserDao userdao = new UserDao();
	
	@Test
	public void testUserList() {
		System.out.println(userdao.userList(null).toString());
	}

}
