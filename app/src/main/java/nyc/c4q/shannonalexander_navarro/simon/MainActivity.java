package nyc.c4q.shannonalexander_navarro.simon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

//TODO The memory game has four colored buttons, each flashing or "lighting up" when it is pressed or activated by the app. Each round in the game consists of the app lighting up one or more buttons in order, after which the player must press the buttons in the same order to advance to the next round.

//For each new round, the app will light up the buttons in the same order as in the previous rounds, then add a new randomly selected button to the end of the sequence. The number of buttons that light up and then must be pressed is always equal to the current round number.


public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private Button redButton;
    private Button greenButton;
    private Button blueButton;
    private Button yellowButton;
    private int round = 0;
    ArrayList<View> colorsArray = new ArrayList<>();
    private Random random;
    private int randomNumber;
    ArrayList<View> generatedGameArray = new ArrayList<>();
   // ArrayList<View> userButtonsPicked = new ArrayList<>();
    int score = 0;

    //private Handler time;
    private int buttonIndex = 0;
    boolean gameRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.start_button);
        blueButton = (Button) findViewById(R.id.button_blue);
        greenButton = (Button) findViewById(R.id.button_green);
        redButton = (Button) findViewById(R.id.button_red);
        yellowButton = (Button) findViewById(R.id.button_yellow);
        //colorsArray = {//array of buttons, this is correct?
        colorsArray.add(findViewById(R.id.button_blue));
        colorsArray.add(findViewById(R.id.button_green));
        colorsArray.add(findViewById(R.id.button_red));
        colorsArray.add(findViewById(R.id.button_yellow));

      //  initializeViews(); //find view by id methods


    }


    public void randomButton() { //picks one random color, then adds to another arrayList

        random = new Random();
        int indexValue = random.nextInt(colorsArray.size());
        generatedGameArray.add(colorsArray.get(indexValue));
    }


    public void playGame(){
   // gameRunning = true;
        while (gameRunning) {
            for (int i = 0; i < generatedGameArray.size(); i++) {
                buttonClicked(generatedGameArray.get(i));

            }
        }

    }
    public void buttonClicked(View v) { //check what button was clicked

        switch (v.getId()) {
            case R.id.start_button:
                Toast.makeText(MainActivity.this, "Watch for the buttons to light up and then press them in that order.", Toast.LENGTH_SHORT).show();
                randomButton();
                gameRunning = true;
              // playGame();
                break;
            case R.id.button_blue:
                if (generatedGameArray.get(round).getId() == v.getId()){
                    score += 1;
                    randomButton();
                } else {
                    Toast.makeText(MainActivity.this, "You lose, start again.", Toast.LENGTH_SHORT).show();
                    onRestart();
                }
//change color of button
                //if button picked is correct generate a new color here?
                break;
            case R.id.button_green:
                if (generatedGameArray.get(round).getId() == v.getId()){
                    score += 1;
                    randomButton();
                } else {
                    Toast.makeText(MainActivity.this, "You lose, start again.", Toast.LENGTH_SHORT).show();
                    onRestart();
                }
                break;
            case R.id.button_red:
                if (generatedGameArray.get(round).getId() == v.getId()){
                    score += 1;
                    randomButton();
                } else {
                    Toast.makeText(MainActivity.this, "You lose, start again.", Toast.LENGTH_SHORT).show();
                    onRestart();
                }

                break;
            case R.id.button_yellow:
                if (generatedGameArray.get(round).getId() == v.getId()){
                    score += 1;
                    randomButton();
                } else {
                    Toast.makeText(MainActivity.this, "You lose, start again.", Toast.LENGTH_SHORT).show();
                    onRestart();
                }

                break;
        }

    }


//    //need to click start button , need on click listener to do this
//    public void initializeViews() { // might not need this
//        startButton = (Button) findViewById(R.id.start_button);
//        redButton = (Button) findViewById(R.id.button_red);
//        greenButton = (Button) findViewById(R.id.button_green);
//        blueButton = (Button) findViewById(R.id.button_blue);
//        yellowButton = (Button) findViewById(R.id.button_yellow);
//    }


}







