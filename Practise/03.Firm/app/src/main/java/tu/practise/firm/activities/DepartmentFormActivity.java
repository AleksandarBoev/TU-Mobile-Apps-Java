package tu.practise.firm.activities;

import androidx.appcompat.app.AppCompatActivity;
import tu.practise.firm.domain.models.binding.DepartmentBindingModel;
import tu.practise.firm.exceptions.InvalidDepartmentException;
import tu.practise.firm.services.DepartmentService;

import android.os.Bundle;
import android.view.View;

public class DepartmentFormActivity extends BaseFormActivity {
    DepartmentService departmentService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_form);

        this.departmentService = ((FirmApplication)getApplication()).getDepartmentService();
    }

    @Override
    public void save(View view) {
        String departmentName = super.getEditTextText(R.id.departmentNameEditText);
        String departmentManagerId = super.getEditTextText(R.id.departmentManagerIdEditText);
        String departmentTownId = super.getEditTextText(R.id.departmentTownIdEditText);

        Integer departmentManagerIdValue, departmentTownIdValue;

        try {
            departmentManagerIdValue = Integer.parseInt(departmentManagerId);
        } catch (NumberFormatException nfe) {
            departmentManagerIdValue = null;
        }

        try {
            departmentTownIdValue = Integer.parseInt(departmentTownId);
        } catch (NumberFormatException nfe) {
            departmentTownIdValue = null;
        }

        DepartmentBindingModel departmentBindingModel =
                new DepartmentBindingModel(departmentName, departmentManagerIdValue, departmentTownIdValue);

        try {
            departmentService.save(departmentBindingModel);
        } catch (InvalidDepartmentException ide) {
            //TODO set text view with ide.getMessage()
        }
        super.toMainActivity();
    }

    @Override
    public void back(View view) {
        super.toMainActivity();
    }
}
