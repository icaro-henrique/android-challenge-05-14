package com.example.pessoas.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    String nome = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button cadastro = (Button) findViewById(R.id.cadastro);
        Button lista = (Button) findViewById(R.id.lista);
        cadastro.setOnClickListener(this);
        lista.setOnClickListener(this);
        //Intent op1R = getIntent();
        //nome = op1R.getStringExtra("Nome");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.cadastro:
                Intent op1 = new Intent(MainActivity.this,op1.class);
                //op1.putExtra("Nome", nome);
                startActivity(op1);
                break;
            case R.id.lista:
                Intent op2 = new Intent(MainActivity.this,op2.class);
                startActivity(op2);
                break;
        }
    }

}
