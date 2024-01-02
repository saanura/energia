package com.example.dialer;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	
	EditText txt;
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,call,del,save;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		txt=(EditText) findViewById(R.id.txt);
		b1=(Button) findViewById(R.id.d1);
		b1.setOnClickListener(this);
		b2=(Button) findViewById(R.id.d2);
		b2.setOnClickListener(this);
		b3=(Button) findViewById(R.id.d3);
		b3.setOnClickListener(this);
		b4=(Button) findViewById(R.id.d4);
		b4.setOnClickListener(this);
		b5=(Button) findViewById(R.id.d5);
		b5.setOnClickListener(this);
		b6=(Button) findViewById(R.id.d6);
		b6.setOnClickListener(this);
		b7=(Button) findViewById(R.id.d7);
		b7.setOnClickListener(this);
		b8=(Button) findViewById(R.id.d8);
		b8.setOnClickListener(this);
		b9=(Button) findViewById(R.id.d9);
		b9.setOnClickListener(this);
		b10=(Button) findViewById(R.id.d10);
		b10.setOnClickListener(this);
		b11=(Button) findViewById(R.id.d11);
		b11.setOnClickListener(this);
		b12=(Button) findViewById(R.id.d12);
		b12.setOnClickListener(this);
		del=(Button) findViewById(R.id.del);
		del.setOnClickListener(this);
		call=(Button) findViewById(R.id.call);
		call.setOnClickListener(this);
		save=(Button) findViewById(R.id.save);
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
		// TODO Auto-generated method stub
		
		if(arg0.equals(b1)){
			txt.append("1");
		}
		else if(arg0.equals(b2))
		{
			txt.append("2");
		}
		else if(arg0.equals(b3))
		{
			txt.append("3");
		}
		else if(arg0.equals(b4))
		{
			txt.append("4");
		}
		else if(arg0.equals(b5))
		{
			txt.append("5");
		}
		
		else if(arg0.equals(b6))
		{
			txt.append("6");
		}
		
		else if(arg0.equals(b7))
		{
			txt.append("7");
		}
		
		else if(arg0.equals(b8))
		{
			txt.append("8");
		}
		
		else if(arg0.equals(b9))
		{
			txt.append("9");
		}
		
		else if(arg0.equals(b10))
		{
			txt.append("*");
		}
		else if(arg0.equals(b11))
		{
			txt.append("0");
		}
		else if(arg0.equals(b12))
		{
			txt.append("#");
		}
		
		else if(arg0.equals(del))
		{
			String num=txt.getText().toString();
			if(num.length()>0){
				num=num.substring(0,num.length()-1);
			}
			txt.setText(num);
		}
		
		else if(arg0.equals(call))
		{
			String num=txt.getText().toString();
			Intent it= new Intent(Intent.ACTION_CALL);
			it.setData(Uri.parse("tel:"+num));
			startActivity(it);
		}
		else if(arg0.equals(save)){
			String num= txt.getText().toString();
			Intent its = new Intent(Intent.ACTION_INSERT,ContactsContract.Contacts.CONTENT_URI);
			its.putExtra(ContactsContract.Intents.Insert.PHONE, num);
			startActivity(its);
		}
	
	}

}
