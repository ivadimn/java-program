package org.ivadimn.sq.ui;

import org.ivadimn.sq.model.Rectangle;

/**
 * Created by vadim on 14.07.16.
 */
public class Main {
    public static void main(String[] args) {


        Rectangle[] rects = new Rectangle[6];
        int s = 0;
        // TODO Auto-generated method stub
            /*if (args.length != 2) {
                System.out.println("Èñïîëüçîâàíèå:");
                System.out.println("CalcSquqre input.txt output.txt");
                System.out.println("input.txt - âõîäíîé ôàéë ñ êîîðäèíàòàìè ïðÿìîóãîëüíèêîâ");
                System.out.println("output.txt - âûõîäíîé ôàéë, ñîäåðæàùèé ïîëùàäü îáúåäèíåíèÿ ïðÿìîóãîëüíèêîâ");
                return;
            }
            System.out.println(args[0] + " " + args[1]);*/

        rects[0] = new Rectangle((0, 0, 15, 20);
        rects[1] = new Rectangle(2,14,5,18);
        rects[2] = new Rectangle(1, 1, 4, 5);
        rects[3] = new Rectangle(3, 4,6, 8);
        rects[4] = new Rectangle(4, 6, 7, 10);
        rects[5] = new Rectangle(5,7, 8, 11);
        int s1;
        int s2;
        int ss = 0;
        for (int k = 0; k < rects.length; k++)
        s = s + rects[k].getSquare();
        System.out.println("Ïëîùàäü îáúåäèíåíèÿ - " + s);
        for (int i = 0; i < rects.length; i++) {
            for(int j = i + 1; j < rects.length; j++) {

                if (j != i) {
                    Rectangle r = r[i].getIntersection(rects[j]);
                    ss = ss + s2;
                }
                //for (int k = 0; k < i; k++) {
                //ss = ss - rects[j].getIntersectionSquare(rects[k]);
                //}
                //s = s - ss;
                System.out.println("ss = " + ss + "  s = " + s);

            }
            //System.out.println("s = " + s);
        }
        s = s - ss;
        System.out.println("Ïëîùàäü îáúåäèíåíèÿ - " + s);
    }
}
