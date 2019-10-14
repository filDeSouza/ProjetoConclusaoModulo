package com.example.projetoconclusaodemodulo.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.projetoconclusaodemodulo.R;
import com.example.projetoconclusaodemodulo.adapter.RestauranteAdapter;
import com.example.projetoconclusaodemodulo.interfaces.RecyclerViewOnClick;
import com.example.projetoconclusaodemodulo.modelo.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements RecyclerViewOnClick {

    private RecyclerView recyclerView;
    private RestauranteAdapter adapter;
    private List<Restaurante> restauranteList = new ArrayList<>();
    public static final String RESTAURANTE_KEY = "restaurante";
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = findViewById(R.id.recyclerViewRestaurantes);

        adapter = new RestauranteAdapter(getRestaurantes(), this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private List<Restaurante> getRestaurantes(){

        restauranteList.add(new Restaurante(R.drawable.amaury, "Amaury Dumbo", "Avenida Aurora 1200, Bela Vista, Sao Paulo", "17:00","01:00"));
        restauranteList.add(new Restaurante(R.drawable.outback, "Outback", "Avenida Alphaville 1500", "12:00","01:00"));

        return restauranteList;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_drawer, menu);
        return true;
    }

    @Override
    public void onClick(Restaurante restaurante) {

        Intent intent = new Intent(HomeActivity.this, PratosActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(RESTAURANTE_KEY, restaurante);
        intent.putExtras(bundle);
        startActivity(intent);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
