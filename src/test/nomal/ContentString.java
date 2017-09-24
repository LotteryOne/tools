package test.nomal;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;

public class ContentString {

	private static final Logger logger = Logger.getLogger(ContentString.class);

	public static final String cityRegion = "310000000000";

	public static final String CATEGORY = "categories";

	public static final String DATA = "data";

	public static final String ADD = "add";

	public static final String REDUCE = "reduce";

	public static final SimpleDateFormat YEAR = new SimpleDateFormat("yyyy");

	public static final SimpleDateFormat FORATE_DATE = new SimpleDateFormat(
			"yyyy-MM-dd");

	public static Map<String, String> dicMap = new HashMap<String, String>();

	private static final JsonConfig jsonConfig = new JsonConfig();

	private static final JsonConfig exclude = new JsonConfig();

	private static final DateMorpher dateMorpher = new DateMorpher(
			new String[] { "yyyy-MM-dd" });
	private static final TestBt myDateMorpher = new TestBt(
			new String[] { "yyyy-MM-dd" });
	
	
	public static final String BASEINFO_EXCEL = "/template/excel/baseInfo.xlsx";

	public static final String BED_CHANGE_EXCEL = "/template/excel/bedChangeInfo.xlsx";

	public static final String OLDER_LIVE_EXCEL = "/template/excel/olderliveInfo.xlsx";

	public static final String FLJG_OPER_EXCEL = "/template/excel/fljgOperationExcel.xlsx";

	public static final String FLJG_EMP_INFO = "/template/excel/fljgEmpInfo.xlsx";

	public static final String BLANCE_INFO_EXCEL = "/template/excel/blanceInfoExcel.xlsx";

	public static final String CHARGE_INFO_EXCEL = "/template/excel/chargeInfoExcel.xlsx";

	public ContentString() {
		jsonConfig.registerJsonValueProcessor(Date.class,
				new UtilJsonDateValueProcessor());
	}

	static {
		jsonConfig.registerJsonValueProcessor(Date.class,
				new UtilJsonDateValueProcessor());
		String handlerMappingsLocation = "com/wondersgroup/business/fljg/util/DicMap.properties";
		ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
		java.util.Properties mappings = null;
		try {
			mappings = PropertiesLoaderUtils.loadAllProperties(
					handlerMappingsLocation, classLoader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dicMap = new HashMap(mappings);
	}

	public static List<Map<String, Object>> getMapList(List list) {
		if (list == null)
			return null;
		List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();

		if (list.size() > 0) {
			Object content = list.get(0);
			Field[] fields = content.getClass().getDeclaredFields();
			for (Object obj : list) {
				Map<String, Object> map = new HashMap<String, Object>();
				for (Field field : fields) {
					try {

						PropertyDescriptor pd = new PropertyDescriptor(
								field.getName(), obj.getClass());
						Method getMethod = pd.getReadMethod();// 获得get方法
						Object o = getMethod.invoke(obj);
						map.put(field.getName(), o);
					} catch (Exception e) {
						logger.error(e.getMessage());
					}
				}
				mapList.add(map);
			}
		}
		return mapList;
	}

	public static String getJsonFromMap(Map<String, Object> map) {

		if (map != null) {
			JSONObject obj = JSONObject.fromObject(map);
			return obj.toString();
		} else {
			return "{}";
		}
	}

	/**
	 * the list element must be not null
	 * 
	 * @param list
	 * @param target
	 * @return List<target>
	 */
	public static List<Object> copyList(List<?> list, Class<?> target) {
		List<Object> data = new ArrayList<Object>();
		if (list == null || list.size() == 0) {
			return data;
		}
		for (Object obj : list) {
			try {
				Object oop = target.newInstance();
				BeanUtils.copyProperties(obj, oop);
				data.add(oop);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return data;
	}

	public static String createJsonWithDate(Object obj) {
		return JSONObject.fromObject(obj, jsonConfig).toString();
	}

	public static String createListJsonWithDate(List<?> list) {
		return JSONArray.fromObject(list, jsonConfig).toString();
	}

	public static String createJsonExcludeAttribute(Object obj, String[] att) {
		exclude.setExcludes(att);
		return JSONObject.fromObject(obj, exclude).toString();
	}

	public List getBeanListFromJsonData(String data, Class beanClass) {
		JSONArray jsonArray = JSONArray.fromObject(data);
		JSONUtils.getMorpherRegistry().registerMorpher(
				new DateMorpher(new String[] { "yyyy-MM-dd" }));
		List list = new ArrayList(jsonArray.size());
		for (Iterator iter = jsonArray.iterator(); iter.hasNext();) {
			JSONObject jsonObject = (JSONObject) iter.next();
			list.add(JSONObject.toBean(jsonObject, beanClass));
		}
		return list;
	}

//	@Deprecated
	public static Object createBeanWithDate(String json, Class<?> target) {
		JSONObject jsonObject = JSONObject.fromObject(json, jsonConfig);
		JSONUtils.getMorpherRegistry().registerMorpher(myDateMorpher);
		return JSONObject.toBean(jsonObject, target);
	}

//	public static String createPageJson(Page page) {
//		int total = page.getTotalSize();
//		List list = page.getResult();
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("total", total);
//		map.put("data", list);
//		return JSONObject.fromObject(map, jsonConfig).toString();
//	}

}