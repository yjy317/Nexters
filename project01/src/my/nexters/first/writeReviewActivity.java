package my.nexters.first;

import my.nexters.first.database.DB_Request;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

public class writeReviewActivity extends Activity {
    /** Called when the activity is first created. */
	//���� ���� ����
	String myName, myTitle, myWriter, myPublisher, myReview;
	int myRating;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_review);
        
        findViewById(R.id.btn_submit).setOnClickListener(buttonClick); 

    }
    
    //���� ���� ��ư Ŭ��
    Button.OnClickListener buttonClick = new Button.OnClickListener() {

		public void onClick(View v) {
			// �Է��� ������ ���� ������ ����
			myTitle = ((EditText)(findViewById(R.id.title_editText))).getText().toString();
			myWriter = ((EditText)(findViewById(R.id.writer_editText))).getText().toString();
			myPublisher = ((EditText)(findViewById(R.id.publisher_editText))).getText().toString();
			myReview = ((EditText)(findViewById(R.id.review_editText))).getText().toString();
			myRating = ((RatingBar)(findViewById(R.id.ratingBar))).getNumStars();
			
			DB_Request.HttpPostData(myTitle, myWriter, myPublisher, myReview, myRating);
			
		}
    	
    };
}