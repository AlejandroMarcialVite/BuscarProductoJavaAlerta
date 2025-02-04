package com.example.buscarproductojavaalerta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText editTextProducto, txtNombre;
    private Spinner spinnerCategoria;
    private Button buttonBuscar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos del XML
        editTextProducto = findViewById(R.id.edit_producto);
        spinnerCategoria = findViewById(R.id.spinner_categoria);
        buttonBuscar = findViewById(R.id.button_buscar);
        txtNombre = findViewById(R.id.txtTexTex); // Nuevo campo de nombre adicional

        // Configurar Spinner con categorías
        String[] categorias = {"Electronica", "Ropa", "Hogar"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, categorias);
        spinnerCategoria.setAdapter(adapter);

        // Acción del botón Buscar
        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String producto = editTextProducto.getText().toString();
                String categoria = spinnerCategoria.getSelectedItem().toString();
                String nombre = txtNombre.getText().toString(); // Captura el nombre adicional

                // Mostrar mensaje con el nombre capturado
                Toast.makeText(MainActivity.this,
                        "Nombre: " + nombre + "\nProducto: " + producto + "\nCategoría: " + categoria,
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
