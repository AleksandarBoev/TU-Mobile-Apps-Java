package tu.practise.firm.activities;

import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseViewActivity extends AppCompatActivity {
    protected void fillSpinner(List<String> values, int spinnerId) {
        Spinner spinner = findViewById(spinnerId);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, values);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    protected String getSpinnerSelectedString(int spinnerId) {
        Spinner spinner = findViewById(spinnerId);
        return (String) spinner.getSelectedItem();
    }
}
