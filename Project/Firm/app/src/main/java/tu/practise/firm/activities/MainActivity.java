package tu.practise.firm.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import tu.practise.firm.database.FirmDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirmApplication firmApplication = (FirmApplication) this.getApplication();

        if (firmApplication.getFirmDatabase() == null) {
            FirmDatabase firmDb = Room.databaseBuilder(getApplicationContext(),
                    FirmDatabase.class, "firm_db").allowMainThreadQueries().build();
            firmApplication.setUp(firmDb);
        }
    }

    public void goToTownFormActivity(View view) {
        Intent intent = new Intent(this, TownFormActivity.class);
        startActivity(intent);
    }

    public void goToViewTownActivity(View view) {
        Intent intent = new Intent(this, TownViewActivity.class);
        startActivity(intent);
    }
}
