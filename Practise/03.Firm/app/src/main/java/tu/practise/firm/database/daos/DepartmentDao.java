package tu.practise.firm.database.daos;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import tu.practise.firm.database.entities.Department;
import tu.practise.firm.domain.models.view.DepartmentViewModel;

@Dao
public interface DepartmentDao {
    @Query("SELECT * FROM departments")
    List<Department> getAllDepartments();

    @Query("SELECT " +
            "d.id AS id, " +
            "d.name AS name, " +
            "printf('%s %s', e.first_name, e.last_name) AS manager_name, " +
            "e.position AS manager_position, " +
            "t.name AS town_name " +
            "FROM departments d " +
            "INNER JOIN employees e " +
            "ON d.manager_id = e.id " +
            "INNER JOIN towns t " +
            "ON d.town_id = t.id")
    List<DepartmentViewModel> getAllDepartmentViews();

    @Query("SELECT " +
            "d.id AS id, " +
            "d.name AS name, " +
            "printf('%s %s', e.first_name, e.last_name) AS manager_name, " +
            "e.position AS manager_position, " +
            "t.name AS town_name " +
            "FROM departments d " +
            "INNER JOIN employees e " +
            "ON d.manager_id = e.id " +
            "INNER JOIN towns t " +
            "ON d.town_id = t.id " +
            "WHERE d.id = :id " +
            "LIMIT 1")
    DepartmentViewModel getDepartmentViewById(Integer id);

    @Update
    void updateDepartment(Department department);

    @Insert
    void saveDepartment(Department department);

    @Delete
    void deleteDepartment(Department department);
}
