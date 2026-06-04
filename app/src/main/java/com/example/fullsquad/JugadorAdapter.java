package com.example.fullsquad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder> {

    // Lista recibida desde SQLite
    private ArrayList<Jugador> listaJugadores;

    public JugadorAdapter(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    // Referencias de la tarjeta
    public static class JugadorViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreJugador;
        TextView tvInfoJugador;
        TextView tvCorreoJugador;

        public JugadorViewHolder(View itemView) {
            super(itemView);

            // Vincular elementos XML
            tvNombreJugador = itemView.findViewById(R.id.tvNombreJugador);
            tvInfoJugador = itemView.findViewById(R.id.tvInfoJugador);
            tvCorreoJugador = itemView.findViewById(R.id.tvCorreoJugador);
        }
    }

    @Override
    public JugadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Crear tarjeta jugador
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_jugador, parent, false);

        return new JugadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JugadorViewHolder holder, int position) {

        // Obtener jugador actual
        Jugador jugador = listaJugadores.get(position);

        // Mostrar nombre
        holder.tvNombreJugador.setText(jugador.getNombre());

        // Mostrar dorsal y posición
        holder.tvInfoJugador.setText(
                "Dorsal: " + jugador.getDoral() +
                        " | " +
                        jugador.getPosiscion()
        );

        // Mostrar correo
        holder.tvCorreoJugador.setText(
                jugador.getCorreo()
        );
    }

    @Override
    public int getItemCount() {

        // Número de jugadores
        return listaJugadores.size();
    }
}
