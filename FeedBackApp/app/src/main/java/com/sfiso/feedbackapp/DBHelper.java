package com.sfiso.feedbackapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final String strDB_Name = "HNS";
    private static final int intDB_Version = 1;
    public static final String strTable_Name = "HNS";
    public static final String strColumn_FeedbackID ="ID";
    public static final String strColumn_Module_Name = "Problem";
    public static final String strColumn_Learning_Outcomes_Number = "Item";
    public static final String strColumn_Opportunities_Number = "DP";
    public static final String strColumn_Relevance_Number = "Reference";
    public static final String strColumn_Lecturer_Responded_Number = "Address";
    public static final String strColumn_Technology_Enhanced_Number = "Name";
    public static final String strColumn_Needs_Improve = "Contact";
    public static final String strColumn_Needs = "Email";

    String strCreate_TableCMD = "Create table" + " " + strTable_Name
            + "(" + strColumn_FeedbackID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT,"
            + strColumn_Module_Name + " " + "text,"
            + strColumn_Learning_Outcomes_Number + " " + "text,"
            + strColumn_Opportunities_Number + " " + "text,"
            + strColumn_Relevance_Number + " " + "text,"
            + strColumn_Lecturer_Responded_Number + " " + "text,"
            + strColumn_Technology_Enhanced_Number + " " + "text,"
            + strColumn_Needs_Improve + " " + "text,"
            + strColumn_Needs + " " + "text)";


    @Override
    public void onCreate(SQLiteDatabase sqliteDatabase)
    {
        sqliteDatabase.execSQL(strCreate_TableCMD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1)
    {
    }

    public DBHelper (Context context)
    {
        super(context, strDB_Name, null, intDB_Version);
    }
}