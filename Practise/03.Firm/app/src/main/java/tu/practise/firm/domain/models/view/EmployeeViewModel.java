package tu.practise.firm.domain.models.view;

import java.math.BigDecimal;
import java.sql.Date;

import androidx.room.ColumnInfo;

public class EmployeeViewModel {
    @ColumnInfo(name = "full_name")
    private String fullName;
    @ColumnInfo(name = "department_id")
    private Integer departmentId;
    private BigDecimal salary;
    private String position;
    @ColumnInfo(name = "date_of_hire")
    private Date dateOfHire;
    @ColumnInfo(name = "department_name")
    private String departmentName;
    @ColumnInfo(name = "town_name")
    private String townName;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getDateOfHire() {
        return dateOfHire;
    }

    public void setDateOfHire(Date dateOfHire) {
        this.dateOfHire = dateOfHire;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
