package sv.edu.ues.fia.eisi.me19027parcial02.Conductor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.me19027parcial02.Clases.BDParcial;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Conductor;
import sv.edu.ues.fia.eisi.me19027parcial02.R;


public class ActualizarConductorActivity extends AppCompatActivity {

    BDParcial helper;
    EditText ediLicencia,ediNombre,ediEstado,ediEdad,editipolicencia;
    String licencia,nombre,estado,tipoLicencia;
    Integer edad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_actualizar_conductor);
        helper = new BDParcial(this);
        ediLicencia = (EditText) findViewById(R.id.txtLicencia);
        ediNombre = (EditText) findViewById(R.id.txtNombre);
        ediEstado = (EditText) findViewById(R.id.txtEstado);
        ediEdad = (EditText) findViewById(R.id.txtEdad);
        editipolicencia = (EditText) findViewById(R.id.txtTipoLicencia);


    }

    public void Actualizar_Conductor(View view) {
        licencia = ediLicencia.getText().toString();
        nombre = ediNombre.getText().toString();
        estado = ediEstado.getText().toString();
        edad = (Integer) Integer.valueOf(ediEdad.getText().toString());
        tipoLicencia=editipolicencia.getText().toString();


        String regInsertados;
        Conductor conductor=new Conductor();
        conductor.setLicencia(licencia);
        conductor.setNombre(nombre);
        conductor.setEstadoCivil(estado);
        conductor.setTipoLicencia(tipoLicencia);
        conductor.setEdad(edad);

        helper.abrir();
        regInsertados=helper.actualizar(conductor);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }

}