package com.example.ra04a_boundle_contactlist00;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Bundle bundle=this.getIntent().getExtras();
        String Name=bundle.getString("Name");
        String Tel=bundle.getString("Tel");
        String Phone=bundle.getString("Phone");
        String Email=bundle.getString("Email");

        TextView tv1=(TextView)findViewById(R.id.textView8);
        TextView tv2=(TextView)findViewById(R.id.textView9);
        TextView tv3=(TextView)findViewById(R.id.textView10);
        TextView tv4=(TextView)findViewById(R.id.textView11);

        tv1.setText("姓名: "+Name);
        tv2.setText("電話: "+Tel);
        tv3.setText("手機: "+Phone);
        tv4.setText("Email: "+Email);



    }
}