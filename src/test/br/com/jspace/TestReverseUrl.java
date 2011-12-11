package br.com.jspace;

import org.junit.Test;

/**
 * 
 * @author rodrigoramalho
 *
 */
public class TestReverseUrl extends AbstractUrlTest{

	@Test
	public void breakReverseUrl() throws Exception{
		breakProtectedUrl("http://fire.tiozao.net/?url=Sjh56Jm/elif/moc.evreselif.www//:ptth", "http://www.fileserve.com/file/mJ65hjS");
	}

	@Test
	public void breakReverseUrl1() throws Exception{
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

	@Test
	public void breakReverseUrl5() throws Exception{
		breakProtectedUrl("http://www.protetordownloads.info/download/?lmth.rar.llluabinac.dsahjkdsjakahcek.sebereht.rodaderp/356d833/52704438/ld/moc.eliftoh//:ptth", "http://hotfile.com/dl/83440725/338d653/predador.therebes.kechakajsdkjhasd.canibaulll.rar.html");
	}
	
	@Test
	public void breakReverseUrl6() throws Exception{
		breakProtectedUrl("http://tubaraoninja.comdownload1/?1bqtvm2zcasz8b2%3f/moc.erifaidem.www//:ptth=lru%3f/daolnwod/moc.acargedsacisum//:ptth", "http://www.mediafire.com/?2b8zsacz2mvtqb1");
	}

	@Test
	public void breakReverseUrl7() throws Exception{
		breakProtectedUrl("http://meggacelular.com/baixando/?link=rar.esooL_-_odatruF_ylleN/99448921/selif/moc.erahsdipar//:ptth", "http://rapidshare.com/files/12984499/Nelly_Furtado_-_Loose.rar");
	}
	
	@Test
	public void breakReverseUrl8() throws Exception{
		breakProtectedUrl("http://www.celularbr.com/filmesquentes/?5INK4KUL=d?/moc.daolpuagem.www//:ptth", "http://www.megaupload.com/?d=LUK4KNI5");
	}
	
	@Test
	public void breakReverseUrl9() throws Exception{
		breakProtectedUrl("http://www.protetordownloads.info/download/?lmth.rar.llluabinac.dsahjkdsjakahcek.sebereht.rodaderp/356d833/52704438/ld/moc.eliftoh//:ptth", "http://hotfile.com/dl/83440725/338d653/predador.therebes.kechakajsdkjhasd.canibaulll.rar.html");
	}
	
	@Test
	public void breakReverseUrl10() throws Exception{
		breakProtectedUrl("http://fire.tiozao.net/?link=Sjh56Jm/elif/moc.evreselif.www//:ptth", "http://www.fileserve.com/file/mJ65hjS");
	}
	
}