package br.com.desprotetorlink;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(value=Suite.class)
@Suite.SuiteClasses(value={
		TestBase64Url.class,
		TestReverseUrl.class,
		TestSimpleUrl.class
})
public class TestAll{}
