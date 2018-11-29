package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.collection.DaumNews;
import com.example.demo.service.CrawlService;

@Controller
public class ExecuteController {

	@Autowired
	private CrawlService cs;
	
	@PostMapping(value="/exedaum")
	@ResponseBody
	public List<DaumNews> postMethodName(@RequestParam Map<String,String> auth) throws Exception {
		if(!"daum".equals(auth.get("id"))) {
			throw new Exception("NoNo");
		}
		if(!"daum".equals(auth.get("pwd"))) {
			throw new Exception("nono");
		}
		return cs.getDaumList();
	}
}
