package app.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import app.domain.entities.Student;
import app.repository.StudentDao;

@Database(entities = {Student.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract StudentDao studentDao(); //interface as a field?
}
