package com.example.george.naoapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.concurrent.ExecutionException;
public class Remote_Control extends AppCompatActivity {
    AsyncTask<String, Void, String> httptask;
    ImageButton forw, backw, left, right, kill , camera , sleep , wakeup, record, listen, recspeech;
    ImageView img;
    Button sit, sitR, crouch, stand_in, stand_zero, stand, lying_belly, lying_back,autopilot,autopilot_off,message;
    String ip, fixed_ip_url, details;
    long tStart;
    int flag=0;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.about:
                //Toast.makeText(getApplicationContext(),"About selected", Toast.LENGTH_SHORT).show();
                details=ip + "^" + "about";
                send_movement_to_server();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.remote,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remote__control);
        setTitle("Remote Control");
        Bundle receiveBundle = this.getIntent().getExtras();
        ip = receiveBundle.getString("ip");
        //Toast.makeText(getApplicationContext(), "Computer Ip : " + ip, Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(), "Nao Ip : " + nao_ip, Toast.LENGTH_LONG).show();

        forw = (ImageButton) findViewById(R.id.imageButton);
        backw = (ImageButton) findViewById(R.id.imageButton5);
        left = (ImageButton) findViewById(R.id.imageButton3);
        right = (ImageButton) findViewById(R.id.imageButton4);
        kill = (ImageButton) findViewById(R.id.imageButton10);
        camera =(ImageButton) findViewById(R.id.imageButton2);
        sleep = (ImageButton) findViewById(R.id.imageButton6);
        wakeup = (ImageButton) findViewById(R.id.imageButton7);
        record = (ImageButton) findViewById(R.id.imageButton9);
        listen = (ImageButton) findViewById(R.id.imageButton8);
        recspeech=(ImageButton)findViewById(R.id.imageButton11);

        sit = (Button) findViewById(R.id.button7);
        sitR = (Button) findViewById(R.id.button3);
        crouch = (Button) findViewById(R.id.button8);
        stand_in = (Button) findViewById(R.id.button4);
        stand_zero = (Button) findViewById(R.id.button5);
        stand = (Button) findViewById(R.id.button9);
        lying_belly = (Button) findViewById(R.id.button6);
        lying_back = (Button) findViewById(R.id.button2);
        autopilot=(Button)findViewById(R.id.button10);
        autopilot_off=(Button)findViewById(R.id.button11);
        message=(Button)findViewById(R.id.button12);


        img=(ImageView)findViewById(R.id.imageView);


        message.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Remote_Control.this, MessageActivity.class);
                startActivity(intent);

            }
        });


        forw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "forward";
                send_movement_to_server();
            }
        });
        backw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "backward";
                send_movement_to_server();
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "left";
                send_movement_to_server();
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "right";
                send_movement_to_server();
            }
        });
        kill.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "kill";
                send_movement_to_server();
            }
        });
        camera.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "camera";
                send_movement_to_server();
                Toast.makeText(getApplicationContext(), "Photo captured and stored!", Toast.LENGTH_LONG).show();
                Picasso.with(Remote_Control.this).load("http://zafora.icte.uowm.gr/~ictest00577/image_upload/uploads/mitsos.png").noFade().noPlaceholder().memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(img);
            }
        });

        sleep.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "sleep";
                send_movement_to_server();
            }
        });
        wakeup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "wake";
                send_movement_to_server();
            }
        });

        record.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //details = ip + "^" + "record";
                //send_movement_to_server();
                //Toast.makeText(getApplicationContext(), "Record Pressed!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Remote_Control.this, RecordActivity.class);
                startActivity(intent);

            }
        });

        recspeech.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //details = ip + "^" + "record";
                //send_movement_to_server();
                //Toast.makeText(getApplicationContext(), "Record Pressed!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Remote_Control.this, RecWav.class);
                startActivity(intent);

            }
        });

        listen.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                details = ip + "^" + "rec";
                tStart = System.currentTimeMillis();
                send_movement_to_server();
                final ProgressDialog progress = new ProgressDialog(Remote_Control.this);
                progress.setTitle("Listening wav from nao");
                progress.setMessage("Please wait...");
                progress.setCancelable(false);
                progress.show();
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //meta apo 7 sec
                        try {
                            final MediaPlayer player = new MediaPlayer();
                            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            player.setDataSource("http://zafora.icte.uowm.gr/~ictest00577/image_upload/uploads/test.wav");
                            player.prepare();
                            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mediaPlayer)
                                {
                                    long tEnd = System.currentTimeMillis();
                                    long tDelta = tEnd - tStart;
                                    double elapsedSeconds = tDelta / 1000.0;
                                    Toast.makeText(getApplicationContext(),String.valueOf(elapsedSeconds),Toast.LENGTH_LONG).show();
                                    Toast.makeText(getApplicationContext(), "Wav playing from server...!", Toast.LENGTH_SHORT).show();
                                    player.start();
                                    progress.dismiss();
                                }
                            });


                            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                            {
                                @Override
                                public void onCompletion(MediaPlayer mp)
                                {
                                    player.stop();
                                    Toast.makeText(getApplicationContext(), "Wav stopped playing...!", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (Exception e) {
                            // TODO: handle exception
                        }
                    }
                }, 10000);

            }
        });




        sit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "sit";
                send_movement_to_server();
            }
        });

        sitR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "sitrelax";
                send_movement_to_server();
            }
        });
        crouch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "crouch";
                send_movement_to_server();
            }
        });
        stand_in.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "standinit";
                send_movement_to_server();
            }
        });

        stand_zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "standzero";
                send_movement_to_server();
            }
        });
        stand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "stand";
                send_movement_to_server();
            }
        });
        lying_belly.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "lyingbelly";
                send_movement_to_server();
            }
        });
        lying_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                details = ip + "^" + "lyingback";
                send_movement_to_server();
            }
        });

        autopilot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flag=1;
                details = ip + "^" + "auto";
                send_movement_to_server();
                final Handler ha;
                ha= new Handler();
                ha.postDelayed(new Runnable() {

                        @Override
                        public void run() {
                            //call function
                            Picasso.with(Remote_Control.this).load("http://zafora.icte.uowm.gr/~ictest00577/image_upload/uploads/mitsos.png").noFade().noPlaceholder().memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(img);

                            ha.postDelayed(this, 1000);

                            if (flag==0)
                            {
                                ha.removeCallbacksAndMessages(null);
                            }
                        }
                    }, 1000);


            }
        });

        autopilot_off.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                flag=0;
                details = ip + "^" + "off";
                send_movement_to_server();

                Picasso.with(Remote_Control.this).load("http://zafora.icte.uowm.gr/~ictest00577/image_upload/uploads/mitsos.png").memoryPolicy(MemoryPolicy.NO_CACHE).networkPolicy(NetworkPolicy.NO_CACHE).into(img);
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

