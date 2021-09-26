package com.chs.previsaotempo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.chs.previsaotempo.R;
import com.chs.previsaotempo.adapter.RecyclerAdapterCidades;
import com.chs.previsaotempo.app.Utils;
import com.chs.previsaotempo.data.CidadeDAO;
import com.chs.previsaotempo.model.Cidade;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<Cidade> cidades = new ArrayList<>();
    private TextView dataHora;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lista de Cidades");
        dataHora = findViewById(R.id.textoData);
        dataHora.setText("Ultimas alterações "+ Utils.generateData());
        recyclerView = findViewById(R.id.rvListPrevUser);
        cidades = CidadeDAO.getInstance().listarCidadesAdicionadas();
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        RecyclerAdapterCidades adapterCidades = new RecyclerAdapterCidades(cidades);
        recyclerView.setAdapter(adapterCidades);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_adicionar_cidade, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.btAdicionar){
            Intent intent = new Intent(MainActivity.this, AdicionarCidadeActivity.class);
            startActivity(intent);
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public MenuInflater getMenuInflater() {
        return super.getMenuInflater();
    }


}