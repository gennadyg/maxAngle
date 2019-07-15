package org.dy;


public class Tree implements Comparable<Tree> {

    private int x;
    private int y;



    public Tree(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getAngleToCenter() {
        return (Math.toDegrees(Math.atan2(y, x))+360) % 360;
    }

    public double getAngleToTree(Tree other) {
        double mine = getAngleToCenter();
        double oth = other.getAngleToCenter();
        if(mine>oth) {
            oth += 360;
        }
        return oth - mine;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }




    @Override
    public int compareTo(Tree o2) {
        double angleO1 = this.getAngleToCenter();
        double angleO2 = o2.getAngleToCenter();
        if (angleO1 > angleO2) {
            return 1;
        } else if (angleO1 == angleO2) {
            return 0;
        } else {
            return -1;
        }
    }
}
