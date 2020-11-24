package com.example.registramais.recyclerviewpedidos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.registramais.FormPedidoFragment;
import com.example.registramais.R;
import com.example.registramais.RecyclerViewFragment;
import com.example.registramais.model.Pedido;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Collections;
import java.util.List;

public class PedidosAdapter extends RecyclerView.Adapter<PedidosAdapter.ViewHolder> {
    private Context context;
    private List<Pedido> pedidoList;
    private PedidoOnClickListener onClickListener;

    public PedidosAdapter(Context context, List<Pedido> pedidoList) {
        this.context = context;
        this.pedidoList = pedidoList;
    }

    public void setOnItemClickListener(PedidoOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public PedidosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_pedidos, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosAdapter.ViewHolder holder, int position) {
    Pedido pedido = pedidoList.get(position);
    holder.vincula(pedido);
    }

    @Override
    public int getItemCount() {
        return pedidoList.size();
    }

    public void changePosition(int lastPosition, int startingPosition){
        Collections.swap(pedidoList, startingPosition, lastPosition);
        notifyItemMoved(startingPosition, lastPosition);
    }

    public void removePedido(int adapterPosition){
        Pedido pedido = pedidoList.get(adapterPosition);
        FirebaseFirestore.getInstance().collection("pedidosTest").document(pedido.getId()).delete();
        pedidoList.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewValor;
        private TextView textViewNome;
        private TextView textViewData;
        private ImageView imageViewRecycler;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        textViewValor = itemView.findViewById(R.id.txtValorRecyclerPedidos);
        textViewNome = itemView.findViewById(R.id.txtNomeRecyclerPedidos);
        textViewData = itemView.findViewById(R.id.txtDataRecyclerPedidos);
        }

        public void vincula(Pedido pedido) {
            textViewValor.setText(pedido.getNumero());
            textViewNome.setText(pedido.getNomeCliente());
            textViewData.setText(pedido.getData());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Pedido pedido = pedidoList.get(getAdapterPosition());
                    onClickListener.itemClick(pedido);
                }
            });
        }
    }
}
