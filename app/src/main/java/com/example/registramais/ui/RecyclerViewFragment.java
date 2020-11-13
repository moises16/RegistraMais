package com.example.registramais.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registramais.R;
import com.example.registramais.model.Product;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment {
    private RecyclerView recyclerViewPedidos;
    private List<Product> productList;

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
        productList = new ArrayList<>();
        return inflater.inflate(R.layout.fragment_recycler_view, container, false);
    }

    void configRecyclerView(View view){
        recyclerViewPedidos = view.findViewById(R.id.recyclerViewPedidos);
    }
}