package tu.practise.firm.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import tu.practise.firm.database.daos.TownDao;
import tu.practise.firm.database.entities.Town;

@Database(entities = {Town.class}, version = 1, exportSchema = false)
public abstract class FirmDatabase extends RoomDatabase {
    public abstract TownDao townDao();
}
