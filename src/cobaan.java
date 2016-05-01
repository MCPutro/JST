
import java.text.DecimalFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mu'ti C Putro
 */
public class cobaan {
    public static void main(String[] args) {
        double d = 0.341231;
        DecimalFormat fd = new DecimalFormat(".#");
        double d2 = Double.parseDouble(fd.format(d));
        System.out.println(d2);
    }
}
