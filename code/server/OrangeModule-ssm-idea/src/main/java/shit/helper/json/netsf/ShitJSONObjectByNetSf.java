package shit.helper.json.netsf;

import net.sf.json.JSONObject;
import shit.helper.json.ShitJSONArray;
import shit.helper.json.ShitJSONObject;

import java.util.Set;

/**
 * 更据net.sf.json包来完成JSONObject
 * 
 * @author GongTengPangYi 依赖jar包：commons-beanutils, commons-collections,
 *         commons-lang, commons-logging, json-lib-jdk, ezmorph
 */
public class ShitJSONObjectByNetSf extends ShitJSONObject<JSONObject> {
	/*
	 * 不用JSONObject来from的属性类型
	 */
	private static final String TYPES = "java.lang.String; java.lang.Integer; "
			+ "java.lang.Long; java.lang.Float; java.lang.Boolean;";

	public ShitJSONObjectByNetSf() {
		super();
		jsonObject = new JSONObject();
	}

	public ShitJSONObjectByNetSf(JSONObject jsonObject) {
		super();
		this.jsonObject = jsonObject;
	}

	@Override
	public void put(String key, Object obj) {
		try {
			if (TYPES.indexOf(obj.getClass().getName()) >= 0) {
				jsonObject.put(key, obj);
			} else if (obj instanceof ShitJSONObject) {
				jsonObject.put(key, ((ShitJSONObject)obj).getJSONObject());
			} else if (obj instanceof ShitJSONArray) {
				jsonObject.put(key, ((ShitJSONArray)obj).getJSONArray());
			} else {
				jsonObject.put(key, JSONObject.fromObject(obj));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Object get(String key) {
		return jsonObject.get(key);
	}

	@Override
	public ShitJSONObject<JSONObject> getJSONObject(String key) {
		ShitJSONObjectByNetSf jobj = new ShitJSONObjectByNetSf();
		jobj.setJSONObject(jsonObject.getJSONObject(key));
		return jobj;
	}

	@Override
	public ShitJSONArray getJSONArray(String key) {
		ShitJSONArrayByNetSf array = new ShitJSONArrayByNetSf();
		array.setJSONArray(jsonObject.getJSONArray(key));
		return array;
	}

	@Override
	public void remove(String key) {
		jsonObject.remove(key);
	}

	@Override
	public Set<String> keySet() {
		return jsonObject.keySet();
	}

	@Override
	public String toString() {
		return jsonObject.toString();
	}

	@Override
	public Object toBean(Class<?> beanClass) {
		return JSONObject.toBean(jsonObject, beanClass);
	}

	@Override
	protected void fromObject1(Object obj) {
		jsonObject = JSONObject.fromObject(obj);
	}

}
