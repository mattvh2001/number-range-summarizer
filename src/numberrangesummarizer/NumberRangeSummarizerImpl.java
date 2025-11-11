package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Implementation of NumberRangeSummarizer that groups sequential numbers into ranges.
 */
public class NumberRangeSummarizerImpl implements NumberRangeSummarizer {
   
   /**
    * Parses a comma-delimited string of numbers and returns a sorted collection.
    * @param input comma-delimited string of numbers
    * @return sorted collection of integers
    */
   public Collection<Integer> collect(String input) {
      return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .sorted()
            .collect(Collectors.toList());
   }

   /**
    * Summarizes a collection of integers by grouping sequential numbers into ranges.
    * @param input collection of integers
    * @return string representation with
    */
   public String summarizeCollection(Collection<Integer> input) {
      if (input.isEmpty()) {
         return "";
      }
      
      ArrayList<Integer> sortedList = new ArrayList<>(input);
      Collections.sort(sortedList);
      
      StringBuilder result = new StringBuilder();
      int rangeStart = sortedList.get(0);
      int rangeEnd = rangeStart;

      for (int i = 1; i < sortedList.size(); i++) {
         int currentNumber = sortedList.get(i);
         
         //If it isnt sequential, the current range is appended and a new one is started
         if (currentNumber != rangeEnd + 1) {
            appendRange(result, rangeStart, rangeEnd);
            rangeStart = currentNumber;
         }
         
         rangeEnd = currentNumber;
      }

      //appends the final range
      appendRange(result, rangeStart, rangeEnd);
      return result.toString();
   }

   /**
    * Appends a range to the result string.
    * Single numbers are added as-is, ranges as "start-end".
    */
   private void appendRange(StringBuilder result, int start, int end) {
      if (result.length() > 0) {
         result.append(", ");
      }

      if (start == end) {
         result.append(start);
      } else {
         result.append(start).append("-").append(end);
      }
   }
}