package sv.edu.ues.fia.eisi.me19027parcial02;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import sv.edu.ues.fia.eisi.me19027parcial02.Listview.ListViewActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Menu.MenuConductorActivity;
import sv.edu.ues.fia.eisi.me19027parcial02.Menu.MenuVehiculoActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Menu_Conductor(View view) {

        Intent intent = new Intent(MainActivity.this, MenuConductorActivity.class);
        startActivity(intent);
    }

    public void Menu_Vehiculos(View view) {
        Intent intent=new Intent(MainActivity.this, MenuVehiculoActivity.class);
        startActivity(intent);
    }

    public void Vista(View view) {
        Intent intent=new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    }
}