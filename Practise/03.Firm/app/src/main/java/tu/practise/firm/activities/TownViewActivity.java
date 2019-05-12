package tu.practise.firm.activities;

import androidx.appcompat.app.AppCompatActivity;
import tu.practise.firm.domain.models.view.TownViewModel;
import tu.practise.firm.services.TownService;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

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
        nameTown = extractNamesTowns(townService);

        super.fillSpinner(new ArrayList<String>(nameTown.keySet()), R.id.town_names_spinner);
    }

    public void viewTown(View view) { //TODO what if user did not select anything?
        String selectedTownName = super.getSpinnerSelectedString(R.id.town_names_spinner);
        TownViewModel townViewModel = nameTown.get(selectedTownName);
        //TODO vizualize info
    }

    private Map<String, TownViewModel> extractNamesTowns(TownService townService) {
        List<TownViewModel> townViewModels = townService.getAll();
        Map<String, TownViewModel> nameTown = new TreeMap<>();
        for (TownViewModel townViewModel : townViewModels) {
            nameTown.put(townViewModel.getName(), townViewModel);
        }

        return nameTown;
    }
}
