import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Загрузить из файла строки, каждая из которых содержит:
        //владельца, модель, год и цвет машины, разделенные ;
        Map<Car, String>  carStringMap = loadMapFromFile("owners of cars");
        System.out.println("carStringMap = " + carStringMap);
        //спросить у пользователя, какая машина его интересует
        //прочитать с консоли модель, год и цвет
        Car carToFind = askForCar();
        //вывести имя владельца, если такой есть, иначе "машина не найдена"
        String owner = carStringMap.getOrDefault(carToFind, "машина не найдена");

        System.out.println("carToFind = " + carToFind);
        System.out.println("owner = " + owner);
    }

    private static Car askForCar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите искомую модель:");
        String model = scanner.nextLine();
        System.out.println("введите год:");
        int year = scanner.nextInt();
        System.out.println("введите цвет");
        String color = scanner.next();
        return new Car(model, year, color);
    }

    private static Map<Car, String> loadMapFromFile(String filename) {
        Map<Car, String> map = new HashMap<>();
        //открыть файл и разбираться
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                //Загрузить из файла строки, каждая из которых содержит:
                //владельца, модель, год и цвет машины, разделенные ;
                String[] mas = line.split("; ");
                String owner = mas[0];
                String model = mas[1];
                int year = Integer.parseInt(mas[2]);
                String color = mas[3];
                Car singleCar = new Car(model, year, color);
                map.put(singleCar, owner);
            }
            
        }
        catch (Exception eeee){
            System.out.println("что-то не так "+eeee.getMessage());
        }
        return map;
    }
}