package tu.practise.databaseproject;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface StudentDao {
    @Insert
    void save(Student student);

    @Query("SELECT * FROM students LIMIT 100")
    List<Student> getAll();

    @Query("SELECT * FROM students s WHERE s.id = :id LIMIT 1")
    Student getStudentById(int id);
}
