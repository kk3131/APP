package com.example.appfinaltest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 將 JSON 資料載入 SQLite 資料庫
        JSONUtils.loadProductsToDatabase(this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<MyListData> productList = loadProductsFromDatabase(); // 從資料庫加載資料

        MyListAdapter adapter = new MyListAdapter(productList, this);
        recyclerView.setAdapter(adapter);

        Button goToCartButton = findViewById(R.id.goToCartButton);
        goToCartButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CartActivity.class);
            startActivity(intent);
        });
    }

    // 從資料庫查詢商品資料
    private List<MyListData> loadProductsFromDatabase() {
        List<MyListData> productList = new ArrayList<>();
        SQLiteHelper dbHelper = new SQLiteHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query("products", null, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                Log.d("Database", "SQL Query: SELECT * FROM products");

                String name = cursor.getString(cursor.getColumnIndex("name"));
                String productId = cursor.getString(cursor.getColumnIndex("productId"));
                String imageName = cursor.getString(cursor.getColumnIndex("imageId"));
                int imageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                String description = cursor.getString(cursor.getColumnIndex("description"));
                String test = cursor.getString(cursor.getColumnIndex("test"));

                productList.add(new MyListData(name, imageId, description, productId, price, test));
            }
            cursor.close();
        }
        db.close();
        return productList;
    }
}
