//package nyc.c4q.shannonalexander_navarro.simon;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//
//import java.util.Random;
//
//public class ButtonSequence extends AppCompatActivity implements View.OnClickListener {
//
//    private Button[] buttonSequence; //this needs to be an empty array that i add the button order to, then check against user input
//
//    public  Button[] colorBank;
//    Button redBtn;
//    Button blueBtn;
//    Button greenBtn;
//    Button yellowBtn;
//
//    public void initializeColors() {
//        colorBank = new Button[]{ //this is an array of button objects
//                new Button(R.id.button_red), //need to reference button id
//                new Button(R.id.button_yellow),
//                new Button(R.id.button_green),
//                new Button(R.id.button_blue)
//        };
//      //  updateColors();
//    }
//
//    public static int randomButton(int[] array){
//        int rnd = new Random().nextInt(colorBank.length);
//        return array[rnd];
//    }
//
////    public ButtonSequence() {
////        buttonSequence = new Button[]{
//// store the sequence game picks}
//public void userButtonSequence() {}
////        userButtonSequence = new Button[]{
////          store the sequence user picks
////        };
////    }
//
////    //  private int currentIndex = 0;
////
////    public void pickButton(){
////
////    }
////    public void addButtonsToArray() {
////
////        updateButton(); //this method will add buttons to the sequence
////    }
////4
////    @Override
////    public void onClick(View view) {
////
////    }
//}