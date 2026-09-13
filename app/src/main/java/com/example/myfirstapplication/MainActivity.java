package com.example.myfirstapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button addButton = findViewById(R.id.main_add_contact);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                System.out.println("Hello");
//                Toast.makeText(MainActivity.this,                     "Button clicked",
//                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, AddContact.class);
                startActivity(intent);
//
            }
        });

        Button showButton = findViewById(R.id.main_show_contact);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper helper = new DBHelper(MainActivity.this);
                HashMap<String, String> allContacts = helper.getAllContacts();
                for (String name: allContacts.keySet()){
                    Log.d("contacts", name + " "+allContacts.get(name));
                }

                Intent intent = new Intent(MainActivity.this, ShowContacts.class);
                intent.putExtra("contacts", allContacts);
                startActivity(intent);

            }
        });

    }

    /**
     * The activity is now in the foreground and accepting input.
     * Runs on every return, not just the first time — so it fires
     * after Back from another activity, when onCreate does not.
     *
     * Do here: refresh data that may have changed while you were away,
     * restart animations, re-acquire the camera or sensors.
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE", "onResume");
    }

    /**
     * Something is covering the activity — a dialog, an incoming call,
     * another app. Still partly visible, no longer interactive.
     *
     * The last callback the system GUARANTEES to call. Everything after
     * it can be skipped if the process is killed.
     *
     * Keep it fast: the next activity cannot draw until this returns.
     * Do here: pause video, release the camera, stop animations.
     */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE", "onPause");
    }

    /**
     * The activity is now completely hidden. The instance still exists
     * in memory, so all your fields and listeners are intact.
     *
     * No timing pressure here, unlike onPause.
     * Do here: persist drafts and unsaved form state, unregister
     * broadcast receivers, stop location updates.
     */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE", "onStop");
    }

    /**
     * The activity is being torn down — the user finished it, or the
     * system reclaimed it, or the screen rotated.
     *
     * NOT guaranteed. A process killed under memory pressure skips this
     * entirely, so never put must-not-lose work here.
     *
     * Do here: cleanup that only matters while the object lives —
     * close cursors, stop threads, release listeners you registered
     * on long-lived objects.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE", "onDestroy");
    }
}



