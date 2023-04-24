package com.example.parcial.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcial.R;

import java.util.ArrayList;
import java.util.List;

public class NotaAdapter extends RecyclerView.Adapter<NotaAdapter.ViewHolder>{

        private LayoutInflater inflater;

        private Context context;

        private ArrayList<String> notas=new ArrayList<>();


        public NotaAdapter(LayoutInflater inflater, Context context, ArrayList<String> notas) {
            this.inflater = inflater;
            this.context = context;
            this.notas = notas;
        }

        @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View root=inflater.inflate(R.layout.item_rview,parent,false);
                return new ViewHolder(root);
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.tvtitulo.setText((notas.get(position)));

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int posicion = holder.getAdapterPosition();
                        String nota=notas.get(posicion);
                        Bundle bundle=new Bundle();
                        bundle.putString("nota", nota);
                        bundle.putInt("pos",posicion);
                        Navigation.findNavController(v).navigate(R.id.nav_detalles,bundle);
                    }
                });
            }


            @Override
            public int getItemCount() {
                return notas.size();
            }

            public class ViewHolder extends RecyclerView.ViewHolder{

                TextView tvtitulo;

                public ViewHolder(@NonNull View itemView) {
                    super(itemView);
                    tvtitulo=itemView.findViewById(R.id.tvNota);

                }
            }
}
