package app;

import java.security.SecureRandom;
import java.util.Random;

public class homeWork9 {
    public static void main(String[] args) {
        int[][] array = new int[4][4];

        fillArray(array);
        printArray(array);

        int sumPart = calculateSumPart(array);
        int sumUnPart = calculateSumUnPart(array);
        long productEvenColumns = calculateProductEvenColumns(array);
        long productOddColumns = calculateProductOddColumns(array);

        System.out.println("Сума елементів у парних рядках (рядок 0, 2): " + sumPart);
        System.out.println("Сума елементів у непарних рядках (рядок 1, 3): " + sumUnPart);
        System.out.println("Добуток елементів у парних стовпцях (стовпець 0, 2): " + productEvenColumns);
        System.out.println("Добуток елементів у непарних стовпцях (стовпець 1, 3): " + productOddColumns);

        if (isMagicSquare(array)) {
            System.out.println("Матриця є магічним квадратом.");
        } else {
            System.out.println("Матриця не є магічним квадратом.");
        }
    }

    public static void fillArray(int[][] array) {
        Random random = new SecureRandom();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(50) + 1;
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int calculateSumPart(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < array[i].length; j++) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static int calculateSumUnPart(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                for (int j = 0; j < array[i].length; j++) {
                    sum += array[i][j];
                }
            }
        }
        return sum;
    }

    public static long calculateProductEvenColumns(int[][] array) {
        long product = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j % 2 == 0) {
                    product *= array[i][j];
                }
            }
        }
        return product;
    }

    public static long calculateProductOddColumns(int[][] array) {
        long product = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j % 2 != 0) {
                    product *= array[i][j];
                }
            }
        }
        return product;
    }

    public static boolean isMagicSquare(int[][] array) {
        int n = array.length;
        int magicSum = 0;

        for (int j = 0; j < n; j++) {
            magicSum += array[0][j];
        }

        for (int i = 1; i < n; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += array[i][j];
            }
            if (rowSum != magicSum) {
                return false;
            }
        }

        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < n; i++) {
                colSum += array[i][j];
            }
            if (colSum != magicSum) {
                return false;
            }
        }

        int mainDiagSum = 0;
        for (int i = 0; i < n; i++) {
            mainDiagSum += array[i][i];
        }
        if (mainDiagSum != magicSum) {
            return false;
        }

        int secondaryDiagSum = 0;
        for (int i = 0; i < n; i++) {
            secondaryDiagSum += array[i][n - 1 - i];
        }
        if (secondaryDiagSum != magicSum) {
            return false;
        }

        return true;
    }




    }

