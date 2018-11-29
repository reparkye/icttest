package com.example.demo;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.collection.DaumNews;
import com.example.demo.repository.DaumNewsRepository;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IcttestApplicationTests {
	static final String CONNECT_URI = "https://media.daum.net/culture/";
	static final String SELECT_QUERY="ul.list_mainnews";
	
	@Autowired
	private DaumNewsRepository dnRepo;
	
	@Test
	public void contextLoads() throws IOException{
	Document doc = Jsoup.connect(CONNECT_URI).get();
	Elements ulElements = doc.select(SELECT_QUERY);
	assertEquals(1, ulElements.size());
	log.info("ul size=>{}",ulElements.size());
}
	
	@Test
	public void selectLis() throws IOException {
		Document doc = Jsoup.connect(CONNECT_URI).get();
		Elements ulElements = doc.select(SELECT_QUERY);
		Elements aElements = ulElements.select("li>dl>dt:not(.photo)>a");
		assertEquals(10,aElements.size());
		List<DaumNews> nitnList = new ArrayList<DaumNews>();
		for(Element aElement : aElements) {
			String uri = aElement.attr("href");
			int sIdx = uri.indexOf("aid=");
			String aid = uri.substring(sIdx) + "&abc";
			if(aid.indexOf("&")!=1) {
				aid = aid.substring(0,aid.indexOf("&"));
			}
			aid = aid.replace("aid=", "");
			log.info("aid=>{}",aid);
			
			String tittle = aElement.text();
			DaumNews nitn = new DaumNews();
			nitn.setAid(aid);
			nitn.setUri(uri);
			nitn.setTittle(tittle);
			nitnList.add(nitn);
		}
		
		dnRepo.saveAll(nitnList);
	}
}
