package com.example.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{
	
	Button create,open,save;
	EditText txt;
	String FILE_NAME="example.txt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt=(EditText) findViewById(R.id.txt);
		create=(Button) findViewById(R.id.button_create);
		create.setOnClickListener(this);
		open=(Button) findViewById(R.id.button_open);
		open.setOnClickListener(this);
		save=(Button) findViewById(R.id.button_save);
		save.setOnClickListener(this);
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		if(arg0.equals(create)){
			String text=txt.getText().toString();
			FileOutputStream fos=null;
			try {
				fos=openFileOutput(FILE_NAME, MODE_PRIVATE);
				fos.write(text.getBytes());
				txt.getText().clear();
				Toast.makeText(getApplicationContext(),getFilesDir()+FILE_NAME,100000).show();
				fos.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			
		}
		else if (arg0.equals(open)) {
		    FileInputStream fis = null;
		    try {
		        fis = openFileInput(FILE_NAME);
		        InputStreamReader isr = new InputStreamReader(fis);
		        BufferedReader bf = new BufferedReader(isr);
		        StringBuffer sb = new StringBuffer();
		        String text;
		        while ((text = bf.readLine()) != null) {
		            sb.append(text).append("\n");
		        }
		        txt.setText(sb.toString()); // Corrected from txt.setText(text.toString());
		        fis.close();
		        bf.close(); // Close the BufferedReader
		    } catch (FileNotFoundException e) {
		        e.printStackTrace();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}

		
		else if(arg0.equals(save)){
			{
				String text=txt.getText().toString();
				FileOutputStream fos=null;
				try {
					fos=openFileOutput(FILE_NAME, MODE_PRIVATE);
					fos.write(text.getBytes());
					txt.getText().clear();
					Toast.makeText(getApplicationContext(),getFilesDir()+FILE_NAME,100000).show();
					fos.close();
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					
					e.printStackTrace();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
				
		
		}
		
		
	}
		
}
	
}


