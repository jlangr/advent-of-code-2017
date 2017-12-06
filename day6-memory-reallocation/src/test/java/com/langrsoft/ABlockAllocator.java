package com.langrsoft;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ABlockAllocator {
    BlockAllocator allocator;

    @Test
    public void indexOfMost() {
        assertEquals(2, new BlockAllocator().indexOfMax(new int[] { 0, 2, 7, 0 }));
    }

    @Test
    public void indexOfMostUsesFirstLargest() {
        assertEquals(1, new BlockAllocator().indexOfMax(new int[] { 0, 7, 2, 7, 0}));
    }

    @Test
    public void indexOfMostUsesFirstLargestWhenAllSame() {
        assertEquals(0, new BlockAllocator().indexOfMax(new int[] { 0, 0, 0, 0, 0 }));
    }

    @Test
    public void clearAndRedistribute() {
        allocator = new BlockAllocator(0, 2, 7, 0);

        allocator.redistributeMax();
        assertArrayEquals(new int[] { 2, 4, 1, 2 }, allocator.banks());

        allocator.redistributeMax();
        assertArrayEquals(new int[] { 3, 1, 2, 3 }, allocator.banks());

        allocator.redistributeMax();
        assertArrayEquals(new int[] { 0, 2, 3, 4 }, allocator.banks());

        allocator.redistributeMax();
        assertArrayEquals(new int[] { 1, 3, 4, 1 }, allocator.banks());

        allocator.redistributeMax();
        assertArrayEquals(new int[] { 2, 4, 1, 2 }, allocator.banks());
    }

    @Test
    public void redistributeUntilRepeat() {
        allocator = new BlockAllocator(0, 2, 7, 0);
        assertEquals(5, allocator.redistributeAll());
    }

    @Test
    public void adventTest() {
        allocator = new BlockAllocator(5, 1, 10, 0, 1, 7, 13, 14, 3, 12, 8, 10, 7, 12, 0, 6);
        assertEquals(5042, allocator.redistributeAll());
    }
}
