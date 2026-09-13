package com.example.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowContacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contacts);
        loadContacts();
    }
    private void loadContacts(){
        Intent intent = getIntent();
        HashMap<String, String> allContacts= (HashMap<String, String>) intent.getSerializableExtra("contacts");
        ArrayList<String> rows = new ArrayList<>();
        if (allContacts != null) {
            for (String name : allContacts.keySet()) {
                Log.d("contacts", name + " " + allContacts.get(name));
                rows.add(name + " " + allContacts.get(name));
            }
        }

        ListView list = findViewById(R.id.listContacts);
        list.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, rows));

    }
}