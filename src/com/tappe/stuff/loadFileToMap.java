package com.tappe.stuff;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ClassUtils;

public class loadFileToMap {
	public static void main(String[] args) throws IOException {
		String handlerMappingsLocation = "test/nomal/bu.hahah";
		ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
		java.util.Properties mappings = PropertiesLoaderUtils
				.loadAllProperties(handlerMappingsLocation, classLoader);
		Map handlerMappings = new HashMap(mappings);
		Set set = handlerMappings.keySet();
		for (Object object : set) {
			System.out.println(object + ">>>>" + handlerMappings.get(object));

		}
	}
}
