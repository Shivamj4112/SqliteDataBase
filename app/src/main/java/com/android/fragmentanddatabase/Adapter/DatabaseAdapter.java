package com.android.fragmentanddatabase.Adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.fragmentanddatabase.Activity.MainActivity;
import com.android.fragmentanddatabase.Database.Database;
import com.android.fragmentanddatabase.ModelClass.ModelClass;
import com.android.fragmentanddatabase.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter extends RecyclerView.Adapter<DatabaseAdapter.Viewholder> {

    Activity activity;
    List<ModelClass> list;
    Database database;

    public DatabaseAdapter(Activity activity , List<ModelClass> list) {
        this.list = list;
        this.activity = activity;
    }

    @NonNull
    @Override
    public DatabaseAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.retrievelayout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DatabaseAdapter.Viewholder holder, @SuppressLint("RecyclerView") int position) {

        holder.Name.setText(list.get(position).getName());
        holder.Age.setText(list.get(position).getAge());
        holder.Mobile.setText(list.get(position).getMobile());
        holder.Email.setText(list.get(position).getEmail());

        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.update_dialog);

                MaterialButton update = dialog.findViewById(R.id.update);
                MaterialButton cancel = dialog.findViewById(R.id.cancel_update);

                TextView id = dialog.findViewById(R.id.id);
                id.setText(list.get(position).getId()+"");

                EditText name = dialog.findViewById(R.id.name);
                EditText age = dialog.findViewById(R.id.age);
                EditText mobile = dialog.findViewById(R.id.mobile);
                EditText email = dialog.findViewById(R.id.email);
                

                name.setText(list.get(position).getName());
                age.setText(list.get(position).getAge());
                mobile.setText(list.get(position).getMobile());
                email.setText(list.get(position).getEmail());

                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        database = new Database(activity);

//                        List<Database1_Model> list = database.RetriveData();

                        String Name = name.getText().toString();
                        String Age = age.getText().toString();
                        String Mobile = mobile.getText().toString();
                        String Email = email.getText().toString();

                        database.Update(list.get(position).getId(),Name , Age, Mobile, Email);
                        dialog.dismiss();

                        MainActivity.Retrieve(activity);

                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        dialog.dismiss();
                        Toast.makeText(activity, "cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                dialog.show();
            }
        });



        holder.Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = new Database(activity);
                database.Delete(list.get(position).getId());
                MainActivity.Retrieve(activity);
                Toast.makeText(view.getContext(), "Data Deleted", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {

        TextView Name, Age, Mobile, Email;
        ImageView Edit, Delete;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.txtLayoutName);
            Age = itemView.findViewById(R.id.txtLayoutAge);
            Mobile = itemView.findViewById(R.id.txtLayoutMobile);
            Email = itemView.findViewById(R.id.txtLayoutEmail);

            Edit = itemView.findViewById(R.id.imgEdit);
            Delete = itemView.findViewById(R.id.imgDelete);

        }
    }
}
