package com.example.registramais;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.registramais.model.Pedido;
import com.example.registramais.recyclerviewpedidos.PedidoItemTouchHelper;
import com.example.registramais.recyclerviewpedidos.PedidoOnClickListener;
import com.example.registramais.recyclerviewpedidos.PedidosAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewFragment extends Fragment {
    private static final String PEDIDOS_COLLECTION = "pedidosTest";
    private static final String TAG = "RecyclerViewFragment";
    private RecyclerView recyclerViewPedidos;
    public List<Pedido> pedidoList;
    private FirebaseUser user;
    private PedidosAdapter adapter;
    private FloatingActionButton floatingActionButtonPedido;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
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
        View view = inflater.inflate(R.layout.fragment_recycler_view_pedido, container, false);
        user = FirebaseAuth.getInstance().getCurrentUser();
        db = FirebaseFirestore.getInstance();
        pedidoList = new ArrayList<>();
        configRecyclerView(view);
        loadData(view);

            if (getArguments() != null) {
                Pedido pedido = (Pedido) getArguments().getSerializable(FormPedidoFragment.PEDIDO_SAVE);
                db.collection(PEDIDOS_COLLECTION).add(pedido);
                loadData(view);
                adapter.notifyDataSetChanged();
            }
            return view;
    }

    void configRecyclerView(View view){
        recyclerViewPedidos = view.findViewById(R.id.recyclerViewPedido);
        recyclerViewPedidos.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PedidosAdapter(getActivity().getApplicationContext(), pedidoList);
        recyclerViewPedidos.setAdapter(adapter);
        adapter.setOnItemClickListener(new PedidoOnClickListener() {
            @Override
            public void itemClick(Pedido pedido) {
                Navigation.findNavController(view).navigate(R.id.action_recyclerViewFragment_to_formPedidoFragment);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new PedidoItemTouchHelper(adapter));
        itemTouchHelper.attachToRecyclerView(recyclerViewPedidos);
    }


    void loadData(View view){
        db.collection(PEDIDOS_COLLECTION).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    pedidoList.clear();
                    for (QueryDocumentSnapshot document : task.getResult()){
                        Pedido pedido = document.toObject(Pedido.class);
                        pedido.setId(document.getId());
                        pedidoList.add(pedido);
                    }
                        configRecyclerView(view);
                } else {
                    Log.d(TAG, "Erro getting documents: ", task.getException());
                }
            }
        });
    }



}