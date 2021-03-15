package yi.yang.yiyangflashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView questionTextView = findViewById(R.id.flashcard_question);
    TextView answerTextView = findViewById(R.id.flashcard_answer);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView addButton = findViewById(R.id.add_flashcard);

        questionTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                    questionTextView.setVisibility(View.INVISIBLE);
                    answerTextView.setVisibility(View.VISIBLE);
            }
        });

        answerTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                questionTextView.setVisibility(View.VISIBLE);
                answerTextView.setVisibility(View.INVISIBLE);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddFlashcard.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });

        //in Activity A
        //Intent intent = new Intent(MainActivity.this, AddQuestion.class);
        //intent.putExtra("key", "some info to send");
        //startActivity(intent);

        //in Activity B:
        //protected void onCreate(Bundle savedInstanceState){
        //String data = getIntent().getStringExtra("key"); //data = "some info to send"

        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {

            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 100 && resultCode == RESULT_OK) { // this 100 needs to match the 100 we used when we called startActivityForResult!
                if (data != null) {
                    String string1 = data.getExtras().getString("string1"); // 'string1' needs to match the key we used when we put the string in the Intent
                    String string2 = data.getExtras().getString("string2");
                    questionTextView.setText(string1);
                    answerTextView.setText(string2);
                }
            }

        }

    }
