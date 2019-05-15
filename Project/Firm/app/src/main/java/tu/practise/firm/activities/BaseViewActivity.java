package tu.practise.firm.activities;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;


public abstract class BaseViewActivity extends BaseActivity {
    public abstract void visualize(View view);

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
