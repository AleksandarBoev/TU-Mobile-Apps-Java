package tu.practise.firm.services;

import tu.practise.firm.database.FirmDatabase;

public abstract class BaseFirmServiceImpl {
    private FirmDatabase firmDatabase;

    protected BaseFirmServiceImpl(FirmDatabase firmDatabase) {
        this.firmDatabase = firmDatabase;
    }

    protected FirmDatabase getFirmDatabase() {
        return firmDatabase;
    }
}
