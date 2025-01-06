package com.example.dbcontentprovidertest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.example.dbcontentprovidertest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String PROVIDER_URI = "content://com.example.dbcontentprovidertest.StudentProvider";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.insert.setOnClickListener(v -> {
            ContentValues addRowValue = new ContentValues();

            addRowValue.put("number", "200106054");
            addRowValue.put("name", "홍길동");
            addRowValue.put("department", "컴퓨터");
            addRowValue.put("age", "18");
            addRowValue.put("grade", 3);

            getContentResolver().insert(Uri.parse(PROVIDER_URI), addRowValue);
            binding.editText.setText("recode add");
        });
        binding.query.setOnClickListener(v -> {
            String[] columns = new String[]{"_id", "number", "name",
                    "department", "age", "grade"};


            Cursor c = getContentResolver().query(
                    Uri.parse(PROVIDER_URI),
                    columns,
                    null, null, null);

            if (c != null) {
                binding.editText.setText("");

                while (c.moveToNext()) {
                    int id = c.getInt(0);
                    String number = c.getString(1);
                    String name = c.getString(2);
                    String department = c.getString(3);
                    String age = c.getString(4);
                    int grade = c.getInt(5);

                    binding.editText.append(
                            "id : " + id + "\n" +
                                    "number : " + number + "\n" +
                                    "name : " + name + "\n" +
                                    "department : " + department + "\n" +
                                    "age : " + age + "\n" +
                                    "grade : " + grade + "\n" +
                                    "----------------------------");

                }
                binding.editText.append("\n Total : " + c.getCount());
                //c.close();
            }
        });
        binding.update.setOnClickListener(v -> {
            ContentValues updateRowValue = new ContentValues();
            updateRowValue.put("name", "고길동");

            int updateRecordCnt = getContentResolver().update(
                    Uri.parse(PROVIDER_URI),
                    updateRowValue,
                    "number=200106054",
                    null);

            binding.editText.setText("레코드 갱신 : " + updateRecordCnt);
        });
        binding.delete.setOnClickListener(v -> {
            int deleteRecordCnt = getContentResolver().delete(
                    Uri.parse(PROVIDER_URI),
                    null, null);
            binding.editText.setText("삭제된 레코드 수 : " + deleteRecordCnt);
        });
    }
}