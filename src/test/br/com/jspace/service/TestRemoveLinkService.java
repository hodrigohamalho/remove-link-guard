package br.com.jspace.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.commons.codec.binary.Base64;
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
 */
public class TestRemoveLinkService {

	private RemoveLinkService service = new RemoveLinkServiceImpl();

	@Test
	public void decodeBase64(){
		// Vou testar soh o decode aqui.
		String code = "aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/";
		
		String decoded = new String(Base64.decodeBase64(code.getBytes()));
		assertNotNull(decoded);
		assertEquals("http://www.2shared.com/video/MxQbakWF/OAPDFEI.html", decoded);
	}
	
	@Test
	public void decode2Base64() throws Exception{
		// Vou testar soh o decode aqui.
		String wrongUrl = "http://encurtador.com/?RVo1WEhOTjA9ZD8vbW9jLmRhb2xwdWFnZW0ud3d3Ly86cHR0aA==";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.megaupload.com/?d=0NNHX5ZE", url);
	}
	
	@Test
	public void decode3Base64() throws Exception{
		// Vou testar soh o decode aqui.
		String wrongUrl = "http://protelink.info/ir/id/aHR0cDovL3d3dy5lYXN5LXNoYXJlZS5jb20vcHJvZ3JhbWFzLz91cmw9aHR0cDovL2RlcG9zaXRmaWxlcy5jb20vZmlsZXMvbGJrbzVuY3ho/";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://depositfiles.com/files/lbko5ncxh", url);
	}
	

	@Test
	public void breakSimpleURL() throws Exception{
		String wrongUrl = "http://www.megaupload.com/?d=G6ZFTBJW";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals(wrongUrl, url);
	}

	@Test 
	public void breakCommomProtectedUrl() throws Exception{
		String wrongUrl = "http://clubedodownload.info/link/?url=http://www.megaupload.com/?d=G6ZFTBJW";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.megaupload.com/?d=G6ZFTBJW", url);
	}

	@Test
	public void breakBase64Url() throws Exception{
		String wrongUrl = "http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.2shared.com/video/MxQbakWF/OAPDFEI.html", url);
	}

	@Test
	public void breakUrlWithBlankSpaces() throws Exception{
		String wrongUrl = "  http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/  ";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.2shared.com/video/MxQbakWF/OAPDFEI.html", url);
	}

	@Test
	public void breakInvalidUrl(){
		try {
			String wrongUrl = "fanfarrao.com";
			service.breakUrl(wrongUrl);

			fail("url should throw exception");
		} catch (Exception e) {
		}
	}

	@Test
	public void breakEmptyUrl(){
		try {
			String wrongUrl = "";
			service.breakUrl(wrongUrl);

			fail("url should throw exception");
		} catch (Exception e) {
		}
	}

	@Test
	public void breakReverseUrl() throws Exception{
		String wrongUrl = "http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.fileserve.com/file/mJ65hjS", url);
	}
	
	@Test
	public void breakReverseUrl2() throws Exception{
		String wrongUrl = "http://www.celularbr.com/filmesquentes/?5INK4KUL=d?/moc.daolpuagem.www//:ptth";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.megaupload.com/?d=LUK4KNI5", url);

	}
	
	@Test
	public void breakReverseUrl3() throws Exception{
		String wrongUrl = "http://www.baixeaquifilmes.com/link/?XSEC2VYW=d?/moc.daolpuagem.www//:ptth";
		String url = service.breakUrl(wrongUrl);
		
		assertNotNull(url);
		assertEquals("http://www.megaupload.com/?d=WYV2CESX", url);
	}

	@Test
	public void breakComplexUrl() throws Exception{
		try {
			String wrongUrl = "http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/  = \"http://www.2shared.com/video/MxQbakWF/OAPDFEI.html\"";
			service.breakUrl(wrongUrl);

			fail("url should throw exception");
		} catch (Exception e) {
		}
	}

	@Test
	public void breakUrlThatNotContainsTheWordUrl() throws Exception{
		String wrongUrl = "http://fire.tiozao.net/?link=Sjh56Jm/elif/moc.evreselif.www//:ptth";
		String url = service.breakUrl(wrongUrl);

		assertNotNull(url);
		assertEquals("http://www.fileserve.com/file/mJ65hjS", url);
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
		String wrongUrl = "http://www.downsupremo.com/download/?url=687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d3330354f35323736";
		
		String url = service.breakUrl(wrongUrl);
		assertEquals("http://www.megaupload.com/?d=305O5276", url);
	}
	
	@Test
	public void decode2AsciiLink() throws Exception{
		String wrongUrl = "http://www.puxandolegal.com/ir/?id=687474703a2f2f616e6f6e796d6f7573652e6f72672f6367692d62696e2f616e6f6e2d7777772e6367692f687474703a2f2f7777772e66696c6573657276652e636f6d2f66696c652f56456463435255179346b794b36";
		
		String url = service.breakUrl(wrongUrl);
		assertEquals("", url);
	}
	
	@Test
	public void decode3AsciiLink() throws Exception{
		String wrongUrl = "http://www.vinxp.com/download/d/?t=48445456202623383231313b2057574520536d61636b646f776e202832322f30342f313129";
		
		String url = service.breakUrl(wrongUrl);
		assertEquals("http://www.vinxp.com/hdtv-wwe-smackdown-220411", url);
	}
	
	@Test
	public void breakUrlWithParamBetweenQueryAndExclamation() throws Exception{
		String wrongUrl = "http://www.protetordelinks.com/links/?go!aHR0cDovL2xpeC5pbi8tNTgzNmQ3";
		
		String url = service.breakUrl(wrongUrl);
		assertEquals("http://lix.in/-5836d7", url);
	}
}
