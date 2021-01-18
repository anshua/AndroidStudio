package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /*
    Player
    1 - X
    0 - O
     */

    private boolean activeGame = true;

    private TextView turn;
    private Button btnNewGame;
    int activePlayer = 1;
    int[] game = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    String winner = "";
    int filledBox = 0;
    /*
    state meaning
    0 - O
    1 - X
    2 - null
     */

    int[][] winningPosition = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                                {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6} };


    public void plyerTap(View view) {
        Log.d("Madhuri", "plyerTap: " + filledBox);
        ImageView iv = (ImageView) view;
        int tappedImage = Integer.parseInt(iv.getTag().toString());

        if(!activeGame){
            resetGame(view);
        }

        if(game[tappedImage] == 2 && activeGame){
            filledBox++;
            game[tappedImage] = activePlayer;
            iv.setTranslationY(-1000f);
            if(activePlayer == 0){
                iv.setImageResource(R.drawable.circle);
                activePlayer = 1;
                turn.setText("X's Turn - Tap to play");

            }
            else {
                iv.setImageResource(R.drawable.cross);
                activePlayer = 0;
                turn.setText("O's Turn - Tap to play");
            }

            iv.animate().translationYBy(1000f).setDuration(300);
        }

        String winner = "";

        // check if any player win
        for(int[] winPos: winningPosition){
            if(game[winPos[0]] == game[winPos[1]] && game[winPos[2]] == game[winPos[1]] && game[winPos[0]] != 2){
                if(game[winPos[0]] == 0){
                    winner = "Player-O has won";
                }
                else {
                    winner = "Player-X has won";
                }
                turn.setText(winner);
                activeGame = false;
            }
        }

        if (filledBox == 9 && winner == ""){
            winner = "Game Tied";
            turn.setText(winner);
            activeGame = false;

        }
    }

    private void resetGame(View view) {
        activeGame = true;
        for (int i = 0; i < 9; i++) {
            game[i] = 2;
        }
        winner = "";
        activePlayer = 1;
        turn.setText("X's Turn - Tap to play");
        ((ImageView) findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        turn = findViewById(R.id.tvTurn);
        turn.setText("X's Turn - Tap to play");
        btnNewGame = findViewById(R.id.btnNewGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame(v);
            }
        });

    }

}