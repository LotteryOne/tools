package com.tappe.json;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

public class UtilJsonDateValueProcessor implements JsonValueProcessor {

	private String format = "yyyy-MM-dd";

	public UtilJsonDateValueProcessor() {
		super();
	}

	public UtilJsonDateValueProcessor(String format) {
		super();
		this.format = format;
	}

	public Object processArrayValue(Object paramObject,
			JsonConfig paramJsonConfig) {
		return process(paramObject);
	}

	public Object processObjectValue(String paramString, Object paramObject,
			JsonConfig paramJsonConfig) {
		return process(paramObject);
	}

	private Object process(Object value) {
		if (value instanceof Date) {
			if (format == null) {
				return ContentString.FORATE_DATE.format(value);
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.CHINA);    
	            return sdf.format(value);  
			}
		}
		return value == null ? "" : value.toString();
	}

}
