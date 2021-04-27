package com.example.search_lab.algorithm.list;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public final class LongestIncreasingSequence implements SequenceSearch {

    @Override
    public int getSequenceLength(List<Integer> numbers) {
        if (numbers.size() == 0) {
            return 0;
        }
        Integer[] tail = new Integer[numbers.size()];
        int length = 1; // always points empty slot in tail
        tail[0] = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > tail[length - 1]) {
                // v[i] extends the largest subsequence
                tail[length++] = numbers.get(i);
            } else {
                // v[i] will extend a subsequence and discard older subsequence
                // find the largest value just smaller than v[i] in tail
                // to find that value do binary search for the v[i] in the range
                // from begin to 0 + length
                int idx = Arrays.binarySearch(tail, 0, length - 1, numbers.get(i));
                // binarySearch returns negative value if searched
                // element is not found in  array
                // this negative value stores the appropriate place where the
                // element is supposed to be stored
                if (idx < 0) {
                    idx = -1 * idx - 1;
                }
                // replacing the existing subsequence with new end value
                tail[idx] = numbers.get(i);
            }
        }
        return length;
    }
}
