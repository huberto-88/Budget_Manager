class Car {

    int yearModel;
    String make;
    int speed;

    void accelerate() {
        speed += 5;
    }

    void brake() {
        speed = speed <= 5 ? 0 : speed - 5;
    }
}