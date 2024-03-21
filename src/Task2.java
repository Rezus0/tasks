import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        List<Map<String, String>> list = initTable();
        List<String> namesForAgeLessThan30 = list.stream()
                .filter(map -> {
                    String age = map.get("Возраст");
                    try {
                        return Integer.parseInt(age) < 30;
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException(String.format("Wrong age: %s", age));
                    }
                }).map(map -> map.get("Имя")).toList();
        List<String> namesForSalaryInRub = list.stream()
                .filter(map -> map.get("Зарплата").contains("руб"))
                .map(map -> map.get("Имя"))
                .toList();
        double averageAge = list.stream().mapToInt(map -> {
            String age = map.get("Возраст");
            try {
                return Integer.parseInt(age);
            } catch (NumberFormatException e) {
                throw new NumberFormatException(String.format("Wrong age: %s", age));
            }
        }).summaryStatistics().getAverage();
        System.out.println(namesForAgeLessThan30);
        System.out.println(namesForSalaryInRub);
        System.out.println(averageAge);
    }

    private static List<Map<String, String>> initTable() {
        Map<String, String> map1 = Map.of("Имя", "Кирилл", "Возраст", "26",
                "Должность", "Middle java dev", "Зарплата", "150000 руб");
        Map<String, String> map2 = Map.of("Имя", "Виталий", "Возраст", "28",
                "Должность", "Senior java automation QA", "Зарплата", "2000$");
        Map<String, String> map3 = Map.of("Имя", "Александр", "Возраст", "31",
                "Должность", "junior functional tester", "Зарплата", "50000 руб");
        Map<String, String> map4 = Map.of("Имя", "Дементий", "Возраст", "35",
                "Должность", "dev-ops", "Зарплата", "1500$");
        return List.of(map1, map2, map3, map4);
    }
}
