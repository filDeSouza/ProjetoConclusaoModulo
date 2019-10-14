package com.example.projetoconclusaodemodulo.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetoconclusaodemodulo.R;
import com.example.projetoconclusaodemodulo.adapter.PratoAdapter;
import com.example.projetoconclusaodemodulo.interfaces.RecyclerViewOnClickPrato;
import com.example.projetoconclusaodemodulo.modelo.Prato;
import com.example.projetoconclusaodemodulo.modelo.Restaurante;

import java.util.ArrayList;
import java.util.List;

import static com.example.projetoconclusaodemodulo.views.HomeActivity.RESTAURANTE_KEY;

public class PratosActivity extends AppCompatActivity implements RecyclerViewOnClickPrato {

    private ImageView imageViewRestaurante;
    private TextView textViewNomeRestaurante;
    private ImageView imageViewPrato;
    private TextView txtNomePrato;
    private String stringRestaurante;

    private RecyclerView recyclerView;
    private PratoAdapter adapter;
    private List<Prato> pratoList = new ArrayList<>();
    public static final String PRATO_KEY = "prato";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pratos);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){

            Restaurante restaurante = getIntent().getExtras().getParcelable(RESTAURANTE_KEY);

            Drawable drawable = getResources().getDrawable(restaurante.getImagem());
            imageViewRestaurante.setImageDrawable(drawable);
            textViewNomeRestaurante.setText(restaurante.getNome());
            stringRestaurante = restaurante.getNome();
        }

        recyclerView = findViewById(R.id.recyclerViewPratos);
        adapter = new PratoAdapter(getPratos(), this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));


    }

    private void initViews() {

        imageViewRestaurante = findViewById(R.id.imageViewRestauranteTelaPratos);
        imageViewPrato = findViewById(R.id.imageViewFotoPrato);
        txtNomePrato = findViewById(R.id.textViewNomePrato);
        textViewNomeRestaurante = findViewById(R.id.textViewNomeRestaurantePratos);
    }

    private List<Prato> getPratos(){

        if (stringRestaurante.equals("Amaury Dumbo")){
            pratoList.add(new Prato(R.drawable.biro, "Arroz Biro Biro", "Arroz temperado, com legumes e uma pitada do Biro Biro!"));
            pratoList.add(new Prato(R.drawable.bola, "Sorvete de Bola", "Sorvete servido com bolas de boi!"));
            pratoList.add(new Prato(R.drawable.maoteiga, "Pão com Mãoteiga", "Prato refinado, preparado pelo Sidney, mecänico do Restaurante!"));
            pratoList.add(new Prato(R.drawable.soparala, "Sopa Rala", "Carro cheff da Casa, sopa especialmente preparada com as sobras das lavagens dos pratos!"));
            pratoList.add(new Prato(R.drawable.restaurante1, "Chumass a la vonts", "Prato refinado, regado à molho madeira, salpicado em chumass a la piel"));
        }else if (stringRestaurante.equals("Outback")){
            pratoList.add(new Prato(R.drawable.onion, "Blume Onion", "Uma deliciosa cebola frita, preparada com molho especial Outback!"));
            pratoList.add(new Prato(R.drawable.chicken, "Chicken Wings", "Deliciosas asas de frango, podendo escolher entre nosso molho especial super picante e pouco picante!"));
            pratoList.add(new Prato(R.drawable.cordeiro, "Costela de Cordeiro", "Deliciosas costelas de cordeiro, preparadas com molho Outback!"));
            pratoList.add(new Prato(R.drawable.ribsburger, "Ribs Burger", "Hamburger preparado com o carro chefe da casa, nossa tradicional costela desfiada!"));
            pratoList.add(new Prato(R.drawable.ribsfries, "Ribs Fries", "A sempre pedida fries, coberta com queijo cheddar, bacon e costela desfiada!"));
            pratoList.add(new Prato(R.drawable.legumesvapor, "Legumes no Vapor", "Legumes preparados especialmente no vapor"));

        }

        return pratoList;
    }

    @Override
    public void onClick(Prato prato) {

        Intent intent = new Intent(PratosActivity.this, DetalhePratoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRATO_KEY, prato);
        intent.putExtras(bundle);
        startActivity(intent);


    }
}
