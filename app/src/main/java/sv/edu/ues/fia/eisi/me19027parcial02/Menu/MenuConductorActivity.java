package sv.edu.ues.fia.eisi.me19027parcial02.Menu;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sv.edu.ues.fia.eisi.me19027parcial02.Conductor.ActualizarConductorActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Conductor.ConsultarConductorActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Conductor.EliminarConductorActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Conductor.InsertarConductorActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.R;


public class MenuConductorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_conductor);
    }

    public void Inserta_Conductor(View view) {
        Intent intent = new Intent(MenuConductorActivity.this, InsertarConductorActivity.class);
        startActivity(intent);
    }

    public void Consultar_Conductor(View view) {
        Intent intent = new Intent(MenuConductorActivity.this, ConsultarConductorActivity.class);
        startActivity(intent);
    }

    public void Eliminar_Conductor(View view) {
        Intent intent = new Intent(MenuConductorActivity.this, EliminarConductorActivity.class);
        startActivity(intent);
    }

    public void Actualizar_Conductor2(View view) {
        Intent intent = new Intent(MenuConductorActivity.this, ActualizarConductorActivity.class);
        startActivity(intent);
    }
}