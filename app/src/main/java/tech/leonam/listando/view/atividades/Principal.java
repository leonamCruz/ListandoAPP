package tech.leonam.listando.view.atividades;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;

import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

import tech.leonam.listando.R;
import tech.leonam.listando.view.adaptadores.AdaptadorDePaginas;

public class Principal extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 view;
    private Activity currentActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setStatusBarColor(Color.BLACK);
        iniciarComponentes();
        adicionarTabListener();
        arrastaProLado();
    }
    private void arrastaProLado() {
        view.registerOnPageChangeCallback(new OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Objects.requireNonNull(tabLayout.getTabAt(position)).select();
            }
        });
    }

    private void adicionarTabListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    private void iniciarComponentes() {
        view = findViewById(R.id.view_das_coisas);
        view.setAdapter(new AdaptadorDePaginas(this));
        tabLayout = findViewById(R.id.tabLayout);
    }
}
