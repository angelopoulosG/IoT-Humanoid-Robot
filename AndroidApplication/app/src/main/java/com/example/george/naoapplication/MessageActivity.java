package com.example.george.naoapplication;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;

public class MessageActivity extends AppCompatActivity {
    Button nao_speak;
    EditText nao_text;
    String details,ip, fixed_ip_url,nao_str;
    ImageView tick;
    int flag=0;
    AsyncTask<String, Void, String> httptask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);
        setTitle("Remote Control");

        ip="http://zafora.icte.uowm.gr/~ictest00577";
        nao_speak=(Button)findViewById(R.id.button13);
        nao_text=(EditText)findViewById(R.id.editText);
        tick=(ImageView)findViewById(R.id.imageView2);


        nao_text.setHintTextColor(getResources().getColor(R.color.orange));

        flag=0;
        tick.setVisibility(View.INVISIBLE);
        nao_speak.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                nao_str=nao_text.getText().toString();
                if(nao_str.matches(""))
                {
                    flag=0;
                    tick.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "You did not enter a message", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //Toast.makeText(getApplicationContext(), nao_str, Toast.LENGTH_SHORT).show();
                    tick.setVisibility(View.VISIBLE);
                    details = "text" + "^" + nao_str;
                    send_movement_to_server();
                    final Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            tick.setVisibility(View.INVISIBLE);
                        }
                    }, 3000);
                }

            }
        });


    }

    public void send_movement_to_server() {
        fixed_ip_url = ip + "/main.php";
        httptask = new HttpAsyncTask().execute(fixed_ip_url, details, "");
        String x;
        try {
            x = httptask.get();
            Log.i("Pira", x);

        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }
    }
}
