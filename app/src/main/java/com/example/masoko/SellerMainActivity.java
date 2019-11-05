package com.example.masoko;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.firebase.auth.FirebaseAuth;

public class SellerMainActivity extends AppCompatActivity {

           /*----------------------------------------------------------------------
            |  Class: ParentMainActivity
            |
            |  Purpose: Creates a Tab View that will enable the user to move through 3 tabs (Fragments)
            |
            |  Note: ParentLocationTab: Tab that will handle all the location
            |        ParentHistoryTab: Tab that will show the user's all the previous consultation
            |        ParentProfileTab: Tab that will show the users's profile and enable the user to edit profile details
            |
            |
            *-------------------------------------------------------------------*/

    //Declare class variables
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private Button addshop_button, addproduct, addstock;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_main);

        addshop_button = (Button) findViewById(R.id.add_shop_button);

        addproduct = (Button) findViewById(R.id.add_product_button);

        addstock = (Button) findViewById(R.id.add_stock_button);


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);

        mViewPager.setAdapter(mSectionsPagerAdapter);
        addshop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addShopActivity();

            }
        });
        addproduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProduct();

            }
        });

        addstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addStock();

            }
        });


    }

    public void addShopActivity(){
        Intent intent = new Intent(SellerMainActivity.this, AddShopDetails.class);
        startActivity(intent);
        finish();
    }

    public void addProduct(){
        Intent intent = new Intent(SellerMainActivity.this, AddProductActivity.class);
        startActivity(intent);
        finish();
    }

    public void addStock(){
        Intent intent = new Intent(SellerMainActivity.this, AddStockActivity.class);
        startActivity(intent);
        finish();
    }



    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    SellerHistoryTab sellerHistoryTab = new SellerHistoryTab();
                    return sellerHistoryTab;
                case 1:
                    SellerProfileTab sellerProfileTab = new SellerProfileTab();
                    return sellerProfileTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent_icon activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_log_out) {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(SellerMainActivity.this, UserOptionsActivity.class);
            startActivity(intent);
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}