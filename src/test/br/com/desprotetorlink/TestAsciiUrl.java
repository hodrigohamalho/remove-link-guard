package br.com.desprotetorlink;

import org.junit.Test;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class TestAsciiUrl extends AbstractUrlTest{
	
	@Test
	public void breakAsciiUrl() throws Exception{
		breakProtectedUrl("http://www.downsupremo.com/download/?url=687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d3330354f35323736", "http://www.megaupload.com/?d=305O5276");
	}

	@Test
	public void breakAsciiUrl1() throws Exception{
		breakProtectedUrl("http://www.vinxp.com/download/d/?t=48445456202623383231313b2057574520536d61636b646f776e202832322f30342f313129", "http://www.vinxp.com/hdtv-wwe-smackdown-220411");
	}

	@Test
	public void breakAsciiUrl2() throws Exception{
		breakProtectedUrl("http://www.protetordelinks.com/links/?go!aHR0cDovL2xpeC5pbi8tNTgzNmQ3", "http://lix.in/-5836d7");
	}

	@Test
	public void breakAsciiUrl3() throws Exception{
		breakProtectedUrl("http://protetordelink.tv/download/protetorbtf/350/687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d4d545037594d3031", "http://www.megaupload.com/?d=MTP7YM01");
	}
	
	@Test
	public void breakAsciiUrl4() throws Exception{
		breakProtectedUrl("http://www.baixarfilmesonline.tv/proteger/?id=687474703a2f2f7777772e6d656761766964656f2e636f6d2f3f643d444f5a4f334e5a4f", "http://www.megavideo.com/?d=DOZO3NZO");
	}
	
	@Test
	public void breakAsciiUrl5() throws Exception{
		breakProtectedUrl("http://www.baixarfilmesonline.tv/proteger/?id=687474703a2f2f7777772e6d65676175706c6f61642e636f6d2f3f643d444f5a4f334e5a4f", "http://www.megaupload.com/?d=DOZO3NZO");
	}
	
}
