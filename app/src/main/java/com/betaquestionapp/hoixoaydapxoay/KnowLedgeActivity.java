package com.betaquestionapp.hoixoaydapxoay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class KnowLedgeActivity extends QuestionActivity {

    Button btnHoiTiepDi;
    ImageView imgKienThuc;
    TextView txtKienThuc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_know_ledge );

        btnHoiTiepDi = findViewById( R.id.buttonHoiTiepDi );
        imgKienThuc = findViewById( R.id.imageviewKnowLedge );
        txtKienThuc = findViewById( R.id.textviewKnowLedge );

        setKienThuc( numberQuestionPack);


        btnHoiTiepDi.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( KnowLedgeActivity.this, QuestionActivity.class );
                startActivity( intent );


            }
        } );

    }

    public void setKienThuc(int s) {
        switch (s) {
            case 1:
                imgKienThuc.setImageResource( arrayQuestion.get( numberQuestion - 1 ).getHinh() );
                txtKienThuc.setText( arrayQuestion.get( numberQuestion - 1 ).getKnowledge() );
                break;
            case 2:
                imgKienThuc.setImageResource( arrayToan.get( numberQuestion - 1 ).getHinh() );
                txtKienThuc.setText( arrayToan.get( numberQuestion - 1 ).getKnowledge() );
                break;
            case 3:
                imgKienThuc.setImageResource( arrayTanGai.get( numberQuestion - 1 ).getHinh() );
                txtKienThuc.setText( arrayTanGai.get( numberQuestion - 1 ).getKnowledge() );
                break;
            default:
                imgKienThuc.setImageResource( arrayQuestion.get( numberQuestion - 1 ).getHinh() );
                txtKienThuc.setText( arrayQuestion.get( numberQuestion - 1 ).getKnowledge() );
                break;

        }
    }

}