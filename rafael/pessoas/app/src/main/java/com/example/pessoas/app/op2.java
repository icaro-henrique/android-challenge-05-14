package com.example.pessoas.app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;


public class op2 extends ActionBarActivity {

    private ArrayList<String> pessoas = new ArrayList<String>();
    private ArrayList<String[]> todos = new ArrayList<String[]>();
    List<String> linhas_do_arquivo;
    ListView listaPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op2);
        listaPessoas = (ListView) findViewById(R.id.listaPessoas);
        lerArquivo();
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,pessoas);
        listaPessoas.setAdapter(adapter);

        listaPessoas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View view, int position, long index) {
                Intent pessoainha = new Intent(op2.this,Pessoa.class);
                pessoainha.putExtra("PESSOA", todos.get(position));
                startActivity(pessoainha);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.op2, menu);
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

    public void lerArquivo()
    {
        AssetManager assetManager = getResources().getAssets();
        InputStream inputStream;
        SharedPreferences prefs;

        try {
            inputStream = assetManager.open("data.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String recebe_string;

            linhas_do_arquivo = new ArrayList<String>();

            int i = 0;
            while ( (recebe_string = bufferedReader.readLine()) != null ) {
                linhas_do_arquivo.add(recebe_string);
                String[] name = recebe_string.split(";");
                pessoas.add(name[0]);
                todos.add(name);
                //prefs = getSharedPreferences("pessoa"+i, Context.MODE_PRIVATE);
                //SharedPreferences.Editor edNome = prefs.edit();
                //edNome.putString("NOME", name[0]);
                //edNome.putString("FOTO", name[1]);
                //edNome.putString("CARGO", name[2]);
                //edNome.commit();
            }

            System.out.println("QUANTIDADE DE LINHAS: " + linhas_do_arquivo.size());
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
