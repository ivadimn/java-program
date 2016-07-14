package org.ivadimn.sq.model;

/**
 * Created by vadim on 14.07.16.
 */
public class Rectangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Rectangle() {
        //no-op
    }

    public Rectangle(int x1, int y1, int x2, int y2) {

        //делаем так чтобы x1 и y1 всегда были меньше чем x2 и y2
        if (x1 <= x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
        else {
            this.x1 = x2;
            this.x2 = x1;
        }
        if (y1 <= y2) {
            this.y1 = y1;
            this.y2 = y2;
        }
        else {
            this.y1 = y2;
            this.y2 = y1;
        }
    }

    //возвращает площадь прямоугольника
    public int getSquare() {

        return (x2 - x1) * (y2 - y1);
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setX1(short x1) {
        this.x1 = x1;
    }

    public void setY1(short y1) {
        this.y1 = y1;
    }

    public void setX2(short x2) {
        this.x2 = x2;
    }

    public void setY2(short y2) {
        this.y2 = y2;
    }

    //получить прямоугольник являющийся пересечением
    //
    public Rectangle getIntersection(Rectangle r) {

        int dx = 0;
        int dy = 0;
        int nx1 = 0, nx2 = 0;
        int ny1 = 0, ny2 = 0;

        //âûÿâëÿåì ïåðåñå÷åíèå ïî îñè Õ

        if ((r.x1 >= x1) & (r.x1 <= x2)) {

            if (r.x2 >= x2) {
                nx1 = r.x1;
                nx2 = x2;
            }
            else {
                nx1 = r.x1;
                nx2 = r.x2;
            }
        }
        else if ((r.x2 >= x1) & (r.x2 <= x2)) {
            if (r.x1 < x1) {
                nx1 = x1;
                nx2 = r.x2;
            }
            else {
                nx1 = r.x1;
                nx2 = r.x2;
            }
        }
        //âûÿâëÿåì ïåðåñå÷åíèå ïî Ó
        if ((r.y1 >= y1) & (r.y1 <= y2)) {
            if (r.x2 >= x2) {
                ny1 = r.y1;
                ny2 = y2;
            }
            else {
                ny1 = r.y1;
                ny2 = r.y2;
            }
        }
        else if ((r.y2 >= y1) & (r.y2 <= y2)) {
            if (r.x1 < x1) {
                ny1 = y1;
                ny2 = r.y2;
            }
            else {
                ny1 = r.y1;
                ny2 = r.y2;
            }
        }
        if (nx2 - nx1 == 0 || ny2 - ny1 == 0)
            return null;
        else
            return new Rectangle(nx1, ny1, nx2, ny2);
    }
}
