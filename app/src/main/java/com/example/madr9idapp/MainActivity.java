package com.example.madr9idapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etID;
    Button btnClear, btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            etID.setText("");
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = etID.getText().toString().trim();
                if(id.length() != 13)
                {
                    tvResult.setText("");
                    Toast.makeText(MainActivity.this, "Total number of digits must be 13", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String dob = id.substring(0,6);
                    String year = "20"+dob.substring(0,2);
                    String month = dob.substring(2,4);
                    int m  = Integer.parseInt(month);
                    String months[] = {"", "January", "Feb", "March",
                    "April", "May", "June", "July", "Aug", "Sept", "Oct"
                    ,"Nov", "Dec"};

                    String day = dob.substring(4,6);

                    String dateOfBirth = day+"/"+months[m]+"/"+year;
                    String gender;
                    int gen = Integer.parseInt(id.substring(6,10));
                    if(gen<5000)
                    {
                        gender = "Female";
                    }
                    else
                    {
                        gender = "Male";
                    }

                    String citizenShip;
                    if(id.charAt(10)=='0')
                    {
                        citizenShip = "SA Citizen";
                    }
                    else if(id.charAt(10)=='1')
                    {
                        citizenShip = "Permanent Resident";
                    }
                    else
                    {
                        citizenShip = "Invalid Digit";
                    }

                    String validity;

                    if(id.charAt(12) == '0')
                    {
                        validity = "Invalid";
                    }
                    else
                    {
                        validity = "Valid";
                    }

                    String text = "DOB : "+dateOfBirth +"\n"
                            +"Gender : "+gender+"\n"
                            +"Nationality : "+citizenShip+"\n"
                            +"Validity : "+validity;
                    tvResult.setText(text);

                }

            }
        });


    }

    public void init()
    {
        etID = findViewById(R.id.etID);
        btnClear = findViewById(R.id.btnClear);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);
    }


}