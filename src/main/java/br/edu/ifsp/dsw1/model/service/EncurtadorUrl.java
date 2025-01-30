package br.edu.ifsp.dsw1.model.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncurtadorUrl {
	private final static Map<String, String> mapeadorUrl = new HashMap<>();
	private final static String dominio = "http://encurtador.dsw1/";
	private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final Random RANDOM = new Random();	
	
	public static String getUrlCurta(String urlLonga) {
		
		
		int sufixoTamanho = RANDOM.nextInt(5) + 1; 
        StringBuilder sufixo = new StringBuilder(sufixoTamanho);
        
        for (int i = 0; i < sufixoTamanho; i++) {
        	sufixo.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
		
        String urlCurta = dominio + sufixo;
		mapeadorUrl.put(urlCurta, urlLonga);
		
		return urlCurta;
	}
	
	public static String getUrlLonga(String urlCurta) {
		return mapeadorUrl.get(urlCurta);
	}
	
}
