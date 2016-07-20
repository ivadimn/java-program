package org.ivadimn.sq.ui;

import org.ivadimn.sq.model.Rectangle;

import java.util.ArrayList;

/**
 * Created by vadim on 14.07.16.
 */
public class Main {
    public static void main(String[] args) {


        Rectangle[] rects = new Rectangle[3];
        ArrayList<Rectangle> inters = new ArrayList<>();

        int s = 0;


        rects[0] = new Rectangle(0, 0, 5, 7);
        rects[1] = new Rectangle(1, 1, 6, 8);
        rects[2] = new Rectangle(2, 2, 7, 9);
        //rects[3] = new Rectangle(3, 4,6, 8);
        //rects[4] = new Rectangle(4, 6, 7, 10);
        //rects[5] = new Rectangle(5,7, 8, 11);
        int sMinus = 0;
        int sPlus = 0;
        int ss = 0;
        for (int k = 0; k < rects.length; k++) {
            s = s + rects[k].getSquare();
            System.out.println("Площадь  - " + rects[k].getSquare());
        }
        System.out.println("Площадь прямоугольников - " + s);
        for (int i = 0; i < rects.length; i++) {
            for(int j = i + 1; j < rects.length; j++) {

                if (j != i) {

                    Rectangle r = rects[i].getIntersection(rects[j]);
                    sMinus += r.getSquare();
                    inters.add(r);
                }
            }
            //System.out.println("s = " + s);
        }

        for (int i = 0; i < inters.size(); i++) {
            for(int j = i + 1; j < inters.size(); j++) {

                if (j != i) {

                    Rectangle r = inters.get(i).getIntersection(inters.get(j));
                    sPlus += r.getSquare();
                }
            }
            //System.out.println("s = " + s);
        }
        s = s - sMinus + sPlus;
        System.out.println("Площадь пересечения - " + s);
    }
}
