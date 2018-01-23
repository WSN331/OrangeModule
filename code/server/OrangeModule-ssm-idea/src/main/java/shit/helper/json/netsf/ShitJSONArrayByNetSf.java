package shit.helper.json.netsf;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import shit.helper.json.ShitJSONArray;
import shit.helper.json.ShitJSONObject;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * 更据net.sf.json包来完成JSONArray
 * 
 * @author GongTengPangYi 依赖jar包：commons-beanutils, commons-collections,
 *         commons-lang, commons-logging, json-lib-jdk, ezmorph
 */
public class ShitJSONArrayByNetSf extends ShitJSONArray<JSONArray> {

	public ShitJSONArrayByNetSf() {
		super();
		jsonArray = new JSONArray();
	}

	public ShitJSONArrayByNetSf(JSONArray jsonArray) {
		super();
		this.jsonArray = jsonArray;
	}

	@Override
	public int size() {
		return jsonArray.size();
	}

	@Override
	public boolean isEmpty() {
		return jsonArray.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return jsonArray.contains(o);
	}

	@Override
	public Iterator iterator() {
		return jsonArray.iterator();
	}

	@Override
	public Object[] toArray() {
		return jsonArray.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {
		return jsonArray.toArray(a);
	}

	@Override
	public boolean add(Object value) {
		return jsonArray.add(changeJSONObject(value));
	}

	@Override
	public boolean remove(Object o) {
		return jsonArray.remove(o);
	}

	@Override
	public boolean addAll(Collection c) {
		for (Object o : c) {
			if (!add(o)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		if (c != null) {
			int offset = 0;
			for (Object o : c) {
				add(index + offset++, o);
			}
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		jsonArray.clear();
	}

	@Override
	public Object get(int index) {
		Object object = jsonArray.get(index);
		if (object instanceof JSONObject) {
			return new ShitJSONObjectByNetSf((JSONObject)object);
		} else if (object instanceof JSONArray) {
			return new ShitJSONArrayByNetSf((JSONArray)object);
		}
		return object;
	}

	@Override
	public Object set(int index, Object element) {
		return jsonArray.set(index, changeJSONObject(element));
	}

	@Override
	public void add(int index, Object element) {
		jsonArray.add(index, changeJSONObject(element));
	}

	private Object changeJSONObject(Object obj) {
		if (obj instanceof ShitJSONObject) {
			return ((ShitJSONObject) obj).getJSONObject();
		} else if (obj instanceof ShitJSONArray) {
			return ((ShitJSONArray)obj).getJSONArray();
		} else {
			return obj;
		}
	}

	@Override
	public Object remove(int index) {
		return jsonArray.remove(index);
	}

	@Override
	public int indexOf(Object o) {
		return jsonArray.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return jsonArray.lastIndexOf(o);
	}

	@Override
	public ListIterator listIterator() {
		return jsonArray.listIterator();
	}

	@Override
	public ListIterator listIterator(int index) {
		return jsonArray.listIterator(index);
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		return jsonArray.subList(fromIndex, toIndex);
	}

	@Override
	public boolean retainAll(Collection c) {
		return jsonArray.retainAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		return jsonArray.removeAll(c);
	}

	@Override
	public boolean containsAll(Collection c) {
		return jsonArray.containsAll(c);
	}

	@Override
	public ShitJSONArray<JSONArray> fromString(String str) {
		return new ShitJSONArrayByNetSf(JSONArray.fromObject(str));
	}

	@Override
	public String toString() {
		return jsonArray.toString();
	}

}
