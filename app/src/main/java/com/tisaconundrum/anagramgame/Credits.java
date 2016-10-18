package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.tisaconundrum.anagramgame.R.layout.credits;

/**
 * Created by tisaconundrum on 10/17/2016.
 */

public class Credits extends AppCompatActivity{
    private RelativeLayout creditsLayout;
    private TextView titleLeft;
    private TextView titleMiddle;
    private TextView titleRight;
    private Animation compileAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(credits);
        creditsLayout = (RelativeLayout) findViewById(R.id.credits_layout);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        titleAnimate();
    }

    private void titleAnimate(){
        titleLeft = (TextView) findViewById(R.id.title_bar_left);
        titleMiddle = (TextView) findViewById(R.id.title_credits);
        titleRight = (TextView) findViewById(R.id.title_bar_right);

        compileAnimation = AnimationUtils.loadAnimation(Credits.this, R.anim.back_anim_for_title_left);
        compileAnimation.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnimation.setAnimationListener(new Animation.AnimationListener() {
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

        titleLeft.startAnimation(compileAnimation);

        compileAnimation = AnimationUtils.loadAnimation(Credits.this, R.anim.back_anim_for_title_right);
        compileAnimation.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnimation.setAnimationListener(new Animation.AnimationListener() {
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

        titleRight.startAnimation(compileAnimation);

        compileAnimation = AnimationUtils.loadAnimation(Credits.this, R.anim.back_anim_for_title_middle);
        compileAnimation.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnimation.setAnimationListener(new Animation.AnimationListener() {
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

        titleMiddle.startAnimation(compileAnimation);
    }
}