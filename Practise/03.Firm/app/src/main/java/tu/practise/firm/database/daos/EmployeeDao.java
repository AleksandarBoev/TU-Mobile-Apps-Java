package tu.practise.firm.database.daos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import tu.practise.firm.database.entities.Employee;

@Dao
public interface EmployeeDao {
    @Query("SELECT * FROM employees")
    List<Employee> getAllEmployees();

    @Delete
    void deleteEmployee(Employee employee);

    @Insert
    void saveEmployee(Employee employee);


}
