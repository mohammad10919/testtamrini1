package ir.mohammad.testtamrini.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ir.mohammad.testtamrini.model.HomeModel;
import ir.mohammad.testtamrini.R;
import ir.mohammad.testtamrini.model.HomeUrl;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.homeViewHolder>{

    List<HomeUrl> homeUrlsmodel;
    Context mcontex;

    public HomeAdapter(List<HomeUrl> homeUrlsmodel) {
        this.homeUrlsmodel = homeUrlsmodel;
    }

    @NonNull
    @Override
    public homeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.homeurllayout,parent,false);
        return new homeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull homeViewHolder holder, int position) {
        holder.texttitlee.setText(homeUrlsmodel.get(position).getTitle());
        holder.texttozihh.setText(homeUrlsmodel.get(position).getTozih());
        holder.textpricee.setText(homeUrlsmodel.get(position).getPrice());
        holder.textdataa.setText(homeUrlsmodel.get(position).getData());
        Picasso.get().load(homeUrlsmodel.get(position).getImageurl()).into(holder.imagehomeurll);

    }

    @Override
    public int getItemCount() {
        return homeUrlsmodel.size();
    }

    public class homeViewHolder extends RecyclerView.ViewHolder {
        TextView texttitlee;
        TextView texttozihh;
        TextView textpricee;
        TextView textdataa;
        ImageView imagehomeurll;

        public homeViewHolder(@NonNull View itemView) {
            super(itemView);
            texttitlee=(TextView)itemView.findViewById(R.id.texttitle);
            texttozihh=(TextView)itemView.findViewById(R.id.texttozih);
            textpricee=(TextView)itemView.findViewById(R.id.textprice);
            textdataa=(TextView)itemView.findViewById(R.id.textdate);
            imagehomeurll=(ImageView)itemView.findViewById(R.id.imageurl);

        }
    }
}
