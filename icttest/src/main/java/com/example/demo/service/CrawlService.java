package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import com.example.demo.collection.DaumNews;

public interface CrawlService {

	public List<DaumNews> getDaumList() throws IOException;
}
