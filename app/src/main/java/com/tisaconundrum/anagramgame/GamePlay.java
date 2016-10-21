package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by tisaconundrum on 10/21/2016.
 */

public class GamePlay extends AppCompatActivity {
    private RelativeLayout gamePlayLayout;
    private String DATA_FILE = "anagrams.txt";
    private ImageView tile1,tile2,tile3,tile4,tile5,tile6,tile7;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);                                                             // tell the Dalvik VM to run your code in addition to the existing code in the onCreate() of the parent class.
        setContentView(R.layout.game_play);                                                             // set xml file of focus
        gamePlayLayout = (RelativeLayout) findViewById(R.id.game_play_layout);                          // get xml file's android:id. I'll be honest, I'm not sure why this needs to be here
        View decorView = getWindow().getDecorView();                                                    // Retrieve the current decor view
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);                                // Make our game full screen, so we don't have to worry about the top bar
        if (getSupportActionBar() != null) {                                                            // this is redundant, but it's for safety
            getSupportActionBar().hide();                                                               // simply make sure that the bar is actually hidden, despite being in "Full Screen"
        }
        initTiles();                                                                                    // initialize all our tiles, and get them prepped to be worked with
        getInputFile(DATA_FILE);                                                                        // we need our dictionary of words to match against.


    }

    private void getInputFile(String data_file) {
    }

    private void initTiles() {
        tile1 = (ImageView) findViewById(R.id.tile1);
        tile2 = (ImageView) findViewById(R.id.tile2);
        tile3 = (ImageView) findViewById(R.id.tile3);
        tile4 = (ImageView) findViewById(R.id.tile4);
        tile5 = (ImageView) findViewById(R.id.tile5);
        tile6 = (ImageView) findViewById(R.id.tile6);
        tile7 = (ImageView) findViewById(R.id.tile7);
        tile1.setImageResource(R.mipmap.alpha_a);
        tile2.setImageResource(R.mipmap.alpha_p);
        tile3.setImageResource(R.mipmap.alpha_p);
        tile4.setImageResource(R.mipmap.alpha_s);

    }
}
