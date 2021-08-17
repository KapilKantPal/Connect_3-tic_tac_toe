package com.programmingmanav.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 0:yellow , 1:red
    int count = 0;
    int activePlayer = 1;
    boolean gameActive = true;

    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void click(View view){

        Log.i("count"," count = "+count);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        ImageView imageView = (ImageView) view;
        int tag =  Integer.parseInt(imageView.getTag().toString());

            if (gameState[tag] == 2 && gameActive) {
                count++;
                show(view);
                Log.i("tag", "tag = " + tag);
            }


        for(int[] win1 : winPosition){
            if(gameState[win1[0]] == gameState[win1[1]] && gameState[win1[0]] == gameState[win1[2]] && gameState[win1[0]] != 2){
                gameActive = false;
                if(activePlayer == 0){
                    Log.i("count","red");
                    winnerTextView.setText("x has won");
                    break;
                }else{
                    Log.i("count","yellow");
                    winnerTextView.setText("o has won");
                    break;
                }
            }else if(count > 8 ){
                winnerTextView.setText("Draw");
            }
        }


    }

    public void show (View x){
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        ImageView imageView = (ImageView) x;
        imageView.animate().alpha(0);
        int tag =  Integer.parseInt(imageView.getTag().toString());
        imageView.animate().alpha(1).setDuration(100).rotation(3600);
        if(activePlayer == 0){
            imageView.setImageResource(R.drawable.yellow);
            activePlayer = 1;
            gameState[tag] = 1;
            winnerTextView.setText("x's Turn.");

        }else{
            imageView.setImageResource(R.drawable.red);
            activePlayer = 0;
            gameState[tag] = 0;
            winnerTextView.setText("o's Turn.");
        }
    }

    public void playAgain(View view){
        Button button = (Button) view;

        ImageView img1 = (ImageView)findViewById(R.id.imageView1);
        ImageView img2 = (ImageView)findViewById(R.id.imageView2);
        ImageView img3 = (ImageView)findViewById(R.id.imageView3);
        ImageView img4 = (ImageView)findViewById(R.id.imageView4);
        ImageView img5 = (ImageView)findViewById(R.id.imageView5);
        ImageView img6 = (ImageView)findViewById(R.id.imageView6);
        ImageView img7 = (ImageView)findViewById(R.id.imageView7);
        ImageView img8 = (ImageView)findViewById(R.id.imageView8);
        ImageView img9 = (ImageView)findViewById(R.id.imageView9);
        img1.setImageDrawable(null);
        img2.setImageDrawable(null);
        img3.setImageDrawable(null);
        img4.setImageDrawable(null);
        img5.setImageDrawable(null);
        img6.setImageDrawable(null);
        img7.setImageDrawable(null);
        img8.setImageDrawable(null);
        img9.setImageDrawable(null);

        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);
        winnerTextView.setText("x's Turn.");
        activePlayer = 1;
        gameActive = true;

        for(int i=0;i<9;i++){
            gameState[i]=2;
        }
        count =0;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}