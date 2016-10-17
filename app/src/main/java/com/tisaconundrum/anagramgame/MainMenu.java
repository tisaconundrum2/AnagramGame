package com.tisaconundrum.anagramgame;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {
    private RelativeLayout anagramLayout;
    private Animation compileAnim;
    private ImageView playBtn, settingsBtn;
    private TextView titleLeft;
    private TextView titleMiddle;
    private TextView titleRight;

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
        initMenu();
        initSettings();
        initCredits();

    }

    private void initSettings(){
        settingsBtn = (ImageView) findViewById(R.id.settings_button);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent settingsIntent = new Intent(MainMenu.this, Settings.class);
                        settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); //this checks that all animations are done before moving foward
                        startActivity(settingsIntent);
                    }
                }, GameSettings.START_NEW_ACTIVITY_DURATION);

            }
        });
    }
    private void initGame(){}
    private void initMenu(){
        // Making the title look pretty, coming in and out
        titleLeft = (TextView) findViewById(R.id.anagram_left);
        titleMiddle = (TextView) findViewById(R.id.anagram_middle);
        titleRight = (TextView) findViewById(R.id.anagram_right);

        // Set up animation for title left
        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.back_anim_for_title_left);
        compileAnim.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        titleLeft.startAnimation(compileAnim);

        // Set up animation for title middle
        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.back_anim_for_title_middle);
        compileAnim.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        titleMiddle.startAnimation(compileAnim);

        // Set up animation for title right
        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.back_anim_for_title_right);
        compileAnim.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        titleRight.startAnimation(compileAnim);

    }
    private void initCredits(){}
    public void onBackPressed(){}
}
