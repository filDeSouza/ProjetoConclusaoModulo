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
import com.example.projetoconclusaodemodulo.interfaces.RecyclerViewOnClickPrato;
import com.example.projetoconclusaodemodulo.modelo.Prato;

import java.util.List;

public class PratoAdapter extends RecyclerView.Adapter<PratoAdapter.ViewHolder> {

    private List<Prato> pratoList;

    private RecyclerViewOnClickPrato listener;

    public PratoAdapter(List<Prato> pratoList, RecyclerViewOnClickPrato listener) {
        this.pratoList = pratoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview_pratos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final Prato prato = pratoList.get(position);
        holder.onBind(prato);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.onClick(prato);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pratoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPrato;
        private TextView txtNomePrato;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            imageViewPrato = itemView.findViewById(R.id.imageViewFotoPrato);
            txtNomePrato = itemView.findViewById(R.id.textViewNomePrato);
        }

        public void onBind(Prato prato){

            Drawable drawable = itemView.getResources().getDrawable(prato.getImagem());
            imageViewPrato.setImageDrawable(drawable);
            txtNomePrato.setText(prato.getNome());

        }

    }
}
