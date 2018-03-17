package com.example.adsi.adoptadog.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adsi.adoptadog.R;
import com.example.adsi.adoptadog.models.Perros;
import com.example.adsi.adoptadog.perrosActivity;

import java.util.ArrayList;

/**
 * Created by ADSI on 8/03/2018.
 */

public class perrosAdapter  extends RecyclerView.Adapter<perrosAdapter.perrosViewHolder> {

    private ArrayList<Perros> perros;
    private int resource;
    private Activity activity;

    public perrosAdapter(ArrayList<Perros> perros, int resource, Activity activity) {
        this.perros = perros;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public perrosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new perrosViewHolder(view);
    }

    @Override
    public void onBindViewHolder(perrosViewHolder holder, int position) {
        Perros perro = perros.get(position);
        holder.perrosCard.setImageResource(perros.get(position).getPerrosImage());
        holder.nombreCard.setText(perro.getNombre());
        holder.edadCard.setText(perro.getEdad());
        holder.razaCard.setText(perro.getRaza());
        holder.tipoCard.setText(perro.getTipo());
    }

    @Override
    public int getItemCount() {
        return perros.size();
    }

    public class perrosViewHolder extends RecyclerView.ViewHolder{

        private ImageView perrosCard;
        private TextView nombreCard;
        private TextView edadCard;
        private TextView razaCard;
        private TextView tipoCard;

        public perrosViewHolder(View itemView) {
            super(itemView);

            perrosCard = (ImageView) itemView.findViewById(R.id.idimagen);
            nombreCard = (TextView) itemView.findViewById(R.id.idnombre);
            edadCard   = (TextView) itemView.findViewById(R.id.idedad);
            razaCard   = (TextView) itemView.findViewById(R.id.idraza);
            tipoCard   = (TextView) itemView.findViewById(R.id.idtipo);

        }
    }
}
