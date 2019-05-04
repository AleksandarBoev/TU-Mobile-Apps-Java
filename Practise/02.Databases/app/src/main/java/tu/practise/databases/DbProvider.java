package tu.practise.databases;

import android.app.Application;

import androidx.room.Room;
import app.database.AppDatabase;

public class DbProvider extends Application {
    private AppDatabase appDatabase;

    public DbProvider() {
        this.appDatabase = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "edication_db").build();
    }

    public AppDatabase getAppDatabase() {
        return this.appDatabase;
    }
}
