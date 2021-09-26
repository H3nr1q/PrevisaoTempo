package com.chs.previsaotempo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chs.previsaotempo.R;
import com.chs.previsaotempo.data.CidadeDAO;
import com.chs.previsaotempo.model.Cidade;

import java.util.List;

public class RecyclerAdapterAddCidade extends RecyclerView.Adapter<RecyclerAdapterAddCidade.AddCidadeViewHolder> {
    private List<Cidade> cidadeListAdd;
    private OnClickCidade onClickCidade;

    public OnClickCidade getOnClickCidade(){
        return onClickCidade;
    }

    public void setOnClickCidade(OnClickCidade onClickCidade){
        this.onClickCidade = onClickCidade;
    }


    public RecyclerAdapterAddCidade(List<Cidade> cidadeListAdd){
        this.cidadeListAdd = cidadeListAdd;
    }

    @Override
    public RecyclerAdapterAddCidade.AddCidadeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_previsao, parent, false);
        return new AddCidadeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddCidadeViewHolder holder, int position) {
        Cidade cidadeA = cidadeListAdd.get(position);
        holder.cidadeAdd.setText(cidadeA.getCidade());
        holder.temperaturaAdd.setText(cidadeA.getTemperatura());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickCidade.setOnCidadeListener(position, cidadeListAdd.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cidadeListAdd.size();
    }

    public class AddCidadeViewHolder extends RecyclerView.ViewHolder {
        public TextView cidadeAdd;
        public TextView temperaturaAdd;
        public int id;

        public AddCidadeViewHolder(View itemView) {
            super(itemView);
            cidadeAdd = itemView.findViewById(R.id.txtCidade);
            temperaturaAdd = itemView.findViewById(R.id.txtTemp);
        }
    }

    public interface OnClickCidade{
        void setOnCidadeListener(int position, Cidade cidade);
    }

}
