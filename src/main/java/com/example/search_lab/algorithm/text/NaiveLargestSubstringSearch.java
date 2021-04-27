package com.example.search_lab.algorithm.text;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public final class NaiveLargestSubstringSearch implements LargestSubstringSearch {

    private static class Pair {

        private final int i;
        private final int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i &&
                    j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

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

        Set<Pair> visitedCoordinates = new HashSet<>();
        int biggestLength = 0;
        Pair indexes = null;
        for (int i = 1; i < pyramid.length; i++) {
            int[] row = pyramid[i];
            for (int j = 0; j < row.length - 1; j++) {
                int element = pyramid[i][j];
                Pair pair = new Pair(i, j);
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
                            indexes = new Pair(i, x);
                            visitedCoordinates.add(indexes);
                        }
                    }
                }
            }
        }
        if (indexes == null) {
            return "";
        }
        return text.substring(indexes.getI(), indexes.getJ() + 1);
    }

    private void fillPyramid(int[][] pyramid, String content) {
        for (int i = 0; i < pyramid.length; i++) {
            for (int j = 0; j < pyramid[i].length; j++) {
                pyramid[i][j] = (content.charAt(i) == content.charAt(j)) ? 1 : 0;
            }
        }
    }

}
