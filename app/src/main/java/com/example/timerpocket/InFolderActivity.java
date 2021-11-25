package com.example.timerpocket;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class InFolderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.in_folder);

        Button btnTimerAdd = (Button) findViewById(R.id.btnTimerAdd);


        btnTimerAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), AddTimerActivity.class);
                startActivity(outIntent);
            }
        });

        Intent inIntent = getIntent();
        String timerName = inIntent.getStringExtra("TimerName");
        int hour = inIntent.getIntExtra("Hour", 0);
        int minute = inIntent.getIntExtra("Minute", 0);
        int second = inIntent.getIntExtra("Second", 0);
        boolean alr;



        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = (ListView) findViewById(R.id.listTimer);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);












    }
}
