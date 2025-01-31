package br.edu.ifsp.dsw1.model.service;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLValidator {
	 public static boolean isValidURL(String urlString) {
	        try {
	            URL url = new URL(urlString);
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            connection.setRequestMethod("HEAD");
	            connection.setConnectTimeout(3000);
	            connection.setReadTimeout(3000);
	            int responseCode = connection.getResponseCode();
	            return responseCode >= 200 && responseCode < 400;
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
