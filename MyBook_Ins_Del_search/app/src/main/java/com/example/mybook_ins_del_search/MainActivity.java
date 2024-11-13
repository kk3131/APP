package com.example.mybook_ins_del_search;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Book> bookList;
    private BookAdapter bookAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = new ArrayList<>();
        bookAdapter = new BookAdapter(bookList);
        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(bookAdapter);

        // 設定點擊事件
        bookAdapter.setOnItemClickListener(position -> editBook(position));
    }

    public void addBook(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("新增書籍");

        final EditText inputName = new EditText(this);
        inputName.setHint("輸入書名");
        final EditText inputNumber = new EditText(this);
        inputNumber.setHint("輸入編號");

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(inputName);
        layout.addView(inputNumber);
        builder.setView(layout);

        builder.setPositiveButton("儲存", (dialog, which) -> {
            String bookName = inputName.getText().toString();
            String bookNumber = inputNumber.getText().toString();

            if (!bookName.isEmpty() && !bookNumber.isEmpty()) {
                bookList.add(new Book(bookName, bookNumber));
                bookAdapter.notifyItemInserted(bookList.size() - 1);
            } else {
                Toast.makeText(this, "請輸入完整資料", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("取消", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    private void editBook(int position) {
        Book selectedBook = bookList.get(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("編輯書籍");

        final EditText inputName = new EditText(this);
        inputName.setText(selectedBook.getName());
        final EditText inputNumber = new EditText(this);
        inputNumber.setText(selectedBook.getNumber());

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(inputName);
        layout.addView(inputNumber);
        builder.setView(layout);

        builder.setPositiveButton("儲存", (dialog, which) -> {
            selectedBook.setName(inputName.getText().toString());
            selectedBook.setNumber(inputNumber.getText().toString());
            bookAdapter.notifyItemChanged(position);
        });

        builder.setNegativeButton("取消", (dialog, which) -> dialog.cancel());
        builder.show();
    }

    public void deleteBook(View view) {
        if (!bookList.isEmpty()) {
            int lastPosition = bookList.size() - 1;
            bookList.remove(lastPosition);
            bookAdapter.notifyItemRemoved(lastPosition);
        } else {
            Toast.makeText(this, "無項目可刪除", Toast.LENGTH_SHORT).show();
        }
    }
}