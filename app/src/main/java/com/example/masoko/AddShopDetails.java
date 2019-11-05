package com.example.masoko;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddShopDetails extends AppCompatActivity {

    private EditText permit, kra_pin, location, delivery;
    private ImageView imageViewLogo;
    private Button addshop_button;
    private ProgressDialog progressDialog;

    FirebaseUser user;

    String uid;

    DatabaseReference databaseShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_shop_details);

        permit =(EditText)findViewById(R.id.business_permit);
        kra_pin =(EditText)findViewById(R.id.kra_pin);
        location =(EditText)findViewById(R.id.location);
        delivery =(EditText)findViewById(R.id.delivery);


        imageViewLogo = (ImageView) findViewById(R.id.logo);

        addshop_button = (Button) findViewById(R.id.add_shop_button);
        progressDialog = new ProgressDialog(this);

        user = FirebaseAuth.getInstance().getCurrentUser();
        uid = user.getUid();

        databaseShop = FirebaseDatabase.getInstance().getReference("shops").child(uid);

        addshop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveShop();
            }
        });

        imageViewLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });

    }

    private void saveShop(){
        String businesspermit = permit.getText().toString().trim();
        String pin = kra_pin.getText().toString().trim();
        String shoplocation = location.getText().toString().trim();
        String deliveryarea = delivery.getText().toString().trim();

        if (businesspermit.equals("") || pin.equals("") || shoplocation.equals("")){
            Toast.makeText(AddShopDetails.this, "Please enter all details", Toast.LENGTH_SHORT).show();
        } else {

            //Use the progressDialog so as to avoid user wait as Firebase Validates the user
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            String shop_id = databaseShop.push().getKey();
            Shop shop = new Shop(shop_id, businesspermit, pin, shoplocation, deliveryarea);
            databaseShop.child(shop_id).setValue(shop);
            Toast.makeText(this, "Shop added successfully", Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();

        }

    }
}
