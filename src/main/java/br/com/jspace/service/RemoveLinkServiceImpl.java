package br.com.jspace.service;

import org.apache.commons.codec.binary.Base64;

import br.com.jspace.util.LinkUtil;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class RemoveLinkServiceImpl implements RemoveLinkService {

	String BEETWEN_QUERY_AND_EQUALS = "\\?[\\w]++\\=";
	String BEETWEN_QUERY_AND_EXCLAMATION = "\\?[\\w]++\\!";
	String HTTP_ASCII = "687474703";

	public String breakUrl(String protectedUrl) {
		String url = "";

		validate(protectedUrl);

		url = parseUrl(protectedUrl.trim());

		if (url.startsWith(HTTP_ASCII)) {
			url = LinkUtil.decodeAsciiLink(url);
		} else if (Base64.isArrayByteBase64(url.getBytes())) {
			url = LinkUtil.decodeBase64(url);
		}
		
		if (url.endsWith("//:ptth")) {
			url = LinkUtil.decodeInvertedUrl(url);
		}

		return url;
	}

	private void validate(String protectedUrl) {
		if (protectedUrl.trim().contains(" ")) {
			throw new IllegalArgumentException("Link inválido");
		} else if (!protectedUrl.contains("http://")) {
			throw new IllegalArgumentException("Url no formato inválido. 'necessita de http://'");
		}
	}

	public String parseUrl(String protectedUrl) {
		String url = "";

		for (String urlSeparator : LinkUtil.urlSeparator){
			if (protectedUrl.contains(urlSeparator) && urlSeparator != "/?"){
				int urlStart = protectedUrl.indexOf(urlSeparator);
				url = protectedUrl.substring(urlStart + urlSeparator.length());
				break;
			}
		}
		
		return url;
	}
}