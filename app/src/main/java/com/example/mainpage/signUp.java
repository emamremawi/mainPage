package com.example.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {
    private EditText editTextUsername, editTextEmail, editTextPassword, editTextPasswordsub;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();

        editTextUsername = findViewById(R.id.Username);
        editTextPassword = findViewById(R.id.passwordw);
        editTextPasswordsub = findViewById(R.id.passwordcon);

        Button buttonSignUp = findViewById(R.id.submit);
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    private void signUp() {
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordS = editTextPasswordsub.getText().toString().trim();

        firebaseAuth.createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!password.equals(passwordS)){

                            Toast.makeText(signUp.this, "passwords are not the same", Toast.LENGTH_SHORT).show();
                        }else if (task.isSuccessful()) {
                            Toast.makeText(signUp.this, "Sign up successful.", Toast.LENGTH_SHORT).show();
                            authenticate(username,password);
                            Intent intent = new Intent(signUp.this, MainActivity.class);
                            startActivity(intent);

                        } else {
                            // If sign up fails, display a message to the user.
                            Toast.makeText(signUp.this, "make sure of the content", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }




    private boolean authenticate(String username, String password) {
        // Implement your custom authentication logic here, e.g., check against a database
        // For a simple example, you can hardcode some credentials
        return username.equals("your_username") && password.equals("your_password");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}