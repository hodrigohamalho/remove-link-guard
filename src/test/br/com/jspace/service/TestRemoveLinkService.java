package br.com.jspace.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * Example urls:
   http://www.megaupload.com/?d=G6ZFTBJW
   http://clubedodownload.info/link/?url=http://www.megaupload.com/?d=G6ZFTBJW
   http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth
   http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/  = "http://www.2shared.com/video/MxQbakWF/OAPDFEI.html"
   http://meggacelular.com/baixando/?link=rar.esooL_-_odatruF_ylleN/99448921/selif/moc.erahsdipar//:ptth
   http://www.protetordelinks.com/links/?go!aHR0cDovL2xpeC5pbi8tNTgzNmQ3
   http://www.downsupremo.com/download/?url=687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d3330354f35323736
   http://www.celularbr.com/filmesquentes/?5INK4KUL=d?/moc.daolpuagem.www//:ptth

 * @author rodrigoramalho
 */
public class TestRemoveLinkService {

	private RemoveLinkService service = new RemoveLinkServiceImpl();

	@Test
	public void parserUrl(){
		testeParser("http://clubedodownload.info/link/?url=http://www.megaupload.com/?d=G6ZFTBJW", "http://www.megaupload.com/?d=G6ZFTBJW");
		testeParser("http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth", "Sjh56Jm/elif/moc.evreselif.www//:ptth");
		testeParser("http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/", "aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/");
		testeParser("http://www.downsupremo.com/download/?url=687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d3330354f35323736", "687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d3330354f35323736");
		testeParser("http://meggacelular.com/baixando/?link=rar.esooL_-_odatruF_ylleN/99448921/selif/moc.erahsdipar//:ptth", "rar.esooL_-_odatruF_ylleN/99448921/selif/moc.erahsdipar//:ptth");
		testeParser("http://www.protetordelinks.com/links/?go!aHR0cDovL2xpeC5pbi8tNTgzNmQ3", "aHR0cDovL2xpeC5pbi8tNTgzNmQ3");
		testeParser("http://www.celularbr.com/filmesquentes/?5INK4KUL=d?/moc.daolpuagem.www//:ptth", "5INK4KUL=d?/moc.daolpuagem.www//:ptth");
		testeParser("http://www.protetordownloads.info/download/?lmth.rar.llluabinac.dsahjkdsjakahcek.sebereht.rodaderp/356d833/52704438/ld/moc.eliftoh//:ptth", "lmth.rar.llluabinac.dsahjkdsjakahcek.sebereht.rodaderp/356d833/52704438/ld/moc.eliftoh//:ptth");
	}

	private void testeParser(String protectedUrl, String expectedUrl) {
		String breakedUrl = service.parseUrl(protectedUrl);
		assertEquals(expectedUrl, breakedUrl);
	}

	@Test
	public void break0Base64() throws Exception{
		breakProtectedUrl("http://www.loucosporsoftwares.com/protetor2/?aHR0cDovL3JhcGlkc2hhcmUuY29tL2ZpbGVzLzE4MTE5MzIzOC9SZXZpc3RhX0VsZWt0b3JfLV9KYW5laXJvX2RlXzIwMDkud3d3LnRoZWdlbml1cy5", "http://rapidshare.com/files/181193238/Revista_Elektor_-_Janeiro_de_2009.www.thegenius.");
	}
	
	@Test
	public void break1Base64() throws Exception{
		breakProtectedUrl("http://encurtador.com/?RVo1WEhOTjA9ZD8vbW9jLmRhb2xwdWFnZW0ud3d3Ly86cHR0aA==", "http://www.megaupload.com/?d=0NNHX5ZE");
	}
	
	@Test
	public void break2Base64() throws Exception{
		breakProtectedUrl("http://encurtador.com/?RVo1WEhOTjA9ZD8vbW9jLmRhb2xwdWFnZW0ud3d3Ly86cHR0aA==", "http://www.megaupload.com/?d=0NNHX5ZE");
	}
	
	@Test
	public void break3Base64() throws Exception{
		breakProtectedUrl("http://protelink.info/ir/id/aHR0cDovL3d3dy5lYXN5LXNoYXJlZS5jb20vcHJvZ3JhbWFzLz91cmw9aHR0cDovL2RlcG9zaXRmaWxlcy5jb20vZmlsZXMvbGJrbzVuY3ho/", "http://depositfiles.com/files/lbko5ncxh");
	}

	private void breakProtectedUrl(String protectedUrl, String expectedUrl) throws Exception {
		String url = service.breakUrl(protectedUrl);

		assertNotNull(url);
		assertEquals(expectedUrl, url);
	}


	@Test
	public void breakSimpleURL() throws Exception{
		breakProtectedUrl("http://www.megaupload.com/?d=G6ZFTBJW", "http://www.megaupload.com/?d=G6ZFTBJW");
	}

