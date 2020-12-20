package com.example.appvoiceacting.View;

import android.graphics.Bitmap;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.example.appvoiceacting.Model.Actor;
import com.example.appvoiceacting.R;
import androidx.annotation.NonNull;
import android.widget.ImageView;
import java.util.ArrayList;
import android.view.ViewGroup;
 import android.widget.TextView;
import android.graphics.BitmapFactory;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ActorViewHolder>
        implements View.OnClickListener {
    private ArrayList<Actor> items;
    private View.OnClickListener listener;

    // Clase interna:
    // Se implementa el ViewHolder que se encargará
    // de almacenar la vista del elemento y sus datos
    public static class ActorViewHolder
            extends RecyclerView.ViewHolder {
        private ImageView ImageView_id;
        private TextView TextView_id;

        private TextView TextView_email;
        private TextView TextView_nombre;

        public ActorViewHolder(View itemView) {
            super(itemView);
            TextView_id = (TextView) itemView.findViewById(R.id.firstName);
            TextView_nombre = (TextView) itemView.findViewById(R.id.firstName);
            TextView_email = (TextView) itemView.findViewById(R.id.email);
            ImageView_id=(ImageView) itemView.findViewById(R.id.photo);
        }

        public void ActorBind(Actor item) {
            byte[] decodedString = Base64.decode(item.getImage(), Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            ImageView_id.setImageBitmap(decodedByte);
            TextView_id.setText(item.getId());
            TextView_email.setText(item.getEmail());
            TextView_nombre.setText(item.getName());
        }
    }

    // Contruye el objeto adaptador recibiendo la lista de datos
    public ActorAdapter(@NonNull ArrayList<Actor> items) {
        this.items = items;
    }

    // Se encarga de crear los nuevos objetos ViewHolder necesarios
    // para los elementos de la colección.
    // Infla la vista del layout, crea y devuelve el objeto ViewHolder
    @Override
    public ActorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        row.setOnClickListener(this);

        ActorViewHolder avh = new ActorViewHolder(row);
        return avh;
    }

    // Se encarga de actualizar los datos de un ViewHolder ya existente.
    @Override
    public void onBindViewHolder(ActorViewHolder viewHolder, int position) {
        Actor item = items.get(position);
        viewHolder.ActorBind(item);
    }

    // Indica el número de elementos de la colección de datos.
    @Override
    public int getItemCount() {
        return items.size();
    }

    // Asigna un listener al elemento
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }

}
