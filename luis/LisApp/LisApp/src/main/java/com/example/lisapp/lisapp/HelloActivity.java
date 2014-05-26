package com.example.lisapp.lisapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class HelloActivity extends Activity {

    public static final String PREFS_NAME = "MyPrefsFile";
    TextView confirmTxt;
    EditText nameTxt;
    Button confirmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        confirmBtn = (Button)findViewById(R.id.confirmBtn);
        confirmTxt = (TextView)findViewById(R.id.confirmTxt);
        nameTxt = (EditText)findViewById(R.id.nameText);
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        String lastName = settings.getString("name",null);
        confirmTxt.setText("Hello " + lastName);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    confirmTxt.setText("Hello " + nameTxt.getText().toString());
            }
        });
    }

    @Override
    protected void onStop(){
        super.onStop();

        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("name", nameTxt.getText().toString());

        // Commit the edits!
        editor.commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hello, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
