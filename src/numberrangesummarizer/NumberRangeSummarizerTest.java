package numberrangesummarizer;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Arrays;


public class NumberRangeSummarizerTest {
    
    private NumberRangeSummarizer summarizer;

    @BeforeEach
    public void setUp() {
        summarizer = new NumberRangeSummarizerImpl();
    }

    @Test
    public void testBasicRangeSummarization() {
        //test for the example from the interface documentation
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);
        
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", result);
    }


    @Test
    public void testOwnExample() {
        //test for the example from my own example
        String input = "1,2,3,6,8,9,13,15,17,18,19,23,24,25";
        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);
        
        assertEquals("1-3, 6, 8-9, 13, 15, 17-19, 23-25", result);
    }

    @Test
    public void testSingleNumbersOnly() {
        //test for when no consecutive numbers form a range
        String input = "1,5,10,15,20";
        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);
        
        assertEquals("1, 5, 10, 15, 20", result);
    }

    @Test
    public void testAllConsecutiveNumbers() {
        //test for when all numbers form one continuous range
        String input = "5,6,7,8,9,10";
        Collection<Integer> numbers = summarizer.collect(input);
        String result = summarizer.summarizeCollection(numbers);
        
        assertEquals("5-10", result);
    }
}
