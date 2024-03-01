package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
//import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> list = new ArrayList<>(List.of(2, 5, 1, 34, 16, 7, 11));

        List<Integer> actual1 = App.take(list, 2);
        assertThat(actual1).isEqualTo(List.of(2, 5));

        List<Integer> actual2 = App.take(list, 5);
        assertThat(actual2).isEqualTo(List.of(2, 5, 1, 34, 16));

        List<Integer> actual3 = App.take(list, 0);
        assertThat(actual3).isEqualTo(List.of());

        List<Integer> actual4 = App.take(list, 9);
        assertThat(actual4).isEqualTo(List.of(2, 5, 1, 34, 16, 7, 11));
        // END
    }
}
