package com.example.demoldap;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class DemoLdapApplicationTests {

	@Autowired
	private WebApplicationContext wac;

	private WebClient webClient;
	
	@Before
	public void setup() {
		webClient = new WebClient();
		//webClient = MockMvcWebClientBuilder.webAppContextSetup(wac).build();
	}

	@Test
	public void contextLoads() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		String url = "http://localhost:8080/hello";
		String htmlunit = "http://htmlunit.sourceforge.net";
        HtmlPage page = webClient.getPage(htmlunit);
        assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
        //assertEquals("Hello!!!!", page.getBody().getTextContent());
	}

}
