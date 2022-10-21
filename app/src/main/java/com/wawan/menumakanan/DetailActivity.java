package com.wawan.menumakanan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    ImageView IVimageMenuMakanan;
    TextView tvNamaMenu, tvHargaMenu, tvSatuanMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        IVimageMenuMakanan = findViewById(R.id.iv_foto_makanan);
        tvNamaMenu = findViewById(R.id.tv_nama_makanan);
        tvHargaMenu = findViewById(R.id.tv_harga_makanan);
        tvSatuanMenu = findViewById(R.id.tv_satuan_makanan);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getStringExtra("namaMenu");
        setActionBarTitle(title);

        getExtra();
    }

    private void getExtra() {
        if(getIntent().hasExtra("gambarMenu") && getIntent().hasExtra("namaMenu") && getIntent().hasExtra("hargaMenu") && getIntent().hasExtra("satuanMenu")) {
            int gambarMenu = getIntent().getIntExtra("gambarMenu", R.drawable.menu1);
            String namaMenu = getIntent().getStringExtra("namaMenu");
            String hargaMenu = getIntent().getStringExtra("hargaMenu");
            String satuanMenu = getIntent().getStringExtra("satuanMenu");

            setData(gambarMenu, namaMenu, hargaMenu, satuanMenu);
        }
    }

    private void setData(int gambarMenu, String namaMenu, String hargaMenu, String satuanMenu) {
        IVimageMenuMakanan.setImageResource(gambarMenu);
        tvNamaMenu.setText(namaMenu);
        tvHargaMenu.setText(hargaMenu);
        tvSatuanMenu.setText(satuanMenu);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }
}