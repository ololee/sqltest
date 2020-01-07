package cn.ololee.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


/*
create table Book(
id integer primary key autoincrement,
author text,
price real,
pages integr,
name text
)

*/
public class MySqlLiteHelper extends SQLiteOpenHelper {
    public static final String  CREATE_BOOK="create table Book(\n" +
            "id integer primary key autoincrement,\n" +
            "author text,\n" +
            "price real,\n" +
            "pages integr,\n" +
            "name text\n" +
            ")";
    private Context context;
    public MySqlLiteHelper( Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BOOK);
        Toast.makeText(context,"创建database成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
