import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static vij.klu.projectapp.R.id.category;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Movie.db";
    public static final String TABLE_NAME = "TYPE";
    public static final String COL_1 = "MovieName";
    public static final String COL_2 = "castcrew";
    public static final String COL_3 = "Rating";
    public static final String COL_4 = "Timings";
    public static final String COL_5 = "Theatre";
    public static final String COL_6 = "Category";
 public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME +" (MovieName TEXT,castcrew TEXT,Rating INTEGER ,Timings TEXT,Theatre TEXT,Category TEXT)");
    }
@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }
public boolean insertData(String MovieName,String castcrew ,String Rating,String Timings,String Theatre,String Category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,MovieName);
        contentValues.put(COL_2,castcrew);
        contentValues.put(COL_3,Rating);
        contentValues.put(COL_4,Timings);
        contentValues.put(COL_5,Theatre);
        contentValues.put(COL_6,Category);


        long result = db.insert(TABLE_NAME,null ,contentValues);

        if(result == -1)
            return false;
        else
            return true;
    }
public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME ,null);
        return res;
    }
public boolean updateData(String id,String name,String surname,String marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }
}
