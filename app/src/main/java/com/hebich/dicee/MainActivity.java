package com.hebich.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;
        rollButton = (Button) findViewById(R.id.rollbutton);

        final ImageView leftDice = ( ImageView ) findViewById(R.id.image_leftDice);

        final ImageView rightDice = ( ImageView ) findViewById(R.id.image_rightDice);

        final TextView textResult = (TextView) findViewById(R.id.textResult);

        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d ("TEst", "Testeee");

                Random randomNumberGenerator = new Random();

                int number = randomNumberGenerator.nextInt(6);

                Log.d("DICEE", "The Random Number is " + number);

                leftDice.setImageResource(diceArray[number]);

                int number2 = randomNumberGenerator.nextInt(6);
                rightDice.setImageResource(diceArray[number2]);

                int result = number + number2 + 2;
                // plus 2 because arrays start with 0

                textResult.setText("your score is: "+ result);

                if (result == 12 ){
                    textResult.setText("congrats you hit the Jackpot");
                }


            }
        });


    }
}
