package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

/**
 * Created by tisaconundrum on 10/17/2016.
 */

public class GamePlay extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }
}
