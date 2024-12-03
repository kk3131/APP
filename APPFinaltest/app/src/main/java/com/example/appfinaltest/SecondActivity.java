package com.example.appfinaltest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 接收從 MainActivity 傳遞過來的數據
        String name = getIntent().getStringExtra("name");
        String productId = getIntent().getStringExtra("productId");
        String description = getIntent().getStringExtra("description");
        double price = getIntent().getDoubleExtra("price", 0.0);
        int imageId = getIntent().getIntExtra("imageId", 0);

        // 綁定視圖
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView productIdTextView = findViewById(R.id.productIdTextView);
        TextView priceTextView = findViewById(R.id.priceTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        ImageView productImageView = findViewById(R.id.productImageView);
        Button backButton = findViewById(R.id.backButton);

        // 設定資料到視圖
        nameTextView.setText("品名: " + name);
        productIdTextView.setText("編號: " + productId);
        priceTextView.setText(String.format("價格: $%.2f", price));
        descriptionTextView.setText("描述: " + description);
        productImageView.setImageResource(imageId);

        // 返回按鈕點擊事件
        backButton.setOnClickListener(v -> {
            // 結束當前活動，返回到上一個活動
            finish();
        });
    }
}
