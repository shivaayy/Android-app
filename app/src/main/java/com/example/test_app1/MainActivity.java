package com.example.test_app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button)findViewById(R.id.button);

        t1=(TextView)findViewById(R.id.pass);

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month=month+1;
                        String s=dayOfMonth+"/"+month+"/"+year;

                        t1.setText(s);

                    }
                },
                        Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView username=(TextView)findViewById(R.id.user);
                TextView password=(TextView)findViewById(R.id.pass);
                TextView t=(TextView)findViewById(R.id.twarn);
                if (username.getText().toString().equals("shivam")&& password.getText().toString().equals("23/1/2020"))
                {
                    t.setText("Login Successful");

                }
                else
                {   t.setText("You Enter Wrong Username or Password !!!");
                    Vibrator vib=(Vibrator)getSystemService(VIBRATOR_SERVICE);
                    vib.vibrate(1000);

                }

            }
        });
    }
}
