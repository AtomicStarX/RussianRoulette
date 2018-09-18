package org.ieselcaminas.pmdm.russianroulette;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button randomButton;
    Button[] buttons = new Button[6];
    TextView textView;
    ImageView imageView;
    Button buttonReload;
    Boolean gameOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        randomButton = createRandomButton();

        initViews();
        initGame();

        buttonReload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initGame();
            }
        });

        for (Button button : buttons) {
            button.setOnClickListener(this);
        }
    }


    @Override
    public void onClick(View v) {
        if (v.equals(randomButton)) {
            textView.setVisibility(View.VISIBLE);
            imageView.setBackgroundColor(getResources().getColor(R.color.newBackGroundColor));
            gameOver = true;
            v.setBackgroundColor(getResources().getColor(R.color.gameOverButtonColor));
        } else {
            v.setEnabled(false);
        }
    }

    //Init Views And Game
    public void initGame() {
        gameOver = false;
        createRandomButton();
        imageView.setBackgroundColor(getResources().getColor(R.color.backGroundColor));
        textView.setVisibility(View.INVISIBLE);
        for (Button button : buttons) {
            button.setEnabled(true);
        }
    }

    public void initViews() {
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);

        buttonReload = findViewById(R.id.buttonReload);
        textView = findViewById(R.id.textView);
        imageView = findViewById(R.id.imageViewBackground);

    }

    //Create Random Button
    public Button createRandomButton() {
        int n = (int) (Math.random() * 6);
        randomButton = buttons[n];
        return randomButton;
    }

}
