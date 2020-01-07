package cn.ololee.sql;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button button;
    private MySqlLiteHelper sqlLiteHelper;
    private Button addData;
    private Button getData;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences=getSharedPreferences("main",Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        final String content=sharedPreferences.getString("fruits","你还没有存储内容!!!");
        //Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
        button=findViewById(R.id.createSql);
        sqlLiteHelper=new MySqlLiteHelper(this,"BookStore.db",null,1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database=LitePal.getDatabase();
               /* SQLiteDatabase sqLiteDatabase=sqlLiteHelper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put("name","达芬奇密码");
                contentValues.put("author","Dan Brown");
                contentValues.put("pages",454);
                contentValues.put("price",18.88);
                sqLiteDatabase.insert("Book",null,contentValues);
                sqLiteDatabase.update("Book",contentValues,"name=",new String[]{"达芬奇密码"});
                contentValues.clear();*/
                //Cursor cursor=sqLiteDatabase.query("Book","","","","","","");
                //
            }
        });
        addData=findViewById(R.id.addData);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book(1001,"Dan Brown",14.96,251,"达芬奇的密码");
                book.save();
            }
        });
        getData=findViewById(R.id.getData);
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        List<String> fruitList=new ArrayList<>();
        String[] fruits={"apple","orange","watermellon","strawberry","lemon","pear","banana"};
        for (int i = fruits.length - 1; i >= 0; i--) {
            fruitList.add(fruits[i]);
        }
        String fruitStr="";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            fruitStr=fruitList.stream().collect(Collectors.joining(","));
        }
        editor.putString("fruits",fruitStr);
        editor.apply();
    }
}
