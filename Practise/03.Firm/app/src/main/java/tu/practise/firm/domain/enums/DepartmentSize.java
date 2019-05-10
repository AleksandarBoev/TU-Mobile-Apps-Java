package tu.practise.firm.domain.enums;

public enum DepartmentSize {
    SMALL, MEDIUM, BIG;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1);
    }
}
