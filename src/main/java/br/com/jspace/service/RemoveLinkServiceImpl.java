package br.com.jspace.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import br.com.jspace.util.CustomLinks;
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
	
	private CustomLinks customLinks = new CustomLinks();

	public String breakUrl(String protectedUrl) {
		validate(protectedUrl);

		do{
			if(customLinks.isCustomLink(protectedUrl)){
				protectedUrl = customLinks.decryptCustomProtectors(protectedUrl);
			}else{
				protectedUrl = parseUrl(protectedUrl.trim());
				protectedUrl = decryptUrl(protectedUrl);
			}
		}while(isNestedUrl(protectedUrl));

		return protectedUrl;
	}

	public String parseUrl(String protectedUrl) {
		String url = "";

		do{
			if (protectedUrl.contains("%3f")){
				protectedUrl = protectedUrl.replaceAll("%3f", "?");
			}
			
			url = extractSignificantUrl(protectedUrl, url);
		}while(isNestedUrl(url));

		return url;
	}

	private String decryptUrl(String protectedUrl) {
		// Don't put elseif in this ifs sequence.
		if (protectedUrl.startsWith(HTTP_ASCII)) {
			protectedUrl = LinkUtil.decodeAsciiLink(protectedUrl);
		}

		if (Base64.isArrayByteBase64(protectedUrl.getBytes())) {
			protectedUrl = LinkUtil.decodeBase64(protectedUrl);
		}

		if (protectedUrl.endsWith("//:ptth")) {
			protectedUrl = LinkUtil.decodeReverseUrl(protectedUrl);
		}

		return protectedUrl;
	}


	private void validate(String protectedUrl) {
		if (protectedUrl.trim().contains(" ")) {
			throw new IllegalArgumentException("Link inválido");
		} else if (!protectedUrl.contains("http://")) {
			throw new IllegalArgumentException("Url no formato inválido. 'necessita de http://'");
		}
	}

	private boolean isNestedUrl(String protectedUrl) {
		return StringUtils.countMatches(protectedUrl, "http://") > 1 || ((protectedUrl.contains("http://") && protectedUrl.contains("//:ptth")));
	}

	private String extractSignificantUrl(String protectedUrl, String url) {
		for (String urlSeparator : LinkUtil.urlSeparator){
			if (protectedUrl.contains(urlSeparator)){
				int urlStart = protectedUrl.indexOf(urlSeparator);
				url = protectedUrl.substring(urlStart + urlSeparator.length());
				break;
			}
		}
		return url;
	}
}