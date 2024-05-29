package com.example.fitstreak.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fitstreak.R;
import com.example.fitstreak.database_utils.FireStore;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class SignIn extends AppCompatActivity {

    public static FirebaseAuth auth;
    Button btnSignIn, btnRegister;
    EditText email, password;

    public static FireStore fireStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        fireStore = new FireStore();

        auth = FirebaseAuth.getInstance();
        email = findViewById(R.id.textEmailLogin);
        password = findViewById(R.id.textPasswordLogin);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(v -> {

            String e = email.getText().toString();
            String p = password.getText().toString();

            if (e.isEmpty() || p.isEmpty()) {
                Toast.makeText(SignIn.this, "Email or Password cannot be empty",
                        Toast.LENGTH_SHORT).show();
                return;
            }


            auth.signInWithEmailAndPassword(e, p)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(SignIn.this, "Login successful",
                                        Toast.LENGTH_SHORT).show();

                                FirebaseUser currentUser = auth.getCurrentUser();
                                assert currentUser != null;
                                String uid = currentUser.getUid();

                                fireStore.checkUserInFirestore(uid, SignIn.this);

                            } else {
                                Toast.makeText(SignIn.this, "Account does not exist",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        });

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(view -> {

            String e = email.getText().toString();
            String p = password.getText().toString();

            if (e.isEmpty() || p.isEmpty()) {
                Toast.makeText(SignIn.this, "Email or Password cannot be empty",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            auth.createUserWithEmailAndPassword(e, p).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(SignIn.this, "Register Successful", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(SignIn.this, "Failed To Register Account", Toast.LENGTH_SHORT).show();
                }
            });
        });
    }


}