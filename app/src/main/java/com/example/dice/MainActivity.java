package com.example.dice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView leftDie = findViewById(R.id.user_dice);
        final ImageView rightDie = findViewById(R.id.com_dice);
        Button higher = findViewById(R.id.user_button);
        Button lower = findViewById(R.id.com_button);
        TextView text = findViewById(R.id.Result);
        //-------------------------------------------------------------------

        final int [] diceArray = {R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};
        // we want to pick one of the dices in array randomly and replace it with left and right
        // image view inside your app!
        // Click listener look for an event on your view components.
        higher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                int randLeftDie = rand.nextInt(6);
                int randRightDie = rand.nextInt(6);

                //Log.d("left die",String.valueOf(randLeftDie));
                //Log.d("right die",String.valueOf(randRightDie));

                leftDie.setImageResource(diceArray[randLeftDie]);
                rightDie.setImageResource(diceArray[randRightDie]);

                if(randLeftDie == randRightDie){
                    //it's tie
                    text.setText("IT'S A TIE");
                }else if(randLeftDie> randRightDie){
                    //user win
                    text.setText("USER WIN!");
                }else{
                    //computer win
                    text.setText("COMPUTER WIN!");
                }
                // we need to create a random integer for picking the dices randomly!
            }
        });

        lower.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();
                int randuserDie = rand.nextInt(6);
                int randComputerDie = rand.nextInt(6);

                leftDie.setImageResource(diceArray[randuserDie]);
                rightDie.setImageResource(diceArray[randComputerDie]);
                // we need to create a random integer for picking the dices randomly
                if(randuserDie == randComputerDie){
                    //it's tie
                    text.setText("IT'S A TIE");
                }else if(randuserDie< randComputerDie){
                    //user win
                    text.setText("USER WIN!");
                }else{
                    //computer win
                    text.setText("COMPUTER WIN!");
                }

            }
        });
    }
}