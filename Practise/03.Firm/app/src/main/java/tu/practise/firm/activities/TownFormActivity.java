package tu.practise.firm.activities;

import tu.practise.firm.domain.models.binding.TownBindingModel;
import tu.practise.firm.exceptions.InvalidTownException;
import tu.practise.firm.services.TownService;
import tu.practise.firm.services.TownServiceImpl;

import android.os.Bundle;
import android.view.View;

public class TownFormActivity extends BaseFormActivity {
    private TownService townService;

    public TownFormActivity() {

    }

    public TownFormActivity(TownService townService) { //for unit testing
        this.townService = townService;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_form);
        FirmApplication firmApplication = (FirmApplication) this.getApplication();
        townService = firmApplication.getTownService();
    }

    @Override
    public void cancel(View view) {
        super.toMainActivity();
    }

    @Override
    public void save(View view) {
        String townName = super.getEditTextText(R.id.townNameEditText);
        Integer townPostalCode = null;
        try {
            townPostalCode = Integer.parseInt(super.getEditTextText(R.id.townPostalCodeEditText).trim());
        } catch (NumberFormatException nfe) {
            super.setTextViewText(R.id.errorTextView, TownServiceImpl.INVALID_TOWN_POSTAL_CODE);
            return;
        }

        TownBindingModel townBindingModel = new TownBindingModel(townName, townPostalCode);
        try {
            townService.save(townBindingModel);
            super.toMainActivity();
        } catch (InvalidTownException ite) {
            super.setTextViewText(R.id.errorTextView, ite.getMessage());
        }
    }
}
