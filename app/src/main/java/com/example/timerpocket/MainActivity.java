package com.example.timerpocket;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    View dialogView;
    EditText dlgEdtFolderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("타이머 포켓");


        final ImageView imgBookmark = (ImageView) findViewById(R.id.imgBookmark);
        final ImageView imgBookmark2 = (ImageView) findViewById(R.id.imgBookmark2);

        // 즐겨찾기 버튼 터치시 동작(빈 별 -> 색칠된 별) -> 이후에 즐겨찾기한 타이머들만 나오도록 기능 추가
        imgBookmark.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imgBookmark.setVisibility(View.GONE);
                imgBookmark2.setVisibility(View.VISIBLE);
                return true;
            }
        });

        // 즐겨찾기 버튼 터치시 동작(색칠된 별 -> 빈 별) -> 다시 본래 폴더 목록들이 나오도록
        imgBookmark2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                imgBookmark2.setVisibility(View.GONE);
                imgBookmark.setVisibility(View.VISIBLE);
                return true;
            }
        });


        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = (ListView) findViewById(R.id.listFolder);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        list.setAdapter(adapter);

        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        // 폴더 추가 버튼 클릭시 기능 -> 대화상자 형식으로 폴더명 입력 받고 해당 폴더명으로 ListView 생성
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.new_folder, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("폴더 추가");
                dlg.setIcon(R.drawable.folder_icon);
                dlg.setView(dialogView);

                dlg.setPositiveButton("추가", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dlgEdtFolderName = (EditText) dialogView.findViewById(R.id.dlgEdtFolderName);

                        midList.add(dlgEdtFolderName.getText().toString());
                        adapter.notifyDataSetChanged();
                        Toast.makeText(MainActivity.this, "폴더가 추가되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });


        // ListView 클릭시 InFolderActivity로 넘어감


    }
}