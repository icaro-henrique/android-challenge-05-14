package com.example.lisapp.lisapp;

import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class ContentNameActivity extends ActionBarActivity {

    ImageView imgView;
    TextView nameView;
    TextView posView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_name);
        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray("key");
        imgView = (ImageView)findViewById(R.id.img);
        nameView = (TextView)findViewById(R.id.Name);
        posView = (TextView)findViewById(R.id.pos);
        nameView.setText(array[0]);
        Picasso.with(this).load(array[1]).into(imgView);
        posView.setText(array[2]);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.content_name, menu);
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
