import org.junit.Assert;
import org.junit.jupiter.api.Test;

class DepartmentTest {

    /**
     * Тест с исходными данными из примера
     */
    @Test
    void baseCase() {
        String[] baseCase = {
            "K1\\SK1",
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2",
            "K2",
            "K2\\SK1\\SSK1",
            "K2\\SK1\\SSK2"
        };

        String[] expected = {
            "K2",
            "K2\\SK1",
            "K2\\SK1\\SSK2",
            "K2\\SK1\\SSK1",
            "K1",
            "K1\\SK2",
            "K1\\SK1",
            "K1\\SK1\\SSK2",
            "K1\\SK1\\SSK1"
        };

        String[] result = Department.getSortedDepartments(baseCase);
        Assert.assertArrayEquals(result, expected);
    }

    /**
     * Рандомный тест из головы
     */
    @Test
    void secondTest() {
        String[] array = {
            "K1\\SK2",
            "K1\\SK1\\SSK1",
            "K1\\SK1\\SSK2"
        };
        String[] expected = {
            "K1",
            "K1\\SK2",
            "K1\\SK1",
            "K1\\SK1\\SSK2",
            "K1\\SK1\\SSK1"
        };
        String[] result = Department.getSortedDepartments(array);
        Assert.assertArrayEquals(result, expected);
    }

    /**
     * Рандомный тест из головы
     */
    @Test
    void thirdTest() {
        String[] array = {
                "K2",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2"
        };
        String[] expected = {
                "K2",
                "K1",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        String[] result = Department.getSortedDepartments(array);
        Assert.assertArrayEquals(result, expected);
    }
}