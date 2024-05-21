package mars.mss.api.dto;

public class CargoValueDto {
    private Integer value;

    public CargoValueDto() {}

    public CargoValueDto(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CargoValueDto{" +
               "value=" + value +
               '}';
    }
}
