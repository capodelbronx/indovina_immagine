package com.example.indovinalimmagine;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Correct_answerActivity extends AppCompatActivity {

    boolean provenienza;                //booleano che ccntrolla se al momento l'utente sta giocando a indovina la bandiera o città,
                                        //valore true= indovina la bandiera         false=indovina la città

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.correct_answer);
        String bandieraCorretta = getIntent().getStringExtra("bandieraCorretta");

        String cittaCorretta = getIntent().getStringExtra("cittaCorretta");


        playSound(R.raw.corretto2);

        if(bandieraCorretta!=null&&cittaCorretta==null){
            provenienza=true;
        }else{
            provenienza=false;
        }


    }

    public void onExitButtonClick(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void onContinuaButtonClick(View view) {
        if(provenienza){
            Intent intent = new Intent(this, BandieraActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, CittaActivity.class);
            startActivity(intent);
        }

    }

    private void playSound(int soundResourceId) {
        MediaPlayer mediaPlayer = MediaPlayer.create(this, soundResourceId);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
        mediaPlayer.start();
    }


}
