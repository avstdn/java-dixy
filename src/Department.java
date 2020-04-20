import java.util.*;

class Department {
//    test revert 1

    /**
    * @param departments массив строк исходных кодов подразделений
    * @return массив строк отсортированных и дополненных кодов подразделений
    */
    public static String[] getSortedDepartments(String[] departments) {
        Set<String> departmentSet = new TreeSet<>();

        // Проходим по исходному массиву и разбиваем каждый элемент еще
        // на один массив по "\"
        for (String department : departments) {
            String[] parts = department.split("\\\\");
            StringBuilder temp = new StringBuilder();

            // Добавляем недостающие коды подразделений в TreeSet
            for (String part : parts) {
                if (temp.length() > 0) temp.append("\\").append(part);
                else temp.append(part);
                departmentSet.add(temp.toString());
            }
        }

        // Переопределяем исходный компаратор
        Set<String> sortedSet =  new TreeSet<>((str1, str2) -> {
            for (int i = 0; i < str1.length() && i < str2.length(); i++) {
                    if ((int)str1.charAt(i) != (int)str2.charAt(i)) {
                        return (int)str2.charAt(i) - (int)str1.charAt(i);
                    }
            }
            return str1.length() - str2.length();
        });

        // Сортируем элементы в заданном порядке
        sortedSet.addAll(departmentSet);

        return sortedSet.toArray(new String[0]);
    }
}
