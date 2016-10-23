package nyc.c4q.shannonalexander_navarro.simon;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

//TODO The memory game has four colored buttons, each flashing or "lighting up" when it is pressed or activated by the app. Each round in the game consists of the app lighting up one or more buttons in order, after which the player must press the buttons in the same order to advance to the next round.

//For each new round, the app will light up the buttons in the same order as in the previous rounds, then add a new randomly selected button to the end of the sequence. The number of buttons that light up and then must be pressed is always equal to the current round number.


public class MainActivity extends AppCompatActivity {
    Handler handler;
    private Button startButton;
    private Button redButton;
    private Button greenButton;
    private Button blueButton;
    private Button yellowButton;
    private TextView scoreTextView;
    private int round = 0;
    private Random random;
    private int randomNumber;
    int score = 0;
    boolean startClicked;
    ArrayList<View> colorsArray = new ArrayList<>();
    ArrayList<View> generatedGameArray = new ArrayList<>();

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
        scoreTextView = (TextView) findViewById(R.id.score_text_view);
        colorsArray.add(blueButton);
        colorsArray.add(greenButton);
        colorsArray.add(redButton);
        colorsArray.add(yellowButton);
    }


    public void randomButton() { //picks one random color, then adds to another arrayList

        random = new Random();
        int indexValue = random.nextInt(3);
        generatedGameArray.add(colorsArray.get(indexValue));
        for (int i = 0; i < generatedGameArray.size(); i++) {
            flashColor(colorsArray.get(indexValue), i);
        }
    }

    public void flashColor(View v, int index) {

        switch (v.getId()) {

            case R.id.button_blue:

                v.setBackgroundColor(0xFF00FFFF);//change color

                break;
            case R.id.button_green:

                v.setBackgroundColor(0xFF00FF00);//change color

                break;
            case R.id.button_red:
                v.setBackgroundColor(0XFFFF00FF);//change color

                break;
            case R.id.button_yellow:
                v.setBackgroundColor(0XFFFFFF00);//change color

                break;
        }
    }

    public void checkButtons(View v) {
        if (generatedGameArray.get(round).getId() == v.getId()) {
            Log.i("ARRAY SIZE", generatedGameArray.size() + "");
            Log.i("ARRAY ", generatedGameArray.toString());

            score++;
            round++;
            scoreTextView.setText(String.valueOf(score));
            randomButton();
        } else {
            Log.i("ARRAY ", generatedGameArray.toString());
            generatedGameArray.clear();
            round = 0;
            Toast.makeText(MainActivity.this, "You lose, start again.", Toast.LENGTH_SHORT).show();
            Log.i("ARRAY SIZE", generatedGameArray.size() + "");
            startButton.setVisibility(View.VISIBLE);
            startClicked = false;
            score = 0;
            scoreTextView.setText(String.valueOf(score));
            onRestart();
        }
    }

    public void buttonClicked(View v) { //check what button was clicked
        switch (v.getId()) {
            case R.id.start_button:
                startClicked = true;
                scoreTextView.setText(R.string.score_button);
                v.setVisibility(View.INVISIBLE);
                Toast.makeText(MainActivity.this, "Watch for the buttons to light up and then press them in that order.", Toast.LENGTH_SHORT).show();
                randomButton();
                gameRunning = true;
                break;
            case R.id.button_blue:
                if (startClicked) {
                    checkButtons(v);
                    break;
                }
                break;
            case R.id.button_green:
                if (startClicked) {
                    checkButtons(v);
                    break;
                }
                break;
            case R.id.button_red:
                if (startClicked) {
                    checkButtons(v);
                    break;
                }
                break;
            case R.id.button_yellow:
                if (startClicked) {
                    checkButtons(v);
                    break;
                }
                break;
        }

    }


}







