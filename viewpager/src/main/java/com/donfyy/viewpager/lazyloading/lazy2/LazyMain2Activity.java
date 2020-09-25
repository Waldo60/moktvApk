package com.donfyy.viewpager.lazyloading.lazy2;

import android.os.Bundle;
import android.view.MenuItem;

import com.donfyy.viewpager.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class LazyMain2Activity extends AppCompatActivity {

    ViewPager mViewPager;
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lazy);
        mViewPager = findViewById(R.id.viewPager);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragmentExtendLazy1.newInstance(1));
        fragmentList.add(FragmentExtendLazy1.newInstance(2));
        fragmentList.add(FragmentExtendLazy1.newInstance(3));
        fragmentList.add(FragmentExtendLazy1.newInstance(4));
        fragmentList.add(FragmentExtendLazy1.newInstance(5));
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(viewpagerChangeListener);


    }

    ViewPager.OnPageChangeListener viewpagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            int itemId = R.id.fragment_1;
            switch (i) {
                case 0:
                    itemId = R.id.fragment_1;
                    break;
                case 1:
                    itemId = R.id.fragment_2;
                    break;
                case 2:
                    itemId = R.id.fragment_3;
                    break;
                case 3:
                    itemId = R.id.fragment_4;
                    break;
                case 4:
                    itemId = R.id.fragment_5;
                    break;
            }
            bottomNavigationView.setSelectedItemId(itemId);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.fragment_1:
                    mViewPager.setCurrentItem(0, true);
                    return true;
                case R.id.fragment_2:
                    mViewPager.setCurrentItem(1, true);
                    return true;
                case R.id.fragment_3:
                    mViewPager.setCurrentItem(2, true);
                    return true;
                case R.id.fragment_4:
                    mViewPager.setCurrentItem(3, true);
                    return true;
                case R.id.fragment_5:
                    mViewPager.setCurrentItem(4, true);
                    return true;
            }
            return false;
        }

    };
}
