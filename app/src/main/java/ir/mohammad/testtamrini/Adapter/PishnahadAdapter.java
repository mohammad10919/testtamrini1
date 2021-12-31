package ir.mohammad.testtamrini.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mohammad.testtamrini.R;
import ir.mohammad.testtamrini.model.Pishnahad;

public class PishnahadAdapter extends RecyclerView.Adapter<PishnahadAdapter.pishnahadViewHolder>{
    List<Pishnahad>pishnahad;

    public PishnahadAdapter(List<Pishnahad> pishnahad) {
        this.pishnahad = pishnahad;
    }

    @NonNull
    @Override
    public pishnahadViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.piashnahadlayout,parent,false);
        return new pishnahadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull pishnahadViewHolder holder, int position) {

        holder.price.setText(pishnahad.get(position).getPrice());
        holder.place.setText(pishnahad.get(position).getPlace());
        Picasso.get().load(pishnahad.get(position).getImagepishnahad()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return pishnahad.size();
    }

    public class pishnahadViewHolder extends RecyclerView.ViewHolder {

        TextView price;
        TextView place;
        ImageView imageView;
        public pishnahadViewHolder(@NonNull View itemView) {
            super(itemView);
            price=(TextView)itemView.findViewById(R.id.pricepishnahad);
            place= (TextView)itemView.findViewById(R.id.placepishnahad);
            imageView=(ImageView)itemView.findViewById(R.id.imagepishnahad);

        }
    }

}
