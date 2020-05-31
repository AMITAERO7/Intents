package com.hackernight.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ShowGuess extends AppCompatActivity {

    TextView guessedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        Bundle bundle = getIntent().getExtras();

        guessedText = findViewById(R.id.textGuess);


        /*String guessedTxt = getIntent().getStringExtra("guess");
        int age = getIntent().getIntExtra("age",0);

        if (guessedTxt != null){
            guessedText.setText(guessedTxt.toString());
            Log.d("guess",guessedTxt);
        }*/

        if (bundle != null){
            guessedText.setText(bundle.getString("guess").toString());
            Log.d("Name Extra","Name"+bundle.getString("name"));
            Log.d("Age Extra","Age"+bundle.getInt("age"));
        }


        guessedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  getIntent(); //get the current intent
                intent.putExtra("back_message","From Second Activity !!!!");
                setResult(RESULT_OK,intent);
                finish(); // to remove this activity from the stack
            }
        });

    }
}