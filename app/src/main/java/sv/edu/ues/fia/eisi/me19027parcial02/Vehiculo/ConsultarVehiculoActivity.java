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

public class ConsultarVehiculoActivity extends AppCompatActivity {

    BDParcial helper;
    EditText ediplaca,ediPropietario,ediMarca,edicolor,ediAnio;
    String propietario,color,marca,placa;
    Integer anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_vehiculo);
        helper = new BDParcial(this);
        ediPropietario= (EditText) findViewById(R.id.txtLicenciaPropietario);
        ediplaca=(EditText) findViewById(R.id.txtplaca);
        ediMarca=(EditText) findViewById(R.id.txtMarca) ;
        edicolor = (EditText) findViewById(R.id.txtColor);
        ediAnio = (EditText) findViewById(R.id.txtAnio);
    }

    public void Consultar_Vehiculo(View view) {
        helper.abrir();
        Vehiculo vehiculo = helper.consultar(ediplaca.getText().toString());
        helper.cerrar();
        if(vehiculo == null)
            Toast.makeText(this, "vehciculo con la  " +
                    ediplaca.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            ediplaca.setText("Placa: "+vehiculo.getPlaca());
            ediPropietario.setText("Propietario: "+vehiculo.getPropietario());
            ediMarca.setText("Marca: "+vehiculo.getMarca());
            edicolor.setText("Color: "+vehiculo.getColor());
            ediAnio.setText("AÑO: "+vehiculo.getAnio());

        }
    }
}