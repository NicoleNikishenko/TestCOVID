package com.example.testcovid;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    final boolean[] infoScreen = {false};
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private  FloatingActionButton helpBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Edit texts declarations
        final EditText kupaEt = (EditText)findViewById(R.id.et_kupa);
        final Spinner genderSpinner = (Spinner) findViewById(R.id.gender_spinner);
        final Spinner kupaSpinner = (Spinner) findViewById(R.id.kupa_spinner);

        final EditText firstName = findViewById(R.id.et_first_name);
        final EditText lastName = findViewById(R.id.et_last_name);
        final EditText id = findViewById(R.id.et_id);
        final EditText city = findViewById(R.id.et_city);
        final EditText street = findViewById(R.id.et_street);
        final EditText phoneNum = findViewById(R.id.et_phone_number);

        final TextView infoTv = findViewById(R.id.first_layout_tv);
        final LinearLayout linearLayout = findViewById(R.id.first_layout_ll);
        final RelativeLayout layout = findViewById(R.id.mainLayout);
        final LinearLayout popUp =findViewById(R.id.help_popup);
        final Button nextBtn = findViewById(R.id.nextBtn1);


        //Floating Action Button


        helpBtn = findViewById(R.id.floatingActionButton);

        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!infoScreen[0]) {
                    infoScreen[0] = true;
                    popUp.setVisibility(View.VISIBLE);
                    infoTv.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.GONE);
                    nextBtn.setVisibility(View.GONE);
                    layout.setBackgroundColor(Color.GRAY);
                    helpBtn.setImageResource(R.drawable.ic_close);
                }
                else {
                    infoScreen[0] = false;
                    popUp.setVisibility(View.GONE);
                    infoTv.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.VISIBLE);
                    nextBtn.setVisibility(View.VISIBLE);
                    layout.setBackgroundResource(R.drawable.background_shape);
                    helpBtn.setImageResource(R.drawable.help_icon);
                }
            }
        });

        //Next Button


        nextBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);

                boolean flag = false;


                if(firstName.getText().toString().isEmpty()) {
                    firstName.setError(getString(R.string.must_enter)+ getString(R.string.first_name) );
                    flag = true;
                }
                if(lastName.getText().toString().isEmpty()) {
                    lastName.setError(getString(R.string.must_enter)+ getString(R.string.last_name) );
                    flag = true;
                }
                if(id.getText().toString().isEmpty()) {
                    id.setError(getString(R.string.must_enter)+ getString(R.string.id_number) );
                    flag = true;
                }
                if(city.getText().toString().isEmpty()) {
                    city.setError(getString(R.string.must_enter)+ getString(R.string.city) );
                    flag = true;
                }
                if(street.getText().toString().isEmpty()) {
                    street.setError(getString(R.string.must_enter)+ getString(R.string.street) );
                    flag = true;
                }
                if(phoneNum.getText().toString().isEmpty()) {
                    phoneNum.setError(getString(R.string.must_enter)+ getString(R.string.phone_number) );
                    flag = true;
                }
                if(mDisplayDate.getText() == (getString(R.string.birth_year))) {
                    mDisplayDate.setError("");
                    flag = true;
                }
                if(genderSpinner.getSelectedItem() == getString(R.string.gender)) {
                    ((TextView)genderSpinner.getSelectedView()).setError("");
                    flag = true;
                }
                if(kupaSpinner.getSelectedItem() == getString(R.string.hmo_kupa)) {
                    ((TextView)kupaSpinner.getSelectedView()).setError("");
                    flag = true;
                }
                if(kupaEt.getVisibility() == View.VISIBLE)
                {
                    if (kupaEt.getText().toString().isEmpty())
                    {
                        kupaEt.setError(getString(R.string.must_elaborate));
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


        //Spinners







        List<String> genderArr = new ArrayList<>();
        genderArr.add(getString(R.string.female));
        genderArr.add(getString(R.string.male));
        genderArr.add(getString(R.string.gender));
        final int genderArrSize = genderArr.size() - 1;

        List<String> kupaArr= new ArrayList <>();
        kupaArr.add(getString(R.string.macabi));
        kupaArr.add(getString(R.string.clalit));
        kupaArr.add(getString(R.string.leumit));
        kupaArr.add(getString(R.string.meuhedet));
        kupaArr.add(getString(R.string.other));
        kupaArr.add(getString(R.string.hmo_kupa));
        final int kupaArrSize = kupaArr.size() - 1;

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, genderArr){
            @Override
            public int getCount() {
                return(genderArrSize); // Truncate the list
            }
        };

        ArrayAdapter<String> kupaAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, kupaArr){
            @Override
            public int getCount() {
                return(kupaArrSize); // Truncate the list
            }
        };



        genderAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        genderSpinner.setAdapter(genderAdapter);
        genderSpinner.setSelection(genderArrSize);
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                String itemValue = parent.getItemAtPosition(position).toString();
                if (!itemValue.equals(getString(R.string.gender))) {
                    ((TextView) view).setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        kupaAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        kupaSpinner.setAdapter(kupaAdapter);
        kupaSpinner.setSelection(kupaArrSize);
        kupaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemValue = parent.getItemAtPosition(position).toString();



                if (!itemValue.equals(getString(R.string.hmo_kupa))) {
                    ((TextView) view).setTextColor(Color.BLACK);

                    if (itemValue.equals(getString(R.string.other)))
                        kupaEt.setVisibility(View.VISIBLE);

                    else {
                        kupaEt.setVisibility(View.GONE);
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        //Date Picker



        mDisplayDate = (TextView) findViewById(R.id.birth_year_tv);
        mDisplayDate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day =cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog
                        (MainActivity.this , android.R.style.Theme_Holo_Light_Dialog_MinWidth ,mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getDatePicker().setMaxDate(System.currentTimeMillis());
                dialog.show();
            }
        });

        mDateSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
               Log.d( TAG, "onDateSet: mm/dd/yyyy:" + day + "/" + month + "/" + year);
                String date = getString(R.string.birth_year)+" : "+ day + "/" + month + "/" + year;
                mDisplayDate.setText(date);
                mDisplayDate.setTextColor(Color.BLACK);
                mDisplayDate.setError(null);
            }
        };

    }

    @Override
    public void onBackPressed() {
        if (infoScreen[0])
        {
            helpBtn.callOnClick();
        }
        else
            super.onBackPressed();
    }
}
