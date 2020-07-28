package com.aleynagulec.egitimdeneme;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    String DB_PATH = null;
    private static String DB_NAME = "egitim2";
    private static String DB_TABLE = "eylemler";
    private SQLiteDatabase myDataBase;
    private final Context myContext;

    public DatabaseHelper(Context context, String db_name) {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
        this.DB_NAME = db_name;
        this.DB_PATH = this.myContext.getDatabasePath(DB_NAME).getAbsolutePath();
        Log.e("Path 1", DB_PATH);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if (dbExist) {
        } else {
            this.getReadableDatabase();
            try {
                copyDataBase();
            } catch (IOException e) {
                throw new Error("Error copying database");
            }
        }
    }

    private boolean checkDataBase() //database kontrolu yapılır.
    {
        SQLiteDatabase checkDB = null;
        try {
            String mypath = DB_PATH + DB_NAME;
            checkDB = SQLiteDatabase.openDatabase(mypath, null, SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }
        if (checkDB != null) {
            checkDB.close();
        }
        return checkDB != null ? true : false;
    }

    private void copyDataBase() throws IOException {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
        //inputstream dısa kaynaktan veri okurken kullanılır.
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        //burada dıs kaynaga veri gonderirken kullanılır.
        byte[] buffer = new byte[10];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();
    }

    public void openDataBase() throws SQLiteException {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
    }

    public synchronized void close() {
        if (myDataBase != null)
            myDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion)
            try {
                copyDataBase();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public List<eylemler> verileriCek(String tablo_adi,String kategoriname) {
        List<eylemler> eylems = new ArrayList<>();
        String sart="k_no=?";
        String[] sart1= new String[]{kategoriname};

        Cursor c = myDataBase.query(tablo_adi, null, sart, sart1, null, null, null);

        if (c.moveToFirst()) {
            do {
                eylemler eylem = new eylemler();
                eylem.setEylem_no(c.getString(0));
                eylem.setK_no(c.getString(1));
                eylem.setEylem_adi(c.getString(2));
                eylem.setEylem_resim(c.getString(3));

                eylems.add(eylem);
            } while (c.moveToNext());
        }
        c.close();
        myDataBase.close();
        return eylems;
    }

    public List<Sorular> sorulariCek(String tablo_adi) {
        List<Sorular> sorularList = new ArrayList<>();
        String sart="";
        String[] sart1= new String[]{};
        Cursor c = myDataBase.query(tablo_adi, null, sart, sart1, null, null, null);

        if (c.moveToFirst()) {
            do {
                Sorular sorular = new Sorular();
                sorular.setId(c.getInt(0));
                sorular.setSoru(c.getString(1));
                sorular.setCevap(c.getInt(2));
                sorular.setResim(c.getString(3));
                sorularList.add(sorular);
            } while (c.moveToNext());
        }
        c.close();
        myDataBase.close();
        return sorularList;
    }
}

