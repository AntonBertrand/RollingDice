package com.example.rollingdice;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    int score = 0;

    public void on_button_click(Integer DiceNum) {

        TextView tv = this.findViewById(R.id.numberTextView);


        tv.setText(Integer.toString(DiceNum));


        //Level 2

        TextView InputBox = this.findViewById(R.id.InputBox1);
        String UserInput;
        UserInput = InputBox.getText().toString();

        int UsersNumber;
        UsersNumber = Integer.parseInt(UserInput);  //Turns the Usersinput into an integer

        //Level 3

        TextView UserScore = this.findViewById(R.id.ScoreBox);


        if (UsersNumber == DiceNum) {

            TextView OutputMsg = this.findViewById(R.id.Response);
            OutputMsg.setText("Well Done");
            score = score + 1;
        } else {
            TextView OutputMsg = this.findViewById(R.id.Response);
            OutputMsg.setText("You Lose!");
        }

        TextView ScoreBox = this.findViewById(R.id.ScoreBox);
        ScoreBox.setText("You Score Is " + score);


    }



    public void roll_the_dice(View view) {

        Random r = new Random();
        int DiceNum = r.nextInt(6);

            switch(view.getId())
            {
                case R.id.button:
                        on_button_click(DiceNum);
                    break;
                case R.id.Icebreakers:
                        icebreaker_method(DiceNum);
                    break;
                default:
                    throw new RuntimeException("Unknown button ID");
            }

        }


        public void icebreaker_method (Integer DiceNum) {


            TextView OutputMsg = this.findViewById(R.id.numberTextView);
            TextView OutputMsg2 = this.findViewById(R.id.Response);
            OutputMsg2.setText("");

            switch (DiceNum) {
                case 1:

                    OutputMsg.setText("If you could go anywhere in the world, where would you go?");

                    break;
                case 2:

                    OutputMsg.setText("If you were stranded on a desert island, what three things would you want to take with you?");
                    break;
                case 3:

                    OutputMsg.setText("If you could eat only one food for the rest of your life, what would that be?");
                    break;
                case 4:

                    OutputMsg.setText("If you won a million dollars, what is the first thing you would buy?");
                    break;
                case 5:
                    OutputMsg.setText("If you could spaned the day with one fictional character, who would it be?");
                    break;
                case 6:

                    OutputMsg.setText("If you found a magic lantern and a genie gave you three wishes, what would you wish?");
                    break;

                default:
                    OutputMsg.setText("Error");
                    throw new IllegalStateException("Unexpected value: " + DiceNum);
        }


    }
}