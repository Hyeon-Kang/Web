package week11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Article_parse {
	// 메인 페이지에 뉴스리스트에 위치한 기사들 수집
	public ArrayList<Article>parsing_articles() {
		String main_page = "http://www.koreatimes.co.kr/www/section_602.html";
		ArrayList<Article> arr = new ArrayList<Article> ();
		try {
			Document doc = Jsoup.connect(main_page).get();
			Elements text = doc.select("div[class=list2_article_headline HD]");
			text = text.select("a");
			for(int i = 0; i <text.size(); i++) {
				String url = "http://www.koreatimes.co.kr" + text.get(i).attr("href");
				arr.add(new Article(text.get(i).text(), url, parse_body(url)));
				//System.out.println(arr.get(i).title);
				//System.out.println(arr.get(i).body);
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
	
	// 매개변수로 받은 URL 신문기사 내용 수집
	public String parse_body(String input_url) {
		String url = input_url;
		String body = "";
		try {
			Document doc = Jsoup.connect(url).get();
			Elements text = doc.select("div[id=startts]");
			body = text.text();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return body;
	}
	
	// 실행함수
	public static void main(String[] args) {
		Article_parse obj = new Article_parse();
		ArrayList<Article> arr = obj.parsing_articles();
		Iterator<Article> iter = arr.iterator();
		
		while(iter.hasNext()) {
			Article temp = iter.next();
			System.out.println("<Title : " + temp.title+">");
			System.out.println("<URL : " + temp.url + ">");
			System.out.println(temp.body);
			System.out.println("-------------------------");
		}
	}

}

// 기사별로 저장하기 위한 객체
class Article{
	String url;
	String title;
	String body;
	public Article() {
		title = "";
		url = "";
		body = "";
	}
	
	public Article (String title, String url, String body) {
		this.title = title;
		this.url = url;
		this.body = body;
	}
	
}
