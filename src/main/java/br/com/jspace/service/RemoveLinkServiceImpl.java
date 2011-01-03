package br.com.jspace.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;



public class RemoveLinkServiceImpl implements RemoveLinkService {
	
	String BEETWEN_QUERY_AND_EQUALS = "\\?[\\w]++\\=";
	String HTTP_ASCII = "687474703";

	public String breakUrl(String protectedUrl) {
		String url = "";
		
		if (protectedUrl.trim().contains(" ")){
			throw new IllegalArgumentException("Link inválido");
		}
		
		url = parseUrl(protectedUrl.trim());
		if (url.endsWith("=/")){
			url = decodeBase64Url(url);
		}else if (url.contains("//:ptth")){
			url = decodeInvertedUrl(url);
		}else if (url.startsWith(HTTP_ASCII)){
			url = decodeAsciiLink(url);
		}

		return url;
	}

	private String decodeBase64Url(String url){
		return new String(Base64.decodeBase64(url.getBytes()));
	}

	private String decodeInvertedUrl(String url){
		StringBuilder newUrl = new StringBuilder(url);

		return newUrl.reverse().toString();
	}

	private  String parseUrl(String protectedUrl){
		String url = "";

		
		if (!isASimpleProtectedUrl(protectedUrl) && containsSomethingBetweenQueryAndEquals(protectedUrl)){
			url = getStringAfterQueryAndEquals(protectedUrl);
			
			if (protectedUrl.endsWith("=/")){
				Pattern p = Pattern.compile("(\\w)*=/");
				Matcher m = p.matcher(protectedUrl);
				m.find();
				url = m.group();
			}
		}else if (protectedUrl.contains("http://")){
			url = protectedUrl;
		}else if (!protectedUrl.contains("http://")){
			throw new IllegalArgumentException("Url no formato inválido. 'necessita de http://'");
		}else{
			throw new IllegalArgumentException("Link inválido");
		}

		return url;
	}

	private boolean isASimpleProtectedUrl(String protectedUrl){
		boolean simpleProtectedUrl = false;
		
		int i = StringUtils.countMatches(protectedUrl, "http://");
		
		if (i == 1 && (protectedUrl.contains(":ptth") || protectedUrl.contains(HTTP_ASCII))){
			simpleProtectedUrl = false;
		}else if (i == 1){
			simpleProtectedUrl = true;
		}
		
		return simpleProtectedUrl;
	}
	
	private boolean containsSomethingBetweenQueryAndEquals(String protectedUrl){
		Pattern p = Pattern.compile(BEETWEN_QUERY_AND_EQUALS);
		Matcher m = p.matcher(protectedUrl.toLowerCase());
		
		if (m.find()){
			return true;
		}
		
		return false;
	}
	
	private String getStringAfterQueryAndEquals(String protectedUrl){
		String url = "";
		String param = "";
		
		Pattern p = Pattern.compile("\\?[\\w]++\\=");
		Matcher m = p.matcher(protectedUrl);
		
		while(m.find()){
			param = m.group();
			break;
		}
		
		url = protectedUrl.substring(protectedUrl.indexOf(param) + param.length());
		
		return url;
	}
	
	private String decodeAsciiLink(String protectedUrl){
		String[] ascii = new String[protectedUrl.length()/2];
		
		// Quebra a string com a sequencia de caracteres ascii em duplas de caracteres.
		int j = 0;
		for (int i = 0; i < protectedUrl.length() ; i +=2){
			ascii[j] = protectedUrl.substring(i, i+2);
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
}