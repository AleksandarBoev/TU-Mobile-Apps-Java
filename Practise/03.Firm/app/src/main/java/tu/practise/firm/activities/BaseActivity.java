package tu.practise.firm.activities;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    protected void setTextViewText(int textViewId, String value) {
        TextView textView = findViewById(textViewId);
        textView.setText(value);
    }

    protected void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public abstract void back(View view);
}
