package com.example.masoko;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UserOptionsActivity extends AppCompatActivity {


      /*----------------------------------------------------------------------
        |  Class: UserOptionsActivity
        |
        |  Purpose: Give the two users options to go to their specific roles Activity
        |           Seller or Buyer/Customer
        |
        |  Note: Seller will be directed to SellerLogActivity
        |        Customer will be directed to CustomerLogActivity
        |
        |
        *-------------------------------------------------------------------*/

    //Declare Activity Variables
    Button seller, customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Set the layout of the Activity
        setContentView(R.layout.activity_user_options);

        //Initialize Activity Variables
        seller = (Button) findViewById(R.id.seller_button);
        customer = (Button) findViewById(R.id.customer_button);

        //patient Button
        seller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent to send the user to the Registration Activity
                Intent intent = new Intent(UserOptionsActivity.this, SellerLogActivity.class);
                //Start the Activity
                startActivity(intent);
                finish();
            }
        });

        //Paediatrician Button
        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create new intent to send the user to the Registration Activity
                Intent intent = new Intent(UserOptionsActivity.this, CustomerLogActivity.class);
                //Start the Activity
                startActivity(intent);
                finish();
            }
        });

    }
}
