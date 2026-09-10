package com.example.myfirstapplication;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddContact extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        Button saveButton = findViewById(R.id.btnSaveContact);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editName = findViewById(R.id.editName);
                String name = editName.getText().toString();
                //Log.d("addContact", name);
                EditText editPhone = findViewById(R.id.editPhone);
                String phone = editPhone.getText().toString();
                DBHelper dbHelper = new DBHelper(AddContact.this);
                if (dbHelper.addContact(name, phone) == -1){
                    Toast.makeText(AddContact.this, "Not saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(AddContact.this, "saved", Toast.LENGTH_SHORT).show();                }


            }
        });
    }
}