package com.sfiso.feedbackapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StudentFeedbackTable {

    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;

    public StudentFeedbackTable(Context context)
    {
        dbHelper = new DBHelper(context);
    }

    public void openDB()
    {
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public void closeDB()
    {
        sqLiteDatabase.close();
    }

    public void insertRecord(String strModuleName, int intLearningOutcomesNumber, int intOpportunitiesNumber, int intRelevanceNumber, int intLecturerRespondedNumber, int intTechnologyEnhancedNumber,  String strNeedsImprove)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.strColumn_Module_Name, strModuleName);
        contentValues.put(DBHelper.strColumn_Learning_Outcomes_Number, intLearningOutcomesNumber);
        contentValues.put(DBHelper.strColumn_Opportunities_Number, intOpportunitiesNumber);
        contentValues.put(DBHelper.strColumn_Relevance_Number, intRelevanceNumber);
        contentValues.put(DBHelper.strColumn_Lecturer_Responded_Number, intLecturerRespondedNumber);
        contentValues.put(DBHelper.strColumn_Technology_Enhanced_Number, intTechnologyEnhancedNumber);
        contentValues.put(DBHelper.strColumn_Needs_Improve, strNeedsImprove);

        sqLiteDatabase.insert(DBHelper.strTable_Name, null, contentValues);
    }

    public Cursor getAllRecords()
    {
        return sqLiteDatabase.rawQuery("SELECT * FROM " + DBHelper.strTable_Name, null);
    }

    public void updateRecord(String FeedbackID, String strModuleN, int intLearningOutcomesNumber, int intOpportunitiesNumber, int intRelevanceNumber, int intLecturerRespondedNumber, int intTechnologyEnhancedNumber,  String strNeedsI)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.strColumn_Module_Name, strModuleN);
        contentValues.put(DBHelper.strColumn_Learning_Outcomes_Number, intLearningOutcomesNumber);
        contentValues.put(DBHelper.strColumn_Opportunities_Number, intOpportunitiesNumber);
        contentValues.put(DBHelper.strColumn_Relevance_Number, intRelevanceNumber);
        contentValues.put(DBHelper.strColumn_Lecturer_Responded_Number, intLecturerRespondedNumber);
        contentValues.put(DBHelper.strColumn_Technology_Enhanced_Number, intTechnologyEnhancedNumber);
        contentValues.put(DBHelper.strColumn_Needs_Improve, strNeedsI);

        sqLiteDatabase.update(dbHelper.strTable_Name, contentValues, FeedbackID + "=" +dbHelper.strColumn_FeedbackID, null);
    }
}
