package br.com.jspace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import br.com.jspace.service.RemoveLinkService;
import br.com.jspace.service.RemoveLinkServiceImpl;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class AbstractUrlTest {

	protected RemoveLinkService service = new RemoveLinkServiceImpl();
	
	protected void breakProtectedUrl(String protectedUrl, String expectedUrl) throws Exception {
		String url = service.breakUrl(protectedUrl);

		assertNotNull(url);
		assertEquals(expectedUrl, url);
	}
	
}
