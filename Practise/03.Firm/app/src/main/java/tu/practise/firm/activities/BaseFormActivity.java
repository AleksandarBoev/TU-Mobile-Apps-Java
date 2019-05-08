package tu.practise.firm.activities;

import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseFormActivity extends AppCompatActivity {
    protected void setTextViewText(int textViewId, String value) {
        TextView textView = findViewById(textViewId);
        textView.setText(value);
    }

    protected String getEditTextText(int editTextId) {
        EditText personNameEditText = findViewById(editTextId);
        return personNameEditText.getText().toString();
    }
}
