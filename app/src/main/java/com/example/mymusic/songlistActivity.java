package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class songlistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_songlist);
        ListView songlist;
        songlist=findViewById(R.id.songlist);
        ArrayList<String> songs=new ArrayList<>();
        songs.add("sampleaudio1");
        songs.add("sampleaudio2");
        songs.add("sampleaudio3");
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<>(songlistActivity.this,R.layout.list_item_str,songs);
        songlist.setAdapter(arrayAdapter);
        songlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent=new Intent(songlistActivity.this,songActivity2.class);
                intent.putExtra("number",position);
                startActivity(intent);
            }
        });

    }

}