package sv.edu.ues.fia.eisi.me19027parcial02.Clases;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDParcial {

    private static final String[]camposConductor = new String []{"licencia","nombre","estado","tipolicencia","edad"};
    private static final String[]camposVehiculo = new String [] {"idplaca","propietario","marca","color","anio"};

    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;
    public BDParcial(Context ctx) {this.context = ctx; DBHelper = new DatabaseHelper(context); }

    public static class DatabaseHelper extends SQLiteOpenHelper {
        private static final String BASE_DATOS = "parcial02.s3db";
        private static final int VERSION = 1;
        public DatabaseHelper(Context context) {
            super(context, BASE_DATOS, null, VERSION);
        }



        @Override
        public void onCreate(SQLiteDatabase db) {
            try{
                db.execSQL("CREATE TABLE vehiculo" +"(idplaca VARCHAR(30) NOT NULL PRIMARY KEY," +"propietario VARCHAR(12)," +"marca VARCHAR(30)," +"color VARCHAR(25)," +"anio Integer);");

                db.execSQL("CREATE TABLE conductor" +"(licencia VARCHAR(12) NOT NULL PRIMARY KEY, " +"nombre VARCHAR(30), " +"estado VARCHAR(30)," +"tipoLicencia VARCHAR(25)," +"edad Integer);");

            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }
    public void abrir() throws SQLException{
        db = DBHelper.getWritableDatabase();
        return;
    }
    public void cerrar(){
        DBHelper.close();
    }

    public String insertar(Conductor conductor){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        ContentValues cond = new ContentValues();
        cond.put("licencia",conductor.getlicencia());
        cond.put("nombre",conductor.getNombre());
        cond.put("estado",conductor.getEstadoCivil());
        cond.put("tipolicencia", conductor.getTipoLicencia());
        cond.put("edad",conductor.getEdad());;



        contador=db.insert("conductor", null, cond);
        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }


    public String actualizar(Conductor conductor){
        if(verificarIntegridad(conductor, 5)){
            String[] id = {conductor.getlicencia()};
            ContentValues cond = new ContentValues();
            cond.put("nombre",conductor.getNombre());
            cond.put("edad",conductor.getEdad());
            cond.put("estado",conductor.getEstadoCivil());
            cond.put("tipolicencia", conductor.getTipoLicencia());
            db.update("conductor", cond, "licencia = ?", id);
            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con carnet " + conductor.getlicencia() + " no existe";
        }
    }


    public Conductor consultarConductor(String licencia){

        String[] id = {licencia};
        Cursor cursor = db.query("conductor", camposConductor, "licencia = ?",
                id, null, null, null,null);
        if(cursor.moveToFirst()){
            Conductor conductor = new Conductor();

            conductor.setLicencia(cursor.getString(0));
            conductor.setNombre(cursor.getString(1));
            conductor.setEstadoCivil(cursor.getString(2));
            conductor.setTipoLicencia(cursor.getString(3));
            conductor.setEdad(cursor.getInt(4));
            return conductor;
        }else{
            return null;
        }
    }


    public String eliminar(Conductor conductor){
        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="licencia='"+conductor.getlicencia()+"'";
        contador+=db.delete("conductor", where, null);
        regAfectados+=contador;
        return regAfectados;}

    public String insertar(Vehiculo vehiculo){
        String regInsertados="Registro Insertado Nº= ";
        long contador=0;
        if(verificarIntegridad(vehiculo,1))
        {

        ContentValues cond = new ContentValues();
        cond.put("idplaca",vehiculo.getPlaca());
        cond.put("propietario",vehiculo.getPropietario());
        cond.put("marca",vehiculo.getMarca());
        cond.put("color",vehiculo.getColor());
        cond.put("anio",vehiculo.getAnio());

        contador=db.insert("vehiculo", null, cond);
        }

        if(contador==-1 || contador==0)
        {
            regInsertados= "Error al Insertar el registro, Registro Duplicado. Verificar inserción";
        }
        else {
            regInsertados=regInsertados+contador;
        }
        return regInsertados;
    }
    public String actualizar(Vehiculo vehiculo){
        if(verificarIntegridad(vehiculo, 4)){
            String[] id = {vehiculo.getPlaca()};
            ContentValues cond = new ContentValues();
            cond.put("idplaca",vehiculo.getPlaca());
            cond.put("propietario",vehiculo.getPropietario());
            cond.put("marca",vehiculo.getMarca());
            cond.put("color", vehiculo.getColor());
            cond.put("anio", vehiculo.getAnio());
            db.update("vehiculo", cond, "idplaca = ?", id);

            return "Registro Actualizado Correctamente";
        }else{
            return "Registro con carnet " + vehiculo.getPlaca() + " no existe";
        }
    }
    public Vehiculo consultar(String idplaca){
        String[] id = {idplaca};
        Cursor cursor = db.query("vehiculo", camposVehiculo, "idplaca = ?",
                id, null, null, null,null);
        if(cursor.moveToFirst()){
            Vehiculo vehiculo = new Vehiculo();

            vehiculo.setPlaca(cursor.getString(0));
            vehiculo.setPropietario(cursor.getString(1));
            vehiculo.setMarca(cursor.getString(2));
            vehiculo.setColor(cursor.getString(3));
            vehiculo.setAnio(cursor.getInt(4));
            return vehiculo;
        }else{
            return null;
        }
    }
    public String eliminar(Vehiculo vehiculo){

        String regAfectados="filas afectadas= ";
        int contador=0;
        String where="idplaca='"+vehiculo.getPlaca()+"'";
        contador+=db.delete("vehiculo", where, null);
        regAfectados+=contador;
        return regAfectados;
    }

    private boolean verificarIntegridad(Object dato, int relacion) throws SQLException{
        switch(relacion){
            case 1:
            {
                Vehiculo vehiculo = (Vehiculo) dato;
                String[] id1 = {vehiculo.getPropietario()};
                //abrir();
                Cursor cursor1 = db.query("conductor", null, "licencia = ?", id1, null,
                        null, null);

                if(cursor1.moveToFirst()){
//Se encontraron datos
                    return true;
                }
                return false;
            }
            case 2:
            { return true;}
            case 3:
            {
                Conductor conductor = (Conductor) dato;
                Cursor c=db.query(true, "conductor", new String[] {
                                "licencia" }, "licencia='"+conductor.getlicencia()+"'",null,
                        null, null, null, null);
                if(c.moveToFirst())
                    return true;
                else
                    return false;
            }
            case 4:
            {
                //verificar que exista
                Vehiculo vehiculo = (Vehiculo) dato;
                String[] id = {vehiculo.getPlaca()};
                abrir();
                Cursor c2 = db.query("vehiculo", null, "idplaca = ?", id, null, null,
                        null);
                if(c2.moveToFirst()){
//Se encontro condcutor
                    return true;
                }
                return false;
            }
            case 5:
            {
                //verificar que exista
                Conductor conductor2 = (Conductor) dato;
                String[] id = {conductor2.getlicencia()};
                abrir();
                Cursor c2 = db.query("conductor", null, "licencia = ?", id, null, null,
                        null);
                if(c2.moveToFirst()){
//Se encontro condcutor
                    return true;
                }
                return false;
            }
            case 6:
            {return false;}
            default:
                return false;
        }
    }



}
