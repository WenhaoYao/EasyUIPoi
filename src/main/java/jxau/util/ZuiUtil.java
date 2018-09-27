package jxau.util;

import org.json.JSONArray;
import org.json.JSONObject;

import jxau.model.Page;

public class ZuiUtil {
	public static JSONObject Zui(JSONArray array, int toal, int page) {
		JSONObject jsonObject = new JSONObject();
		Page pager = new Page(page, toal, 10);
		JSONObject object = new JSONObject();
		object.put("page", pager.getPage());
		object.put("recTotal", pager.getRecTotal());
		object.put("recPerPage", pager.getRecPerPage());
		jsonObject.put("result", "success");
		jsonObject.put("data", array);
		jsonObject.put("pager", object);
		return jsonObject;
	}
}
