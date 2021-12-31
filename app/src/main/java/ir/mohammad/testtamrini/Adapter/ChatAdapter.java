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
import ir.mohammad.testtamrini.model.Chatmodel;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.chatViewHolder> {
    List<Chatmodel> chat;

    public ChatAdapter(List<Chatmodel> chat) {
        this.chat = chat;
    }

    @NonNull
    @Override
    public chatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.chatlayout,parent,false);
        return new chatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull chatViewHolder holder, int position) {
        holder.textchat.setText(chat.get(position).getTextchat());
        Picasso.get().load(chat.get(position).getImagechat()).into(holder.imagechat);

    }

    @Override
    public int getItemCount() {
        return chat.size();
    }

    public class chatViewHolder extends RecyclerView.ViewHolder {

        TextView textchat;
        ImageView imagechat;

        public chatViewHolder(@NonNull View itemView) {
            super(itemView);
            textchat=(TextView)itemView.findViewById(R.id.textchat);
            imagechat=(ImageView)itemView.findViewById(R.id.imagechat);
        }
    }
}
