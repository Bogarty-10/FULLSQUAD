package com.example.fullsquad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder> {

    private ArrayList<Jugador> listaJugadores;

    public JugadorAdapter(ArrayList<Jugador> listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    public static class JugadorViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreJugador;
        TextView tvInfoJugador;
        TextView tvCorreoJugador;

        public JugadorViewHolder(View itemView) {
            super(itemView);

            tvNombreJugador = itemView.findViewById(R.id.tvNombreJugador);
            tvInfoJugador = itemView.findViewById(R.id.tvInfoJugador);
            tvCorreoJugador = itemView.findViewById(R.id.tvCorreoJugador);
        }
    }

    @Override
    public JugadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tarjeta_jugador, parent, false);

        return new JugadorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JugadorViewHolder holder, int position) {

        Jugador jugador = listaJugadores.get(position);

        holder.tvNombreJugador.setText(jugador.getNombre());

        holder.tvInfoJugador.setText(
                "Dorsal: " + jugador.getDorsal() + " | " + jugador.getPosicion()
        );

        holder.tvCorreoJugador.setText(jugador.getCorreo());
    }

    @Override
    public int getItemCount() {
        return listaJugadores.size();
    }
}
