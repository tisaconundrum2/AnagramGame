package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by tisaconundrum on 10/17/2016.
 */

public class GamePlay extends AppCompatActivity{
    private RelativeLayout gamePlayLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_play);
        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        addTiles();
    }

    private void addTiles() {

    }
}