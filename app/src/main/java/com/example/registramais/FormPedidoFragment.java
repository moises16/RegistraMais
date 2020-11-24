package com.example.registramais;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.registramais.model.Pedido;
import com.example.registramais.model.Product;
import com.example.registramais.recyclerviewitemproduto.AdapterItemProduct;
import com.example.registramais.recyclerviewitemproduto.RecyclerItemProdutoFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


public class FormPedidoFragment extends Fragment {
    public static final String PEDIDO_SAVE = "NEW_PEDIDO";
    private List<Product> productItemList;
    private EditText nomeCliente;
    private EditText numero;
    private Button buttonAddProduto;
    private Button buttonVerProduto;
    private Button buttonSalvar;
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

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getInputForm();
                Bundle bundle = new Bundle();
                bundle.putSerializable(PEDIDO_SAVE, pedido);
                Navigation.findNavController(view).navigate(R.id.action_formPedidoFragment_to_recyclerViewFragment, bundle);
            }
        });

        buttonAddProduto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_formPedidoFragment_to_recyclerItemProdutoFragment);
            }
        });
        return view;
    }

    void loadViews(View view){
        nomeCliente = view.findViewById(R.id.editTextNomePedidos);
        numero = view.findViewById(R.id.editTextNumeroPedidos);
        buttonAddProduto = view.findViewById(R.id.btnAddPratosPedidos);
        buttonVerProduto = view.findViewById(R.id.btnVerPedidos);
        buttonSalvar = view.findViewById(R.id.btnSalvarFormPedidos);

    }

//    private void loadForm(){
//        nomeCliente.setText(pedido.getNomeCliente());
//        numero.setText(pedido.getNumero());
//        data.setText(pedido.getData());
//    }

    private void getInputForm(){
        if (validaForm()) {
            String nome = nomeCliente.getText().toString();
            String numeroCliente = numero.getText().toString();
            pedido = new Pedido(nome, numeroCliente);
        }
    }

//    private void updatePedidoForm(){
//        String nome = nomeCliente.getText().toString();
//        String valor = numero.getText().toString();
//
//        pedido.setNomeCliente(nome);
//        pedido.setNumero(valor);
//    }

    private boolean validaForm(){
        if (TextUtils.isEmpty(nomeCliente.getText())){
            nomeCliente.setError("Informe o nome do cliente");
            nomeCliente.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(numero.getText())){
            numero.setError("Informe o numero do cliente");
            numero.requestFocus();
            return false;
        }
        return true;
    }

}