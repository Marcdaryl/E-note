package com.example.e_notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DataBaseElber extends SQLiteOpenHelper {

    private  Context context;
    private  static final String DATABSE_NAME="notes.db";
    private  static final int DATABSE_VERSION=1;
    private  static final String TABLE_NAME="mynotes";
    private  static final String COLUMN_ID="_id";
    private  static final String COLUMN_NAME="nom";
    private  static final String COLUMN_SURNAME="prenom";
    private  static final String COLUMN_MARK="notes";
    public DataBaseElber(@Nullable Context context) {
        super(context, DATABSE_NAME, null, DATABSE_VERSION);
        this.context = context;
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        String creation_req="CREATE TABLE "+
                TABLE_NAME +" ( "+COLUMN_ID+
                " INTEGER PRIMARY KEY AUTOINCREMENT,"
                +COLUMN_NAME +" TEXT, "+COLUMN_SURNAME+" TEXT, "+COLUMN_MARK +" TEXT ) ;";
        db.execSQL(creation_req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);

        onCreate(db);
    }

    public  void addNotes(String nom,String prenom,String notes)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,nom);
        cv.put(COLUMN_SURNAME,prenom);
        cv.put(COLUMN_MARK,notes);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1)
        {
            Toast.makeText(context, "Insertion Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Insertion Sucessful", Toast.LENGTH_SHORT).show();
        }
    }

    public  Cursor getNotes()
    {
        String query="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        if(db!=null)
        {
            cursor=db.rawQuery(query,null);
        }
        return cursor;
    }

    public void updateNotes(String _id,String nom,String prenom,String notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,nom);
        cv.put(COLUMN_SURNAME,prenom);
        cv.put(COLUMN_MARK,notes);
        long result=db.update(TABLE_NAME,cv,"_id=?",new String[]{_id});
        if(result==-1)
        {
            Toast.makeText(context, "Update Succesfully", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Update Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void deleteVoid(String _id)
    {
        SQLiteDatabase db= this.getWritableDatabase();
        long result = db.delete(TABLE_NAME,"_id=?",new String[]{_id});
        if(result==-1)
        {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(context, "Succes", Toast.LENGTH_SHORT).show();
        }
    }
}
