import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MatrixTest {

    @ParameterizedTest
    @CsvSource({"5,5", "10,20", "9384,12384"})
    void getWidth_OK(int width, int height) {
        Matrix m = new Matrix(width, height);
        Assertions.assertEquals(width, m.getWidth());
    }

    @org.junit.jupiter.api.Test
    void getWidth_NEGATIVE() {
        int width = -1;
        int height = 5;
        Assertions.assertThrows(NegativeArraySizeException.class, () -> {
            new Matrix(width, height);
        });
    }

    @ParameterizedTest
    @CsvSource({"5,5", "10,20", "9384,12384"})
    void getHeight_OK(int width, int height) {
        Matrix m = new Matrix(width, height);
        Assertions.assertEquals(height, m.getHeight());
    }

    @org.junit.jupiter.api.Test
    void getHeight_NEGATIVE() {
        int width = 1;
        int height = -5;
        Assertions.assertThrows(NegativeArraySizeException.class, () -> {
            new Matrix(width, height);
        });
    }

    @org.junit.jupiter.api.Test
    void fill_random_fixed_25() {
        Matrix m = new Matrix(5, 5);
        m.Fill(0);

        Assertions.assertEquals(" [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n", m.ToString());

        Assertions.assertEquals(25, m.Count(0));
        Assertions.assertEquals(true, m.Found(0));
        Assertions.assertEquals(false, m.Found(1));

        m.Fill(1);
        Assertions.assertEquals(" [1] [1] [1] [1] [1]\r\n" +
                " [1] [1] [1] [1] [1]\r\n" +
                " [1] [1] [1] [1] [1]\r\n" +
                " [1] [1] [1] [1] [1]\r\n" +
                " [1] [1] [1] [1] [1]\r\n", m.ToString());

        Assertions.assertEquals(25, m.Count(1));
        Assertions.assertEquals(true, m.Found(1));
        Assertions.assertEquals(false, m.Found(0));
    }

    @org.junit.jupiter.api.Test
    void fill_random_fixed_1() {
        Matrix m = new Matrix(1, 1);
        m.Fill(9);

        Assertions.assertEquals(" [9]\r\n", m.ToString());
        Assertions.assertEquals(1, m.Count(9));
        Assertions.assertEquals(true, m.Found(9));
        Assertions.assertEquals(false, m.Found(0));
    }

    @org.junit.jupiter.api.Test
    void fill_random_between_25() {
        Matrix m = new Matrix(5, 5);
        m.Fill(0, 2);

        Assertions.assertNotEquals(" [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n" +
                " [0] [0] [0] [0] [0]\r\n", m.ToString());

        Assertions.assertEquals(0, m.Count(3));
        Assertions.assertEquals(25, m.Count(0) + m.Count(1) + m.Count(2));
    }

    @org.junit.jupiter.api.Test
    void fill_random_25() {
        Matrix m = new Matrix(5, 5);
        m.Fill();
        //demo
    }

}