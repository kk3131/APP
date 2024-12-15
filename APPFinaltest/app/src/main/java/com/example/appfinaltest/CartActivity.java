package com.example.appfinaltest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        RecyclerView cartRecyclerView = findViewById(R.id.cartRecyclerView);
        TextView totalTextView = findViewById(R.id.totalTextView);
        Button checkoutButton = findViewById(R.id.checkoutButton);


        cartRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        List<MyListData> cartItems = Cart.getInstance().getItems();

        //如果購物車沒有商品，顯示提示
        if (cartItems.isEmpty()) {
            Toast.makeText(this, "購物車是空的", Toast.LENGTH_SHORT).show();
        }


        MyListAdapter adapter = new MyListAdapter(cartItems, this);
        cartRecyclerView.setAdapter(adapter);

        //計算總金額
        double total = Cart.getInstance().calculateTotal();
        totalTextView.setText(String.format("總金額: $%.2f", total));

        checkoutButton.setOnClickListener(v -> {
            Cart.getInstance().clearCart(); //清空購物車
            adapter.notifyDataSetChanged(); //更新 RecyclerView
            totalTextView.setText("總金額: $0.00");
            Toast.makeText(this, "結帳成功，購物車已清空！", Toast.LENGTH_SHORT).show();
        });
    }
}
