package de.svendsen.structures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinkedListTest {

    Random random;
    ArrayList<Integer> toCompare;
    List<Integer> toTest;

    public static final int TEST_LIST_SIZE = 10000;
    public static final int TEST_LIST_SUB_SAMPLE_SIZE = 1000;

    @BeforeEach
    public void fillEqually() {
        random = new Random();
        toCompare = new ArrayList<>();
        toTest = new LinkedList<>();

        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            int n = random.nextInt();
            toCompare.add(n);
            toTest.add(n);
        }
    }

    @Test
    public void shouldBeEqual() {
        assertIsSameList();
    }

    @Test
    public void removeTest() {
        for (int i = 0; i < TEST_LIST_SUB_SAMPLE_SIZE; i++) {
            removeRandomIndex();
        }

        assertIsSameList();
    }

    @Test
    public void removeFirstTest() {
        for (int i = 0; i < TEST_LIST_SUB_SAMPLE_SIZE; i++) {
            removeFirst();
        }

        assertIsSameList();
    }

    @Test
    public void removeLastTest() {
        for (int i = 0; i < TEST_LIST_SUB_SAMPLE_SIZE; i++) {
            removeLastIndex();
        }

        assertIsSameList();
    }

    @Test
    public void removeAllFrist() {
        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            removeFirst();
        }

        assertIsSameList();
    }

    @Test
    public void removeAllLast() {
        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            removeLastIndex();
        }

        assertIsSameList();
    }

    @Test
    public void addToDumpedList() {
        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            switch (random.nextInt(2)) {
                case 0:
                    removeFirst();
                    break;
                case 1:
                    removeLastIndex();
                    break;
                case 2:
                    removeRandomIndex();
                    break;
                default:
                    throw new TestAbortedException("should not happen");
            }
        }

        assertIsSameList();
        assertSizeIs(0);

        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            int huhu = random.nextInt();
            switch (random.nextInt(2)) {
                case 0:
                    addFirst(huhu);
                    break;
                case 1:
                    addLast(huhu);
                    break;
                case 2:
                    addRandomIndex(huhu);
                    break;
                case 3:
                    throw new TestAbortedException("should not happen");
            }
        }

        assertIsSameList();
        assertSizeIs(TEST_LIST_SIZE);

        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            int hehe = random.nextInt();
            toCompare.add(hehe);
            toTest.add(hehe);
        }

        assertIsSameList();
        assertSizeIs(2 * TEST_LIST_SIZE);
    }

    private void addRandomIndex(int v) {
        int randomIndex = random.nextInt(this.toCompare.size() - 1);
        addAtIndex(randomIndex, v);
    }

    private void addFirst(int value) {
        addAtIndex(0, value);
    }

    private void addLast(int value) {
        addAtIndex(this.toCompare.size(), value);
    }

    private void addAtIndex(int index, int value) {
        this.toCompare.add(index, value);
        this.toTest.add(index, value);
    }

    private void removeRandomIndex() {
        int rIndex = random.nextInt(toCompare.size() - 1);
        this.toCompare.remove(rIndex);
        this.toTest.remove(rIndex);
    }

    private void removeLastIndex() {
        int rIndex = toCompare.size() - 1;
        this.toCompare.remove(rIndex);
        this.toTest.remove(rIndex);
    }

    private void removeFirst() {
        this.toCompare.remove(0);
        this.toTest.remove(0);
    }

    private void assertSizeIs(int assertedSize) {
        assertEquals(toCompare.size(), assertedSize);
        assertEquals(toTest.size(), assertedSize);
    }

    private void assertIsSameList() {

        assertEquals(toCompare.size(), toTest.size());

        for (int i = 0; i < toCompare.size(); i++) {
            assertEquals(toCompare.get(i), toTest.get(i));
        }
    }

}
