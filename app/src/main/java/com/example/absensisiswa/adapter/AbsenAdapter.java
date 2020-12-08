package com.example.absensisiswa.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.absensisiswa.R;
import com.example.absensisiswa.activity.AbsenActivity;
import com.example.absensisiswa.model.PersonItem;

import java.util.List;

public class AbsenAdapter extends ArrayAdapter<PersonItem> {
    private final Context context;
    private final List<PersonItem> personItem;

    public AbsenAdapter(@NonNull Context context,
                        int resource,
                        @NonNull List<PersonItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.personItem = objects;
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context
                .LAYOUT_INFLATER_SERVICE);
        @SuppressLint("ViewHolder") View v = inflater.inflate(R.layout.list_item, parent, false);

        TextView txtIdAbsen = v.findViewById(R.id.tv_absen_id);
        TextView txtNamaAbsen = v.findViewById(R.id.tv_absen_name);
        TextView txtKelasAbsen = v.findViewById(R.id.tv_absen_kelas);
        TextView txtPelajaranAbsen = v.findViewById(R.id.tv_absen_pelajaran);
        TextView txtKeterangan = v.findViewById(R.id.tv_absen_keterangan_masuk);
        TextView txtTanggal = v.findViewById(R.id.tv_absen_tanggal);

        txtIdAbsen.setText(String.valueOf(personItem.get(position).getId()));
        txtNamaAbsen.setText(String.valueOf(personItem.get(position).getNama()));
        txtKelasAbsen.setText(String.valueOf(personItem.get(position).getKelas()));
        txtPelajaranAbsen.setText(String.valueOf(personItem.get(position).getPelajaran()));
        txtKeterangan.setText(String.valueOf(personItem.get(position).getKeterangan_masuk()));
        txtTanggal.setText(String.valueOf(personItem.get(position).getTanggal()));

        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AbsenActivity.class);
                intent.putExtra("id", String.valueOf(personItem.get(position).getId()));
                intent.putExtra("nama", personItem.get(position).getNama());
                intent.putExtra("kelas", personItem.get(position).getKelas());
                intent.putExtra("pelajaran", personItem.get(position).getPelajaran());
                intent.putExtra("keterangan_masuk", personItem.get(position).getKeterangan_masuk());
                intent.putExtra("tanggal", personItem.get(position).getTanggal());
                context.startActivity(intent);
            }
        });

        return v;
    }
}
