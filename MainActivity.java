package com.example.android.quizproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int result = 0;

    // Calculates the result

    // Where is Spain Radio Button is clicked
    public void onWhereIsSpainClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.europe:
                if (checked)
                    // Right answer
                    result = result + 1;
                break;
            case R.id.south_america:
                if (checked)
                    // wrong answer
                    break;
            case R.id.who_knows:
                if (checked)
                    // Come on, that's a truly stupid answer
                    result = result - 1;
                break;
        }
    }

    // People speaking Spanish radio button is clicked
    public void onpeopleSpeakingSpanish(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rightAnswer_Spanish:
                if (checked)
                    // Right answer
                    result = result + 1;
                break;
            case R.id.wrongAnswer_Spanish:
                if (checked)
                    // Wrong answer
                    break;
            case R.id.stupidAnswer_Spanish:
                if (checked)
                    // Come on, that's a truly stupid answer
                    result = result - 1;
                break;
        }
    }

    // Olive Oil is clicked
    public void onoliveoil(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rightAnswer_oil:
                if (checked)
                    // Right answer
                    result = result + 1;
                break;
            case R.id.wrongAnswer_oil:
                if (checked)
                    // wrong answer
                    break;
            case R.id.stupidAnswer_oil:
                if (checked)
                    // Come on, that's a truly stupid answer
                    result = result - 1;
                break;
        }
    }
    // Wine radio button is clicked
    public void onWine(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rigthAnswer_Wine:
                if (checked)
                    // Right answer
                    result = result + 1;
                break;
            case R.id.wrongAnswer_Wine:
                if (checked)
                    // Wrong answer
                    break;
            case R.id.stupidAnswer_Wine:
                if (checked)
                    // Come on, that's a truly stupid answer
                    result = result - 1;
                break;
        }
    }

    // Tourist radio button is clicked
    public void onTourists(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rigthAnswer_tourists:
                if (checked)
                    // Right answer
                    result = result + 1;
                break;
            case R.id.wrongAnswer_tourists:
                if (checked)
                    // Wrong answer
                    break;
            case R.id.stupidAnswer_tourists:
                if (checked)
                    // Come on, that's a truly stupid answer
                    result = result - 1;
                break;
        }
    }
    // Amount of Tourist radio button is clicked
    public void onMostPopular (View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rightAnswer_amountTourists:
                if (checked)
                    // Right answer
                    result = result + 1;
                break;
            case R.id.wrongAnswer_amountTourists:
                if (checked)
                    // Wrong answer
                    break;
            case R.id.stupidAnswer_amountTourists:
                if (checked)
                    // Come on, that's a truly stupid answer
                    result = result - 1;
                break;
        }
    }
    // Is the More info checkbox checked?
    public void moreInfoChecked(View view) { }

    // Show result when Result Button is pressed

    public void createResult(View view) {
        // Get user's name
        EditText nameField = (EditText) findViewById(R.id.nameField);
        String name = nameField.getText().toString();

        //Check which checkbox was clicked and creates message
        CheckBox wantsMoreGeneralInfo = (CheckBox) findViewById(R.id.general_info);
        CheckBox wantsMoreInfoGastronomy = (CheckBox) findViewById(R.id.info_gastronomy);

        String strMessage = "";
        if (wantsMoreInfoGastronomy.isChecked()) {
            strMessage += "\n\nGreat to hear you want to know more about Spanish food. Please visit https://spainguides.com/gastronomy-of-spain/";
        }
        if (wantsMoreGeneralInfo.isChecked()) {
            strMessage += "\n\nYou can find some interesting information about Spain in Spanish official website http://www.spain.info/en/";
        }
        //Gives different messages depending on the results
        String testMessage = "";
        if (result == 6){
            testMessage += "\n\nCongratulations! Your knowlegde about Spain is awesome!.";}
        else if (result <= 0){
            testMessage += "\n\nYou clearly need to visit Spain soon to know more about us!";}
        if (result < 6 & result > 0){
            testMessage += "\n\nYou have good knowledge about Spain but I encourage you to visit us soon to improve it.";}

        // Creates final message
        String resultMessage = "Dear " + name + "\n" + "This is your result: " + result + testMessage + strMessage;
        // Sends the message to an e-mail
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));  // This ensures only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Spanish test Results and more for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, resultMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
       }
      }


