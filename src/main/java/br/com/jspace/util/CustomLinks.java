package br.com.jspace.util;

public class CustomLinks {

	public static final String VINXP = "www.vinxp.com/download/d/";

	public static boolean isVinXp(String protectedUrl){
		return protectedUrl.contains(VINXP) ? true : false;
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


	public static boolean isCustomLink(String protectedUrl) {
		if (protectedUrl.contains(VINXP)){
			return true;
		}
		
		return false;
	}

}
