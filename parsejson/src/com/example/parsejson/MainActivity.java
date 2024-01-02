package com.example.parsejson;

import java.io.IOException;
import java.io.InputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {
	
	Button buttonparse;
	TextView display;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		buttonparse=(Button) findViewById(R.id.button_parse);
		buttonparse.setOnClickListener(this);
		display=(TextView)findViewById(R.id.display);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		try {
			InputStream is = getAssets().open("sample.json");
			int size = is.available();
			byte[] buffer=new byte[size];
			is.read(buffer);
			is.close();
			String json=new String( buffer,"UTF-8");
			JSONArray jsonarr=new JSONArray(json);
			display.setText("");
			for(int i=0;i<jsonarr.length();i++){
				
			
				JSONObject obj=jsonarr.getJSONObject(i);
				display.setText(display.getText()+"Name:"+obj.getString("Name")+"\n");
				display.setText(display.getText()+"Longitude:"+obj.getString("Longitude")+"\n");
				display.setText(display.getText()+"Latitude:"+obj.getString("Latitude")+"\n");
				display.setText(display.getText()+"Temperature:"+obj.getString("Temperature")+"\n");
				display.setText(display.getText()+"Humidity:"+obj.getString("Humidity")+"\n");
				display.setText(display.getText() + "\n");
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}


}
