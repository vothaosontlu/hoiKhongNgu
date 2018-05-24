package com.betaquestionapp.hoixoaydapxoay;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class LoseActivity extends QuestionActivity {

    Button btnManHinhChinh , btnRateUs , btnAnother;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_lose );

        btnManHinhChinh = findViewById( R.id.butTonMeNu );
        btnRateUs = findViewById( R.id.rateuss );


        btnAnother = findViewById( R.id.buttonAnother );




        btnManHinhChinh.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoseActivity.this, MainActivity.class );
                startActivity( intent );
            }
        } );

        btnRateUs.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity( new Intent( Intent.ACTION_VIEW,
                            Uri.parse("market://details?id=com.betaquestionapp.hoixoaydapxoay") ) );
                }catch (ActivityNotFoundException e){
                    startActivity( new Intent( Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.betaquestionapp.hoixoaydapxoay") ) );
                }

            }
        } );


        btnAnother.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        } );


    }


    private void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnAnother);
        popupMenu.getMenuInflater().inflate( R.menu.menu, popupMenu.getMenu() );
        popupMenu.setOnMenuItemClickListener( new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch(item.getItemId()){
                    case R.id.menuMacDinh:

                        numberQuestionPack = 1;
                        numberQuestion = 0;
                        numberLeft = 3;
                        Intent intent = new Intent( LoseActivity.this, QuestionActivity.class );
                        startActivity( intent );
                        setQuestion( numberQuestionPack );

                        break;
                    case R.id.menuToanHoc:numberQuestionPack = 2;
                        numberQuestionPack = 2;
                        numberQuestion = 0;
                        numberLeft = 3;
                        Intent intent1 = new Intent( LoseActivity.this, QuestionActivity.class );
                        startActivity( intent1 );
                        setQuestion( numberQuestionPack );
                        break;

                    case R.id.menuTinhYeu:numberQuestionPack = 3;

                        numberQuestionPack = 3;
                        numberQuestion = 0;
                        numberLeft = 3;
                        Intent intent2 = new Intent( LoseActivity.this, QuestionActivity.class );
                        startActivity( intent2 );
                        setQuestion( numberQuestionPack );
                        break;
                }

                return false;
            }
        } );
        popupMenu.show();
    }
}
