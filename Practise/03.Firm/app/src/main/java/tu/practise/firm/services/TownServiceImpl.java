package tu.practise.firm.services;

import java.util.List;

import tu.practise.firm.classes.PersonBindingModel;
import tu.practise.firm.classes.PersonViewModel;
import tu.practise.firm.database.FirmDatabase;

public class TownServiceImpl extends BaseFirmServiceImpl implements TownService {
    public TownServiceImpl(FirmDatabase firmDatabase) {
        super(firmDatabase);
    }

    @Override
    public List<PersonViewModel> getAll() {
        return null;
    }

    @Override
    public PersonViewModel getById(Integer integer) {
        return null;
    }

    @Override
    public void save(PersonBindingModel object) {

    }
}