	@Test
	public void breakSimpleUR2L() throws Exception{
		breakProtectedUrl("http://indica.celularbr.com/?http://ul.to/6i76b0tz", "http://ul.to/6i76b0tz");
	}

	@Test 
	public void breakCommomProtectedUrl() throws Exception{
		breakProtectedUrl("http://clubedodownload.info/link/?url=http://www.megaupload.com/?d=G6ZFTBJW", "http://www.megaupload.com/?d=G6ZFTBJW");
	}

	@Test
	public void breakBase64Url() throws Exception{
		breakProtectedUrl("http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/", "http://www.2shared.com/video/MxQbakWF/OAPDFEI.html");
	}

	@Test
	public void breakUrlWithBlankSpaces() throws Exception{
		breakProtectedUrl("http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/", "http://www.2shared.com/video/MxQbakWF/OAPDFEI.html");
	}

	@Test(expected=Exception.class)
	public void breakInvalidUrl() throws Exception{
		String wrongUrl = "fanfarrao.com";
		service.breakUrl(wrongUrl);

		fail("url should throw exception");
	}

	@Test(expected=Exception.class)
	public void breakEmptyUrl() throws Exception{
		String wrongUrl = "";
		service.breakUrl(wrongUrl);

		fail("url should throw exception");
	}

	@Test
	public void breakReverseUrl() throws Exception{
		breakProtectedUrl("http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth", "http://www.fileserve.com/file/mJ65hjS");
	}

	@Test
	public void breakReverseUrl2() throws Exception{
		breakProtectedUrl("http://www.celularbr.com/filmesquentes/?5INK4KUL=d?/moc.daolpuagem.www//:ptth", "http://www.megaupload.com/?d=LUK4KNI5");
	}

	@Test
	public void breakReverseUrl3() throws Exception{
		breakProtectedUrl("http://www.baixeaquifilmes.com/link/?XSEC2VYW=d?/moc.daolpuagem.www//:ptth", "http://www.megaupload.com/?d=WYV2CESX");
	}

	@Test(expected=Exception.class)
	public void breakComplexUrl() throws Exception{
		breakProtectedUrl("http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/  = \"http://www.2shared.com/video/MxQbakWF/OAPDFEI.html\"", "http://www.megaupload.com/?");
	}

	@Test
	public void breakUrlThatNotContainsTheWordUrl() throws Exception{
		breakProtectedUrl("http://fire.tiozao.net/?link=Sjh56Jm/elif/moc.evreselif.www//:ptth", "http://www.fileserve.com/file/mJ65hjS");
	}

	@Test
	public void breakUrlWithoutHttp(){
		String wrongUrl = "www.google.com.br";
		
		try{
			service.breakUrl(wrongUrl);
			fail("url should throw exception");
		}catch (Exception e) {
			assertEquals("Url no formato inválido. 'necessita de http://'", e.getMessage());
		}
	}

	@Test
	public void decodeAsciiLink() throws Exception{
		breakProtectedUrl("http://www.downsupremo.com/download/?url=687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d3330354f35323736", "http://www.megaupload.com/?d=305O5276");
	}

	@Test
	public void decode3AsciiLink() throws Exception{
		breakProtectedUrl("http://www.vinxp.com/download/d/?t=48445456202623383231313b2057574520536d61636b646f776e202832322f30342f313129", "http://www.vinxp.com/hdtv-wwe-smackdown-220411");
	}

	@Test
	public void breakUrlWithParamBetweenQueryAndExclamation() throws Exception{
		breakProtectedUrl("http://www.protetordelinks.com/links/?go!aHR0cDovL2xpeC5pbi8tNTgzNmQ3", "http://lix.in/-5836d7");
	}

	@Test
	public void breakBaixarFilmesDublados() throws Exception{
		breakProtectedUrl("http://www.baixarfilmesdublados.info/download/?url=vkibahjdvbdvhbskbskdaHR0cDovL3d3dy5tZWdhdXBsb2FkLmNvbS8/ZD1UMVY2NklHUg==", "http://www.megaupload.com/?d=T1V66IGR");
	}

	@Test
	public void test() throws Exception{
		breakProtectedUrl("http://www.protetordownloads.info/download/?lmth.rar.llluabinac.dsahjkdsjakahcek.sebereht.rodaderp/356d833/52704438/ld/moc.eliftoh//:ptth", "http://hotfile.com/dl/83440725/338d653/predador.therebes.kechakajsdkjhasd.canibaulll.rar.html");
	}
	
	@Test
	public void brekAscii() throws Exception{
		breakProtectedUrl("http://protetordelink.tv/download/protetorbtf/350/687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d4d545037594d3031", "http://www.megaupload.com/?d=MTP7YM01");
	}
	
	

}
