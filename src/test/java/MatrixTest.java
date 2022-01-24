import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    @org.junit.jupiter.api.Test
    void getWidth() {
        int width = 5;
        int height = 5;
        Matrix m = new Matrix(width, height);
        Assertions.assertEquals(width, m.getWidth());
    }

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

    @org.junit.jupiter.api.Test
    void getHeight() {
    }

    @org.junit.jupiter.api.Test
    void fill() {
    }

    @org.junit.jupiter.api.Test
    void count() {
    }

    @org.junit.jupiter.api.Test
    void found() {
    }

    @org.junit.jupiter.api.Test
    void toString() {
    }


}