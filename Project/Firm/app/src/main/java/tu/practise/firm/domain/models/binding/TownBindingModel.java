package tu.practise.firm.domain.models.binding;

public class TownBindingModel {
    private String name;
    private Integer postalCode;

    public TownBindingModel() {
    }

    public TownBindingModel(String name, Integer postalCode) {
        this.name = name;
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
