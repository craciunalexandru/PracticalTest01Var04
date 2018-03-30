package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        Intent intent = getIntent();
        if(intent != null)
        {
            EditText editText = findViewById(R.id.editText);
            String template = intent.getStringExtra("template");
            editText.setText(template);
        }

        // Listeners for buttons
        Button buttonVerify = findViewById(R.id.buttonVerify);
        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticalTest01Var04SecondaryActivity.this,
                        PracticalTest01Var04MainActivity.class);

                intent.putExtra("response", "Verify");
                startActivity(intent);
            }
        });

        Button buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PracticalTest01Var04SecondaryActivity.this,
                        PracticalTest01Var04MainActivity.class);

                intent.putExtra("response", "Cancel");
                startActivity(intent);
            }
        });
    }
}
