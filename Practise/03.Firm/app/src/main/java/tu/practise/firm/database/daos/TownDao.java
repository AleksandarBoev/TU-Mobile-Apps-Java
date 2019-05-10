package tu.practise.firm.database.daos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import tu.practise.firm.database.entities.Town;

@Dao
public interface TownDao {
    @Query(value = "SELECT * FROM towns LIMIT 100")
    List<Town> getTowns();

    @Query(value = "SELECT * FROM towns t WHERE t.id = :id LIMIT 1")
    Town getTownById(Integer id);

    @Query(value = "SELECT * FROM towns t ORDER BY t.name ASC LIMIT 100")
    List<Town> getTownsSortedByNameAsc();

    @Query(value = "SELECT * FROM towns t WHERE t.postal_code = :postalCode")
    Town getTownByPostalCode(Integer postalCode);

    @Insert
    void saveTown(Town town);

    @Delete
    void deleteTown(Town town);
}
