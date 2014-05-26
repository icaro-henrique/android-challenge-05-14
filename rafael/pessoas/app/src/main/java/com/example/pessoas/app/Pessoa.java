package com.example.pessoas.app;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class Pessoa extends ActionBarActivity {

    String[] pessoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);
        Intent PessoaP = getIntent();
        pessoa = PessoaP.getStringArrayExtra("PESSOA");
        TextView name = (TextView)findViewById(R.id.nome);
        name.setText(pessoa[0]);
        TextView cargoP = (TextView)findViewById(R.id.cargo);
        cargoP.setText(pessoa[2]);
        ImageView foto = (ImageView)findViewById(R.id.foto);
        Picasso.with(this).load(pessoa[1]).into(foto);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pessoa, menu);
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
