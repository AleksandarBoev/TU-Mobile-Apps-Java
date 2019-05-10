package tu.practise.firm.activities;

import android.app.Application;

import tu.practise.firm.database.FirmDatabase;
import tu.practise.firm.services.TownService;
import tu.practise.firm.services.TownServiceImpl;

public class FirmApplication extends Application {
    private FirmDatabase firmDatabase;
    private TownService townService;

    public void setUp(FirmDatabase firmDatabase) {
        this.firmDatabase = firmDatabase;
        this.townService = new TownServiceImpl(this.firmDatabase);
    }

    public FirmDatabase getFirmDatabase() {
        return firmDatabase;
    }

    public TownService getTownService() {
        return townService;
    }
}
