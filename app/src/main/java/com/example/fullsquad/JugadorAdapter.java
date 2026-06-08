package com.example.fullsquad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class JugadorAdapter extends RecyclerView.Adapter<JugadorAdapter.JugadorViewHolder> {

    private ArrayList<Jugador> listaJugadores;

    private DBHelper dbHelper;
    public JugadorAdapter(ArrayList<Jugador> listaJugadores, DBHelper dbHelper) {
        this.listaJugadores = listaJugadores;
        this.dbHelper = dbHelper;
    }



    public static class JugadorViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreJugador;
        TextView tvInfoJugador;
        TextView tvCorreoJugador;

        ImageButton btnEliminarJugador;

        public JugadorViewHolder(View itemView) {
            super(itemView);

            tvNombreJugador = itemView.findViewById(R.id.tvNombreJugador);
            tvInfoJugador = itemView.findViewById(R.id.tvInfoJugador);
            tvCorreoJugador = itemView.findViewById(R.id.tvCorreoJugador);

            btnEliminarJugador = itemView.findViewById(R.id.btnEliminarJugador);
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

        holder.btnEliminarJugador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int posicionActual = holder.getAdapterPosition();

                if (posicionActual != RecyclerView.NO_POSITION) {

                    Jugador jugadorEliminar = listaJugadores.get(posicionActual);

                    dbHelper.eliminarJugador(jugadorEliminar.getCorreo());

                    listaJugadores.remove(posicionActual);

                    notifyItemRemoved(posicionActual);

                    Toast.makeText(
                            view.getContext(),
                            "Jugador eliminado",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return listaJugadores.size();
    }
}
