package com.wawan.menumakanan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<MenuModel> modelArrayList = new ArrayList<>();
    RecyclerView recyclerView_menu;
    int mode;

    int gambarMenu[] = {
            R.drawable.menu1,
            R.drawable.menu2,
            R.drawable.menu3,
            R.drawable.menu4,
            R.drawable.menu5,
            R.drawable.menu6,
            R.drawable.menu7,
            R.drawable.menu8,
            R.drawable.menu9
    };

    String namaMenu[] = {
            "Pecel Lele",
            "Nasi Goreng Mercon",
            "Ayam Geprek Keju",
            "Kari Ayam",
            "Tahu Bulat",
            "Salad Buah",
            "Soto Sapi",
            "Bubur Ayam",
            "Bakso Sapi"
    };

    String hargaMenu[] = {
            "15000",
            "18000",
            "20000",
            "16000",
            "3000",
            "12000",
            "15000",
            "12000",
            "17000",
    };

    String satuanMenu[] = {
            "Cobek",
            "Piring",
            "Piring",
            "Mangkok",
            "Piring",
            "Mangkok",
            "Mangkok",
            "Mangkok",
            "Mangkok"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView_menu = findViewById(R.id.rv_menu);

        showRecyclerList();
    }

    private void baca_menu_makanan() {
        for(int i=0; i<namaMenu.length; i++) {
            modelArrayList.add(new MenuModel(
                    namaMenu[i],
                    hargaMenu[i],
                    satuanMenu[i],
                    gambarMenu[i]
            ));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_pilihan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.item1:
                showRecyclerList();
                break;
            case R.id.item2:
                showRecyclerGrid();
                break;
        }
        mode = selectedMode;
    }

    private void showRecyclerGrid() {
        baca_menu_makanan();

        MenuAdapterGrid menuAdapterGrid = new MenuAdapterGrid(modelArrayList, this);
        recyclerView_menu.setAdapter(menuAdapterGrid);
        recyclerView_menu.setLayoutManager(new GridLayoutManager(this, 2));
    }

    private void showRecyclerList() {
        baca_menu_makanan();

        MenuAdapter menuAdapter = new MenuAdapter(modelArrayList, this);
        recyclerView_menu.setAdapter(menuAdapter);
        recyclerView_menu.setLayoutManager(new LinearLayoutManager(this));
    }


}