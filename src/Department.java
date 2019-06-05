import java.util.ArrayList;
import java.util.Comparator;

class Department {

    /**
    * @param departments массив строк исходных кодов подразделений
    * @return массив строк отсортированных и дополненных кодов подразделений
    */
    public static String[] getSortedDepartments(String[] departments) {
        ArrayList<String> result = new ArrayList<>();

        // Проходим по исходному массиву и разбиваем каждый элемент на массив по
        // символу "\"
        for (String department : departments) {
            String[] parts = department.split("\\\\");
            StringBuilder part = new StringBuilder();

            // Добавляем недостающие коды подразделений в результирующий массив,
            // если их там нет
            for (int i = 0; i < parts.length; i++) {
                if (part.length() > 0) part.append("\\").append(parts[i]);
                else part.append(parts[i]);

                if (!result.contains(part.toString())) result.add(part.toString());
            }
        }

        // Переопределяем исходный компаратор и сортируем элементы в
        // необходимом порядке
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                for (int i = 0; i < str1.length() && i < str2.length(); i++) {
                    if ((int)str1.charAt(i) != (int)str2.charAt(i)) {
                        return (int)str2.charAt(i) - (int)str1.charAt(i);
                    }
                }
                return 0;
            }
        });

        return result.toArray(new String[0]);
    }
}
