package tu.practise.firm.database.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "departments",
        foreignKeys = {
                @ForeignKey(entity = Employee.class,
                        parentColumns = "id",
                        childColumns = "manager_id"),
                @ForeignKey(entity = Town.class,
                        parentColumns = "id",
                        childColumns = "town_id"),
        })
public class Department {
    @PrimaryKey
    private Integer id;
    private String name;
    @ColumnInfo(name = "manager_id")
    private Integer managerId;
    @ColumnInfo(name = "town_id")
    private Integer townId;

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
