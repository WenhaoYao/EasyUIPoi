package jxau.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import jxau.model.PageBean;
import jxau.model.User;
import jxau.util.QueryUtil;

public class UserDao {
	
	private QueryRunner queryRunner = new QueryUtil();
	
	public List<User> userList(PageBean pageBean) {
		try {
			StringBuffer sql = new StringBuffer("select * from t_user");
			List<User> result = null;
			if (pageBean != null) {
				sql.append(" limit ?, ?");
				Object[] objects = {pageBean.getStart(), pageBean.getRows()};
				result = queryRunner.query(sql.toString(), new BeanListHandler<User>(User.class), objects);
			} else {
				result = queryRunner.query(sql.toString(), new BeanListHandler<User>(User.class));
			}
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int userCount() {
		try {
			String sql = "select count(*) as total from t_user";
			return queryRunner.query(sql, new ScalarHandler<Number>()).intValue();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int deleteUser(int id) {
		try {
			String sql = "delete from t_user where id = ?";
			return queryRunner.update(sql,id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int addUser(User user) {
		try {
			String sql = "insert into t_user (name, phone, email, qq) values (?, ?, ?, ?)";
			Object[] objects = {user.getName(), user.getPhone(), user.getEmail(), user.getQq()};
			return queryRunner.update(sql, objects);
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
