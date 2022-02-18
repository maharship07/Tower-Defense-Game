import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.java.R;

import java.util.concurrent.atomic.AtomicInteger;

public class ConfigScreen extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_screen);
        TextView diffText = findViewById(R.id.diffText);
        Button easyButton = findViewById(R.id.easyButton);
        Button normalButton = findViewById(R.id.normalButton);
        Button hardButton = findViewById(R.id.hardButton);
        EditText playerName = findViewById(R.id.playerName);
        String name = playerName.getText().toString();
        AtomicInteger currDiff = new AtomicInteger(1);
        easyButton.setOnClickListener(l -> {
            currDiff.set(0);
            diffText.setText("Current Difficulty: Easy");
        });
        normalButton.setOnClickListener(l -> {
            currDiff.set(1);
            diffText.setText("Current Difficulty: Normal");
        });
        hardButton.setOnClickListener(l -> {
            currDiff.set(2);
            diffText.setText("Current Difficulty: Hard");
        });

        Button startButton = findViewById(R.id.startGame);
        startButton.setOnClickListener(l -> {
            if (name != null && !name.trim().isEmpty() && diffText.getText().toString() != null && !diffText.getText().toString().trim().isEmpty()) {
                Intent i = new Intent(this, GameScreen.class);
                i.putExtra("diff", currDiff.get());
                startActivity(i);
                finish();
            }
        });
    }
}
