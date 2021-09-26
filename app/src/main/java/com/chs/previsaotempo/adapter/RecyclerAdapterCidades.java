package com.chs.previsaotempo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.chs.previsaotempo.R;
import com.chs.previsaotempo.model.Cidade;

import java.util.List;

public class RecyclerAdapterCidades extends RecyclerView.Adapter<RecyclerAdapterCidades.CidadeViewHolder> {
    private List<Cidade> cidadeList;

    public RecyclerAdapterCidades(List<Cidade> cidadeList){
        this.cidadeList = cidadeList;
    }

    @Override
    public CidadeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_previsao, parent, false);
        return new CidadeViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CidadeViewHolder holder, int position) {
        Cidade cidade = cidadeList.get(position);
        holder.cidade.setText(cidade.getCidade());
        holder.temperatura.setText(cidade.getTemperatura());
       // holder.tipo.setImageIcon(cidade.getTipo()););


    }

    @Override
    public int getItemCount() {
        return cidadeList.size();
    }

    public class CidadeViewHolder extends RecyclerView.ViewHolder {
        public TextView cidade;
        public TextView temperatura;
        public ImageView tipo;


        public CidadeViewHolder(View itemView) {
            super(itemView);
            cidade = itemView.findViewById(R.id.txtCidade);
            temperatura = itemView.findViewById(R.id.txtTemp);
            tipo = itemView.findViewById(R.id.imageView);
        }
    }
}
