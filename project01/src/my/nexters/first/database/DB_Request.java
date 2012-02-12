package my.nexters.first.database;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DB_Request {
	
	public static void HttpPostData(String myTitle, String myWriter, String myPublisher, String myReview, int myRating){
		try {
		
            //   URL 설정하고 접속하기
            URL url = new URL("http://write_db.php");       // URL 설정
            HttpURLConnection http = (HttpURLConnection) url.openConnection();   // 접속
			
            //   전송 모드 설정 - 기본적인 설정이다
            http.setDefaultUseCaches(false);                                           
            http.setDoInput(true);                         // 서버에서 읽기 모드 지정
            http.setDoOutput(true);                       // 서버로 쓰기 모드 지정 
            http.setRequestMethod("POST");         // 전송 방식은 POST
            
            // 서버에게 웹에서 <Form>으로 값이 넘어온 것과 같은 방식으로 처리하라는 걸 알려준다
            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            
            //   서버로 값 전송
            StringBuffer buffer = new StringBuffer();
            buffer.append("title").append("=").append(myTitle).append("&");                 // php 변수에 값 대입
            buffer.append("writer").append("=").append(myWriter).append("&");   // php 변수 앞에 '$' 붙이지 않는다
            buffer.append("publisher").append("=").append(myPublisher).append("&");           // 변수 구분은 '&' 사용 
            buffer.append("review").append("=").append(myReview).append("&");
            buffer.append("rating").append("=").append(myRating);
          
            OutputStreamWriter outStream = new OutputStreamWriter(http.getOutputStream(), "EUC-KR");
            PrintWriter writer = new PrintWriter(outStream);
            writer.write(buffer.toString());
            writer.flush();
            
		} catch (MalformedURLException e) {
			
		} catch (IOException e) {
			
		}
	}

}
