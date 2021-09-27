package com.chs.previsaotempo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.chs.previsaotempo.R;
import com.chs.previsaotempo.model.Cidade;

public class DetalhesActivity extends AppCompatActivity {
    private TextView cidade;
    private TextView temperatura;
    private TextView tempMax;
    private TextView tempMin;
    private TextView latitude;
    private TextView longitude;
    private TextView velocidade;
    private TextView visibilidade;
    private TextView humidade;
    private TextView pressao;
    public static final String EXTRA_CIDADE = "cidade";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);
        setTitle("Mais Informações");
        bindViews();
        if(getIntent().hasExtra("EXTRA_CIDADE")){
            Bundle extras = getIntent().getExtras();
        }
    }

    public void bindViews(){
        cidade = findViewById(R.id.txtDetailCidade);
        temperatura = findViewById(R.id.txtDetailTemp);
        tempMax = findViewById(R.id.txtTempMax);
        tempMin = findViewById(R.id.txtTempMin);
        latitude = findViewById(R.id.txtLat);
        longitude = findViewById(R.id.txtLong);
        velocidade = findViewById(R.id.txtVel);
        visibilidade = findViewById(R.id.txtVisibilidade);
        humidade = findViewById(R.id.txtHumidade);
        pressao = findViewById(R.id.txtValorPressao);
    }

}