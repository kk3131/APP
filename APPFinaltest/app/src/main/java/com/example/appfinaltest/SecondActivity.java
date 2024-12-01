package com.example.appfinaltest;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String name = getIntent().getStringExtra("name");
        String productId = getIntent().getStringExtra("productId");
        String description = getIntent().getStringExtra("description");
        double price = getIntent().getDoubleExtra("price", 0.0);
        int imageId = getIntent().getIntExtra("imageId", 0);

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView productIdTextView = findViewById(R.id.productIdTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView productImageView = findViewById(R.id.productImageView);

        nameTextView.setText("品名: " + name);
        productIdTextView.setText("編號: " + productId);
        priceTextView.setText("價格: $" + price);
        descriptionTextView.setText("描述: " + description);
        productImageView.setImageResource(imageId);
    }
}
