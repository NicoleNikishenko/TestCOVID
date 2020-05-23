package com.example.testcovid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        //declarations


        final RadioGroup radioGroup1 = findViewById(R.id.rg_first_q);
        final RadioGroup radioGroup2 = findViewById(R.id.rg_second_q);
        final RadioGroup radioGroup3 = findViewById(R.id.rg_third_q);
        final RadioGroup radioGroup4 = findViewById(R.id.rg_forth_q);
        final RadioGroup radioGroup5 = findViewById(R.id.rg_fifth_q);
        final RadioGroup radioGroup6 = findViewById(R.id.rg_sixth_q);
        final RadioGroup radioGroup7 = findViewById(R.id.rg_seventh_q);

        final EditText question4Et = findViewById(R.id.et_forth_q);
        final EditText question5Et = findViewById(R.id.et_fifth_q);
        final EditText question6Et = findViewById(R.id.et_sixth_q);

        //Next + Back Button

        Button nextBtn = findViewById(R.id.nextBtn2);
        Button backBtn = findViewById(R.id.backBtn2);


        backBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);


                boolean flag = false;

                if (radioGroup1.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup1.getChildCount()-1;
                    ((RadioButton)radioGroup1.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if (radioGroup2.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup2.getChildCount()-1;
                    ((RadioButton)radioGroup2.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if (radioGroup3.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup3.getChildCount()-1;
                    ((RadioButton)radioGroup3.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if (radioGroup4.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup4.getChildCount()-1;
                    ((RadioButton)radioGroup4.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if (radioGroup5.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup5.getChildCount()-1;
                    ((RadioButton)radioGroup5.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if (radioGroup6.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup6.getChildCount()-1;
                    ((RadioButton)radioGroup6.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if (radioGroup7.getCheckedRadioButtonId() == -1) {
                    int lastChildPos=radioGroup7.getChildCount()-1;
                    ((RadioButton)radioGroup7.getChildAt(lastChildPos)).setError("");
                    flag = true;
                }
                if(question4Et.isEnabled() == true)
                {
                    if (question4Et.getText().toString().isEmpty())
                    {
                        question4Et.setError(getString(R.string.must_elaborate));
                        flag = true;
                    }
                }
                if(question5Et.isEnabled() == true)
                {
                    if (question5Et.getText().toString().isEmpty())
                    {
                        question5Et.setError(getString(R.string.must_elaborate));
                        flag = true;
                    }
                }
                if(question6Et.isEnabled() == true)
                {
                    if (question6Et.getText().toString().isEmpty())
                    {
                        question6Et.setError(getString(R.string.must_elaborate));
                        flag = true;
                    }
                }


                if(!flag)
                {
                    intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivity(intent);
                }


            }
        });


        //Collapse forth et
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup1.getChildCount()-1;
                ((RadioButton)radioGroup1.getChildAt(lastChildPos)).setError(null);

            }
        });
        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup2.getChildCount()-1;
                ((RadioButton)radioGroup2.getChildAt(lastChildPos)).setError(null);

            }
        });
        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup3.getChildCount()-1;
                ((RadioButton)radioGroup3.getChildAt(lastChildPos)).setError(null);

            }
        });
        radioGroup7.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup7.getChildCount()-1;
                ((RadioButton)radioGroup7.getChildAt(lastChildPos)).setError(null);

            }
        });


        radioGroup4.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup4.getChildCount()-1;
                ((RadioButton)radioGroup4.getChildAt(lastChildPos)).setError(null);

                if (checkedId == (R.id.q4_no)) {
                    question4Et.setEnabled(false);
                    question4Et.setText("");
                    question4Et.setError(null);
                }
                if(checkedId == R.id.q4_yes){
                    question4Et.setEnabled(true);

                }
            }
        });

        //Collapse fifth et


        radioGroup5.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup5.getChildCount()-1;
                ((RadioButton)radioGroup5.getChildAt(lastChildPos)).setError(null);

                if (checkedId == (R.id.q5_no)) {
                    question5Et.setEnabled(false);
                    question5Et.setText("");
                    question5Et.setError(null);

                }
                if(checkedId == R.id.q5_yes){
                    question5Et.setEnabled(true);
                }

            }
        });

        //Collapse sixth et


        radioGroup6.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                int lastChildPos=radioGroup6.getChildCount()-1;
                ((RadioButton)radioGroup6.getChildAt(lastChildPos)).setError(null);

                if (checkedId == (R.id.q6_no)) {
                    question6Et.setEnabled(false);
                    question6Et.setText("");
                    question6Et.setError(null);

                }
                if(checkedId == R.id.q6_yes){
                    question6Et.setEnabled(true);
                }

            }
        });
    }
}
