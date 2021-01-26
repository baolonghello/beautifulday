package com.eloancn.bt.generate.freeMarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * freemarker模板、内容合成工具类
 * FreeMarkerUtils
 * @version 1.0.0
 */
@SuppressWarnings("deprecation")
public class FreeMarkerUtils {


	private static final String UTF8 = "UTF-8";
	
	/**
	 * 指定内容和数据进行合并
	 * @param template
	 * @param obj
	 * @return
	 * @throws TemplateException
	 * @throws IOException
	 */
	public static String getResult(String template, Object obj) throws Exception{
		
		Configuration cfg = new Configuration();
		cfg.setTemplateLoader(new StringTemplateLoader(template));
		cfg.setDefaultEncoding(UTF8);
		cfg.setOutputEncoding(UTF8);
		try {
			Template templateobj = cfg.getTemplate("");
			templateobj.setEncoding(UTF8);
			StringWriter writer = new StringWriter();
			templateobj.process(obj, writer);;
			return writer.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}
	}


}
