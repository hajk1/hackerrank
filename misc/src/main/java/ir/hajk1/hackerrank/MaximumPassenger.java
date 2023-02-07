package ir.hajk1.hackerrank;

public class MaximumPassenger {
    int matrix_length;
    int solution(int[][] input){
        matrix_length=input[0].length;
        return moveForward(input,0,0,0);
    }

    private int moveForward(int[][] input, int x, int y, int value) {
        int[][] tmp;
        if(x==matrix_length||y==matrix_length)
            return -1;
        if(input[x][y]==-1)
            return -1;
        if(x==(matrix_length-1) && y == (matrix_length-1))
            return moveBack(input,matrix_length-1,matrix_length-1,value);
        tmp = input;
        if(input[x][y]==1) {
            value++;
            tmp[x][y]=0;
        }
        int right = moveForward(tmp,x+1,y,value);
        int down = moveForward(tmp,x,y+1,value);
        return (right>down?right:down);
    }

    private int moveBack(int[][] input, int x, int y, int value) {
        int[][] tmp;
        if(x==-1||y==-1)
            return -1;
        if(input[x][y]==-1)
            return -1;
        if(x==0 && y == 0)
            return value;
        tmp = input;
        if(input[x][y]==1) {
            value++;
            tmp[x][y]=0;
        }
        int left = moveBack(tmp,x-1,y,value);
        int up = moveBack(tmp,x,y-1,value);
        return (left>up?left:up);
    }

    public static void main(String[] args) {
        MaximumPassenger passenger = new MaximumPassenger();
        int[][] sample1 = init1(),sample2=init2(), sample3 = init3(), sample4 = init4();
        System.out.println("passenger.solution() = " + passenger.solution(sample1));
        System.out.println("passenger.solution() = " + passenger.solution(sample2));
        System.out.println("passenger.solution() = " + passenger.solution(sample3));
        System.out.println("passenger.solution() = " + passenger.solution(sample4));
    }

    private static int[][] init2() {
        return new int[][]{{0,0,1,-1},{0,0,0,0},{1,0,1,1},{0,1,1,0}};
    }

    private static int[][] init1() {
        return new int[][]{{0,1},{-1,0}};
    }
    private static int[][] init3() {
        return new int[][]{{0,1,-1},{1,0,-1},{1,1,1}};
    }
    private static int[][] init4() {
        return new int[][]{{0,0,0,1},{1,0,0,0},{0,0,0,0},{0,0,0,0}};
    }

}
