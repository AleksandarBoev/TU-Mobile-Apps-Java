package tu.practise.databases;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import app.database.AppDatabase;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "education_db").build();

        setContentView(R.layout.activity_main);
    }

    public void buttonSend(View view) {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }
}
