
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
        p1.loop(32+16+16);
        System.out.println(p1);//manampilkan data yang diperoleh
        System.out.println("MSE : "+p1.getMse());//manampilkan mse
        
//        double d = 0;
//        
//        for (int i = 0; i < p1.getErr().size(); i++) {            
//            System.out.println(i+" "+p1.getErr().get(i));
//            d += Math.pow(p1.getErr().get(i),2);
//            if(i%16 == 15 && i!= 0){
//                System.out.println(d/16);
//                System.out.println("xxx");
//                d=0;
//            }
//        }
//        System.out.println(d/16);
//        System.out.println(bacafile.input[0][4]);
    }
}
