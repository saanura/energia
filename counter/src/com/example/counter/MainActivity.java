package com.example.counter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, Runnable{
	
	
	
	TextView counter;
	Button start,stop;
	int i=0;
	Thread thread;
	Boolean running=false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		counter=(TextView) findViewById(R.id.counter);
		start=(Button) findViewById(R.id.start);
		start.setOnClickListener(this);
		stop = (Button) findViewById(R.id.stop);
		stop.setOnClickListener(this);

		
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
		if(arg0.equals(start)){
			running=true;
			thread=new Thread( this);
			thread.start();
			
		}
		else if(arg0.equals(stop)){
			running=false;
			
		}
		}
	
		
	Handler hand=new Handler() {
	    public void handleMessage(Message m) {
	        counter.setText("" + m.what);
	    }
	};

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(i<100 && running==true){
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				
			
			}
			hand.sendEmptyMessage(i);
			i++;
			
		}
		
		

		
		
	}

}
