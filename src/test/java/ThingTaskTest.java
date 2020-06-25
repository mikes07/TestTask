import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ThingTaskTest {

    private ThingTask thingTask;

    @Before
    public void setUp() {
        List<String> strings = Arrays.asList("Java", "is", "my", "Java", "life", "Java", "life", "my", "Java", "life");
        thingTask = new ThingTask(strings);
    }

    @Test
    public void getListOfEntriesWithCountOfEachStringInDescendingOrderTest() {
        List<Map.Entry<String, Integer>> entries = thingTask.getListOfEntriesWithCountOfEachStringInDescendingOrder();

        assertThat(entries.size(), is(4));

        assertTrue(entries.get(0).getValue() >= entries.get(1).getValue());
        assertTrue(entries.get(1).getValue() >= entries.get(2).getValue());
        assertTrue(entries.get(2).getValue() >= entries.get(3).getValue());

        assertThat(entries.get(0).getKey(), is("Java"));
        assertThat(entries.get(0).getValue(), is(4));
        assertThat(entries.get(1).getKey(), is("life"));
        assertThat(entries.get(1).getValue(), is(3));
        assertThat(entries.get(2).getKey(), is("my"));
        assertThat(entries.get(2).getValue(), is(2));
        assertThat(entries.get(3).getKey(), is("is"));
        assertThat(entries.get(3).getValue(), is(1));
    }

    @Test
    public void getAverageStringLengthTest() {
        double result = thingTask.getAverageStringLength();
        assertThat(result, is(3.4));
    }

}
