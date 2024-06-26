package com.example.proyecto012;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle; 
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener; 

public class MainActivity extends Activity {

	private ListView lv1;
	private String[] telefonos={"4800234", "4582753", "4182758",
			"4761846", "4761723", "4123874"}; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        lv1=(ListView)findViewById(R.id.listView1);
        ArrayAdapter <String>adaptador1=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,telefonos);
        lv1.setAdapter(adaptador1);

        lv1.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView<?> a, View v, int posicion, long id) {
        		Intent intent1 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefonos[posicion]));
        		startActivity(intent1);
        	}
        }); 
    }
    
}
