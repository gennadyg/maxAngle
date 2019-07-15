package org.dy;

import org.junit.Assert;
import org.junit.Test;

public class TreeTest {
    @Test
    public void testSimpleAngles() throws Exception {
        Tree t = new Tree(0, 0);
        double angle = t.getAngleToCenter();
        Assert.assertEquals(0, angle, 0.000001);

        t = new Tree(1, 0);
        angle = t.getAngleToCenter();
        Assert.assertEquals (0, angle, 0.000001);

        t = new Tree(0, 1);
        angle = t.getAngleToCenter();
        Assert.assertEquals(90.0, angle, 0.000001);

        t = new Tree(-1, 0);
        angle = t.getAngleToCenter();
        Assert.assertEquals(180.0, angle, 0.000001);

        t = new Tree(0, -1);
        angle = t.getAngleToCenter();
        Assert.assertEquals(270.0, angle, 0.000001);
    }

    @Test
    public void testAngleBetweenTrees() throws Exception {
        Tree tree1 = new Tree(100, 100);
        Tree tree2 = new Tree(100, -100);

        Assert.assertEquals(90, tree2.getAngleToTree(tree1), 0.00001);
        Assert.assertEquals(270, tree1.getAngleToTree(tree2), 0.00001);
    }
}