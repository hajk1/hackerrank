package ir.hajk1.codility;

import java.util.ArrayList;
import java.util.List;

public class Nethermind3 {

    private List<List<Integer>> childrenList;
    private int maxPathLength;

    public static void main(String[] args) {
        Nethermind3 nethermind3 = new Nethermind3();
        System.out.println(nethermind3.solution("ab", new int[] {-1, 0}));
        System.out.println(nethermind3.solution("abbab  ", new int[] {-1, 0, 0, 0, 2}));
        System.out.println(nethermind3.solution("abab  ", new int[] {-1, 2, 0, 1}));
        System.out.println(nethermind3.solution("aabbaa  ", new int[] {-1, 0, 0, 1, 1, 2}));
        System.out.println(nethermind3.solution("aaaa  ", new int[] {-1, 0, 1, 2}));
        System.out.println(nethermind3.solution("abababab  ", new int[] {-1, 0, 0, 0, 1, 1, 2, 2}));
    }

    public int solution(String S, int[] A) {
        int numberOfNodes = S.length();

        if (numberOfNodes == 0) {
            return 0;
        }

        if (numberOfNodes == 1) {
            return 1;
        }

        childrenList = buildChildrenList(A);
        maxPathLength = 1;

        calculateLongestPath(0, S);

        return maxPathLength;
    }

    private List<List<Integer>> buildChildrenList(int[] parentArray) {
        int totalNodes = parentArray.length;
        List<List<Integer>> children = new ArrayList<>();

        for (int i = 0; i < totalNodes; i++) {
            children.add(new ArrayList<>());
        }

        for (int nodeIndex = 0; nodeIndex < totalNodes; nodeIndex++) {
            int parentIndex = parentArray[nodeIndex];

            if (parentIndex != -1) {
                children.get(parentIndex).add(nodeIndex);
            }
        }

        return children;
    }

    private int calculateLongestPath(int currentNode, String letters) {
        List<Integer> children = childrenList.get(currentNode);

        if (children.isEmpty()) {
            return 1;
        }

        char currentLetter = letters.charAt(currentNode);

        int firstLongest = 0;
        int secondLongest = 0;

        for (int childNode : children) {
            char childLetter = letters.charAt(childNode);
            int childPathLength = calculateLongestPath(childNode, letters);

            if (childLetter != currentLetter) {
                if (childPathLength > firstLongest) {
                    secondLongest = firstLongest;
                    firstLongest = childPathLength;
                } else if (childPathLength > secondLongest) {
                    secondLongest = childPathLength;
                }
            }
        }

        int pathThroughNode = firstLongest + 1 + secondLongest;
        maxPathLength = Math.max(maxPathLength, pathThroughNode);

        return firstLongest + 1;
    }
}

