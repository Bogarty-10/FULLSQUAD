package com.example.fullsquad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PartidoAdapter extends RecyclerView.Adapter<PartidoAdapter.PartidoViewHolder> {

    // Lista recibida desde SQLite
    private ArrayList<Partido> listaPartidos;

    public PartidoAdapter(ArrayList<Partido> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }

    public static class PartidoViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombrePartido;
        TextView tvFechaPartido;
        TextView tvHoraPartido;
        TextView tvLugarPartido;

        public PartidoViewHolder(View itemView) {
            super(itemView);

            tvNombrePartido = itemView.findViewById(R.id.tvNombrePartido);
            tvFechaPartido = itemView.findViewById(R.id.tvFechaPartido);
            tvHoraPartido = itemView.findViewById(R.id.tvHoraPartido);
            tvLugarPartido = itemView.findViewById(R.id.tvLugarPartido);
        }
    }

    @NonNull
    @Override
    public PartidoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Crear tarjeta del partido
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_partido, parent, false);

        return new PartidoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PartidoViewHolder holder, int position) {

        // Obtener partido actual
        Partido partido = listaPartidos.get(position);

        // Mostrar datos en pantalla
        holder.tvNombrePartido.setText(partido.getNombreEvent());
        holder.tvFechaPartido.setText("Fecha: " + partido.getFechEvent());
        holder.tvHoraPartido.setText("Hora: " + partido.getHoraEvent());
        holder.tvLugarPartido.setText("Lugar: " + partido.getLocalizacionEvent());
    }

    @Override
    public int getItemCount() {
        return listaPartidos.size();
    }
}