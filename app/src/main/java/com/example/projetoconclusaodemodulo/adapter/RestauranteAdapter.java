package com.example.projetoconclusaodemodulo.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projetoconclusaodemodulo.R;
import com.example.projetoconclusaodemodulo.interfaces.RecyclerViewOnClick;
import com.example.projetoconclusaodemodulo.modelo.Restaurante;

import java.util.List;

public class RestauranteAdapter extends RecyclerView.Adapter<RestauranteAdapter.ViewHolder>{

    private List<Restaurante> restauranteList;

    private RecyclerViewOnClick listener;


    public RestauranteAdapter(List<Restaurante> restauranteList, RecyclerViewOnClick listener){
        this.restauranteList = restauranteList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_restaurante, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final  Restaurante restaurante = restauranteList.get(position);
        holder.onBind(restaurante);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    listener.onClick(restaurante);

            }
        });

    }

    @Override
    public int getItemCount() {
        return restauranteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewRestaurante;
        private TextView txtNomeRestaurante;
        private TextView txtEnderecoRestaurante;
        private TextView txtHoraFuncionamento;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewRestaurante = itemView.findViewById(R.id.imageViewRestaurante);
            txtNomeRestaurante = itemView.findViewById(R.id.textViewNomeRestaurante);
            txtEnderecoRestaurante = itemView.findViewById(R.id.textViewEnderecoRestaurante);
            txtHoraFuncionamento = itemView.findViewById(R.id.textViewHrFuncionamento);
        }

        public void onBind(Restaurante restaurante){

            Drawable drawable = itemView.getResources().getDrawable(restaurante.getImagem());
            imageViewRestaurante.setImageDrawable(drawable);
            txtNomeRestaurante.setText(restaurante.getNome());
            txtEnderecoRestaurante.setText(restaurante.getEndereco());
            txtHoraFuncionamento.setText("Horário de funcionamento: "+restaurante.getHoraAbertura()+" às "+restaurante.getHoraFechamento());

        }
    }
}
