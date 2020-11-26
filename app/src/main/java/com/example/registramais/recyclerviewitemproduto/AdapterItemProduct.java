package com.example.registramais.recyclerviewitemproduto;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registramais.R;
import com.example.registramais.model.ItemList;
import com.example.registramais.model.Product;

import java.util.ArrayList;
import java.util.List;

public class AdapterItemProduct extends RecyclerView.Adapter<AdapterItemProduct.ViewHolder> {
    private Context context;
    private List<Product> productItemList;
    private List<ItemList> itemListsPedido;
    private ItemList itemList;
    private int qtd = 0;

    public AdapterItemProduct(Context context, List<Product> productItemList) {
        this.context = context;
        this.productItemList = productItemList;

    }


    @NonNull
    @Override
    public AdapterItemProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recycler_itemprodutos,parent,false);
        itemListsPedido = new ArrayList<>();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItemProduct.ViewHolder holder, int position) {
        Product product = productItemList.get(position);
        holder.mergeViewData(product);
    }

    @Override
    public int getItemCount() {
        return productItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewNomeProduct;
        private TextView textViewValorProduct;
        private TextView textViewQuant;
        private Button buttonRemover;
        private Button buttonAdicionar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewQuant = itemView.findViewById(R.id.textViewQtd);
            textViewNomeProduct = itemView.findViewById(R.id.textViewNomeProduto);
            textViewValorProduct = itemView.findViewById(R.id.textViewValorProduto);
            buttonRemover = itemView.findViewById(R.id.btnRemover);
            buttonAdicionar = itemView.findViewById(R.id.btnAdicionar);

            buttonAdicionar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        int numero= Integer.parseInt(textViewQuant.getText().toString());
                        numero++;
                        qtd++;
                        textViewQuant.setText(String.valueOf(numero));
                        getItens(qtd);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("itempedido", itemList);
                }
            });

            buttonRemover.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (qtd >= 1){
                        int numero= Integer.parseInt(textViewQuant.getText().toString());
                        numero--;
                        qtd--;
                        textViewQuant.setText(String.valueOf(numero));
                    }
                }
            });
        }

        public void mergeViewData(Product product) {
            textViewNomeProduct.setText(product.getNome());
            String valor = String.valueOf(product.getValor());
            textViewValorProduct.setText(valor);
        }

        private void getItens(int qtd){
            Product product = productItemList.get(getAdapterPosition());
            String nome = product.getNome();
            double valor = product.getValor();

            ItemList itemList = new ItemList(nome, valor, qtd);
        }
    }
}
