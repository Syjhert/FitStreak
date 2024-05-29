package com.example.fitstreak.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.fitstreak.R;
import com.google.firebase.auth.FirebaseAuth;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Button btnRegister;
    EditText email, password;

    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.textEmail);
        password = findViewById(R.id.textPassword);



        btnRegister = findViewById(R.id.btnRegisterzz);
        btnRegister.setOnClickListener(v -> {
            String e = email.getText().toString();
            String p = password.getText().toString();

            if (e.isEmpty() || p.isEmpty()) {
                Toast.makeText(Register.this, "Email or Password cannot be empty",
                        Toast.LENGTH_SHORT).show();
            }

            auth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(Register.this, "Register Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Register.this, "Failed To Register Account", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }
}