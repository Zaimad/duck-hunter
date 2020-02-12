package org.academiadecodigo.groupwork;

public class Randomizer {

    public static int randomNumber(int max){
        return randomNumber(0, max);
    }

    public static int randomNumber(int min, int max){
        return (int) (Math.random()*(max-min+1)+min);
    }

    public static int specialRandom(int min, int max, int excluded) {
        int num = randomNumber(min, max);

        while (num == excluded) {
            num = randomNumber(min, max);
        }
        return num;
    }

    public static int specialRandom(int min, int max, int excluded1, int excluded2) {
        int num = randomNumber(min, max);

        while (num == excluded1 || num == excluded2) {
            num = randomNumber(min, max);
        }
        return num;
    }

    public static int specialRandom(int min, int max, int excluded1, int excluded2, int exclude3) {
        int num = randomNumber(min, max);

        while (num == excluded1 || num == excluded2 || num == exclude3) {
            num = randomNumber(min, max);
        }
        return num;
    }
}
