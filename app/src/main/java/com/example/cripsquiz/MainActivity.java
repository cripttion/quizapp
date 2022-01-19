package com.example.cripsquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questiontv,questionnumber;
    private Button option1btn,option2btn,option3btn,option4btn;
    private ArrayList<quizmodal> quizmodalarraylist;
    Random random;
    int currentScore = 0 , questionattempt = 1 , currentpost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questiontv = findViewById(R.id.idtvquestion);
        questionnumber = findViewById(R.id.idtvquestionAttempted);
        option1btn = findViewById(R.id.idtvoption1);
        option2btn = findViewById(R.id.idtvoption2);
        option3btn = findViewById(R.id.idtvoption3);
        option4btn = findViewById(R.id.idtvoption4);
        quizmodalarraylist = new ArrayList<>();
        random =  new Random();
       getQuizQuestion(quizmodalarraylist);
       currentpost = random.nextInt(quizmodalarraylist.size());
       setDataView(currentpost);
       option1btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               if(quizmodalarraylist.get(currentpost).getAnswer().trim().toLowerCase().equals(option1btn.getText().toString().trim().toLowerCase()));
                  {
                   currentScore++;

               }
               questionattempt++;
               currentpost=random.nextInt(quizmodalarraylist.size());
               setDataView(currentpost);


           }



       });

        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmodalarraylist.get(currentpost).getAnswer().trim().toLowerCase().equals(option2btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;

                }
                questionattempt++;
                currentpost=random.nextInt(quizmodalarraylist.size());
                setDataView(currentpost);


            }



        });

        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmodalarraylist.get(currentpost).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;

                }
                questionattempt++;
                currentpost=random.nextInt(quizmodalarraylist.size());
                setDataView(currentpost);


            }



        });

        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizmodalarraylist.get(currentpost).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;

                }
                questionattempt++;
                currentpost=random.nextInt(quizmodalarraylist.size());
                setDataView(currentpost);


            }



        });

        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(quizmodalarraylist.get(currentpost).getAnswer().trim().toLowerCase().equals(option4btn.getText().toString().trim().toLowerCase()));
                {
                    currentScore++;

                }
                questionattempt++;
                currentpost=random.nextInt(quizmodalarraylist.size());
                setDataView(currentpost);


            }



        });

    }

    private void show_bottom_sheet(){
        BottomSheetDialog  bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomsheetview = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottom_sheet,(LinearLayout)findViewById(R.id.idtvlinerlayout));
        TextView scoretv = bottomsheetview.findViewById(R.id.idtvscore);
        Button restarttv = bottomsheetview.findViewById(R.id.idtvrestart);
        scoretv.setText("Your score \n"+currentScore+"/4");

        restarttv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentpost = random.nextInt(quizmodalarraylist.size());
                setDataView(currentpost);
                questionattempt= 1;
                currentScore=0;
                bottomSheetDialog.dismiss();
            }

        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomsheetview);
        bottomSheetDialog.show();


    }

    private  void setDataView(int currentpost){
        if(questionattempt==4){
          show_bottom_sheet();
        }
        else{
            questionnumber.setText("Questions Attempted :"+questionattempt+"/10");
            questiontv.setText(quizmodalarraylist.get(currentpost).getQuestion());
            option1btn.setText(quizmodalarraylist.get(currentpost).getOption1());
            option2btn.setText(quizmodalarraylist.get(currentpost).getOption2());
            option3btn.setText(quizmodalarraylist.get(currentpost).getOption3());
            option4btn.setText(quizmodalarraylist.get(currentpost).getOption4());
        }



    }

    private void getQuizQuestion(ArrayList<quizmodal>quizmodalarraylist){

        quizmodalarraylist.add(new quizmodal("what is the minumum age to give voite","18","22","17","21","18"));
        quizmodalarraylist.add(new quizmodal("who is the prime minister of India","Amit sahah","Yogi aditya nath ","Narendra modi","Lalu yadav","Narendra modi"));
        quizmodalarraylist.add(new quizmodal("Most advanced coding language ","c++","c ","java","python","python"));
        quizmodalarraylist.add(new quizmodal("who is elon musk ","a genius ","a mental ","ALien thinker","All of the above","All of the above"));


    }

}