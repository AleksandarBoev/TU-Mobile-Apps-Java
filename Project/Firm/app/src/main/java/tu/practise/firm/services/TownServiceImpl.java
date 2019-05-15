package tu.practise.firm.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import tu.practise.firm.database.FirmDatabase;
import tu.practise.firm.database.entities.Town;
import tu.practise.firm.domain.models.binding.TownBindingModel;
import tu.practise.firm.domain.models.view.TownViewModel;
import tu.practise.firm.exceptions.InvalidTownException;
import tu.practise.firm.utils.CustomModelMapper;

public class TownServiceImpl extends BaseFirmServiceImpl implements TownService {
    public static final String INVALID_TOWN_NAME_NULL_MESSAGE = "Town name is null!";

    public static final int TOWN_NAME_MIN_LENGTH = 3;
    public static final int TOWN_NAME_MAX_LENGTH = 20;
    public static final String INVALID_TOWN_NAME_LENGTH_MESSAGE =
            "Town name should be between " + TOWN_NAME_MIN_LENGTH + " and " +
                    TOWN_NAME_MAX_LENGTH + " characters long";

    public static final String TOWN_NAME_REGEX = "^[A-Z][a-z]+(( [A-Z][a-z]+)?)*";
    public static final String INVALID_TOWN_NAME_FORMAT_MESSAGE =
            "Town name should contain only alphabetic letters and each new word should" +
                    " start with an upper case letter followed by lower case letters";

    public static final String INVALID_TOWN_POSTAL_CODE = "Postal code should be a 4 digit integer!";
    public static final int POSTAL_CODE_REQUIRED_LENGTH = 4;

    public TownServiceImpl(FirmDatabase firmDatabase) {
        super(firmDatabase);
    }

    @Override
    public List<TownViewModel> getAll() {
        List<Town> towns = super.getFirmDatabase().townDao().getTowns();
        List<TownViewModel> result = new ArrayList<>(towns.size());

        for (Town town : towns) {
            TownViewModel townViewModel = new TownViewModel();
            CustomModelMapper.map(town, townViewModel);
            result.add(townViewModel);
        }

        return result;
    }

    @Override
    public TownViewModel getById(Integer integer) {
        if (integer == null)
            return null;

        TownViewModel townViewModel = new TownViewModel();
        Town town = super.getFirmDatabase().townDao().getTownById(integer);
        CustomModelMapper.map(townViewModel, town);
        return townViewModel;
    }

    @Override
    public void save(TownBindingModel townBindingModel) {
        validateBindingModel(townBindingModel);
        Town town = new Town();
        CustomModelMapper.map(townBindingModel, town);
        super.getFirmDatabase().townDao().saveTown(town);
    }


    private void validateBindingModel(TownBindingModel townBindingModel) {
        validateTownNameNotNull(townBindingModel.getName());
        validateTownNameLength(townBindingModel.getName());
        validateTownNameFormat(townBindingModel.getName());
        validateTownPostalCode(townBindingModel.getPostalCode());
    }

    private void validateTownNameNotNull(String townName) {
        if (townName == null) {
            throw new InvalidTownException(INVALID_TOWN_NAME_NULL_MESSAGE);
        }
    }

    private void validateTownNameLength(String townName) {
        townName = townName.trim();
        if (townName.length() < TOWN_NAME_MIN_LENGTH || townName.length() > TOWN_NAME_MAX_LENGTH)
            throw new InvalidTownException(INVALID_TOWN_NAME_LENGTH_MESSAGE);
    }

    private void validateTownNameFormat(String townName) {
        Pattern pattern = Pattern.compile(TOWN_NAME_REGEX);
        Matcher matcher = pattern.matcher(townName);

        if (!matcher.matches())
            throw new InvalidTownException(INVALID_TOWN_NAME_FORMAT_MESSAGE);
    }

    private void validateTownPostalCode(Integer postalCode) {
        if (("" + postalCode).length() != POSTAL_CODE_REQUIRED_LENGTH)
            throw new InvalidTownException(INVALID_TOWN_POSTAL_CODE);
    }
}
