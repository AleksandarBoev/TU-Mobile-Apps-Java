package tu.practise.firm.activities;

import tu.practise.firm.domain.models.view.TownViewModel;
import tu.practise.firm.services.TownService;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TownViewActivity extends BaseViewActivity {
    private Map<String, TownViewModel> nameTown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town_view);
        TownService townService = ((FirmApplication)getApplication()).getTownService();
        nameTown = extractViewModels(townService);

        super.fillSpinner(new ArrayList<String>(nameTown.keySet()), R.id.town_names_spinner);
    }

    @Override
    public void visualize(View view) {
        String selectedTownName = super.getSpinnerSelectedString(R.id.town_names_spinner);

        if (selectedTownName == null || "".equals(selectedTownName))
            return;

        TownViewModel townViewModel = nameTown.get(selectedTownName);
        super.setTextViewText(R.id.visualizeNameTextView, townViewModel.getName());
        super.setTextViewText(R.id.visualizePostalCodeTextView, "" + townViewModel.getPostalCode());
    }

    private Map<String, TownViewModel> extractViewModels(TownService townService) {
        List<TownViewModel> townViewModels = townService.getAll();
        Map<String, TownViewModel> nameTown = new TreeMap<>();
        for (TownViewModel townViewModel : townViewModels) {
            nameTown.put(townViewModel.getName(), townViewModel);
        }

        return nameTown;
    }

    @Override
    public void back(View view) {
        super.toMainActivity();
    }
}
