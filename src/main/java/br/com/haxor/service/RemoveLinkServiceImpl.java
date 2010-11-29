package br.com.haxor.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;



public class RemoveLinkServiceImpl implements RemoveLinkService {

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

		if (protectedUrl.toLowerCase().contains("?url=")){
			url =  protectedUrl.substring(protectedUrl.lastIndexOf("?url="));
			url = url.replace("?url=","");
			
			if (protectedUrl.endsWith("=/")){
				Pattern p = Pattern.compile("(\\w)*=/");
				Matcher m = p.matcher(protectedUrl);
				m.find();
				url = m.group();
			}
		}else if (protectedUrl.contains("http://")){
			url = protectedUrl;
		}else{
			throw new IllegalArgumentException("Link inválido");
		}

		return url;
	}

}