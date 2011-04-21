package br.com.jspace.util;

import org.apache.commons.codec.binary.Base64;

public class LinkUtil {
	
	public static String decodeBase64(String url) {
		return new String(Base64.decodeBase64(url.getBytes()));
	}

	public static String decodeInvertedUrl(String url) {
		StringBuilder newUrl = new StringBuilder(url);

		return newUrl.reverse().toString();
	}

	public static String reverteUrl(String url){
		StringBuilder sb = new StringBuilder(url);
		return sb.reverse().toString();
	}
	
	public static boolean isEncurtador(String protectedUrl) {
		if (protectedUrl.contains("http://encurtador.com")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isBaixeAquiFilmes(String protectedUrl){
		if (protectedUrl.contains("baixeaquifilmes.com/link/")){
			return true;
		}
		
		return false;
	}
	
}
