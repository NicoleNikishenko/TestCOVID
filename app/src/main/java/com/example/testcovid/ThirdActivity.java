package com.example.testcovid;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;




public class ThirdActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);

        //Buttons Listeners
        final EditText siblingsNumber = findViewById(R.id.siblings_et);
        final Button acceptBtn = findViewById(R.id.accept);

        final Button backBtn = findViewById(R.id.backBtn3);
        final Button nextBtn = findViewById(R.id.nextBtn3);
        final Button cancelBtn = findViewById(R.id.cancel_btn);
        final Button endBtn = findViewById(R.id.end_btn);

        final CheckBox checkBox = findViewById(R.id.checkbox);

        final LinearLayout siblingsLayout = findViewById(R.id.siblings_layout);
        final LinearLayout questionLayout = findViewById(R.id.question_layout);
        final TextView infoTV = findViewById(R.id.info_tv);
        final RelativeLayout popUp = findViewById(R.id.agree_popup);
        final ScrollView scroll = findViewById(R.id.scroll_view);

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (siblingsNumber.getText().toString().isEmpty())
                {
                    acceptBtn.callOnClick();
                    return;
                }

                scroll.setVisibility(View.GONE);
                siblingsLayout.setVisibility(View.GONE);
                questionLayout.setVisibility(View.GONE);
                infoTV.setVisibility(View.GONE);
                backBtn.setVisibility(View.GONE);
                nextBtn.setVisibility(View.GONE);

                popUp.setVisibility(View.VISIBLE);
            }

        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkBox.setChecked(false);
                scroll.setVisibility(View.VISIBLE);
                siblingsLayout.setVisibility(View.VISIBLE);
                questionLayout.setVisibility(View.VISIBLE);
                infoTV.setVisibility(View.VISIBLE);
                backBtn.setVisibility(View.VISIBLE);
                nextBtn.setVisibility(View.VISIBLE);
                popUp.setVisibility(View.GONE);

            }

        });



        backBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ThirdActivity.this, SecondActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                startActivity(intent);
            }
        });

        endBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ThirdActivity.this, EndScreen.class);
                startActivity(intent);

            }
        });

        //Accept button

        final float density = getResources().getDisplayMetrics().density;
        final boolean[] flag = {false};


        checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    endBtn.setEnabled(true);
                }
                else
                    endBtn.setEnabled(false);
            }
        });

        acceptBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String numberOfSiblingsStr = siblingsNumber.getText().toString();
                siblingsLayout.removeAllViews();

                if(numberOfSiblingsStr.isEmpty())
                {
                    siblingsNumber.setError(getString(R.string.must_enter)+ getString(R.string.number) );
                    flag[0] = true;
                    return;
                }

                int numOfSiblings = Integer.parseInt(numberOfSiblingsStr);


                for(int i=0;i<numOfSiblings;i++) {


                    LinearLayout layout = new LinearLayout(ThirdActivity.this);
                    layout.setOrientation(LinearLayout.HORIZONTAL);
                    layout.setPadding(0,(int)(10*density),0,(int)(10*density));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    layoutParams.setMargins(0,0,0,(int)(5*density));
                    layout.setBackgroundResource(R.drawable.edit_text_selector);
                    layout.setLayoutParams(layoutParams);
                    siblingsLayout.addView(layout);


                    EditText et1 = new EditText(ThirdActivity.this);
                    EditText et2 = new EditText(ThirdActivity.this);
                    EditText et3 = new EditText(ThirdActivity.this);

                    LinearLayout.LayoutParams etParams1 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1.5f);
                    LinearLayout.LayoutParams etParams2 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,2f);
                    LinearLayout.LayoutParams etParams3 = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT,1f);
                    etParams1.setMargins((int)(10*density),0,(int)(10*density),0);
                    etParams3.setMargins((int)(10*density),0,(int)(10*density),0);

                    et1.setPadding((int)(5*density),(int)(5*density),(int)(5*density),(int)(5*density));
                    et1.setMaxLines(1);
                    et1.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                    et1.setBackgroundResource(R.drawable.edit_text_selector);
                    et1.setHint(R.string.first_name);
                    et1.setLayoutParams(etParams1);
                    et1.setImeOptions(EditorInfo.IME_ACTION_DONE);
                    et1.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    et2.setPadding((int)(5*density),(int)(5*density),(int)(5*density),(int)(5*density));
                    et2.setMaxLines(1);
                    et2.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);
                    et2.setBackgroundResource(R.drawable.edit_text_selector);
                    et2.setHint(R.string.last_name);
                    et2.setLayoutParams(etParams2);
                    et2.setImeOptions(EditorInfo.IME_ACTION_DONE);
                    et2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    et3.setPadding((int)(5*density),(int)(5*density),(int)(5*density),(int)(5*density));
                    et3.setMaxLines(1);
                    et3.setInputType(InputType.TYPE_CLASS_NUMBER);
                    et3.setBackgroundResource(R.drawable.edit_text_selector);
                    et3.setHint(R.string.age);
                    et3.setLayoutParams(etParams3);
                    et3.setImeOptions(EditorInfo.IME_ACTION_DONE);
                    et3.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

                    layout.addView(et1);
                    layout.addView(et2);
                    layout.addView(et3);

                }
            }
        });


    }
}