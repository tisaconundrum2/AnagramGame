package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RelativeLayout;

public class MainMenu extends AppCompatActivity {
    private RelativeLayout anagramLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        anagramLayout = (RelativeLayout) findViewById(R.id.anagram_layout);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }


    }

    private void initCredits(){}
    private void initGame(){}
    private void initMenu(){}
    private void initSettings(){}
    public void onBackPressed(){}
}
