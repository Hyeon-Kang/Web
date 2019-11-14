package week11;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class NaverAPI {
	// papago api 사용하기
	String translate_naver(String origin) {
		String clientId = ""; // 애플리케이션 클라이언트 ID
		String clientSecret = ""; // 애플리케이션 클라이언트 시크릿 값
		String result = "";
		
		try {
			String text = URLEncoder.encode(origin, "UTF-8");
			
			// 요청주소
			String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
			URL url = new URL(apiURL);
			
			// HTTP 서버와 연결
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setRequestMethod("POST");
			
			//HTTP 헤더 설정
			con.setRequestProperty("X-Naver-ClientId", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			
			//HTTP payload 설정
			String postParams = "source=en&target=ko&text=" + text;
			con.setDoOutput(true);
			
			//HTTP 요청 메시지 전송
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			
			// HTTP 응답 메시지 수신
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if(responseCode==200) {// 정상호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			while (( inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			
			// 응답된 JSON 포멧의 메시지 출력
			System.out.println(response.toString());
			result = response.toString();
			
			// 응답된 JSON 포멧 중 payload 부분에 해당하는 부분만 슬라이스 해서 출력 및 result 변수에 저장
			int idx = result.indexOf("translatedText");
			result = result.substring(idx+3);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}

}
