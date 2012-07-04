package br.com.desprotetorlink.service;

public interface RemoveLinkService {
	
	String breakUrl(String protectedUrl) throws Exception;
	
	String parseUrl(String protectedUrl);
	
}
