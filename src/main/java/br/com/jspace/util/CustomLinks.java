package br.com.jspace.util;

import br.com.jspace.service.RemoveLinkServiceImpl;

public class CustomLinks {

	private static final String VINXP = "www.vinxp.com/download/d/";
	private static final String CLUBE_DO_DOWNLOAD = "http://protetor.clubedodownload.info/";
	
	public boolean isCustomLink(String protectedUrl) {
		if (isVinXp(protectedUrl) || isClubeDoDownload(protectedUrl)){
			return true;
		}
		
		return false;
	}
	
	public String decryptCustomProtectors(String protectedUrl) {
		if (isVinXp(protectedUrl)){
			String encryptedTitle = new RemoveLinkServiceImpl().parseUrl(protectedUrl.trim());
			String downloadTitle = LinkUtil.decodeAsciiLink(encryptedTitle);
			downloadTitle = vinXpRemoveInvalidChars(downloadTitle);
			protectedUrl = "http://www.vinxp.com/"+downloadTitle;
		}else if (isClubeDoDownload(protectedUrl)) {
			int startIndex = CustomLinks.CLUBE_DO_DOWNLOAD.length()-1;
			int endIndex = protectedUrl.length()-4;
			
			String encryptedUrl = protectedUrl.substring(startIndex, endIndex);
			System.out.println(encryptedUrl);
			return LinkUtil.decodeReverseUrl(encryptedUrl);
		}
		
		
		return protectedUrl;
	}

	
	private boolean isClubeDoDownload(String protectedUrl){
		return protectedUrl.contains(CLUBE_DO_DOWNLOAD) ? true : false;
	}
	
	public boolean isVinXp(String protectedUrl){
		return protectedUrl.contains(VINXP) ? true : false;
	}
	
	private String vinXpRemoveInvalidChars(String title){
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
