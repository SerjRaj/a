package com.example.exam;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MenuPuntos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_puntos);

        // Cargar fragmento inicial
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new Inicio(), "INICIO")
                    .commit();
        }

        // Botón "SIGUIENTE" → Fragmento1
        Button btn = findViewById(R.id.btnSiguiente);
        btn.setOnClickListener(v -> {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, new Fragmento1(), "FRAG1");
            transaction.addToBackStack(null);
            transaction.commit();
        });
    }

    // Inflar el menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return true;
    }

    // Acción del ítem “Texto” → Fragmento2
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.item1) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, new Fragmento2(), "FRAG2");
            transaction.addToBackStack(null);
            transaction.commit();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}