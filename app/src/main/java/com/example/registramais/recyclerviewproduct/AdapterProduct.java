package com.example.registramais.recyclerviewproduct;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registramais.R;
import com.example.registramais.model.Product;

import java.util.List;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{
    private Context context;
    private List<Product> productList;
    private  ProductsItemClickListener onClickListener;


    public AdapterProduct(Context context, List<Product> productList) {
        this.context = context;
        this.productList = productList;
    }

    public void setOnClickListener(ProductsItemClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_recyclerview_product,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduct.ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.mergeViewData(product);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewproduct;
        private TextView textViewValor;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewproduct=itemView.findViewById(R.id.txtProduto);
            textViewValor=itemView.findViewById(R.id.txtValor);

        }
        void mergeViewData(Product products){
            textViewproduct.setText(products.getNome());
            textViewValor.setText(products.getValorComoString());
        }
    }

}
