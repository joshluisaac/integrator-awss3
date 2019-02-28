package com.avantsystems.integrator.problems;

public class RectangleManager {

    private int netWidth;
    private int netLength;
    private int area;

    public boolean hasOverlap(Rectangle rect1, Rectangle rect2){
        return false;
    }
    public boolean isValidRectangle(Rectangle  rectangle){
        return false;
    }

    public void computeNetWidth(Rectangle rect1, Rectangle rect2) {
        int maxWidthRect1 = RectangleUtils.max(rect1.x2, rect1.x1);
        int minWidthRect2 = RectangleUtils.min(rect2.x2, rect2.x1);
        netWidth = maxWidthRect1 - minWidthRect2;
    }

    public void computeNetLength(Rectangle rect1, Rectangle rect2) {
        int maxWidthRect1 = RectangleUtils.max(rect1.y2, rect1.y1);
        int minWidthRect2 = RectangleUtils.min(rect2.y2, rect2.y1);
        netLength = maxWidthRect1 - minWidthRect2;
    }

    private void calculateArea(final int netLength, final int netWidth){
        area = netLength * netWidth;
    }

    public int calculateOverLappingArea(Rectangle rect1, Rectangle rect2){
        computeNetLength(rect1, rect2);
        computeNetWidth(rect1,rect2);
        calculateArea(getNetLength(),getNetWidth());
        return getArea();
    }

    public int getArea() {
        return area;
    }

    public int getNetWidth() {
        return this.netWidth;
    }

    public int getNetLength() {
        return this.netLength;
    }


    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(2,5,1,5);
        Rectangle rectangle2 = new Rectangle(3,5,2,7);
        int k = new RectangleManager().calculateOverLappingArea(rectangle1, rectangle2);
        System.out.println(k);
    }



}
