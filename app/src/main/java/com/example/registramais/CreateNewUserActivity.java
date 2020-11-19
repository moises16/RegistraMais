package com.example.registramais;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class CreateNewUserActivity extends AppCompatActivity {
    private static final String TAG = "CreateNewUserActivity";
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSave;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        editTextEmail = findViewById(R.id.editTextTextEmailAddressNewUser);
        editTextPassword = findViewById(R.id.editTextTextPasswordNewUser);
        buttonSave = findViewById(R.id.btnCreateNewUser);
        auth = FirebaseAuth.getInstance();

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString();
                String password = editTextPassword.getText().toString();

                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Log.d(TAG,"user created successfully");
                                    FirebaseUser user = auth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    Log.w(TAG,"failed to create user", task.getException());
                                    Toast.makeText(CreateNewUserActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }
                            }
                        });
            }
        });
    }
    private void updateUI(FirebaseUser user) {
        if (user != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this,"Erro ao cadastrar usuário",
                    Toast.LENGTH_SHORT).show();
        }
    }
    }