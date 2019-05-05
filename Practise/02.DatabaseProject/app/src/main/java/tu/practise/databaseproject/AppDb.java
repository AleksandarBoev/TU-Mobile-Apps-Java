package tu.practise.databaseproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
public abstract class AppDb extends RoomDatabase {
    public abstract StudentDao studentDao();
}
