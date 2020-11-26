package com.example.registramais.recyclerviewitempedido;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registramais.R;
import com.example.registramais.model.ItemList;
import com.example.registramais.model.Product;

import java.util.List;

public class AdapterItemPedido extends RecyclerView.Adapter<AdapterItemPedido.ViewHolder> {
    private Context context;
    private List<ItemList> productItemListPedido;


    public AdapterItemPedido(Context context, List<ItemList> productItemListPedido) {
        this.context = context;
        this.productItemListPedido = productItemListPedido;
    }

    @NonNull
    @Override
    public AdapterItemPedido.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recycler_itempedido,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemPedido.ViewHolder holder, int position) {
        ItemList itemList = productItemListPedido.get(position);
        holder.mergeViewData(itemList);
    }

    @Override
    public int getItemCount() {
        return productItemListPedido.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNomeItemPedido;
        private TextView txtValorItemPedido;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomeItemPedido = itemView.findViewById(R.id.textViewNomeItemListPedido);
            txtValorItemPedido = itemView.findViewById(R.id.textViewValorItemListPedido);


        }

        public void mergeViewData(ItemList itemList) {
            String nome = String.valueOf(itemList.getNome());
            txtNomeItemPedido.setText(nome);
            String valor = String.valueOf(itemList.getValor());
            txtNomeItemPedido.setText(valor);
            String qtd = String.valueOf(itemList.getQtdProduct());
            txtValorItemPedido.setText(qtd);
        }
    }

    public void removeItemPedido(int adapterPosition){
        ItemList itemList = productItemListPedido.get(adapterPosition);
        productItemListPedido.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }
}
