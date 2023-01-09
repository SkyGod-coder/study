package me.skygod.test;

import java.util.LinkedList;
import java.util.List;

//A B C D
//0 1 2 3
public class Main {
    static Options options = new Options();

    public static void main(String[] args) {
        boolean[] check = new boolean[10];
        List<String> CorrectOptions = new LinkedList<>();
        check[0] = true;
        while (options.next()) {
            options.sort();
            check[1] = options.getNums()[4] == change1(options.getNums()[1]);
            check[2] = different();
            check[3] = check1();
            check[4] = options.getNums()[4] == options.getNums()[change2(options.getNums()[4])];
            check[5] = check2();
            check[6] = check3();
            check[7] = check4();
            check[8] = check5();
            check[9] = check6();
            if (checkAllTrue(check)) CorrectOptions.add(options.toString());
        }
        for (String correctOption : CorrectOptions) {
            System.out.println(correctOption.replace("0", "A")
                    .replace("1", "B")
                    .replace("2", "C")
                    .replace("3", "D")
            );
        }
    }

    public static boolean checkAllTrue(boolean[] check) {
        for (boolean i : check) {
            if (!i) return false;
        }
        return true;
    }

    public static int change1(int i) {
        switch (i) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
        }
        return 0;
    }

    public static int change2(int i) {
        switch (i) {
            case 0:
                return 7;
            case 1:
                return 3;
            case 2:
                return 8;
            case 3:
                return 6;
        }
        return 0;
    }

    public static boolean check1() {
        switch (options.getNums()[3]) {
            case 0:
                return options.getNums()[0] == options.getNums()[4];
            case 1:
                return options.getNums()[1] == options.getNums()[6];
            case 2:
                return options.getNums()[0] == options.getNums()[8];
            case 3:
                return options.getNums()[5] == options.getNums()[9];
        }
        return false;
    }

    public static boolean check2() {
        switch (options.getNums()[5]) {
            case 0:
                return options.getNums()[7] == options.getNums()[1] &&
                        options.getNums()[1] == options.getNums()[3];
            case 1:
                return options.getNums()[7] == options.getNums()[0] &&
                        options.getNums()[0] == options.getNums()[5];
            case 2:
                return options.getNums()[7] == options.getNums()[2] &&
                        options.getNums()[2] == options.getNums()[9];
            case 3:
                return options.getNums()[7] == options.getNums()[4] &&
                        options.getNums()[4] == options.getNums()[8];
        }
        return false;
    }

    public static boolean check3() {
        int min = options.min;
        if (min == 6) return false;
        switch (options.getNums()[6]) {
            case 0:
                return min == 2;
            case 1:
                return min == 1;
            case 2:
                return min == 0;
            case 3:
                return min == 3;
        }
        return false;
    }

    public static boolean check4() {
        int o_1 = options.getNums()[0];
        switch (options.getNums()[7]) {
            case 0:
                return options.getNums()[6] != o_1 + 1 && options.getNums()[6] != o_1 - 1;
            case 1:
                return options.getNums()[4] != o_1 + 1 && options.getNums()[4] != o_1 - 1;
            case 2:
                return options.getNums()[1] != o_1 + 1 && options.getNums()[1] != o_1 - 1;
            case 3:
                return options.getNums()[9] != o_1 + 1 && options.getNums()[9] != o_1 - 1;
        }
        return false;
    }

    public static boolean check5() {
        boolean x = options.getNums()[0] == options.getNums()[5];
        switch (options.getNums()[8]) {
            case 0:
                return x ^ options.getNums()[5] == options.getNums()[4];
            case 1:
                return x ^ options.getNums()[9] == options.getNums()[4];
            case 2:
                return x ^ options.getNums()[1] == options.getNums()[4];
            case 3:
                return x ^ options.getNums()[8] == options.getNums()[4];
        }
        return false;
    }

    public static boolean check6() {
        int min = options.min;
        int max = options.max;
        if (max == 6) return false;
        switch (options.getNums()[9]) {
            case 0:
                return max - min == 3;
            case 1:
                return max - min == 2;
            case 2:
                return max - min == 4;
            case 3:
                return max - min == 1;
        }
        return false;
    }

    public static boolean different() {
        //A B C D
        //2 5 1 3
        int o_3 = options.getNums()[2];
        int o_6 = options.getNums()[5];
        int o_2 = options.getNums()[1];
        int o_4 = options.getNums()[3];
        switch (o_3) {
            case 0:
                return o_3 != o_6 && o_3 != o_2 && o_3 != o_4;
            case 1:
                return o_6 != o_3 && o_6 != o_2 && o_6 != o_4;
            case 2:
                return o_2 != o_3 && o_2 != o_6 && o_2 != o_4;
            case 3:
                return o_4 != o_3 && o_4 != o_6 && o_4 != o_2;
        }
        return false;
    }
}