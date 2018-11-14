package com.example.initish.testapp;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.initish.testapp.employer.ApplicantAdapter;
import com.example.initish.testapp.employer.Applicants;
import com.example.initish.testapp.employer.candidates;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class StudentDetails extends AppCompatActivity {


    EditText name,dobdd,dobmm,dobyy,locality,pin,edu,train,skills,state,city,district,phone,expp;
    Button candidatebutton;
    private RecyclerView skills_rcv;
    List<Sector> sectors=new ArrayList<>();
    Context context;
    SectorAdapter s_adapter;

    public StudentDetails() {

    }
    FirebaseFirestore db=FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);


        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        }

        name=findViewById(R.id.name);
        dobdd=findViewById(R.id.dobdd);
        dobmm=findViewById(R.id.dobmm);
        dobyy=findViewById(R.id.dobyy);
        phone=findViewById(R.id.phone);
        pin=findViewById(R.id.pin);
        edu=findViewById(R.id.edu);
        train=findViewById(R.id.train);
        skills=findViewById(R.id.skills);
        state=findViewById(R.id.state);
        expp=findViewById(R.id.expp);
        city=findViewById(R.id.city);
        district=findViewById(R.id.district);

        skills_rcv=findViewById(R.id.skills_rcv);
        skills_rcv.setLayoutManager(new GridLayoutManager(this,2));


        s_adapter=new SectorAdapter(this,sectors);
        skills_rcv.setAdapter(s_adapter);


        final String Exp=expp.getText().toString();
        final String Name=name.getText().toString();
        final String DOB=dobdd.getText().toString()+"/"+dobmm.getText().toString()+"/"+dobyy.getText().toString();
        final String Phone=phone.getText().toString();
        final String Locality=locality.getText().toString();
        final String Pin=pin.getText().toString();
        final String Edu=edu.getText().toString();
        final String Training = train.getText().toString();
        final String Skills=skills.getText().toString();
        final String City=city.getText().toString();
        final String State=state.getText().toString();
        final String District=district.getText().toString();


        candidates candy=new candidates();
        candy.setCandidateId(FirebaseAuth.getInstance().getUid());
        candy.setCity(City);
        candy.setDob(DOB);
        candy.setEdu(Edu);
        candy.setPhone(Phone);
        candy.setState(State);
        candy.setName(Name);
        candy.setLocality(Locality);
        candy.setPin(Pin);
        candy.setExp(Exp);
        candy.setTrainings(Training);
        candy.setSkills(Skills);
        candy.setDistrict(District);
        candy.setCandidateId(FirebaseAuth.getInstance().getCurrentUser().getUid());
        candy.setEmail(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        candy.setPhotourl(FirebaseAuth.getInstance().getCurrentUser().getPhotoUrl().toString());

        findViewById(R.id.candidatebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Name.isEmpty())
                {
                    name.setError("Please Enter the name");
                    name.requestFocus();
                }
                else{

                    Toast.makeText(StudentDetails.this, "Details are saved", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getBaseContext(),Main2Activity.class));
                }
            }
        });

    }
}
