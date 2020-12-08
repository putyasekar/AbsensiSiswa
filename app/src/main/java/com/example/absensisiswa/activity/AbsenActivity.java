package com.example.absensisiswa.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.absensisiswa.R;
import com.example.absensisiswa.model.PersonItem;
import com.example.absensisiswa.remote.APIUtils;
import com.example.absensisiswa.remote.AbsenService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbsenActivity extends AppCompatActivity {

    AbsenService absenService;
    EditText edtNama, edtKelas, edtPelajaran, edtKeteranganMasuk, edtTanggal, edtId;
    Button btnSave, btnDel;
    TextView txtId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNama = findViewById(R.id.edt_name);
        edtKelas = findViewById(R.id.edt_class);
        edtPelajaran = findViewById(R.id.edt_pelajaran);
        edtKeteranganMasuk = findViewById(R.id.edt_keterangan);
        edtTanggal = findViewById(R.id.edt_tanggal);
        btnSave = findViewById(R.id.btn_save);
        btnDel = findViewById(R.id.btn_delete);
        edtId = findViewById(R.id.edt_id);
        txtId = findViewById(R.id.txt_id);

        absenService = APIUtils.getAbsenService();

        Bundle extras = getIntent().getExtras();
        String absenNama = extras.getString("nama");
        String absenKelas = extras.getString("kelas");
        String absenPelajaran = extras.getString("pelajaran");
        String absenKeteranganMasuk = extras.getString("keterangan_masuk");
        String absenTanggal = extras.getString("tanggal");

        final String absenID = extras.getString("id");

        edtId.setText(absenID);
        edtNama.setText(absenNama);
        edtKelas.setText(absenKelas);
        edtPelajaran.setText(absenPelajaran);
        edtKeteranganMasuk.setText(absenKeteranganMasuk);
        edtTanggal.setText(absenTanggal);

        if (absenID != null && absenID.trim().length() > 0) {
            edtId.setFocusable(false);
        } else {
            txtId.setVisibility(View.INVISIBLE);
            edtId.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nama = edtNama.getText().toString();
                String kelas = edtKelas.getText().toString();
                String pelajaran = edtPelajaran.getText().toString();
                String keterangan_masuk = edtKeteranganMasuk.getText().toString();
                String tanggal = edtTanggal.getText().toString();

                if (absenID != null && absenID.trim().length() > 0) {
                    updateAbsen(Integer.parseInt(absenKelas), nama, kelas, pelajaran, keterangan_masuk, tanggal);
                } else {
                    addAbsen(nama, kelas, pelajaran, keterangan_masuk, tanggal);
                }
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAbsen(Integer.parseInt(absenID));
                Intent intent = new Intent(AbsenActivity.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addAbsen(String nama, String kelas, String pelajaran, String keterangan_masuk, String tanggal) {
        Call<PersonItem> call = absenService.addAbsen(nama, kelas, pelajaran, keterangan_masuk, tanggal);
        call.enqueue(new Callback<PersonItem>() {
            @Override
            public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AbsenActivity.this, "User added succesfully",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AbsenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PersonItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void updateAbsen(int id, String nama, String kelas, String pelajaran, String keterangan_masuk, String tanggal) {
        Call<PersonItem> call = absenService.updateAbsen(id, nama, kelas, pelajaran, keterangan_masuk, tanggal);
        call.enqueue(new Callback<PersonItem>() {
            @Override
            public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AbsenActivity.this, "User Updated", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AbsenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PersonItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void deleteAbsen(int id) {
        Call<PersonItem> call = absenService.deleteAbsen(id);
        call.enqueue(new Callback<PersonItem>() {
            @Override
            public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(AbsenActivity.this, "User deleted",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AbsenActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<PersonItem> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}