package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {
    int numberOfTaps = 0;
    int startServiceAt = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        // Intent for service
        if(numberOfTaps > startServiceAt) {
            Intent serviceIntent = new Intent(PracticalTest01Var04MainActivity.this,
                    PracticalTest01Var04Service.class);

            EditText editText = findViewById(R.id.editText);
            serviceIntent.putExtra("template", editText.getText().toString());

            startService(serviceIntent);
        }

        // Intent from second activity
        Intent intent = getIntent();
        if(intent != null) {
            // Restart fields
            EditText editText = findViewById(R.id.editText);
            editText.setText("");
            numberOfTaps = 0;

            // Toast message
            String response = intent.getStringExtra("response");
            Toast.makeText(this, response, Toast.LENGTH_LONG).show();

        }

        // Listener for buttons
        final Button buttonTopLeft = findViewById(R.id.buttonTopLeft);
        buttonTopLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setText(buttonTopLeft);
            }
        });

        final Button buttonTopRight = findViewById(R.id.buttonTopRight);
        buttonTopRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setText(buttonTopRight);
            }
        });

        final Button buttonCenter = findViewById(R.id.buttonCenter);
        buttonCenter.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setText(buttonCenter);
            }
        });

        final Button buttonBottomLeft = findViewById(R.id.buttonBottomLeft);
        buttonBottomLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setText(buttonBottomLeft);
            }
        });

        final Button buttonBottomRight = findViewById(R.id.buttonBottomRight);
        buttonBottomRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setText(buttonBottomRight);
            }
        });

        // Listener for navigating to the next activity
        Button buttonNavigation = findViewById(R.id.buttonNavigation);
        buttonNavigation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText editText = findViewById(R.id.editText);
                Intent intent = new Intent(PracticalTest01Var04MainActivity.this,
                        PracticalTest01Var04SecondaryActivity.class);

                intent.putExtra("template", editText.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void setText(Button button) {
        numberOfTaps++;
        EditText editText = findViewById(R.id.editText);
        String text = editText.getText().toString();
        text += " " + button.getText().toString() + ",";
        editText.setText(text);

        Log.d("Tap Updated", String.valueOf(numberOfTaps));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String text = savedInstanceState.getString("editText");
        if( text != null)
        {
            EditText editText = findViewById(R.id.editText);
            editText.setText(text);
            Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        }
    }
}
