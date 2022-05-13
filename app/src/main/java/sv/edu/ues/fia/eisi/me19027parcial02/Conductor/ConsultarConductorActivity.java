package sv.edu.ues.fia.eisi.me19027parcial02.Conductor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.me19027parcial02.Clases.BDParcial;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Conductor;
import sv.edu.ues.fia.eisi.me19027parcial02.R;


public class ConsultarConductorActivity extends AppCompatActivity {
    BDParcial helper;
    EditText edilicencia;
    TextView edinombre,ediestado,editipolicencia,ediedad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_conductor);
        helper = new BDParcial(this);

        edilicencia = (EditText) findViewById(R.id.txtLicencia);
        edinombre= (TextView) findViewById(R.id.txtNombre);
        ediestado = (TextView) findViewById(R.id.txtEstado);
        editipolicencia = (TextView) findViewById(R.id.txtTipoLicencia);
        ediedad = (TextView) findViewById(R.id.txtEdad);

    }

    public void ConsultarUsuario(View view) {
        helper.abrir();
        Conductor conductor = helper.consultarConductor(edilicencia.getText().toString());
        helper.cerrar();
        if(conductor == null)
            Toast.makeText(this, "Conductor con licencia " +
                    edilicencia.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            edinombre.setText("Nombre: "+conductor.getNombre());
            ediestado.setText("Estado civil: "+conductor.getEstadoCivil());
            editipolicencia.setText("Licencia: "+conductor.getTipoLicencia());
            ediedad.setText(String.valueOf("Edad:"+conductor.getEdad()));
        }
    }
}