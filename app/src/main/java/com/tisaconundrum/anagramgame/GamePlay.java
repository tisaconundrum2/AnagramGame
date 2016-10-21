package com.tisaconundrum.anagramgame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.tisaconundrum.anagramgame.R.mipmap.alpha_a;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_b;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_c;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_d;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_e;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_f;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_g;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_h;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_i;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_j;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_k;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_l;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_m;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_n;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_o;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_p;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_q;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_r;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_s;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_t;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_u;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_v;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_w;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_x;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_y;
import static com.tisaconundrum.anagramgame.R.mipmap.alpha_z;

/**
 * Created by tisaconundrum on 10/17/2016.
 */

public class GamePlay extends AppCompatActivity {
    private String DATA_FILE = "anagrams.txt";
    private Integer totalwords = 0;
    private Integer wordsfound = 0;
    private String[] words;
    private TextView textViewAnagramWord;
    private TextView textViewWordLabel;
    private TextView textViewUsernameTitle;
    private String username;
    private RelativeLayout gamePlayLayout;
    private int[] buttons = {alpha_a, alpha_b, alpha_c, alpha_d, alpha_e, alpha_f, alpha_g, alpha_h, alpha_i, alpha_j, alpha_k, alpha_l, alpha_m, alpha_n, alpha_o, alpha_p, alpha_q, alpha_r, alpha_s, alpha_t, alpha_u, alpha_v, alpha_w, alpha_x, alpha_y, alpha_z};
    private int[] tile = {alpha_a, alpha_b, alpha_c, alpha_d, alpha_e, alpha_f, alpha_g, alpha_h, alpha_i, alpha_j, alpha_k, alpha_l, alpha_m, alpha_n, alpha_o, alpha_p, alpha_q, alpha_r, alpha_s, alpha_t, alpha_u, alpha_v, alpha_w, alpha_x, alpha_y, alpha_z};
    private String[] alphaStrings = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};




    @Override
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

    public void initTiles() {
        for (int i = 0; i < alphaStrings.length; i++) {                                                 // loop through 26 letters
            String buttonID = "alpha_" + alphaStrings[i];                                               // buttonID example "alpha_b"
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());                 // finds the tile that is available for interaction on the board
            ImageView alpha_b = (ImageView) findViewById(R.mipmap.alpha_a)
            buttons[i].setOnClickListener((View.OnClickListener) this);                                 // listen for any Clicks
        }
    }

    private void getInputFile(String file) {
        TextView textViewNumTokens = (TextView)findViewById(R.id.words_matched);
        try {                                                                                           // try the file and make sure it exists
            InputStreamReader inputs = new InputStreamReader(getAssets().open(file));                   // input the anagrams.txt file that will be in the src/main/assets directory
            BufferedReader br = new BufferedReader(inputs);                                             // Read the inputs in
            words = br.readLine().split(" ");                                                           // start counting how many words there. We can tell this by the spaces between each word
            //textViewAnagramWord.setText(words[0]);                                                    // TODO, this sets the Anagram text, what we need to do is call a function to populate the tiles when this ran (Line 84)
            getTilePlacement(words[0]);                                                                 // If this all goes off without a hitch, this program should populate the empty tiles with letters
            words[0] = null;                                                                            // delete the existence of the word, because we don't want to be reusing it
            totalwords = words.length - 1;                                                              // get our total word count by using the length function
            textViewNumTokens.setText(wordsfound + "/" + totalwords);                                   // in the xml file textViewNumTokens will now say something like 0/152
            //
        } catch (IOException e) {                                                                       //
            e.printStackTrace();                                                                        // output an error if we can't find the file
        }                                                                                               //
    }

    private void getTilePlacement(String string){
        ImageView tile1 = (ImageView) findViewById(R.id.tile1);                                     // Let's
        ImageView tile2 = (ImageView) findViewById(R.id.tile2);                                     // be
        ImageView tile3 = (ImageView) findViewById(R.id.tile3);                                     // completely
        ImageView tile4 = (ImageView) findViewById(R.id.tile4);                                     // honest
        ImageView tile5 = (ImageView) findViewById(R.id.tile5);                                     // this
        ImageView tile6 = (ImageView) findViewById(R.id.tile6);                                     // isn't
        ImageView tile7 = (ImageView) findViewById(R.id.tile7);                                     // optimal
        ImageView[] tiles = {tile1, tile2, tile3, tile4, tile5, tile6, tile7};                          // put all these variables in a list. XD I can't believe this logic works TBH >_<
        int i = 1;
        for (char ch: string.toCharArray()){                                                            // Parse the string, get each individual letter
            switch (ch){                                                                                // You have no idea how mad I am that I have to do it this way...
                case 'a':                                                                               // Anyway, each number corresponds to a specific letter in R.mipmap
                    tiles[i].setImageResource(tile[0]);                                                 // Naming convention is the worse... This really should be remedied...
                    i++;                                                                                // and i'm probably honestly not going to fix this...¯\_(ツ)_/¯
                    break;
                case 'b':
                    tiles[i].setImageResource(tile[2-1]);
                    i++;
                    break;
                case 'c':
                    tiles[i].setImageResource(tile[3-1]);
                    i++;
                    break;
                case 'd':
                    tiles[i].setImageResource(tile[4-1]);
                    i++;
                    break;
                case 'e':
                    tiles[i].setImageResource(tile[5-1]);
                    i++;
                    break;
                case 'f':
                    tiles[i].setImageResource(tile[6-1]);
                    i++;
                    break;
                case 'g':
                    tiles[i].setImageResource(tile[7-1]);
                    i++;
                    break;
                case 'h':
                    tiles[i].setImageResource(tile[8-1]);
                    i++;
                    break;
                case 'i':
                    tiles[i].setImageResource(tile[9-1]);
                    i++;
                    break;
                case 'j':
                    tiles[i].setImageResource(tile[10-1]);
                    i++;
                    break;
                case 'k':
                    tiles[i].setImageResource(tile[11-1]);
                    i++;
                    break;
                case 'l':
                    tiles[i].setImageResource(tile[12-1]);
                    i++;
                    break;
                case 'm':
                    tiles[i].setImageResource(tile[13-1]);
                    i++;
                    break;
                case 'n':
                    tiles[i].setImageResource(tile[14-1]);
                    i++;
                    break;
                case 'o':
                    tiles[i].setImageResource(tile[15-1]);
                    i++;
                    break;
                case 'p':
                    tiles[i].setImageResource(tile[16-1]);
                    i++;
                    break;
                case 'q':
                    tiles[i].setImageResource(tile[17-1]);
                    i++;
                    break;
                case 'r':
                    tiles[i].setImageResource(tile[18-1]);
                    i++;
                    break;
                case 's':
                    tiles[i].setImageResource(tile[19-1]);
                    i++;
                    break;
                case 't':
                    tiles[i].setImageResource(tile[20-1]);
                    i++;
                    break;
                case 'u':
                    tiles[i].setImageResource(tile[21-1]);
                    i++;
                    break;
                case 'v':
                    tiles[i].setImageResource(tile[22-1]);
                    i++;
                    break;
                case 'w':
                    tiles[i].setImageResource(tile[23-1]);
                    i++;
                    break;
                case 'x':
                    tiles[i].setImageResource(tile[24-1]);
                    i++;
                    break;
                case 'y':
                    tiles[i].setImageResource(tile[25-1]);
                    i++;
                    break;
                case 'z':
                    tiles[i].setImageResource(tile[26-1]);
                    i++;
                    break;
            }

        }

    }

    private void resetTiles() {
                                                                                                        // TODO, make it such that tiles are clickable again
    }

    private void nextWord() {
                                                                                                        // TODO, make it when the right arrow is clicked, we go to the next word to be solved
    }

    private void prevWord() {
                                                                                                        // TODO, make it when the left arrow is clicked, we go to the previous word
    }

    private void submit() {
        ImageView buttonSubmit = (ImageView) findViewById(R.id.submit_button);
        final TextView textViewNumTokens = (TextView)findViewById(R.id.words_matched);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View sub) {                                                             // click to submit the typed word
                TextView input = (TextView) findViewById(R.id.tileOutput);                              // after the click pull the string from the tileOutput box
                String submission = input.getText().toString();                                         // convert the string, probably redundant, but gotta make sure
                for (int i = 0; i < words.length; i++) {                                                // going through each word that is in our list
                    if (words[i] != null) {                                                             // and as long as the list is not empty
                        if (words[i].equals(submission)) {                                              // check to see if the string is the same as the string that was typed
                            wordsfound += 1;                                                            // increment our wordsfound
                            textViewNumTokens.setText("Words matched " + wordsfound + "/" + totalwords);// update textViewNumTokens, and let the user know that they found a correct word
                            words[i] = null;                                                            // since we found a correct word, delete it from the list
                        }
                        if (wordsfound == totalwords) {                                                 // TODO: have the user forwarded to the Game_over layout and display score, utilize intent here
                            //textViewUsernameTitle.setText("Great Job " + helpers.toTitleCase(username) + "!");
                            //textViewWordLabel.setText("");
                            //textViewAnagramWord.setText("You're the bestest!");
                            //input.setText("");
                        }
                    }
                }
                input.setSelectAllOnFocus(true);
            }
        });
    }


}