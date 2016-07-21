package org.ivadimn.sq.ui;

import org.ivadimn.sq.model.Rectangle;

import java.util.*;

/**
 * Created by vadim on 14.07.16.
 */
public class Main {
    private static int step = 0;

    public static void main(String[] args) {


        HashSet<Rectangle> rects = new HashSet<>();
        int s = 0;


        rects.add(new Rectangle(0, 0, 5, 7));
        rects.add(new Rectangle(1, 1, 6, 8));
        rects.add(new Rectangle(2, 2, 7, 9));

        int sMinus = 0;
        int sPlus = 0;
        int ss = 0;
        Iterator<Rectangle> iter = rects.iterator();
        while (iter.hasNext()) {
            Rectangle r = iter.next();
            s = s + r.getSquare();
            System.out.println("Площадь  - " + r.getSquare());
        }
        /*for (int k = 0; k < rects.size(); k++) {
            s = s + rects.get(k).getSquare();
            System.out.println("Площадь  - " + rects.get(k).getSquare());
        }*/

        s = s - getIntersrctionSquare(rects);
        System.out.println("Площадь прямоугольников - " + s);

        /*for (int i = 0; i < rects.length; i++) {
            for(int j = i + 1; j < rects.length; j++) {

                if (j != i) {

                    Rectangle r = rects[i].getIntersection(rects[j]);
                    sMinus += r.getSquare();
                    System.out.println("Площадии 1-х пересечения- " + r.getSquare());
                    inters.add(r);
                }
            }
            //System.out.println("s = " + s);
        }

        for (int i = 0; i < inters.size(); i++) {
            for(int j = i + 1; j < inters.size(); j++) {

                if (j != i) {

                    Rectangle r = inters.get(i).getIntersection(inters.get(j));
                    System.out.println("Площадии 2-х пересечения- " + r.getSquare());
                    sPlus += r.getSquare();
                }
            }
            //System.out.println("s = " + s);
        }
        s = s - sMinus + sPlus;
        System.out.println("Площадь пересечения - " + s);*/
    }

    private static int getIntersrctionSquare(HashSet<Rectangle> rects) {
        int s = 0;
        HashSet<Rectangle> inters = new HashSet<>();
        List<Rectangle>  r = new ArrayList<>();;
        Iterator<Rectangle> iter = rects.iterator();
        while(iter.hasNext())
            r.add(iter.next());

        for (int i = 0; i < r.size(); i++) {
            for(int j = i + 1; j < r.size(); j++) {

                if (!r.get(i).equals(r.get(j))) {

                    Rectangle ri = r.get(i).getIntersection(r.get(j));
                    if (ri.getSquare() > 0) {
                        s += ri.getSquare();
                        inters.add(ri);
                    }
                }
            }
            //System.out.println("s = " + s);
        }
        if (s > 0) {
            if (step % 2 == 0) {
                ++step;
                return s - getIntersrctionSquare(inters);
            }
            else {
                ++step;
                return s + getIntersrctionSquare(inters);
            }

        } else
            return 0;
    }
}
