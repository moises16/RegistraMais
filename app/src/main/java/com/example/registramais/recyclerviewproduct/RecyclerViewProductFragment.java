package com.example.registramais.recyclerviewproduct;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registramais.FormProductFragment;
import com.example.registramais.R;
import com.example.registramais.model.Product;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewProductFragment extends Fragment {
    private static final String PRODUCTS_COLLECTION = "produtos";
    private static final String TAG = "RecyclerViewProductFragment";
    private AdapterProduct adapter;
    private List<Product> productsList;
    private RecyclerView recyclerViewproduct;
    private FirebaseFirestore db;
    private FirebaseUser user;

    public RecyclerViewProductFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view_product,container,false);
        productsList=new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        configRecyclerView(view);
        loadData(view);
        if (getArguments() !=null) {
            Product product = (Product) getArguments().getSerializable(FormProductFragment.PRODUCT_SAVE);
            db.collection(PRODUCTS_COLLECTION).add(product);
            loadData(view);
        }
        return view;
    }

    private void configRecyclerView(@NotNull View view){
    recyclerViewproduct =view.findViewById(R.id.recyclerViewListProducts);
    recyclerViewproduct.setLayoutManager(new LinearLayoutManager(getActivity()));
    adapter=new AdapterProduct(getActivity().getApplicationContext(),productsList);
    recyclerViewproduct.setAdapter(adapter);

    }
    void loadData(View view){
        db.collection(PRODUCTS_COLLECTION)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            productsList.clear();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Product product = document.toObject(Product.class);
                                product.setId(document.getId());
                                productsList.add(product);
                            }

                            configRecyclerView(view);

                        }
                    }
                });
    }
}