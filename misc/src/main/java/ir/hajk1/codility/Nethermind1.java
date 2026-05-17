package ir.hajk1.codility;

class Nethermind1 {

    public static void main(String[] args) {
        Nethermind1 nethermind1 = new Nethermind1();
        System.out.println(nethermind1.solution(new int[] {1, 1, 3}, 1, 1));
        System.out.println(nethermind1.solution(new int[] {6, 5, 5, 4, 3}, 8, 9));
        System.out.println(nethermind1.solution(new int[] {6, 5, 2, 1, 8}, 17, 5));
        System.out.println(nethermind1.solution(new int[] {5, 5, 4, 6}, 8, 8));

        System.out.println(nethermind1.solution(new int[] {}, 10, 10));
        System.out.println(nethermind1.solution(new int[] {100}, 10, 10));
    }

    public int solution(int[] H, int X, int Y) {
        if (H == null || H.length == 0) {
            return 0;
        }

        if (X == 0 && Y == 0) {
            return 0;
        }

        int totalCars = H.length;
        int maxCarsProduced = 0;

        // Try all possible combinations of assigning cars to lines
        int totalCombinations = (int) Math.pow(2, totalCars);

        for (int combination = 0; combination < totalCombinations; combination++) {
            int carsInThisCombination = tryAssignmentCombination(H, X, Y, combination, totalCars);

            if (carsInThisCombination > maxCarsProduced) {
                maxCarsProduced = carsInThisCombination;
            }
        }

        return maxCarsProduced;
    }

    private int tryAssignmentCombination(int[] H, int X, int Y, int assignment, int totalCars) {
        int lineXTimeUsed = 0;
        int lineYTimeUsed = 0;

        // Calculate time used on each line based on assignment
        for (int carIndex = 0; carIndex < H.length; carIndex++) {
            boolean isCarAssignedToLineX = isCarOnLineX(assignment, carIndex);

            if (isCarAssignedToLineX) {
                lineXTimeUsed += H[carIndex];
            } else {
                lineYTimeUsed += H[carIndex];
            }
        }

        // Check if both lines are within capacity
        boolean isValidAssignment = (lineXTimeUsed <= X) && (lineYTimeUsed <= Y);

        if (isValidAssignment) {
            return H.length; // All cars can be produced
        }

        // If full assignment doesn't work, try subsets
        return findMaxCarsInSubsets(H, X, Y, assignment, totalCars);
    }

    private int findMaxCarsInSubsets(int[] H, int X, int Y, int baseAssignment, int totalCars) {
        int maxCars = 0;

        // Try all possible subsets of cars (which cars to produce)
        int allPossibleSubsets = (int) Math.pow(2, totalCars);

        for (int selectedCars = 0; selectedCars < allPossibleSubsets; selectedCars++) {
            int carsCount = countCarsInSelection(H, X, Y, baseAssignment, selectedCars, totalCars);

            if (carsCount > maxCars) {
                maxCars = carsCount;
            }
        }

        return maxCars;
    }

    private int countCarsInSelection(int[] H, int X, int Y, int assignment, int selected, int totalCars) {
        int lineXTime = 0;
        int lineYTime = 0;
        int carCount = 0;

        for (int carIndex = 0; carIndex < H.length; carIndex++) {
            boolean isCarSelected = isCarIncluded(selected, carIndex);

            if (!isCarSelected) {
                continue; // Skip this car
            }

            boolean assignToLineX = isCarOnLineX(assignment, carIndex);

            if (assignToLineX) {
                lineXTime += H[carIndex];
            } else {
                lineYTime += H[carIndex];
            }

            carCount++;
        }

        if (lineXTime <= X && lineYTime <= Y) {
            return carCount;
        }

        return 0;
    }

    private boolean isCarOnLineX(int assignment, int carIndex) {
        int divisor = (int) Math.pow(2, carIndex);
        int quotient = assignment / divisor;
        int remainder = quotient % 2;
        return remainder == 1;
    }

    private boolean isCarIncluded(int selection, int carIndex) {
        int divisor = (int) Math.pow(2, carIndex);
        int quotient = selection / divisor;
        int remainder = quotient % 2;
        return remainder == 1;
    }
}




