package tech.ericwathome.footballfixtures.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tech.ericwathome.footballfixtures.R;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        id = (EditText) findViewById(R.id.id);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strId = id.getText().toString();

                if (strId.isEmpty()){
                    Toast.makeText(MainActivity.this, "can't search without id", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, TrophiesActivity.class);
                    intent.putExtra("id", strId);
                    startActivity(intent);
                }
            }
        });
    }


}