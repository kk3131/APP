package com.example.appquiz20241225_12130126;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String ISBN = getIntent().getStringExtra("ISBN");
        String name = getIntent().getStringExtra("name");
        String productId = getIntent().getStringExtra("productId");
        String description = getIntent().getStringExtra("description");
        double price = getIntent().getDoubleExtra("price", 0.0);
        int imageId = getIntent().getIntExtra("imageId", 0);
        String studentInfo = getIntent().getStringExtra("studentInfo");

        //String category = getIntent().getStringExtra("category");

        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView productIdTextView = findViewById(R.id.productIdTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        TextView studentInfoTextView = findViewById(R.id.student_info);
        ImageView productImageView = findViewById(R.id.productImageView);
        Button backButton = findViewById(R.id.backButton);
        Button addToCartButton = findViewById(R.id.addToCartButton);
        Button goToCartButton = findViewById(R.id.goToCartButton);

        nameTextView.setText("品名: " + name);
        productIdTextView.setText("編號: " + productId);
        priceTextView.setText(String.format("價格: $%.2f", price));
        descriptionTextView.setText("描述: " + description);
        studentInfoTextView.setText("12130126 劉芳妤");
        productImageView.setImageResource(imageId);

        backButton.setOnClickListener(v -> finish());

        addToCartButton.setOnClickListener(v -> {
            Log.d("SecondActivity", "Add to Cart button clicked");

            MyListData product = new MyListData(name, imageId, description, productId, price, ISBN);

            //將商品加入購物車
            Cart.getInstance().addItem(product);


            Toast.makeText(this, name + " 已經被加入購物車", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SecondActivity.this, MainActivity.class);//自動回到商品瀏覧頁面
            startActivity(intent);
        });

        goToCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}