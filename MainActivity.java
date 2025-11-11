package com.example.exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] arreglo1 = {"uno", "dos", "tres"};
    String[] arreglo2 = {"MenuPuntos", "Otro", "Otro 2"};
    int[] listaimagenes = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        listview = findViewById(R.id.vistita);
        listview.setOnItemClickListener(this);

        Adaptador adaptador = new Adaptador(MainActivity.this, arreglo1, arreglo2, listaimagenes);
        listview.setAdapter(adaptador);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0){
            startActivity(new Intent(this, MenuPuntos.class));
        }
        Toast.makeText(this, String.valueOf(position), Toast.LENGTH_SHORT).show();
    }
}