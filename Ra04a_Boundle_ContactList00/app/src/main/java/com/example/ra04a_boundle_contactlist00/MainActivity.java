package com.example.ra04a_boundle_contactlist00;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(MainActivity.this, SecondActivity.class);
                intent.putExtras(setupBundle());
                startActivity(intent);
            }
        });
    }
    Bundle setupBundle(){
        EditText EditTextName=(EditText) findViewById(R.id.editTextText);
        String Name=EditTextName.getText().toString();

        EditText EditTextTel=(EditText) findViewById(R.id.editTextText2);
        String Tel=EditTextTel.getText().toString();

        EditText EditTextPhone=(EditText) findViewById(R.id.editTextText3);
        String Phone=EditTextPhone.getText().toString();

        EditText EditTextEmail=(EditText) findViewById(R.id.editTextText4);
        String Email=EditTextEmail.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("Name",Name);
        bundle.putString("Tel",Tel);
        bundle.putString("Phone",Phone);
        bundle.putString("Email",Email);
        return bundle;
    }
}