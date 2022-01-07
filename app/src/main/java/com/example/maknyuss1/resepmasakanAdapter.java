package com.example.maknyuss1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class resepmasakanAdapter extends RecyclerView.Adapter<resepmasakanAdapter.ViewHolder> {


    public resepmasakanAdapter(ArrayList<daftarresep> listresep) {
        this.listresep = listresep;
    }

    private ArrayList<daftarresep> listresep;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater =  LayoutInflater.from(context);
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.listitem,parent,false));

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull resepmasakanAdapter.ViewHolder holder, int position) {
        daftarresep daftarresep = listresep.get(position);
        holder.id.setText(daftarresep.getId());
        holder.nama.setText(daftarresep.getNama());

        holder.gambar.setImageResource(daftarresep.getId_gambar());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Context context = holder.itemView.getContext();
                    Intent intent = new Intent(context, detailmakanan.class);
                    intent.putExtra("idresep", daftarresep.getId());
                    intent.putExtra("namaresep", daftarresep.getNama());
                    intent.putExtra("keteranganresep", daftarresep.getKeterangan());
                    intent.putExtra("gambarresep", daftarresep.getId_gambar());
                    intent.putExtra("gambarresep2", daftarresep.getGambarresep());

                    context.startActivity(intent);

                } catch (Exception e) {
                    Toast.makeText(view.getContext(), "gagal", Toast.LENGTH_SHORT);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listresep.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id, nama;
        public ImageView gambar ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            nama = (TextView) itemView.findViewById(R.id.nama);
            gambar = (ImageView) itemView.findViewById(R.id.gambar);

        }
    }
}
