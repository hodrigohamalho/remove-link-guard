package br.com.jspace.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class LinkUtil {

	public static List<String> urlSeparator = new ArrayList<String>();
	
	/**
	 * Put the most embracing rules on top.
	 */
	static{
		urlSeparator.add("/?url=http://yess.me/ir/id/");
		urlSeparator.add("/?url=");
		urlSeparator.add("/ir/id/");
		urlSeparator.add("/?link=");
		urlSeparator.add("/?go!");
		urlSeparator.add("/filmesquentes/?");
		urlSeparator.add("/link/?");
		urlSeparator.add("/download/?");
		
		urlSeparator.add("/?d=");
		urlSeparator.add("/?");
	}
	
	public static String decodeBase64(String url) {
		if (url.contains("aHR0")){
			url = url.substring(url.indexOf("aHR0"));
		}
		
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
	
	public static String decodeAsciiLink(String asciiCoded){

		String[] ascii = new String[asciiCoded.length()/2];

		// Quebra a string com a sequencia de caracteres ascii em duplas de caracteres.
		int j = 0;
		for (int i = 0; i < asciiCoded.length() ; i +=2){
			ascii[j] = asciiCoded.substring(i, i+2);
			j++;
		}

		// Transforma essa sequencia de duplo caracteres em inteiros hexadecimais.
		List<Integer> ascDec = new ArrayList<Integer>();
		for (String s : ascii){
			ascDec.add(Integer.parseInt(s, 16));
		}


		// Transforma os hexadecimais em characteres, concatenando em uma string

		StringBuilder link = new StringBuilder();

		for (Integer i : ascDec){
			int nativeInt = i;

			link.append((char) nativeInt);
		}

		return link.toString();
	}
	
	public static boolean isEncurtador(String protectedUrl) {
		if (protectedUrl.contains("http://encurtador.com")) {
			return true;
		}
		
		return false;
	}
	
	public static boolean isProteLink(String protectedUrl){
		if (protectedUrl.contains("http://protelink.info")){
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
	
	public static boolean isVinXp(String protectedUrl){
		if (protectedUrl.contains("www.vinxp.com/download/d/")){
			return true;
		}
		
		return false;
	}
	
	public static String vinXpRemoveInvalidChars(String title){
		// Remove todos os caracteres invalidos da url
		title = title.replace(" &#8211;", "");
		title = title.replace("(","");
		title = title.replace(")","");
		title = title.replace("/","");
		title = title.replace(" ","-");
		title = title.toLowerCase();
		
		return title;
	}
}
