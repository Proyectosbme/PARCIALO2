package sv.edu.ues.fia.eisi.me19027parcial02.Vehiculo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.ues.fia.eisi.me19027parcial02.Clases.BDParcial;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Vehiculo;
import sv.edu.ues.fia.eisi.me19027parcial02.R;

public class InsertarVehiculoActivity extends AppCompatActivity {

    BDParcial helper;
    EditText ediplaca,ediPropietario,ediMarca,edicolor,ediAnio;
    String propietario,color,marca,placa;
    Integer anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar_vehiculo);
        helper = new BDParcial(this);
        ediPropietario= (EditText) findViewById(R.id.txtLicenciaPropietario);
        ediplaca=(EditText) findViewById(R.id.txtplaca);
        ediMarca=(EditText) findViewById(R.id.txtMarca) ;
        edicolor = (EditText) findViewById(R.id.txtColor);
        ediAnio = (EditText) findViewById(R.id.txtAnio);

    }

    public void Registrar_Vehiculo(View view) {
        propietario= ediPropietario.getText().toString();
        placa=ediplaca.getText().toString();
        marca=ediMarca.getText().toString();
        color=edicolor.getText().toString();
        anio = (Integer) Integer.valueOf(ediAnio.getText().toString());

        String regInsertados;
        Vehiculo vehiculo=new Vehiculo();

        vehiculo.setPropietario(propietario);
        vehiculo.setPlaca(placa);
        vehiculo.setMarca(marca);
        vehiculo.setColor(color);
        vehiculo.setAnio(anio);

        helper.abrir();
        regInsertados=helper.insertar(vehiculo);
        helper.cerrar();
        Toast.makeText(this, regInsertados, Toast.LENGTH_SHORT).show();
    }
}