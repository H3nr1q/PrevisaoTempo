package com.chs.previsaotempo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.chs.previsaotempo.R;
import com.chs.previsaotempo.adapter.RecyclerAdapterAddCidade;
import com.chs.previsaotempo.data.CidadeDAO;
import com.chs.previsaotempo.model.Cidade;

import java.util.ArrayList;
import java.util.List;

public class AdicionarCidadeActivity extends AppCompatActivity implements RecyclerAdapterAddCidade.OnClickCidade {
    private RecyclerView recyclerView;
    private List<Cidade> cidades = new ArrayList<>();
    private List<Cidade> cidadeFiltradas = new ArrayList<>();
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_cidade);
        setTitle("Adicionar cidades");
        cidades = CidadeDAO.getInstance().listarTodasCidades();
        recyclerView = findViewById(R.id.rvListAddPrev);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        RecyclerAdapterAddCidade adapterAddCidade = new RecyclerAdapterAddCidade(cidades);
        recyclerView.setAdapter(adapterAddCidade);

        searchView = findViewById(R.id.svBuscarCidades);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String buscouCidade) {
                cidades = CidadeDAO.getInstance().buscarCidade(buscouCidade);
                cidadeFiltradas.addAll(cidades);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                RecyclerAdapterAddCidade adapterAddCidade = new RecyclerAdapterAddCidade(cidades);
                recyclerView.setAdapter(adapterAddCidade);
                return false;
            }
        });

    }

    @Override
    public void setOnCidadeListener(int position, Cidade cidade) {
        CidadeDAO.getInstance().addCidade(cidade.getId());
    }
}