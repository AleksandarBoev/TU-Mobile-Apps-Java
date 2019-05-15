package tu.practise.firm.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import tu.practise.firm.database.daos.DepartmentDao;
import tu.practise.firm.database.daos.EmployeeDao;
import tu.practise.firm.database.daos.TownDao;
import tu.practise.firm.database.entities.Department;
import tu.practise.firm.database.entities.Employee;
import tu.practise.firm.database.entities.Town;

@Database(entities = {Town.class, Employee.class, Department.class}, version = 2, exportSchema = false)
public abstract class FirmDatabase extends RoomDatabase {
    public abstract TownDao townDao();
    public abstract EmployeeDao employeeDao();
    public abstract DepartmentDao departmentDao();
}
