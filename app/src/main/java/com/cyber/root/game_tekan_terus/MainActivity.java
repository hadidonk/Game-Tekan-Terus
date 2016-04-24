package com.cyber.root.game_tekan_terus;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btnmulai;
    private ImageButton btntekan;
    private CountDownTimer countDownTimer;
    private boolean timerHasStared=false;
    private TextView tvskor,tvwaktu;
    private final long startTime=20*1000;
    private final long interval=1*1000;
    private String habis,tambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnmulai=(Button) findViewById(R.id.btnmulai);
        btntekan=(ImageButton) findViewById(R.id.imageButton);
        tvskor=(TextView) findViewById(R.id.tvskor);
        tvwaktu=(TextView) findViewById(R.id.tvwaktu);
        btntekan.setVisibility(View.INVISIBLE);

        btnmulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btntekan.setVisibility(View.VISIBLE);
                btnmulai.setVisibility(View.INVISIBLE);
                countDownTimer = new MycountDownTimer(startTime, interval);
                countDownTimer.start();
            }
        });
btntekan.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        int skor,hasil;
        skor=Integer.parseInt(tvskor.getText().toString());
        hasil=skor+1;
        tvskor.setText(Integer.toString(hasil));
        habis=tvwaktu.getText().toString();
        try {
            if (habis.equals("0")){
                Toast.makeText(getApplicationContext(),"Waktu Sudah Habis !!!",Toast.LENGTH_LONG).show();
          btntekan.setVisibility(View.INVISIBLE);
            }
        }catch (Exception e){

        }

    }
});



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
class MycountDownTimer extends CountDownTimer{

    public MycountDownTimer(long startTime,long interval){
        super(startTime,interval);

    }

    @Override
    public void onTick(long millisUntilFinished) {
        tvwaktu.setText(""+millisUntilFinished/1000);
    }

    @Override
    public void onFinish() {
        tvwaktu.setText("0");
    }
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
