package com.example.lisapp.lisapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ListNameActivity extends ActionBarActivity {

    private static final String TAG = ListNameActivity.class.getName();
    ListView listNameInView;
    String[] arrayInfo =  new String[2];
    Names[] arrayNames = new Names[17];
    String[] namesForList = new String[arrayNames.length];
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        listNameInView = (ListView)findViewById(R.id.listNameView);
        try{
            InputStream is = getResources().openRawResource(R.raw.data);
            InputStreamReader isReader = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(isReader);
            String receiveString = "";
            StringBuilder stringBuilder = new StringBuilder();
            int cont = 0;
            while ( (receiveString = bufferedReader.readLine()) != null ) {
                stringBuilder.append(receiveString);
                arrayInfo = stringBuilder.toString().split(";");
                Names name = new Names(arrayInfo[0], arrayInfo[1], arrayInfo[2]);
                arrayNames[cont] = name;
                cont++;
                stringBuilder.delete(0,stringBuilder.length());
            }
            is.close();
        }
        catch (Exception e){
            Log.e(TAG, "File not found: " + e.toString());
        }
        for(int i = 0; i < arrayNames.length; i++){
            namesForList[i] = arrayNames[i].name;
        }
        adapter = new ArrayAdapter(this , android.R.layout.simple_list_item_1, namesForList);
        listNameInView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listNameInView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle b = new Bundle();

                String[] passingDataRequired = new String[3];
                passingDataRequired[0] = arrayNames[i].name;
                passingDataRequired[1] = arrayNames[i].img;
                passingDataRequired[2] = arrayNames[i].pos;

                b.putStringArray("key", passingDataRequired);

                Intent activityChangeIntent = new Intent(ListNameActivity.this, ContentNameActivity.class);
                activityChangeIntent.putExtras(b);

                // currentContext.startActivity(activityChangeIntent);

                ListNameActivity.this.startActivity(activityChangeIntent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list_name, menu);
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