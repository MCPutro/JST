
import jst.bacafile;
import jst.percobaan1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mu'ti C Putro
 */
public class perconaamMain {
    public static void main(String[] args) {
        percobaan1 p1 = new percobaan1();
        p1.loop(1600);//loop sebanyak 1600
//        p1.loop(0.06);//loop berdasarkan target mse
        System.out.println(p1);//manampilkan data yang diperoleh
        System.out.println("MSE : "+p1.getMse());//manampilkan mse
        System.out.println(p1.getMse().size());

        
        percobaan1.TestTing p = p1.new TestTing();
        p.runTest();
        System.out.println(p);
    }
}
