package tu.practise.firm.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        int b = 5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToTownForm(View view) {
        Intent intent = new Intent(this, TownFormActivity.class);
        startActivity(intent);
    }

    public void testCheckView(View view) {


    }
}
