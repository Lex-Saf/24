import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        int speed;

        System.out.println("24 часа Ле-Мана");

        for (int i = 1; i <= 3; i++) {
            System.out.println("\n- Введите название машины №" + i);
            String name = scanner.next();

            while (true) {
                System.out.println("\n- Введите скорость машины (0-250 км/ч): ");
                if (scanner.hasNextInt()) {
                    speed = scanner.nextInt();
                    if (speed >= 0 && speed <= 250) {
                        break;
                    }
                } else {
                    scanner.next();
                }
                System.out.println("- Неправильная скорость");
            }

            Car car = new Car(name, speed);
            race.leader(car);
        }

        System.out.println("- Самая быстрая машина: " + race.winner());

        scanner.close();
    }

}
class Car {
    String name;
    int speed;

    Car(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
}

class Race {
    String leaderName = "";
    int maxDistance = 0;

    public void leader(Car car) {
        int distance = 24 * car.speed;
        if (distance > maxDistance) {
            maxDistance = distance;
            leaderName = car.name;
        }
    }

    public String winner() {
        return leaderName;
    }
}

