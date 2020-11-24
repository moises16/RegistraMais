package com.example.registramais.recyclerviewitemproduto;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registramais.R;
import com.example.registramais.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class RecyclerItemProdutoFragment extends Fragment {
    private List<Product> productItemList;
    private RecyclerView recyclerViewItemProduto;
    private AdapterItemProduct adapter;
    private FirebaseFirestore db;
    public static final String PRODUCTS_COLLECTION = "produtos";

    public RecyclerItemProdutoFragment() {
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
        productItemList = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        configRecyclerView(view);
        loadData(view);
        return view;
    }

    private void configRecyclerView(View view){
        recyclerViewItemProduto = view.findViewById(R.id.recyclerViewItemProduto);
        recyclerViewItemProduto.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AdapterItemProduct(getActivity().getApplicationContext(),productItemList);
        recyclerViewItemProduto.setAdapter(adapter);
    }

    void loadData(View view){
        db.collection(PRODUCTS_COLLECTION)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            productItemList.clear();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = document.toObject(Product.class);
                                product.setId(document.getId());
                                productItemList.add(product);
                            }

                            configRecyclerView(view);

                        }
                    }
                });
    }
}