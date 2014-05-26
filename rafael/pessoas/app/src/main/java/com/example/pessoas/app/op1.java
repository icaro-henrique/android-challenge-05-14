package com.example.pessoas.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class op1 extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op1);
        Button ok = (Button) findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText nome = (EditText) findViewById(R.id.nome);
                salvaNome(nome.getText().toString());
                Intent ok = new Intent(op1.this,MainActivity.class);
                //ok.putExtra("Nome", nome.getText().toString());
                startActivity(ok);
            }
        });
        Intent main = getIntent();
        TextView name = (TextView)findViewById(R.id.lastName);
        name.setText("Olá "+getNome());
    }

    public void salvaNome(String nome)
    {
        SharedPreferences prefs = getSharedPreferences("preferencias1", Context.MODE_PRIVATE);
        SharedPreferences.Editor edNome = prefs.edit();

        edNome.putString("NOME", nome);

        edNome.commit();
    }

    public String getNome()
    {
        SharedPreferences prefs = getSharedPreferences("preferencias1", Context.MODE_PRIVATE);
        return prefs.getString("NOME","Amigo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.op1, menu);
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
