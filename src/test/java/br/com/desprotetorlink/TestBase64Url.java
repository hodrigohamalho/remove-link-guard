package br.com.desprotetorlink;

import org.junit.Test;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class TestBase64Url extends AbstractUrlTest{

	@Test
	public void breakBase64Url1() throws Exception{
		breakProtectedUrl("http://www.loucosporsoftwares.com/protetor2/?aHR0cDovL3JhcGlkc2hhcmUuY29tL2ZpbGVzLzE4MTE5MzIzOC9SZXZpc3RhX0VsZWt0b3JfLV9KYW5laXJvX2RlXzIwMDkud3d3LnRoZWdlbml1cy5", "http://rapidshare.com/files/181193238/Revista_Elektor_-_Janeiro_de_2009.www.thegenius.");
	}
	
	@Test
	public void breakBase64Url2() throws Exception{
		breakProtectedUrl("http://encurtador.com/?RVo1WEhOTjA9ZD8vbW9jLmRhb2xwdWFnZW0ud3d3Ly86cHR0aA==", "http://www.megaupload.com/?d=0NNHX5ZE");
	}
	
	@Test
	public void breakBase64Url3() throws Exception{
		breakProtectedUrl("http://encurtador.com/?RVo1WEhOTjA9ZD8vbW9jLmRhb2xwdWFnZW0ud3d3Ly86cHR0aA==", "http://www.megaupload.com/?d=0NNHX5ZE");
	}
	
	@Test
	public void breakBase64Url4() throws Exception{
		breakProtectedUrl("http://protelink.info/ir/id/aHR0cDovL3d3dy5lYXN5LXNoYXJlZS5jb20vcHJvZ3JhbWFzLz91cmw9aHR0cDovL2RlcG9zaXRmaWxlcy5jb20vZmlsZXMvbGJrbzVuY3ho/", "http://depositfiles.com/files/lbko5ncxh");
	}
	
	@Test
	public void breakBase64Url5() throws Exception{
		breakProtectedUrl("http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy4yc2hhcmVkLmNvbS92aWRlby9NeFFiYWtXRi9PQVBERkVJLmh0bWw=/", "http://www.2shared.com/video/MxQbakWF/OAPDFEI.html");
	}
	
	@Test
	public void breakBase64Url6() throws Exception{
		breakProtectedUrl("http://www.protetordelinks.com/links/?go!aHR0cDovL2xpeC5pbi8tNTgzNmQ3", "http://lix.in/-5836d7");
	}
	
	@Test
	public void breakBase64Url7() throws Exception{
		breakProtectedUrl("http://www.baixarfilmesdublados.info/download/?url=vkibahjdvbdvhbskbskdaHR0cDovL3d3dy5tZWdhdXBsb2FkLmNvbS8/ZD1UMVY2NklHUg==", "http://www.megaupload.com/?d=T1V66IGR");
	}
	
	@Test
	public void breakBase64Url8() throws Exception{
		breakProtectedUrl("http://yess.me/ir/id/aHR0cDovL2dvby5nbC9iUElRRw==/", "http://goo.gl/bPIQG");
	}
	
	@Test
	public void breakBase64Url9() throws Exception{
		breakProtectedUrl("http://fgprotege.com/link/MTU5NyMjIzE5IyMjaHR0cDovL3d3dy5tZWdhdmlkZW8uY29tLz9kPVA4VDE2VUhB", "http://www.megavideo.com/?d=P8T16UHA");
	}
	
	@Test
	public void breakBase64Url10() throws Exception{
		breakProtectedUrl("http://linkprotegido.info/link/?url=http://yess.me/ir/id/aHR0cDovL3d3dy5maWxlc29uaWMuY29tL2ZpbGUvMjA4MTc0Mzc0NA==/", "http://www.filesonic.com/file/2081743744");
	}
	
	
	
}
