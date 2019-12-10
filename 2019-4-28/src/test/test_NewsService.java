package test;

import java.util.ArrayList;
import java.util.Iterator;

import news.News;
import news.NewsService;

public class test_NewsService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsService ne = new NewsService();
		News news = ne.doSelectById(6);
		System.out.println(news.getTitle());
		System.out.println(news.getContent());
		System.out.println(news.getPubtime());
		System.out.println(news.getUserid());
	}

}
