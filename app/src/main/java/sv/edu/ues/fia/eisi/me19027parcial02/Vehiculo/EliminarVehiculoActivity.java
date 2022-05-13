package sv.edu.ues.fia.eisi.me19027parcial02.Vehiculo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.me19027parcial02.Clases.BDParcial;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Conductor;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Vehiculo;
import sv.edu.ues.fia.eisi.me19027parcial02.R;

public class EliminarVehiculoActivity extends AppCompatActivity {

    EditText edieliminarv;
    BDParcial controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_vehiculo);
        controlhelper=new BDParcial (this);
        edieliminarv=(EditText)findViewById(R.id.txtEeliplaca);
    }

    public void Eliminar_vehiculo(View view) {
        String regEliminadas;
        Vehiculo vehiculo=new Vehiculo();
        vehiculo.setPlaca(edieliminarv.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(vehiculo);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}