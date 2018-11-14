package com.example.initish.testapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedbackActivity extends AppCompatActivity {

    EditText currentCompany,currentCity,currentReview,currentSal,satisfaction,currentJobDescription;
    Button submitButton,skillChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        currentCompany=findViewById(R.id.currentCompany);
                currentCity=findViewById(R.id.currentCity);
                currentReview=findViewById(R.id.currentReview);
                currentSal=findViewById(R.id.currentSal);
                satisfaction=findViewById(R.id.satisfaction);
                currentJobDescription =findViewById(R.id.currentJobDescription);

                submitButton=findViewById(R.id.submitButton);
                skillChange=findViewById(R.id.skillChange);

         final String CURCOMP=currentCompany.getText().toString();
         final String CURCITY=currentCity.getText().toString();
         final String CURSAL=currentSal.getText().toString();
         final String SATIFACTION=satisfaction.getText().toString();
         final String CURJOBDESC=currentJobDescription.getText().toString();



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        skillChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
