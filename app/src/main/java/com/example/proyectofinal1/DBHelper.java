package com.example.proyectofinal1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.proyectofinal1.Model.User;

import java.util.ArrayList;

public class DBHelper {

    private Context con;
    private SQLiteDatabase db;


    public DBHelper(Context con){
        this.con = con;
    }

    public DBHelper OpenDB(){
        DBConnector dbCon = new DBConnector(con);
        db = dbCon.getWritableDatabase();
        return  this;

    }
    public boolean RegistrarUser(User user){
        try{
            ContentValues cv = new ContentValues();
            cv.put("UserName", user.getUserName());
            cv.put("Email", user.getCorreo());
            cv.put("Password", user.getPassword());

            db.insert("userInfo",null,cv);
            return true;
        }catch(Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
            return false;
        }

    }
    public ArrayList<User> LoginUser (String Email, String Password){
        ArrayList<User> userList = new ArrayList<User>();
        try{
            Cursor cursor = db.rawQuery("Select * from userInfo where Email='"+Email+"' and Password'"+Password+"'",null);
            if(cursor.moveToFirst()){
                do{
                    User user =new User();
                    user.setCorreo(cursor.getString(0));
                    user.setPassword(cursor.getString(1));
                    userList.add(user);
                }
                while(cursor.moveToNext());
            }
        }catch (Exception e){
            Toast.makeText(con, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return userList;
    }
}
