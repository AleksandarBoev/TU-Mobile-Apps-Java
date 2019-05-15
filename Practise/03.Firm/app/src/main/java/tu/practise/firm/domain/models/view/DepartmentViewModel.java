package tu.practise.firm.domain.models.view;

import androidx.room.ColumnInfo;
import androidx.room.Ignore;

public class DepartmentViewModel {
    private Integer id;
    private String name;
    @ColumnInfo(name = "manager_name")
    private String managerName;
    @ColumnInfo(name = "manager_position")
    private String managerPosition;
    @ColumnInfo(name = "town_name")
    private String townName;

    public DepartmentViewModel(){

    }

    @Ignore
    public DepartmentViewModel(Integer id, String name, String managerName, String managerPosition, String townName) {
        this.id = id;
        this.name = name;
        this.managerName = managerName;
        this.managerPosition = managerPosition;
        this.townName = townName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPosition() {
        return managerPosition;
    }

    public void setManagerPosition(String managerPosition) {
        this.managerPosition = managerPosition;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }
}
