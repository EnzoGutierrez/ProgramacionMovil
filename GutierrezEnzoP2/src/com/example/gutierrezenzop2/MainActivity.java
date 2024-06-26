package com.example.gutierrezenzop2;

import android.os.Bundle;
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private EditText et1,et2,et3,et4; 
	private TextView tv7;
	private RadioButton r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        et3=(EditText)findViewById(R.id.et3);
        et4=(EditText)findViewById(R.id.et4);
        
        r1=(RadioButton)findViewById(R.id.radio0); 
        r2=(RadioButton)findViewById(R.id.radio1); 
        r3=(RadioButton)findViewById(R.id.radio2); 
        
        tv7=(TextView)findViewById(R.id.tv7);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void alta(View v) {
    	 AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,"administracion", null, 1);
    	 SQLiteDatabase bd=admin.getWritableDatabase();
    	 String nombre=et1.getText().toString();
    	 String dni=et2.getText().toString();
    	 String telefono=et3.getText().toString();
    	 String dias=et4.getText().toString();
    	 ContentValues registro=new ContentValues();
    	 registro.put("dni",dni );
    	 registro.put("nombre",nombre );
    	 registro.put("telefono",telefono );
    	 registro.put("dias",dias );
    	 bd.insert("alquieres", null, registro);
    	 bd.close();
    	 et1.setText("");
    	 et2.setText("");
    	 et3.setText("");
    	 et4.setText("");
    	 Toast.makeText(this, "Se cargaron los datos",
    	Toast.LENGTH_SHORT).show();
    	 } 
    
    public void consulta(View v) {
    	 AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(this,
    	"administracion", null, 1);
    	 SQLiteDatabase bd=admin.getWritableDatabase();
    	 String dni=et2.getText().toString();
    	 Cursor fila=bd.rawQuery("select nombre,telefono,dias from alquieres where dni="+dni+"",null);
    	 if (fila.moveToFirst())
    	 {
    	 et1.setText(fila.getString(0)); 
    	 et3.setText(fila.getString(1));
    	 et4.setText(fila.getString(2));
    	 }
    	 else
    	 Toast.makeText(this, "No existe una persona con dicho dni", Toast.LENGTH_SHORT).show();
    	 bd.close();
    	 } 
    
    public void importe(View view) {
    	int pago = 0;
		 String resultado=String.valueOf(pago);

    	 if (r1.isChecked()==true) {
    		 pago=5000;
    		 resultado=String.valueOf(pago);
    	 } else
    		 if (r2.isChecked()==true) {
    			 pago=3500;
    			 resultado=String.valueOf(pago);
    	 } else
			 if (r3.isChecked()==true) {
				 pago=6000;
				 resultado=String.valueOf(pago);
		 }
    	 
    	 String valor1=et4.getText().toString();
    	 int dias=Integer.parseInt(valor1);
    	 double precioFinal=Double.parseDouble(resultado);
    	 precioFinal = precioFinal * dias;
    	 resultado = String.valueOf(precioFinal); 
    	 
    	 tv7.setText("$" + resultado);
    } 
    
    public void limpiar(View v) {
   	 et1.setText(""); 
   	 et2.setText(""); 
   	 et3.setText("");
   	 et4.setText("");
    }
    
    public void facturar(View view) {
     	Intent i = new Intent(this, Factura.class );
     	i.putExtra("nombre", et1.getText().toString()); 
     	i.putExtra("telefono", et3.getText().toString());
     	i.putExtra("dias", et4.getText().toString());
     	i.putExtra("monto", tv7.getText().toString());
     	 
     	 startActivity(i);
     }
}
