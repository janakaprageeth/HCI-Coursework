package DrawShapes;

import java.awt.*;
abstract class Shape implements Shapes2{
    String name;
    Point start =null;
    Point end;
    Color clr;
    public void setValues(String name, Point startPoint, Point endPoint, Color color){
        start = startPoint;
        this.name = name;
        end = endPoint;
        clr = color;

    };

    public abstract void draw(Graphics g, Point startPoint, Point endPoint, Color color);
}
interface Shapes2{
    public String getName();
    public Point getStart();
    public Point getEnd();
    public Color getColor();
    public abstract void draw(Graphics g, Point startPoint, Point endPoint, Color color);


}
class Oval extends Shape{
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {

        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        int size;
        if(height>width){
            size=width;
        }else{size=height;}
//            System.out.println("sqr x : "+ x); // Console log
//            System.out.println("sqr y : "+ y); // Console log
        g.setColor(color);


        name = "Oval";
        start= startPoint;
        end= endPoint;
        clr=color;
        g.fillOval(x,//x
                y,//y
                width,//width
                height);// height
//            System.out.println("fin x : "+ x); // Console log
//            System.out.println("fin y : "+ y); // Console log
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    @Override
    public Color getColor() {
        return clr;
    }
}
class Rectangle extends Shape{
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {

        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);
        g.setColor(color);

        name = "Rectangle";
        start= startPoint;
        end= endPoint;
        clr=color;
        g.fillRect(x,//x
                y,//y
                width,//width
                height);// height
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    @Override
    public Color getColor() {
        return clr;
    }
}
class Triangle extends Shape {
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];

        xPoints[0] = startPoint.x; // x-coordinate of the first point
        yPoints[0] = endPoint.y;   // y-coordinate of the first point

        xPoints[1] = endPoint.x;   // x-coordinate of the second point
        yPoints[1] = endPoint.y;   // y-coordinate of the second point

        xPoints[2] = (startPoint.x + endPoint.x) / 2; // x-coordinate of the third point
        yPoints[2] = startPoint.y;                   // y-coordinate of the third point

        g.setColor(color);

        name = "Triangle";
        start = startPoint;
        end = endPoint;
        clr = color;

        g.fillPolygon(xPoints, yPoints, 3); // Draw the triangle using the provided points
    }
    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    @Override
    public Color getColor() {
        return clr;
    }
}
class Square extends Shape{
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {

        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        int size;
        if(height>width){
            size=width;
        }else{size=height;}
//            System.out.println("sqr x : "+ x); // Console log
//            System.out.println("sqr y : "+ y); // Console log
        g.setColor(color);
//            int x_dis=Math.abs(endPoint.x - startPoint.x);
//            int y_dis=Math.abs(endPoint.y - startPoint.y);
//            System.out.println("sqr x dis : "+ x_dis); // Console log
//            System.out.println("sqr y dis : "+ y_dis); // Console log
        if( ( endPoint.x>startPoint.x) && (endPoint.y<startPoint.y) ){
            x= startPoint.x;
            y=startPoint.y-size;
        }
        if( ( endPoint.x>startPoint.x) && (endPoint.y>startPoint.y) ){
            x= startPoint.x;
            y=startPoint.y;
        }
        if( ( endPoint.x<startPoint.x) && (endPoint.y>startPoint.y) ){
            x= startPoint.x-size;
            y=startPoint.y;
        }
        if( ( endPoint.x<startPoint.x) && (endPoint.y<startPoint.y) ){
            x= startPoint.x-size;
            y=startPoint.y-size;
        }

        name = "Square";
        start= startPoint;
        end= endPoint;
        clr=color;
        g.fillRect(x,//x
                y,//y
                size,//width
                size);// height
//            System.out.println("fin x : "+ x); // Console log
//            System.out.println("fin y : "+ y); // Console log
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    @Override
    public Color getColor() {
        return clr;
    }
}

class Circle extends Shape{
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {

        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        int size;
        if(height>width){
            size=width;
        }else{size=height;}
//            System.out.println("sqr x : "+ x); // Console log
//            System.out.println("sqr y : "+ y); // Console log
        g.setColor(color);
//            int x_dis=Math.abs(endPoint.x - startPoint.x);
//            int y_dis=Math.abs(endPoint.y - startPoint.y);
//            System.out.println("sqr x dis : "+ x_dis); // Console log
//            System.out.println("sqr y dis : "+ y_dis); // Console log
        if( ( endPoint.x>startPoint.x) && (endPoint.y<startPoint.y) ){
            x= startPoint.x;
            y=startPoint.y-size;
        }
        if( ( endPoint.x>startPoint.x) && (endPoint.y>startPoint.y) ){
            x= startPoint.x;
            y=startPoint.y;
        }
        if( ( endPoint.x<startPoint.x) && (endPoint.y>startPoint.y) ){
            x= startPoint.x-size;
            y=startPoint.y;
        }
        if( ( endPoint.x<startPoint.x) && (endPoint.y<startPoint.y) ){
            x= startPoint.x-size;
            y=startPoint.y-size;
        }
        name = "Circle";
        start= startPoint;
        end= endPoint;
        clr=color;
        g.fillOval(x,//x
                y,//y
                size,//width
                size);// height
//            System.out.println("fin x : "+ x); // Console log
//            System.out.println("fin y : "+ y); // Console log
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Point getStart() {
        return start;
    }

    @Override
    public Point getEnd() {
        return end;
    }

    @Override
    public Color getColor() {
        return clr;
    }
}

class Rectangle2 extends Shape {
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        g.setColor(color);
        name = "Rectangle";
        start= startPoint;
        end= endPoint;
        clr=color;
        g.fillRect(x, y, width, height);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Point getStart() {
        return null;
    }

    @Override
    public Point getEnd() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }
}

class Oval2 extends Shape {
    public void draw(Graphics g, Point startPoint, Point endPoint, Color color) {
        int width = Math.abs(endPoint.x - startPoint.x);
        int height = Math.abs(endPoint.y - startPoint.y);
        int x = Math.min(startPoint.x, endPoint.x);
        int y = Math.min(startPoint.y, endPoint.y);

        g.setColor(color);
        name = "Oval";
        start= startPoint;
        end= endPoint;
        clr=color;
        g.fillOval(x, y, width, height);

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Point getStart() {
        return null;
    }

    @Override
    public Point getEnd() {
        return null;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
