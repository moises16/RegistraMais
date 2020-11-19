package com.example.registramais;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.registramais.model.Product;

import java.security.PrivateKey;


public class FormProductFragment extends Fragment {

    public static final String PRODUCT_SAVE = "PRODUCT_SAVE";
    public static final String PRODUCT_EDIT = "PRODUCT_EDIT";
    private TextView txtProduct;
    private TextView txtvalues;
    private Button btnsave;
    private  Product product;

    public FormProductFragment() {
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
        View view = inflater.inflate(R.layout.fragment_form_product, container, false);
        carregaCampos(view);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                getProductFromForm();
                Bundle bundle=new Bundle();
                bundle.putSerializable(PRODUCT_SAVE,product);
                Navigation.findNavController(view).navigate(R.id.recyclerViewProductFragment,bundle);
            }
        });
        return view;
    }

    private void carregaCampos(View view) {
        txtProduct = view.findViewById(R.id.editTextNameProduct);
        txtvalues = view.findViewById(R.id.editTextValuesProduct);
        btnsave = view.findViewById(R.id.buttonSave);

    }
    private void getProductFromForm(){
        if (validateForm()) {
            String nomeproduto = txtProduct.getText().toString();
            String valorString = txtvalues.getText().toString();
         // double valorproduct = Double.parseDouble(valorString);
            product = new Product(nomeproduto, valorString);
        }
    }

    private boolean validateForm() {
        if (TextUtils.isEmpty(txtProduct.getText())){
            txtProduct.setError("Informe o nome do produto");
            txtProduct.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(txtvalues.getText())){
            txtvalues.setError("Informe a descrição do produto");
            txtvalues.requestFocus();
            return false;
        }

        return true;
    }
}

