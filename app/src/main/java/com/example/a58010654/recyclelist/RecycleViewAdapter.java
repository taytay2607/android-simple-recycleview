package com.example.a58010654.recyclelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private List<User> userList;
    private Context context;
    private ClickListener clickListener;

    public RecycleViewAdapter(List<User> userList, Context context, ClickListener clickListener) {
        this.userList = userList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.user_card,null);
        return  new ViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        User user = userList.get(i);

        viewHolder.imageView1.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        viewHolder.imageView2.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_foreground));
        viewHolder.textView1.setText(user.getName());
        viewHolder.textView2.setText(user.getId());
        viewHolder.textView3.setText(user.getAge());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener{

        ImageView imageView1,imageView2;
        TextView textView1,textView2,textView3;
        WeakReference<ClickListener> listenerRef;

        public ViewHolder(@NonNull View itemView, ClickListener listener) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.imageView);
            imageView2 = itemView.findViewById(R.id.button);
            textView1 = itemView.findViewById(R.id.text1);
            textView2 = itemView.findViewById(R.id.text2);
            textView3 = itemView.findViewById(R.id.text3);

            listenerRef = new WeakReference<>(listener);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            imageView2.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.button){
                listenerRef.get().onPositionMenuClick(getAdapterPosition());
            }else{
                listenerRef.get().onPositionClicked(getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            listenerRef.get().onLongClicked(getAdapterPosition());
            return true;
        }
    }
}
