package com.kenfor.demo.base;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class StaticFreemarker {
	private static Configuration freemarkerCfg = null;
	private static final String basePath = "WEB-INF/templates/";
	static {
		freemarkerCfg = new Configuration();
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
	}

	/**
	 * 初始化数据域，讲session和request中的值写入map
	 * 
	 * @param request
	 * @return map
	 */
	public static Map<String, Object> initMap(HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();

		HttpSession session = request.getSession();
		Enumeration<String> attrNames = session.getAttributeNames();
		while (attrNames.hasMoreElements()) {
			String attrName = attrNames.nextElement();
			map.put(attrName, session.getAttribute(attrName));
		}

		Enumeration<String> attrNames2 = request.getAttributeNames();
		while (attrNames2.hasMoreElements()) {
			String attrName = attrNames2.nextElement();
			map.put(attrName, request.getAttribute(attrName));
		}

		map.put("base", request.getContextPath());
		return map;
	}

	public static void init(HttpServletRequest request, String ftl,
			String htmlName, String fileName) {
		freemarkerCfg.setServletContextForTemplateLoading(request.getSession()
				.getServletContext(), basePath + fileName);
		BufferedWriter buff = null;
		Writer out = null;
		try {
			Template template = freemarkerCfg.getTemplate(ftl);
			template.setEncoding("UTF-8");
			String path = request.getSession().getServletContext()
					.getRealPath("/");
			buff = new BufferedWriter(new FileWriter(path + htmlName));
			File htmlFile = new File(path + htmlName);
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "UTF-8"));

			template.process(initMap(request), out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void init(HttpServletRequest request, String ftl,
			String htmlName) {
		freemarkerCfg.setServletContextForTemplateLoading(request.getSession()
				.getServletContext(), basePath);
		BufferedWriter buff = null;
		Writer out = null;
		try {
			Template template = freemarkerCfg.getTemplate(ftl);
			template.setEncoding("UTF-8");
			String path = request.getSession().getServletContext()
					.getRealPath("/");
			buff = new BufferedWriter(new FileWriter(path + htmlName));
			File htmlFile = new File(path + htmlName);
			out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(htmlFile), "UTF-8"));

			template.process(initMap(request), out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				buff.close();
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}