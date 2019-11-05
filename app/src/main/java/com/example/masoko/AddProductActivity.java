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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProductActivity extends AppCompatActivity {

    private EditText p_price, p_name, p_category, p_brand, p_quantity, p_units;
    private ImageView imageViewLogo;

    private Button addproduct_button;
    private ProgressDialog progressDialog;

    DatabaseReference databaseProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        p_name =(EditText)findViewById(R.id.productname);
        p_price =(EditText)findViewById(R.id.productprice);
        p_category =(EditText)findViewById(R.id.productcategory);
        p_brand =(EditText)findViewById(R.id.productbrand);
        p_quantity =(EditText)findViewById(R.id.productquantity);
        p_units =(EditText)findViewById(R.id.productunit);


        addproduct_button = (Button) findViewById(R.id.add_product_button);
        progressDialog = new ProgressDialog(this);
        imageViewLogo = (ImageView) findViewById(R.id.p_image);


        databaseProduct = FirebaseDatabase.getInstance().getReference("products");

        addproduct_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
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

    private void saveProduct(){
        String name = p_name.getText().toString().trim();
        String price = p_price.getText().toString().trim();
        String category = p_category.getText().toString().trim();
        String brand = p_brand.getText().toString().trim();
        String quantity = p_quantity.getText().toString().trim();
        String unit = p_units.getText().toString().trim();


        if (name.equals("") || price.equals("") || category.equals("") || brand.equals("") || quantity.equals("") || quantity.equals("")){
            Toast.makeText(AddProductActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
        } else {

            //Use the progressDialog so as to avoid user wait as Firebase Validates the user
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            String id = databaseProduct.push().getKey();
            Product product = new Product(id, name, price, category, brand, quantity, unit);
            databaseProduct.child(id).setValue(product);
            Toast.makeText(this, "Shop added successfully", Toast.LENGTH_SHORT).show();

        }

    }
}
