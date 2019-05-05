package com.example.clothshopapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.clothshopapp.R;
import com.example.clothshopapp.adapter.ViewPagerAdapter;
import com.example.clothshopapp.fragment.LoginFragment;
import com.example.clothshopapp.fragment.SignupFragment;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout=findViewById(R.id.tabId);
        viewPager=findViewById(R.id.viewPager);

        ViewPagerAdapter adapter=new ViewPagerAdapter(getSupportFragmentManager());
        adapter.loginFragment(new LoginFragment(),"Login");
        adapter.loginFragment(new SignupFragment(),"Signup");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
