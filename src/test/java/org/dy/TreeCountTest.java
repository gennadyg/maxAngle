package org.dy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TreeCountTest {

    private TreeCount counter;

    @Before
    public void setUp() throws Exception {
        counter = new TreeCount();
    }
    @Test
    public void testComplexCase() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(10, 30));
        forest.add(new Tree(50, 2));
        forest.add(new Tree(50, 1));
        forest.add(new Tree(50, 0));
        forest.add(new Tree(50, -1));
        forest.add(new Tree(50, -2));
        forest.add(new Tree(-50, 20));
        forest.add(new Tree(-50, -20));

        double alpha = 30;
        assertEquals(5, counter.countTrees(alpha, forest));
    }
    @Test
    public void testComplexCase1() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(10, 30));
        forest.add(new Tree(50, 2));
        forest.add(new Tree(50, 1));
        forest.add(new Tree(50, 0));
        forest.add(new Tree(50, -1));
        forest.add(new Tree(50, -2));
        forest.add(new Tree(-50, 20));
        forest.add(new Tree(-50, -20));

        double alpha = 360;
        assertEquals(9, counter.countTrees(alpha, forest));
    }

    @Test
    public void testEmptyForest() throws Exception {
        ArrayList<Tree> emptyForest = new ArrayList<Tree>();
        assertEquals(0, counter.countTrees(100.0, emptyForest));
    }

    @Test
    public void testBasicCase2() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(-1, -1));

        double alpha = 90;
        assertEquals(1, counter.countTrees(alpha, forest));
    }

    @Test
    public void testBasicCase() throws Exception {
        ArrayList<Tree> forest = new ArrayList<Tree>();
        forest.add(new Tree(1, 1));
        forest.add(new Tree(1, 2));
        forest.add(new Tree(1, 3));

        double alpha = 90;
        assertEquals(3, counter.countTrees(alpha, forest));
    }



}