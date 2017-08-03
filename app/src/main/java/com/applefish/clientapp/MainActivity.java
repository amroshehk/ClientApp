package com.applefish.clientapp;

import android.content.ComponentName;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
   public void goToDataView(View view)
   {
       Intent intent = new Intent();
       intent.setComponent(new ComponentName("com.applefish.protectingapps", "com.applefish.protectingapps.ViewDataActivity"));
       startActivity(intent);

   }
    public void showContentInfo(View view)
    {
        // Retrieve student records
        String URL = "content://com.applefish.protectingapps.StudentsProvider";

        Uri students = Uri.parse(URL);
        Cursor c =  getContentResolver().query(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                 final String _ID = "_id";
                 final String NAME = "name";
                 final String GRADE = "grade";
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(_ID)) +
                                ", " +  c.getString(c.getColumnIndex( NAME)) +
                                ", " + c.getString(c.getColumnIndex( GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }

    }

}
