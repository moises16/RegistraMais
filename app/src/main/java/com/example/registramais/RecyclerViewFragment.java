package com.example.registramais;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registramais.model.Pedido;
import com.example.registramais.recyclerviewpedidos.PedidoItemTouchHelper;
import com.example.registramais.recyclerviewpedidos.PedidoOnClickListener;
import com.example.registramais.recyclerviewpedidos.PedidosAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment {
    public static final String EXTRA_EDIT_PEDIDO = "editPedido";
    private static final int REQUEST_SAVE_CODE = 1;
    private static final int REQUEST_EDIT_PEDIDO = 2;
    private RecyclerView recyclerViewPedidos;
    private List<Pedido> pedidoList;
    private PedidosAdapter adapter;
    private FloatingActionButton floatingActionButtonPedido;
    public RecyclerViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.item_list_pedidos, container, false);
        pedidoList = new ArrayList<>();
        configRecyclerView(view);
        floatingActionButtonPedido = view.findViewById(R.id.floatingActionButtonTeste);
        floatingActionButtonPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FormPedidoFragment.class);
                startActivity(intent);
            }
        });
        return view;
    }

    void configRecyclerView(View view){
        recyclerViewPedidos = view.findViewById(R.id.recyclerViewPedidos);
        recyclerViewPedidos.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new PedidosAdapter(getContext(), pedidoList);
        recyclerViewPedidos.setAdapter(adapter);
        adapter.setOnItemClickListener(new PedidoOnClickListener() {
            @Override
            public void itemClick(Pedido pedido) {
                Intent intent = new Intent(getActivity(), FormPedidoFragment.class);
                intent.putExtra(EXTRA_EDIT_PEDIDO, pedido);
                startActivityForResult(intent, REQUEST_EDIT_PEDIDO);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new PedidoItemTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerViewPedidos);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null)return;
        if (requestCode == REQUEST_SAVE_CODE && data.hasExtra(FormPedidoFragment.PEDIDO_SAVE)){
            if (requestCode == Activity.RESULT_OK){
                Pedido pedido = (Pedido) data.getSerializableExtra(FormPedidoFragment.PEDIDO_SAVE);

            }
        }
    }
}