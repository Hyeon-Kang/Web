
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Article_parse_work {
	public ArrayList<Article>parsing_articles(){
		// 메인 페이지 주소
		String main_page="http://www.koreaherald.com/list.php?ct=020200000000.html";
		ArrayList<Article> arr=new ArrayList<Article>();
		try {
			Document doc=Jsoup.connect(main_page).get();
			// 읽어올 태그 div 지정
			Elements text=doc.select("div[class=contentsWrap]");
			text=text.select("a");
			for(int i=0;i<text.size();i++) {
				// 내부 경로
				String url="http://www.koreaherald.com"+text.get(i).attr("href");
				arr.add(new Article(text.get(i).text(),url,parse_body(url)));
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return arr;
	}
	public String parse_body(String input_url) {
		String url=input_url;
		String body="";
		try {
			Document doc =Jsoup.connect(url).get();
			// 수집할 태그 지정
			Elements text=doc.select("div[id=articleText]");
			body=text.text();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return body;
	}
	public static void main(String[] args) {
		Article_parse_work obj = new Article_parse_work();
		ArrayList<Article> arr = obj.parsing_articles();
		Iterator<Article> iter = arr.iterator();

		while(iter.hasNext()) {
			Article temp =iter.next();
			System.out.println("<Title : >"+temp.title+">");
			System.out.println("<URL:"+temp.url+">");
			System.out.println(temp.body);
			System.out.println();
		}
	}
	
	class Article{//기사 저장하는 클래스
		String url;
		String title;
		String body;
		public Article() {
			title="";
			url="";
			body="";
		}
		
		public Article(String title, String url, String body) {
			this.title=title;
			this.url=url;
			this.body=body;
		}
	}

}
