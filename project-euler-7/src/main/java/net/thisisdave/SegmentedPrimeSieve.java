package net.thisisdave;

import java.util.Arrays;

/**
 * Based on the Segmented sieve of Eratosthenes in order to find prime numbers
 */
public class SegmentedPrimeSieve {

    private static final long MAX = 10001L;
    private static final long SQRT_MAX = (long) Math.sqrt(MAX) + 1;
    private static final int MEMORY_SIZE = (int) (MAX >> 4);
    private static byte[] array = new byte[MEMORY_SIZE];

    public static void main(String[] args) {

        double debut = System.currentTimeMillis();

        // Find prime
        Arrays.fill(array, (byte) 0);

        for (long i = 3; i < SQRT_MAX; i += 2) {
            if (!getBit(i)) {
                long j = (i * i);
                while (j < MAX) {
                    setBit(j);
                    j += (2 * i);
                }
            }
        }

        // Display prime
        long pi = 0;
        for (long i = 3; i < MAX; i += 2) {
            if (!getBit(i)) {
                pi++;
                // System.out.println(i);
            }
        }

        double fin = System.currentTimeMillis();

        System.out.println("Max: " + MAX + " -- Pi:" + pi + " -- T: " + (fin - debut) / 1000d);
    }

    public static boolean getBit(long i) {
        byte block = array[(int) (i >> 4)];
        byte mask = (byte) (1 << ((i >> 1) & 7));

        return ((block & mask) != 0);
    }

    public static void setBit(long i) {
        int index = (int) (i >> 4);
        byte block = array[index];
        byte mask = (byte) (1 << ((i >> 1) & 7));

        array[index] = (byte) (block | mask);
    }
}
