package com.example.curtislavaud.hope.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.example.curtislavaud.hope.Model.Footballer;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Curtis Lavaud on 24/03/2019.
 */

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME = "Footballers.db";
    private static final int DB_VER = 1;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER );
    }

    //Function, retrieve all footballers
    public List<Footballer> getFootballers()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names within table
        String[] sqlSelect={"Id","Name", "Age", "Position", "Email", "Area"};
        String tableName="Footballers"; //table name

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Footballer> result = new ArrayList<>() ;
        if(cursor.moveToFirst() ) {
            do {
                Footballer footballer = new Footballer();
                footballer.setId(cursor.getInt(cursor.getColumnIndex("Id")));
                footballer.setName(cursor.getString(cursor.getColumnIndex("Name")));
                footballer.setAge(cursor.getString(cursor.getColumnIndex("Age")));
                footballer.setPosition(cursor.getString(cursor.getColumnIndex("Position")));
                footballer.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
                footballer.setArea(cursor.getString(cursor.getColumnIndex("Area")));

                result.add(footballer);
            } while (cursor.moveToNext());

        }
        return result;
    }

    //Function get all footballer's position and area
    public List<String> getPositionAndArea()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names within table
        String[] sqlSelect={"Position" + "Area"};
        String tableName="Footballers"; //table name

        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<String> result = new ArrayList<>() ;
        if(cursor.moveToFirst() ) {
            do {
                result.add(cursor.getString(cursor.getColumnIndex("Position" + "Area")) );
            } while (cursor.moveToNext());

        }
        return result;
    }

    //Function get footballer by position and area
    public List<Footballer> getFootballerByPosition (String position)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names within table
        String[] sqlSelect={"Id","Name", "Age", "Position", "Email", "Area"};
        String tableName="Footballers"; //table name

        qb.setTables(tableName);
        //how query will appear in search bar
        Cursor cursor = qb.query(db, sqlSelect, "Position LIKE = ?", new String[]{"%" +position+"%"}, null, null, null);
        List<Footballer> result = new ArrayList<>() ;
        if(cursor.moveToFirst() ) {
            do {
                Footballer footballer = new Footballer();
                footballer.setId(cursor.getInt(cursor.getColumnIndex("Id")) );
                footballer.setName(cursor.getString(cursor.getColumnIndex("Name")));
                footballer.setAge(cursor.getString(cursor.getColumnIndex("Age")));
                footballer.setPosition(cursor.getString(cursor.getColumnIndex("Position")));
                footballer.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
                footballer.setArea(cursor.getString(cursor.getColumnIndex("Area")));

                result.add(footballer);
            } while (cursor.moveToNext());
        }
        return result;
    }
    //Function get footballer by position and area
    public List<Footballer> getFootballerByArea (String area)
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //all column names within table
        String[] sqlSelect={"Id","Name", "Age", "Position", "Email", "Area"};
        String tableName="Footballers"; //table name

        qb.setTables(tableName);
        //how query will appear in search bar
        Cursor cursor = qb.query(db, sqlSelect, "area LIKE = ?", new String[]{"%" +area+"%"}, null, null, null);
        List<Footballer> result = new ArrayList<>() ;
        if(cursor.moveToFirst() ) {
            do {
                Footballer footballer = new Footballer();
                footballer.setId(cursor.getInt(cursor.getColumnIndex("Id")) );
                footballer.setName(cursor.getString(cursor.getColumnIndex("Name")));
                footballer.setAge(cursor.getString(cursor.getColumnIndex("Age")));
                footballer.setPosition(cursor.getString(cursor.getColumnIndex("Position")));
                footballer.setEmail(cursor.getString(cursor.getColumnIndex("Email")));
                footballer.setArea(cursor.getString(cursor.getColumnIndex("Area")));

                result.add(footballer);
            } while (cursor.moveToNext());

        }
        return result;
    }

}
