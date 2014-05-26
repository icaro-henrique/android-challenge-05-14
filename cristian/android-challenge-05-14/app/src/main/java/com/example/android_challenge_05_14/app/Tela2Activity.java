package com.example.android_challenge_05_14.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;


public class Tela2Activity extends ActionBarActivity {

    private Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        final ListView lst_View = (ListView)findViewById(R.id.lst_Profiles);

        final ArrayList<Profile> items = getProfiles("data.txt");

        final ArrayAdapter<Profile> adapter = new ArrayAdapter<Profile>(this,
                android.R.layout.simple_list_item_1, items);

        lst_View.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Profile p = items.get(position);
                Intent intent = new Intent(context,ProfileActivity.class);
                intent.putExtra("Name",p.getName());
                intent.putExtra("Job",p.getJob());
                intent.putExtra("Image",p.getImage());
                startActivity(intent);
            }
        });
        lst_View.setAdapter(adapter);


    }

    private ArrayList<Profile> getProfiles(String fileName) {
        ArrayList<Profile> items = new ArrayList<Profile>();
        try{
            int count = 0;
            Scanner fileScanner = new Scanner(getAssets().open(fileName));
            while (fileScanner.hasNextLine())
            {
                String[] data = fileScanner.nextLine().split(";");
                items.add(new Profile(data[0], data[2], data[1]));
                count++;
            }
        }
        catch (FileNotFoundException e) {
            Toast.makeText(this, "File not found: " + e.toString(), 1000);
        } catch (IOException e) {
            Toast.makeText(this, "File not found: " + e.toString(), 1000);
        }
        return items;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tela2, menu);
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
