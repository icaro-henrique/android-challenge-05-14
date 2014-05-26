package com.example.android_challenge_05_14.app;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Tela1Activity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        final TextView lb_welcome = (TextView)findViewById(R.id.lb_Welcome);
        lb_welcome.setText("Olá "+getLastName());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela1, menu);
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

    public void bt_OkOnclick(View v){
        final EditText txt_Name = (EditText)findViewById(R.id.txt_Name);
        if(saveName(txt_Name.getText().toString()))
            Toast.makeText(this,"Parabéns pequeno padawan",1000).show();

    }
    public boolean saveName(String name){
        SharedPreferences shared = this.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shared.edit();
        editor.putString(getString(R.string.keyName),name);
        return editor.commit();
    }
    public String getLastName(){
        SharedPreferences shared = this.getPreferences(Context.MODE_PRIVATE);
        return shared.getString(getString(R.string.keyName),"");
    }

}
