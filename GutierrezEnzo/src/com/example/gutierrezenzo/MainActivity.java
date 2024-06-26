package com.example.gutierrezenzo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private TextView tv5;
	private RadioButton r1,r2,r3,r4,r5;
	private CheckBox checkBox1;
	private EditText et1;
	public String tipo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv5=(TextView)findViewById(R.id.tv5);
        r1=(RadioButton)findViewById(R.id.r1); 
        r2=(RadioButton)findViewById(R.id.r2); 
        r3=(RadioButton)findViewById(R.id.r3); 
        r4=(RadioButton)findViewById(R.id.r4); 
        r5=(RadioButton)findViewById(R.id.r5); 
        checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        et1=(EditText)findViewById(R.id.editText1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void tipoHerramienta(View view) {
    	int importe = 0;
		 String resultado=String.valueOf(importe);

    	 if (r1.isChecked()==true) {
    		 importe=500;
    		 resultado=String.valueOf(importe);
    	 } else
    		 if (r2.isChecked()==true) {
    			 importe=3000;
    			 resultado=String.valueOf(importe);
    	 } else
			 if (r3.isChecked()==true) {
				 importe=5000;
				 resultado=String.valueOf(importe);
		 }
    	 
    	 if (checkBox1.isChecked()==true) {
    		 double nro1=Double.parseDouble(resultado);
    		 double seguro = nro1 * 1.20;
    		 resultado = String.valueOf(seguro);
    	 }
    	 
    	 if (r4.isChecked()==true) {
    		 double nro1=Double.parseDouble(resultado);
    		 double contado = nro1 * 0.90;
    		 resultado = String.valueOf(contado); 
    		 tipo = "Contado";
    	 } else
    		 if (r5.isChecked()==true) {
    			 double tarjeta=Double.parseDouble(resultado);
    			 resultado = String.valueOf(tarjeta);
    			 tipo = "Tarjeta";
    			 
    	 }
    	 
    	 String valor1=et1.getText().toString();
    	 int dias=Integer.parseInt(valor1);
    	 double precioFinal=Double.parseDouble(resultado);
    	 precioFinal = precioFinal * dias;
    	 resultado = String.valueOf(precioFinal); 
    	 
    	 tv5.setText("$" + resultado);
    } 
    
    public void facturar(View view) {
      	 Intent i = new Intent(this, Factura.class );
      	 i.putExtra("tipo", tipo);
      	 i.putExtra("monto", tv5.getText().toString()); 
      	 startActivity(i);
      } 
    
}
