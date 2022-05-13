package sv.edu.ues.fia.eisi.me19027parcial02.Menu;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sv.edu.ues.fia.eisi.me19027parcial02.Conductor.EliminarConductorActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.R;
import sv.edu.ues.fia.eisi.me19027parcial02.Vehiculo.ActualizarVehiculoActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Vehiculo.ConsultarVehiculoActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Vehiculo.EliminarVehiculoActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Vehiculo.InsertarVehiculoActivity;


public class MenuVehiculoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_vehiculo);
    }

    public void Inserta_Vehiculo(View view) {
        Intent intent = new Intent(MenuVehiculoActivity.this, InsertarVehiculoActivity.class);
        startActivity(intent);
    }

    public void Actualizar_Vehiculo(View view) {
        Intent intent = new Intent(MenuVehiculoActivity.this, ActualizarVehiculoActivity.class);
        startActivity(intent);
    }

    public void Consultar_Vehiculo(View view) {
        Intent intent = new Intent(MenuVehiculoActivity.this, ConsultarVehiculoActivity.class);
        startActivity(intent);
    }

    public void Eliminar_Vehiculo(View view) {
        Intent intent = new Intent(MenuVehiculoActivity.this, EliminarVehiculoActivity.class);
        startActivity(intent);
    }
}