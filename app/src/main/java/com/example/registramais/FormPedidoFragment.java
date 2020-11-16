package com.example.registramais;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.registramais.model.Pedido;

import java.util.Enumeration;


public class FormPedidoFragment extends Fragment {
    public static final String PEDIDO_SAVE = "NEW_PEDIDO";
    private EditText nomeCliente;
    private EditText numero;
    private EditText data;
    private Button buttonAddProduto;
    private Button buttonVerProduto;
    private Button buttonSalvar;
    private Intent intent;
    private Pedido pedido;

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
        data = view.findViewById(R.id.editTextEnderecoPedidos);
        buttonAddProduto = view.findViewById(R.id.btnAddPratosPedidos);
        buttonVerProduto = view.findViewById(R.id.btnVerPedidos);
        buttonSalvar = view.findViewById(R.id.btnSalvarFormPedidos);


    }

    void buttonSalvar(View view){
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (intent.hasExtra(RecyclerViewFragment.EXTRA_EDIT_PEDIDO)){
                updatePedidoForm();

            }else{
                getInputForm();

            }
            }
        });
    }

    private void loadForm(){
        nomeCliente.setText(pedido.getNomeCliente());
        numero.setText(pedido.getNumero());
        data.setText(pedido.getData());
    }

    private void getInputForm(){
        String nome = nomeCliente.getText().toString();
        int valor = Integer.parseInt(numero.getText().toString());
        String dataTxt = data.getText().toString();

        pedido = new Pedido(nome,valor,dataTxt);
    }

    private void updatePedidoForm(){
        String nome = nomeCliente.getText().toString();
        int valor = Integer.parseInt(numero.getText().toString());

        pedido.setNomeCliente(nome);
        pedido.setNumero(valor);
    }

    private void goToRecyclerViewFragment(String saveOrEditExtra){
        Intent intent = new Intent(getActivity(), RecyclerViewFragment.class);
        intent.putExtra(saveOrEditExtra, pedido);
    }
}