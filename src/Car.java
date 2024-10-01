import java.util.Objects;

public class Car {
    String model;
    int year;
    String color;

    public Car(String model, int year, String color) {
        this.model = model;
        this.year = year;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year && Objects.equals(model, car.model) && Objects.equals(color, car.color);
        //можно сделать поинтереснее, на случай если цвет не указан или год не указан
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, year, color);
        //можно сделать поинтереснее, на случай если цвет не указан или год не указан
    }
}
