package tu.practise.databaseproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        StudentViewModel selectedStudent = intent.getParcelableExtra(MainActivity.SPINNER_SELECTED_VALUE_KEY);

        TextView textView = findViewById(R.id.textViewActivity2);
        textView.setText(selectedStudent.getName());
    }

    public void goToActivity1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
