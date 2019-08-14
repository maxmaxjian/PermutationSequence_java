import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SolutionTest {
    private int input1;
    private int input2;
    private String expected;
    private Solution soln = new Solution1();

    public SolutionTest(int input1, int input2, String output) {
        this.input1 = input1;
        this.input2 = input2;
        this.expected = output;
    }

    @Parameterized.Parameters
    public static Collection parameters() {
        return Arrays.asList(new Object[][]{
                {3, 3, "213"},
                {4, 9, "2314"}
        });
    }

    @Test
    public void testPerm() {
        assertEquals(expected, soln.getPermutation(input1, input2));
    }

}