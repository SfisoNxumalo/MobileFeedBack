package com.sfiso.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private SectionsPageAdapter sectionPageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sectionPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.vpViewPager);
        setupViewPager(viewPager);
        TabLayout tabLayout = findViewById(R.id.tbtabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        SectionsPageAdapter sectionsPageAdapter= new SectionsPageAdapter(getSupportFragmentManager());
        sectionsPageAdapter.addFragment(new Createtab_Fragment(), "Create");
        sectionsPageAdapter.addFragment(new Readtab_Fragment() ,"Read");
        sectionsPageAdapter.addFragment(new Updatetab_Fragment() ,"Update");

        viewPager.setAdapter(sectionsPageAdapter);
    }
}