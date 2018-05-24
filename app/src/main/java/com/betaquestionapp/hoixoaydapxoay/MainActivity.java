package com.betaquestionapp.hoixoaydapxoay;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AdView mAdView;
    public static int numberQuestion = 0;
    public static int numberLeft = 3;
    public static int numberQuestionPack = 1;
    Button btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState   ) {
        super.onCreate( savedInstanceState );

        requestWindowFeature( Window.FEATURE_NO_TITLE);
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_main );
        this.setRequestedOrientation( ActivityInfo.SCREEN_ORIENTATION_PORTRAIT );
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7590251974628711~7538384997");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //-----------------codepart---------------
        btnPlay = findViewById(R.id.buttonPlay );



        //chuyensangmanhinhcauhoi

        btnPlay.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( MainActivity.this, QuestionActivity.class );
                startActivity( intent );
                numberQuestion = 0;
                numberLeft = 3;

            }
        } );//new play





    }

}
