package com.tisaconundrum.anagramgame;

import android.app.Activity;
import android.view.View;
import android.widget.Button;

/**
 * Created by tisaconundrum on 10/20/2016.
 */

public class AlphaActivity extends Activity implements View.OnClickListener{
    Button alpha_a, alpha_b, alpha_c, alpha_d, alpha_e, alpha_f, alpha_g, alpha_h, alpha_i, alpha_j, alpha_k, alpha_l, alpha_m, alpha_n, alpha_o, alpha_p, alpha_q, alpha_r, alpha_s, alpha_t, alpha_u, alpha_v, alpha_w, alpha_x, alpha_y, alpha_z;
    String[] alphaStrings = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    private Button[] buttons;
    public void setupButtons(){
        for (int i = 0; i < 27; i++){
            String buttonID = "alpha_"+alphaStrings[i];
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = ((Button) findViewById(resID));
            buttons[i].setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {

    }
}
