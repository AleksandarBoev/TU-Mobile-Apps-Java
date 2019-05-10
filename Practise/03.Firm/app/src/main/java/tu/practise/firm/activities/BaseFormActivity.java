package tu.practise.firm.activities;

import android.content.Intent;
import android.view.View;
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

    protected void toMainActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public abstract void cancel(View view);

//    public void cancel(View view) { //does not show up in the layout "onClick" drop down menu this way
//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);
//    }

    public abstract void save(View view);
}
