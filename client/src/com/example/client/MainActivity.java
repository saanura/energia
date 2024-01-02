package com.example.client;

import com.example.calculator.calculator;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener, ServiceConnection {

    EditText txtfirst, txtsecond;
    Button btnadd, btnsub, btnmul;
    TextView txtresult;
    calculator cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtfirst = (EditText) findViewById(R.id.txt_first);
        txtsecond = (EditText) findViewById(R.id.txt_second);
        txtresult = (TextView) findViewById(R.id.txt_result);

        btnadd = (Button) findViewById(R.id.btn_add);
        btnadd.setOnClickListener(this);

        btnsub = (Button) findViewById(R.id.btn_sub);
        btnsub.setOnClickListener(this);

        btnmul = (Button) findViewById(R.id.btn_mul);
        btnmul.setOnClickListener(this);

        Intent intent = new Intent("com.example.calculator");
        intent.setPackage("com.example.server");
        bindService(intent, this, BIND_AUTO_CREATE);
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
        String s1 = txtfirst.getText().toString();
        String s2 = txtsecond.getText().toString();
        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);

        if (cal != null) {
            if (arg0.equals(btnadd)) {
                try {
                    int result = cal.add(a, b);
                    txtresult.setText(String.valueOf(result));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (arg0.equals(btnsub)) {
                try {
                    int result = cal.sub(a, b);
                    txtresult.setText(String.valueOf(result));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else if (arg0.equals(btnmul)) {
                try {
                    int result = cal.mul(a, b);
                    txtresult.setText(String.valueOf(result));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        } else {
            Toast.makeText(this, "Service not connected", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onServiceConnected(ComponentName arg0, IBinder arg1) {
        // TODO Auto-generated method stub
        Toast.makeText(getBaseContext(), "Service Connected", Toast.LENGTH_LONG).show();
        cal = (calculator) calculator.Stub.asInterface(arg1);
    }

    @Override
    public void onServiceDisconnected(ComponentName arg0) {
        // TODO Auto-generated method stub
        cal = null;
    }
}
