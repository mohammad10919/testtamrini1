package ir.mohammad.testtamrini.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ir.mohammad.testtamrini.R;
import ir.mohammad.testtamrini.model.Fiilteer;

public class FiilteerAdapter extends RecyclerView.Adapter<FiilteerAdapter.fiilteerViewHolder> {
    List<Fiilteer> fiilteer;

    public FiilteerAdapter(List<Fiilteer> fiilteer) {
        this.fiilteer = fiilteer;
    }

    @NonNull
    @Override
    public fiilteerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.fiilteerlayout,parent,false);
        return new fiilteerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull fiilteerViewHolder holder, int position) {
        holder.fiilteerbutton.setText(fiilteer.get(position).getFiilteerbutton());
    }

    @Override
    public int getItemCount() {
        return fiilteer.size();
    }

    public class fiilteerViewHolder extends RecyclerView.ViewHolder {

        Button fiilteerbutton;
        public fiilteerViewHolder(@NonNull View itemView) {
            super(itemView);
            fiilteerbutton=(Button)itemView.findViewById(R.id.fiilterbutton);
        }
    }
}
