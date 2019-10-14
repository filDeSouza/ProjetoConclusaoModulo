package com.example.projetoconclusaodemodulo.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.projetoconclusaodemodulo.R;
import com.example.projetoconclusaodemodulo.modelo.Prato;

import static com.example.projetoconclusaodemodulo.views.PratosActivity.PRATO_KEY;

public class DetalhePratoActivity extends AppCompatActivity {

    private ImageView imgViewPrato;
    private TextView txtViewNomePrato;
    private TextView txtViewDetalhePrato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_prato);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null){

            Prato prato = getIntent().getExtras().getParcelable(PRATO_KEY);

            Drawable drawable = getResources().getDrawable(prato.getImagem());
            imgViewPrato.setImageDrawable(drawable);
            txtViewNomePrato.setText(prato.getNome());
            txtViewDetalhePrato.setText(prato.getDescricao());

        }

    }

    private void initViews(){
        imgViewPrato = findViewById(R.id.imageViewPrato);
        txtViewNomePrato = findViewById(R.id.textViewPrato);
        txtViewDetalhePrato = findViewById(R.id.textViewDetalhePrato);
    }
}
