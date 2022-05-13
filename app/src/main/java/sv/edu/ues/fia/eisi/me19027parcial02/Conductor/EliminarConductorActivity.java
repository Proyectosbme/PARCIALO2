package sv.edu.ues.fia.eisi.me19027parcial02.Conductor;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.me19027parcial02.Clases.BDParcial;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Conductor;
import sv.edu.ues.fia.eisi.me19027parcial02.R;

public class EliminarConductorActivity extends AppCompatActivity {

    EditText editCarne;
    BDParcial controlhelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eliminar_conductor);
        controlhelper=new BDParcial (this);
        editCarne=(EditText)findViewById(R.id.txtEliminarLicencia);
    }

    public void Eliminar_conductor(View view) {
        String regEliminadas;
        Conductor conductor=new Conductor();
        conductor.setLicencia(editCarne.getText().toString());
        controlhelper.abrir();
        regEliminadas=controlhelper.eliminar(conductor);
        controlhelper.cerrar();
        Toast.makeText(this, regEliminadas, Toast.LENGTH_SHORT).show();
    }
}
