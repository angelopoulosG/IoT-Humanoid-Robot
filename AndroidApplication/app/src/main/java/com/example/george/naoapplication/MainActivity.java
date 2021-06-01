package com.example.george.naoapplication;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;


import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button connect_btn;
    long tStart;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.info:
                //Toast.makeText(getApplicationContext(),"Info selected", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent1);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    AsyncTask<String , Void, String> httptask;
    String ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Remote Control");
        connect_btn=(Button)findViewById(R.id.button);

        connect_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ip="http://zafora.icte.uowm.gr/~ictest00577";


                int flag = check_connection(ip);
                if (flag == 0)
                {
                    Toast.makeText(getApplicationContext(), "Connection with the server established!", Toast.LENGTH_LONG).show();

                    //call remote control activity
                    Intent intent = new Intent(MainActivity.this, Remote_Control.class);
                    intent.putExtra("ip", ip);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Connection Error...Please check the ip and retry!", Toast.LENGTH_LONG).show();
                }

            }
        });


    }


    public int check_connection(String ip)
    {
        String check_ip= ip + "/connection.php";
        tStart = System.currentTimeMillis();
        httptask = new HttpAsyncTask().execute(check_ip, check_ip, "");
        String x;
        try {
            x = httptask.get();
            Log.i("Pira", x);
            if(x.equals("YES"))
            {
                long tEnd = System.currentTimeMillis();
                long tDelta = tEnd - tStart;
                double elapsedSeconds = tDelta / 1000.0;
                Toast.makeText(getApplicationContext(),String.valueOf(elapsedSeconds),Toast.LENGTH_LONG).show();
                return 0;
            }
            else if (x.equals("NO"))
            {
                return -1;
            }

        }catch(InterruptedException e){

        } catch(ExecutionException e){

        }

        return -2;
    }
}