package com.example.proyecto017;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast; 
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends Activity {
	EditText et1;
	EditText et2; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2); 
    }

    public void grabar(View v) {
    	 String nomarchivo = et1.getText().toString();
    	 String contenido=et2.getText().toString();
    	 try{
    		 File tarjeta = Environment.getExternalStorageDirectory();
	    	 File file = new File(tarjeta.getAbsolutePath(), nomarchivo);
	    	 OutputStreamWriter osw =new OutputStreamWriter(new FileOutputStream(file));
	    	 osw.write(contenido);
	    	 osw.flush();
	    	 osw.close();
	    	 Toast.makeText(this,"Los datos fueron grabados correctamente",Toast.LENGTH_SHORT).show();
	    	 et1.setText("");
	    	 et2.setText("");
    	 }
    	 catch (IOException ioe)
    	 	{
    	 		}
    }  
    
    public void recuperar(View v) {
    	 String nomarchivo = et1.getText().toString();
    	 File tarjeta = Environment.getExternalStorageDirectory();
    	 File file = new File(tarjeta.getAbsolutePath(),
    	nomarchivo);
    	 try {
    	 FileInputStream fIn = new FileInputStream(file);
    	 InputStreamReader archivo=new InputStreamReader(fIn);
    	 BufferedReader br=new BufferedReader(archivo);
    	 String linea=br.readLine();
    	 String todo="";
    	 while (linea!=null)
    	 {
    	 todo=todo+linea+"\n";
    	 linea=br.readLine();
    	 }
    	 br.close();
    	 archivo.close();
    	 et2.setText(todo);
    	 } catch (IOException e)
    	 {
    	 }
    	 } 
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
}
