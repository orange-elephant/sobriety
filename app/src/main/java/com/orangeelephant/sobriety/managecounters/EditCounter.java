package com.orangeelephant.sobriety.managecounters;

import android.content.ContentValues;
import android.content.Context;
import android.widget.Toast;

import com.orangeelephant.sobriety.database.DBhelper;
import com.orangeelephant.sobriety.database.DefineTables;

import net.sqlcipher.database.SQLiteDatabase;

public class EditCounter {
    private final int counterID;
    private final Context context;

    public EditCounter(Context context, int counterID) {
        this.context = context;
        this.counterID = counterID;

    }

    public void addReason(String reason) {
        SQLiteDatabase db = new DBhelper(context).getWritableDatabase("");
        ContentValues contentValues = new ContentValues();
        contentValues.put(DefineTables.Counters.COLUMN_COUNTER_ID, counterID);
        contentValues.put(DefineTables.Counters.COLUMN_SOBRIETY_REASON, reason);
        db.insert(DefineTables.Counters.TABLE_NAME_REASONS, null, contentValues);
        db.close();
    }

    public void printEditSuccessfulMessage(String toastMessage) {
        Toast deletionMessage = Toast.makeText(this.context, toastMessage, Toast.LENGTH_LONG);
        deletionMessage.show();
    }
}
