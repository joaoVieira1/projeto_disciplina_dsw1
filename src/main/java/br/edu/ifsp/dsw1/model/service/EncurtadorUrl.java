package br.edu.ifsp.dsw1.model.service;

import java.util.HashMap;
import java.util.Map;

public class EncurtadorUrl {
	private final static Map<String, String> mapeadorUrl = new HashMap<>();
	private final static String dominio = "http://encurtador.dsw1/";
	private static int id = 100;
	
	
	public static String getUrlCurta(String urlLonga) {
		String urlCurta = dominio + id;
		mapeadorUrl.put(urlCurta, urlLonga);
		id++;
		return urlCurta;
	}
	
	public static String getUrlLonga(String urlCurta) {
		return mapeadorUrl.get(urlCurta);
	}
	
}
