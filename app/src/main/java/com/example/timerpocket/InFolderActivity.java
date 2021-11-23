package com.example.timerpocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class InFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_folder);

        Button btnTimerAdd = (Button) findViewById(R.id.btnTimerAdd);
        ListView list = (ListView) findViewById(R.id.listTimer);

        btnTimerAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), AddTimerActivity.class);
                startActivity(outIntent);
            }
        });

        Intent inIntent = getIntent();
        String timerName = inIntent.getStringExtra("TimerName");









    }
}
