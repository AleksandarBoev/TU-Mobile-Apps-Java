package tu.practise.firm.activities;

import androidx.appcompat.app.AppCompatActivity;
import tu.practise.firm.classes.Person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TownFormActivity extends BaseFormActivity {
    public TownFormActivity() {
        int a = 5;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_form);
    }

    public void goToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
