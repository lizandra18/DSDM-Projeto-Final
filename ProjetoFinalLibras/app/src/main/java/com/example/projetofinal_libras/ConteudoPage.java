package com.example.projetofinal_libras;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ConteudoPage extends AppCompatActivity {
    ViewPager2 viewPager;
    MyViewPagerAdapter myAdapter;
    TabLayout tabLayout;

    String[] menu = {"Explicação", "Sinais", "SignWriting"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conteudo_page);

        int itemId = getIntent().getIntExtra("id", 0);

        SharedPreferences sharedPref = getSharedPreferences("ContentPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("savedItemId", itemId);
        editor.apply();

        tabLayout = findViewById(R.id.tablayout);

        myAdapter = new MyViewPagerAdapter(
                getSupportFragmentManager(),
                getLifecycle()
        );

        myAdapter.addFragment(Fragment1.newInstance(itemId));
        myAdapter.addFragment(new Fragment2());
        myAdapter.addFragment(new Fragment3());

        viewPager = findViewById(R.id.viewPager2);
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPager.setAdapter(myAdapter);

        new TabLayoutMediator(
                tabLayout,
                viewPager,
                (tab, position) -> tab.setText(menu[position])
        ).attach();
    }
}
