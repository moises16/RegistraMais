package com.example.registramais.recyclerviewpedidos;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

public class PedidoItemTouchHelper extends ItemTouchHelper.Callback {
    private PedidosAdapter adapter;

    public PedidoItemTouchHelper(PedidosAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return makeMovementFlags(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//        int startingPosition = viewHolder.getAdapterPosition();
//        int lastPosition = target.getAdapterPosition();
//
//        adapter.changePosition(startingPosition, lastPosition);
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        adapter.removePedido(viewHolder.getAdapterPosition());
    }
}
