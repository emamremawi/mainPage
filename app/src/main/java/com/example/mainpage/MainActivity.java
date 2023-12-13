package com.example.mainpage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);

    }
    public void goToLogIn(View view) {
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public void book(View view) {
        Intent intent = new Intent(this, chooseBarber.class);
        startActivity(intent);
    }

    public void Adaieh(View view) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("btata");

        ref.child("alanisawesome").setValue("me");

        // Create a new user object (replace with your own data)
//        ArrayList <Boolean> appoinments = new ArrayList();
//        appoinments.add(true);
//        ArrayList <String> bookings = new ArrayList();
//        bookings.add("potatah");
//        barber b = new barber(12,"Emam",appoinments,bookings);

        // Push the new user data to the database
        ref.push().setValue("batata")
                .addOnSuccessListener(aVoid -> {
                    // Data inserted successfully
                    Log.d("MyApp", "Data inserted");
                    Toast.makeText(MainActivity.this, "Done", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e -> {
                    // Failed to insert data
                    Log.e("MyApp", "Failed to insert data: " + e.getMessage());
                    Toast.makeText(MainActivity.this, "Erroraieh", Toast.LENGTH_SHORT).show();
                });


    }
    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(this, login.class); // Replace LoginActivity.class with your login activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}