package com.example.search_lab.algorithm.text;

import com.example.search_lab.util.Pair;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public final class NaiveLargestSubstringSearch implements LargestSubstringSearch {

    @Override
    public String getLargestSubsequence(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        int[][] pyramid = new int[text.length()][];
        for (int i = 1; i <= text.length(); i++) {
            pyramid[i - 1] = new int[i];
        }
        fillPyramid(pyramid, text);

        Set<Pair<Integer>> visitedCoordinates = new HashSet<>();
        int biggestLength = 0;
        Pair<Integer> indexes = null;
        for (int i = 1; i < pyramid.length; i++) {
            int[] row = pyramid[i];
            for (int j = 0; j < row.length - 1; j++) {
                int element = pyramid[i][j];
                Pair<Integer> pair = new Pair<>(i, j);
                if (element == 1 && !visitedCoordinates.contains(pair)) {
                    int x = i;
                    int y = j;
                    int length = 1;
                    while (x < pyramid.length - 1) {
                        int next = pyramid[++x][++y];
                        if (next == 1) {
                            length++;
                        } else {
                            break;
                        }
                        if (length > biggestLength) {
                            biggestLength = length;
                            indexes = new Pair<>(i, x);
                            visitedCoordinates.add(indexes);
                        }
                    }
                }
            }
        }
        if (indexes == null) {
            return "";
        }
        return text.substring(indexes.getFirst(), indexes.getSecond() + 1);
    }

    private void fillPyramid(int[][] pyramid, String content) {
        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = (content.charAt(i) == content.charAt(j)) ? 1 : 0;
            }
        }
    }

}
