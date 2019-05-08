package tu.practise.databaseproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static String SPINNER_SELECTED_VALUE_KEY = "tu.practise.databaseproject.SPINNER_VALUE";
    private Map<String, Student> nameStudent;

    public AppDb appDb; //is null every time the activity is entered. Can't be static. Can't store it in "Application", because it is initialized via application context

    public AppDb getAppDb() {
        if (appDb == null) {
            appDb = Room.databaseBuilder(getApplicationContext(),
                    AppDb.class, "school_db").allowMainThreadQueries().build();
        }
        return appDb;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) { //called every time when entering this activity
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> studentList = getAppDb().studentDao().getAll();
        this.nameStudent = this.listToMap(studentList);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                new ArrayList<>(this.nameStudent.keySet()));

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void createAndSave(View view) {
        EditText studentNameEditText = findViewById(R.id.student_name_edit_text);
        String studentName = studentNameEditText.getText().toString();

        if ("".equals(studentName.trim()))
            return;

        Student student = new Student();
        student.setName(studentName);

        try {
            getAppDb().studentDao().save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void goToAnotherActivity(View view) {
        Spinner spinner = findViewById(R.id.spinner);
        String studentName = (String) spinner.getSelectedItem();
        Student student = this.nameStudent.get(studentName);
        StudentViewModel studentViewModel = new StudentViewModel();
        studentViewModel.setName(student.getName());
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(SPINNER_SELECTED_VALUE_KEY, studentViewModel);
        startActivity(intent);
    }

    private Map<String, Student> listToMap(List<Student> studentList) {
        Map<String, Student> result = new LinkedHashMap<>();

        for (Student student : studentList) {
            result.put(student.getName(), student);
        }

        return result;
    }
}
