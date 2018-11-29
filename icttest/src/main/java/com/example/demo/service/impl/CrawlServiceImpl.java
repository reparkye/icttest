package com.example.demo.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.collection.DaumNews;
import com.example.demo.repository.DaumNewsRepository;
import com.example.demo.service.CrawlService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CrawlServiceImpl implements CrawlService {

	@Value("${ex.target.url}")
	private String targetUrl;
	
	@Value("${ex.parent.selector}")
	private String pSelector;
	
	@Value("${ex.dt.selector}")
	private String dtSelector;
	
	@Autowired
	private DaumNewsRepository dnRepo;
	
	
	@Override
	public List<DaumNews> getDaumList() throws IOException {
		Document doc = Jsoup.connect(targetUrl).get();
		Elements newsElements = doc.select("ul.list_mainnews>li");
		for(Element aElement : newsElements) {
			System.out.println(aElement);
			//System.out.println(aElement.select("a").attr("href"));
			System.out.println("--------------");
		}
//		Elements ulElements = doc.select(pSelector);
//		Elements aElements = ulElements.select(dtSelector);
//		List<DaumNews> nitnList = new ArrayList<DaumNews>();
//		for(Element aElement : aElements) {
//			String uri = aElement.attr("href");
//			int sIdx = uri.indexOf("aid=");
//			String aid = uri.substring(sIdx) + "&abc";
//			if(aid.indexOf("&")!=1) {
//				aid = aid.substring(0,aid.indexOf("&"));
//			}
//			aid = aid.replace("aid=", "");
//			
//			if(dnRepo.findByAid(aid).size()!=0) {
//				continue;
//			}
//			
//			String tittle = aElement.text();
//			DaumNews nitn = new DaumNews();
//			nitn.setAid(aid);
//			nitn.setUri(uri);
//			nitn.setTittle(tittle);
//			nitnList.add(nitn);
//		}
		
//		return dnRepo.saveAll(nitnList);
		return null;
	}

}
