package test;

import org.junit.Test;

import jxau.model.User;
import jxau.util.ReflectUtil;

public class ReflectTest {

	@Test
	public void test() throws Exception {
		User user = new User("yaowenhao", "15179495910", "1007829579@qq.com", "1007829579");
		Object[] objects = ReflectUtil.getEntityValue(user);
		for (Object object : objects) {
			System.out.println(object);
		}
	}

}
