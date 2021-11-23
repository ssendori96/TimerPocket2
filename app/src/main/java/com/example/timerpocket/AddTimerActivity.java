package com.example.timerpocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class AddTimerActivity extends AppCompatActivity {

    boolean alrSwitchCheck;
    boolean vibSwitchCheck;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_timer);
        setTitle("타이머 추가");

        EditText edtTimerName = (EditText) findViewById(R.id.edtTimerName);
        EditText edtHour, edtMin, edtSec;
        edtHour = (EditText) findViewById(R.id.edtHour);
        edtMin = (EditText) findViewById(R.id.edtMin);
        edtSec = (EditText) findViewById(R.id.edtSec);


        Switch switchAlr, switchVib;
        switchAlr = (Switch) findViewById(R.id.switchAlr);
        switchVib = (Switch) findViewById(R.id.switchVib);

        switchAlr.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) alrSwitchCheck = true;
                else alrSwitchCheck = false;
            }
        });
        switchVib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) vibSwitchCheck = true;
                else vibSwitchCheck = false;
            }
        });



        Button btnTimerCancel, btnTimerSave;
        btnTimerCancel = (Button) findViewById(R.id.btnTimerCancel);
        btnTimerSave = (Button) findViewById(R.id.btnTimerSave);

        btnTimerCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btnTimerSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), InFolderActivity.class);
                intent.putExtra("TimerName", edtTimerName.getText().toString());
                intent.putExtra("Hour", Integer.parseInt(edtHour.getText().toString()));
                intent.putExtra("Minute", Integer.parseInt(edtMin.getText().toString()));
                intent.putExtra("Second", Integer.parseInt(edtSec.getText().toString()));
                intent.putExtra("AlarmCheck", alrSwitchCheck);
                intent.putExtra("VibCheck", vibSwitchCheck);
                finish();
            }
        });


    }
}
