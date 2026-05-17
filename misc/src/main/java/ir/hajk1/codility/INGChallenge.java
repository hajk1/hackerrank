package ir.hajk1.codility;

public class INGChallenge {


    public boolean solution(String s) {
        // Implement your solution here
        char[] chars = s.toCharArray();
        boolean b = false;
        for (char aChar : chars) {
            switch (aChar) {
            case 'a':
                if (b) {
                    return false;
                }
                continue;
            case 'b':

                b = true;


            }

        }

        return true;
    }

}
