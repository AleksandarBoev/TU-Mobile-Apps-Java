package tu.practise.databaseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static AppDb appDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void createAndSave(View view) {
        EditText studentNameEditText = findViewById(R.id.student_name_edit_text);
        String studentName = studentNameEditText.getText().toString();

        Student student = new Student();
        student.setName(studentName);

        AppDb appDb = Room.databaseBuilder(getApplicationContext(),
                AppDb.class, "school_db").build();

        try {
            appDb.studentDao().save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
