package web.model;

public class Car {
    private String model;
    private String series;
    private int age;
    private String color;

    public Car(String model, String series, int age, String color) {
        this.model = model;
        this.series = series;
        this.age = age;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }
}
