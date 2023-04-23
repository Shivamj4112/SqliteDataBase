package com.android.fragmentanddatabase.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.fragmentanddatabase.ModelClass.ModelClass;
import com.android.fragmentanddatabase.R;

import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.Viewholder> {

    List<ModelClass> list;
    public DatabaseAdapter(List<ModelClass> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DatabaseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrievelayout,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseAdapter.Viewholder holder, int position) {

        holder.Name.setText(list.get(position).getName());
        holder.Age.setText(list.get(position).getAge());
        holder.Mobile.setText(list.get(position).getMobile());
        holder.Email.setText(list.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView Name,Age,Mobile,Email;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.txtLayoutName);
            Age = itemView.findViewById(R.id.txtLayoutAge);
            Mobile = itemView.findViewById(R.id.txtLayoutMobile);
            Email = itemView.findViewById(R.id.txtLayoutEmail);
        }
    }
}
