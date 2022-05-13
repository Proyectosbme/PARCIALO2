package sv.edu.ues.fia.eisi.me19027parcial02.Listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;

import sv.edu.ues.fia.eisi.me19027parcial02.Clases.BDParcial;
import sv.edu.ues.fia.eisi.me19027parcial02.Clases.Vehiculo;
import sv.edu.ues.fia.eisi.me19027parcial02.R;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {
    ListView listviewpersonas;
    ArrayList<String>listaInformacion;
    ArrayList<Vehiculo> listaVehiculo;
    BDParcial.DatabaseHelper DBHelper;
    EditText ediAniob;
    Integer aniob;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        DBHelper = new BDParcial.DatabaseHelper(getApplicationContext());
       //try {
        listviewpersonas = (ListView) findViewById(R.id.lv1);
        ediAniob = (EditText) findViewById(R.id.txtAnioB);
      // }
      // catch(Exception e){
       Toast.makeText(this,"Error/algun campo esta vacio" , Toast.LENGTH_SHORT).show();

      // }



    }

    public void consultarVehiculos() {
        SQLiteDatabase db=DBHelper.getReadableDatabase();
        Vehiculo vehiculo = null;
        listaVehiculo= new ArrayList<Vehiculo>();
        aniob=(Integer) Integer.valueOf(ediAniob.getText().toString());
        Cursor cursor = db.rawQuery("select * from vehiculo "+ "where anio ="+aniob, null);

          while (cursor.moveToNext()){
            Vehiculo vehiculo1 = new Vehiculo();
            vehiculo1.setPlaca(cursor.getString(0));
            vehiculo1.setPropietario(cursor.getString(1));
            vehiculo1.setMarca(cursor.getString(2));
            vehiculo1.setColor(cursor.getString(3));
            vehiculo1.setAnio(cursor.getInt(4));
            listaVehiculo.add(vehiculo1);
        }
        obtenerLista();

    }

    public void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        for (int i=0; i<listaVehiculo.size();i++){
            listaInformacion.add(
                    "Placa: "+listaVehiculo.get(i).getPlaca()+"\n"+
                    "Propietario: "+listaVehiculo.get(i).getPropietario()+"\n"+
                    "Marca: "+listaVehiculo.get(i).getMarca()+"\n"+
                    "Color: "+listaVehiculo.get(i).getColor()+"\n"+
                    "Año :"+listaVehiculo.get(i).getAnio());
        }

    }

    public void Vehiculo_por_anio(View view) {
            try{
            consultarVehiculos();
            ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaInformacion);
            if (listaInformacion.size()!=0){
            listviewpersonas.setAdapter(adapter);


            }else{
                Toast.makeText(this,"No hay vehiculos para el año "+aniob , Toast.LENGTH_SHORT).show();

            }
            }catch(Exception e){
              Toast.makeText(this,"Error/algun campo esta vacio" , Toast.LENGTH_SHORT).show();
              }


    }
}