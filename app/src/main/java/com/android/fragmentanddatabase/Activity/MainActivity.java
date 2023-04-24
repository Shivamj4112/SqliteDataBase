package com.android.fragmentanddatabase.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.android.fragmentanddatabase.Adapter.DatabaseAdapter;
import com.android.fragmentanddatabase.Adapter.ViewAdapter;
import com.android.fragmentanddatabase.Database.Database;
import com.android.fragmentanddatabase.ModelClass.ModelClass;
import com.android.fragmentanddatabase.R;
import com.android.fragmentanddatabase.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    TabLayout tabLayout;
//    ViewPager pager;
static ActivityMainBinding binding;
    static Database database;
    List<ModelClass> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        datalist = new ArrayList<>();
        database = new Database(MainActivity.this);

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Name = binding.edtName.getText().toString();
                String Age = binding.edtAge.getText().toString();
                String Mobile = binding.edtMobile.getText().toString();
                String Email = binding.edtEmail.getText().toString();

                // Insert Data
                database.InsertData(Name,Age,Mobile,Email);

                // Retrieve Data
                Retrieve(MainActivity.this);


            }
        });



//
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//        recyclerView.setAdapter(new DatabaseAdapter);




//        tabLayout = findViewById(R.id.tabLayout);
//        pager = findViewById(R.id.viewPager);
//
//        tabLayout.addTab(tabLayout.newTab().setText("Insert"));
//        tabLayout.addTab(tabLayout.newTab().setText("Retrieve"));
//        tabLayout.addTab(tabLayout.newTab().setText("Update"));
//        tabLayout.addTab(tabLayout.newTab().setText("Delete"));
//
//        ViewAdapter adapter = new ViewAdapter(getSupportFragmentManager());
//        pager.setAdapter(adapter);
//
//        tabLayout.setupWithViewPager(pager);


    }

    public static void Retrieve(Activity activity) {

        List<ModelClass> list = database.Retrieve();
        binding.recycler.setLayoutManager(new LinearLayoutManager(activity));
        binding.recycler.setAdapter(new DatabaseAdapter(activity,list));
    }
}