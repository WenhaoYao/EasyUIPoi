package jxau.util;

import java.util.List;

import org.json.JSONArray;

import jxau.model.User;

public class JsonUtil {
	
	public static JSONArray JsonFomatter(List<User> list) {
		/*JSONArray object = new JSONArray(list);*/
		JSONArray array = new JSONArray(list);
		/*for (User users : list) {
			JSONObject user = new JSONObject();
			user.put("id", users.getId());
			user.put("name", users.getName());
			user.put("phone", users.getPhone());
			user.put("email", users.getEmail());
			user.put("qq", users.getQq());
			array.put(user);
		}*/
		/*JSONObject object = new JSONObject();
		object.put("Users", array);*/
		return array;
	}
}
