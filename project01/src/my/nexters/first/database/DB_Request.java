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
		
            //   URL �����ϰ� �����ϱ�
            URL url = new URL("http://write_db.php");       // URL ����
            HttpURLConnection http = (HttpURLConnection) url.openConnection();   // ����
			
            //   ���� ��� ���� - �⺻���� �����̴�
            http.setDefaultUseCaches(false);                                           
            http.setDoInput(true);                         // �������� �б� ��� ����
            http.setDoOutput(true);                       // ������ ���� ��� ���� 
            http.setRequestMethod("POST");         // ���� ����� POST
            
            // �������� ������ <Form>���� ���� �Ѿ�� �Ͱ� ���� ������� ó���϶�� �� �˷��ش�
            http.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            
            //   ������ �� ����
            StringBuffer buffer = new StringBuffer();
            buffer.append("title").append("=").append(myTitle).append("&");                 // php ������ �� ����
            buffer.append("writer").append("=").append(myWriter).append("&");   // php ���� �տ� '$' ������ �ʴ´�
            buffer.append("publisher").append("=").append(myPublisher).append("&");           // ���� ������ '&' ��� 
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
