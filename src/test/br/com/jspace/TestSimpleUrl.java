package br.com.jspace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

/**
 * @author rodrigoramalho
 */
public class TestSimpleUrl extends AbstractUrlTest{

	@Test
	public void breakSimpleUR2L() throws Exception{
		breakProtectedUrl("http://indica.celularbr.com/?http://ul.to/6i76b0tz", "http://ul.to/6i76b0tz");
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
	public void breakUrlWithoutHttp(){
		String wrongUrl = "www.google.com.br";
		
		try{
			service.breakUrl(wrongUrl);
			fail("url should throw exception");
		}catch (Exception e) {
			assertEquals("Url no formato inválido. 'necessita de http://'", e.getMessage());
		}
	}
}
