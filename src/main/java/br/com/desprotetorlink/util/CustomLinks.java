package br.com.desprotetorlink.util;

import br.com.desprotetorlink.service.RemoveLinkServiceImpl;

public class CustomLinks {

	private static final String VINXP = "www.vinxp.com/download/d/";
	private static final String CLUBE_DO_DOWNLOAD = "http://protetor.clubedodownload.info/";
	private static final String BAIXE_DE_TUDO = "http://link.baixedetudo.net/";
	
	public boolean isCustomLink(String protectedUrl) {
		if (isVinXp(protectedUrl) || isClubeDoDownload(protectedUrl) || isBaixedeTudo(protectedUrl)){
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
			String encryptedUrl = getEncryptedUrl(protectedUrl, CLUBE_DO_DOWNLOAD);
			protectedUrl = LinkUtil.decodeReverseUrl(encryptedUrl);
		}else if (isBaixedeTudo(protectedUrl)){
			String encryptedUrl = getEncryptedUrl(protectedUrl, BAIXE_DE_TUDO);
			protectedUrl = LinkUtil.decodeReverseUrl(encryptedUrl);
		}
		
		return protectedUrl;
	}

	private boolean isBaixedeTudo(String protectedUrl) {
		return protectedUrl.contains(BAIXE_DE_TUDO) ? true : false;
	}

	private String getEncryptedUrl(String protectedUrl, String linkSource) {
		int startIndex = linkSource.length()-1;
		int endIndex = protectedUrl.length()-4;
		
		String encryptedUrl = protectedUrl.substring(startIndex, endIndex);
		return encryptedUrl;
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
