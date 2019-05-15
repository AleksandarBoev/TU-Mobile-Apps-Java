package tu.practise.firm.activities;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseFormActivity extends BaseActivity {
    public abstract void save(View view);

    protected String getEditTextText(int editTextId) {
        EditText personNameEditText = findViewById(editTextId);
        return personNameEditText.getText().toString();
    }
}
