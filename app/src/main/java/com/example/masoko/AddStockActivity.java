package com.example.masoko;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStockActivity extends AppCompatActivity {
    private EditText s_name, s_quantity;
    private Button addstock_button;
    private ProgressDialog progressDialog;

    DatabaseReference databaseStock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);

        s_name =(EditText)findViewById(R.id.stockname);
        s_quantity =(EditText)findViewById(R.id.stockquantity);

        addstock_button = (Button) findViewById(R.id.add_stock_button);
        progressDialog = new ProgressDialog(this);

        databaseStock = FirebaseDatabase.getInstance().getReference("stocks");

        addstock_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveStock();
            }
        });
    }

    private void saveStock(){
        String name = s_name.getText().toString().trim();
        String quantity = s_quantity.getText().toString().trim();

        if (name.equals("") || quantity.equals("")){
            Toast.makeText(AddStockActivity.this, "Please enter all details", Toast.LENGTH_SHORT).show();
        } else {

            //Use the progressDialog so as to avoid user wait as Firebase Validates the user
            progressDialog.setMessage("Loading...");
            progressDialog.setCancelable(false);
            progressDialog.show();

            String id = databaseStock.push().getKey();
            Stock stock = new Stock(id, name, quantity);
            databaseStock.child(id).setValue(stock);
            Toast.makeText(this, "Shop added successfully", Toast.LENGTH_SHORT).show();

        }

    }
}
