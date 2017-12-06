package com.langrsoft;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BlockAllocator {
    int[] banks;

    public BlockAllocator(int... banks) {
        this.banks = banks;
    }

    int indexOfMax(int[] ints) {
        int index = ints.length - 1;
        for (int i = ints.length - 2; i >= 0; i--)
            if (ints[i] >= ints[index])
                index = i;
        return index;
    }

    void redistributeMax() {
        int currentIndex = indexOfMax(banks);
        int toAllocate = banks[currentIndex];
        banks[currentIndex] = 0;
        while (toAllocate-- > 0) {
            currentIndex = nextIndex(currentIndex, banks.length);
            banks[currentIndex]++;
        }
    }

    private int nextIndex(int currentIndex, int length) {
        return ++currentIndex == length ? 0 : currentIndex;
    }

    public int[] banks() {
        return banks;
    }

    public int redistributeAll() {
        Set<String> allocations = new HashSet<>();
        allocations.add(banksSignature());

        int redistributeCount = 0;
        do {
            redistributeMax();
            allocations.add(banksSignature());
            redistributeCount++;
        } while (noDuplicatesExist(allocations, redistributeCount));
        return redistributeCount;
    }

    private String banksSignature() {
        return Arrays.toString(banks);
    }

    private boolean noDuplicatesExist(Set<String> allocations, int redistributeCount) {
        int oneForTheOriginalConfiguration = 1;
        return allocations.size() == redistributeCount + oneForTheOriginalConfiguration;
    }
}
