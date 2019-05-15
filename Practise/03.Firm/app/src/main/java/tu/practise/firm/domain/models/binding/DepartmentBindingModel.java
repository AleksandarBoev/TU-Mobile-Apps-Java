package tu.practise.firm.domain.models.binding;

public class DepartmentBindingModel {
    private String name;

    private Integer managerId;
    private Integer townId;

    public DepartmentBindingModel() {
    }

    public DepartmentBindingModel(String name, Integer managerId, Integer townId) {
        this.name = name;
        this.managerId = managerId;
        this.townId = townId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getTownId() {
        return townId;
    }

    public void setTownId(Integer townId) {
        this.townId = townId;
    }
}


