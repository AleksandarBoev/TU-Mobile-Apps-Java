package tu.practise.firm.activities;

import android.app.Application;

import tu.practise.firm.database.FirmDatabase;
import tu.practise.firm.services.DepartmentService;
import tu.practise.firm.services.DepartmentServiceImpl;
import tu.practise.firm.services.TownService;
import tu.practise.firm.services.TownServiceImpl;

public class FirmApplication extends Application {
    private FirmDatabase firmDatabase;
    private TownService townService;
    private DepartmentService departmentService;

    public void setUp(FirmDatabase firmDatabase) {
        this.firmDatabase = firmDatabase;
        this.townService = new TownServiceImpl(this.firmDatabase);
        this.departmentService = new DepartmentServiceImpl(this.firmDatabase.departmentDao());
    }

    public FirmDatabase getFirmDatabase() {
        return firmDatabase;
    }

    public TownService getTownService() {
        return townService;
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }
}
