package com.example.appmidterm1106_12130126;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        String title = getIntent().getStringExtra("title");
        String description = getIntent().getStringExtra("description");


        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        titleTextView.setText(title);
        descriptionTextView.setText(description);
    }
}
