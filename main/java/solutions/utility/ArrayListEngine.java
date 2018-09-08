package solutions.utility;

import java.util.Date;
import java.util.Random;

/**
 * Created by hoducust on 2018/8/12 22H 58m .
 */
public class ArrayListEngine {

    public int[] randomGenerateArray(int size,int range, long seed) {
        Random rd = new Random(seed);

        int[] result = new int[size];
        while (--size >= 0) {
            result[size] = rd.nextInt(range);
        }
        return result;
    }

    public int[] defaultRandomArray() {
        return randomGenerateArray(1000, 1000, new Date().getTime());
    }

    public static void main(String[] args) {
        int[] result = new ArrayListEngine().randomGenerateArray(100,100, 20L);
        System.out.println();
    }
}
