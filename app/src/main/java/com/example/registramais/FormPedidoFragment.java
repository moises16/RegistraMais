package com.example.registramais;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class FormPedidoFragment extends Fragment {
    private EditText nomeCliente;
    private EditText numero;
    private EditText endereco;
    private Button buttonAddProduto;
    private Button buttonVerProduto;
    private Button buttonSalvar;

    public FormPedidoFragment() {
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
        View view =inflater.inflate(R.layout.fragment_form_pedido, container, false);

        loadViews(view);

        return view;
    }

    void loadViews(View view){
        nomeCliente = view.findViewById(R.id.editTextNomePedidos);
        numero = view.findViewById(R.id.editTextNumeroPedidos);
        endereco = view.findViewById(R.id.editTextEnderecoPedidos);
        buttonAddProduto = view.findViewById(R.id.btnAddPratosPedidos);
        buttonVerProduto = view.findViewById(R.id.btnVerPedidos);
        buttonSalvar = view.findViewById(R.id.btnSalvarFormPedidos);
    }

    void buttonSalvar(View view){
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}