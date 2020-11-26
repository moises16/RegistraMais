package com.example.registramais.recyclerviewitempedido;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registramais.R;
import com.example.registramais.model.ItemList;
import com.example.registramais.model.Product;
import com.example.registramais.recyclerviewitemproduto.AdapterItemProduct;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class RecyclerItemPedidoFragment extends Fragment {
    private List<Product> pedidoItemList;
    private RecyclerView recyclerViewItemProduto;
    private AdapterItemProduct adapter;

    public RecyclerItemPedidoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_item_produto, container, false);
        pedidoItemList = new ArrayList<>();
        configRecyclerView(view);

        return view;
    }

    private void configRecyclerView(View view){
        recyclerViewItemProduto = view.findViewById(R.id.recycleritemlistpedido);
        recyclerViewItemProduto.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterItemProduct(getActivity().getApplicationContext(), pedidoItemList);
        recyclerViewItemProduto.setAdapter(adapter);
    }
}