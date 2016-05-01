/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jst;

import java.text.DecimalFormat;
import java.util.*;

/**
 *
 * @author Mu'ti C Putro
 */
public class percobaan1 {

    private ArrayList<Double> w11 = new ArrayList<>();
    private ArrayList<Double> w21 = new ArrayList<>();
    private ArrayList<Double> w31 = new ArrayList<>();
    private ArrayList<Double> w41 = new ArrayList<>();
    private ArrayList<Double> b1 = new ArrayList<>();
    private ArrayList<Double> w12 = new ArrayList<>();
    private ArrayList<Double> w22 = new ArrayList<>();
    private ArrayList<Double> w32 = new ArrayList<>();
    private ArrayList<Double> w42 = new ArrayList<>();
    private ArrayList<Double> b2 = new ArrayList<>();
    private ArrayList<Double> w13 = new ArrayList<>();
    private ArrayList<Double> w23 = new ArrayList<>();
    private ArrayList<Double> w33 = new ArrayList<>();
    private ArrayList<Double> w43 = new ArrayList<>();
    private ArrayList<Double> b3 = new ArrayList<>();

    private ArrayList<Double> u1 = new ArrayList<>();
    private ArrayList<Double> u2 = new ArrayList<>();
    private ArrayList<Double> u3 = new ArrayList<>();
    private ArrayList<Double> z1 = new ArrayList<>();
    private ArrayList<Double> z2 = new ArrayList<>();
    private ArrayList<Double> z3 = new ArrayList<>();
    private ArrayList<Double> v1 = new ArrayList<>();
    private ArrayList<Double> v2 = new ArrayList<>();
    private ArrayList<Double> v3 = new ArrayList<>();
    private ArrayList<Double> b4 = new ArrayList<>();
    private ArrayList<Double> u4 = new ArrayList<>();
    private ArrayList<Double> y = new ArrayList<>();
    private ArrayList<Double> err = new ArrayList<>();
    private ArrayList<Double> dw11 = new ArrayList<>();
    private ArrayList<Double> dw21 = new ArrayList<>();
    private ArrayList<Double> dw31 = new ArrayList<>();
    private ArrayList<Double> dw41 = new ArrayList<>();
    private ArrayList<Double> db1 = new ArrayList<>();
    private ArrayList<Double> dw12 = new ArrayList<>();
    private ArrayList<Double> dw22 = new ArrayList<>();
    private ArrayList<Double> dw32 = new ArrayList<>();
    private ArrayList<Double> dw42 = new ArrayList<>();
    private ArrayList<Double> db2 = new ArrayList<>();
    private ArrayList<Double> dw13 = new ArrayList<>();
    private ArrayList<Double> dw23 = new ArrayList<>();
    private ArrayList<Double> dw33 = new ArrayList<>();
    private ArrayList<Double> dw43 = new ArrayList<>();
    private ArrayList<Double> db3 = new ArrayList<>();
    private ArrayList<Double> dv1 = new ArrayList<>();
    private ArrayList<Double> dv2 = new ArrayList<>();
    private ArrayList<Double> dv3 = new ArrayList<>();
    private ArrayList<Double> db4 = new ArrayList<>();

    private ArrayList<Double> mse = new ArrayList<>();

    private bacafile bf;
    private double alpha;

//    public void baca() {
//        bf = new bacafile();
//        bf.output();
//    }
    public percobaan1() {
        bf = new bacafile("data.txt");
        bf.output();

        alpha = 0.7;

        this.w11.add(desimal(randomRang(-1, 1)));
        this.w21.add(desimal(randomRang(-1, 1)));
        this.w31.add(desimal(randomRang(-1, 1)));
        this.w41.add(desimal(randomRang(-1, 1)));
        this.b1.add(desimal(randomRang(-1, 1)));

        this.w12.add(desimal(randomRang(-1, 1)));
        this.w22.add(desimal(randomRang(-1, 1)));
        this.w32.add(desimal(randomRang(-1, 1)));
        this.w42.add(desimal(randomRang(-1, 1)));
        this.b2.add(desimal(randomRang(-1, 1)));

        this.w13.add(desimal(randomRang(-1, 1)));
        this.w23.add(desimal(randomRang(-1, 1)));
        this.w33.add(desimal(randomRang(-1, 1)));
        this.w43.add(desimal(randomRang(-1, 1)));
        this.b3.add(desimal(randomRang(-1, 1)));

        addU123(0);

        addZ();

        this.v1.add(new Double(desimal(randomRang(-1, 1))));
        this.v2.add(new Double(desimal(randomRang(-1, 1))));
        this.v3.add(new Double(desimal(randomRang(-1, 1))));
        this.b4.add(desimal(randomRang(-1, 1)));

        addU4Y();

        addErrDelta(0);
        hitungMSE();
    }

    public double randomRang(double min, double max) {
        Random r = new Random();
        double hasil = -999;
        while (true) {
            
            hasil = min + (max - min) * r.nextDouble();
            if(hasil >= -1 && hasil <= 1){
                return hasil;
            }
        }
//        return min + (max - min) * r.nextDouble();
//        return r.doubles(min, max).findFirst().getAsDouble();
    }

    public void loop(int iterasi) {
        for (int i = 1; i < iterasi; i++) {
            addWV();
            addU123(i % 16);
            addZ();
            addU4Y();
            addErrDelta(i % 16);
        }
        hitungMSE();
    }

    public void loop(double target) {
        int i = 1;
        while (true) {
//        for (; i < iterasi; i++) {
            mse.clear();
            addWV();
            addU123(i % 16);
            addZ();
            addU4Y();
            addErrDelta(i % 16);
            if (i % 16 == 15) {
                hitungMSE();
                if (mse.get(mse.size() - 1) <= target) {
                    break;
                }
            }
            i++;
        }
    }

    public void addWV() {//untuk iterasi ke 2 dari 1 start
        this.w11.add(desimal(w11.get(w11.size() - 1) + dw11.get(dw11.size() - 1)));
        this.w21.add(desimal(w21.get(w21.size() - 1) + dw21.get(dw21.size() - 1)));
        this.w31.add(desimal(w31.get(w31.size() - 1) + dw31.get(dw31.size() - 1)));
        this.w41.add(desimal(w41.get(w41.size() - 1) + dw41.get(dw41.size() - 1)));
        this.b1.add(desimal(b1.get(b1.size() - 1) + db1.get(db1.size() - 1)));

        this.w12.add(desimal(w12.get(w12.size() - 1) + dw12.get(dw12.size() - 1)));
        this.w22.add(desimal(w22.get(w22.size() - 1) + dw22.get(dw22.size() - 1)));
        this.w32.add(desimal(w32.get(w32.size() - 1) + dw32.get(dw32.size() - 1)));
        this.w42.add(desimal(w42.get(w42.size() - 1) + dw42.get(dw42.size() - 1)));
        this.b2.add(desimal(b2.get(b2.size() - 1) + db2.get(db2.size() - 1)));

        this.w13.add(desimal(w13.get(w13.size() - 1) + dw13.get(dw13.size() - 1)));
        this.w23.add(desimal(w23.get(w23.size() - 1) + dw23.get(dw23.size() - 1)));
        this.w33.add(desimal(w33.get(w33.size() - 1) + dw33.get(dw33.size() - 1)));
        this.w43.add(desimal(w43.get(w43.size() - 1) + dw43.get(dw43.size() - 1)));
        this.b3.add(desimal(b3.get(b3.size() - 1) + db3.get(db3.size() - 1)));

        this.v1.add(desimal(v1.get(v1.size() - 1) + dv1.get(dv1.size() - 1)));
        this.v2.add(desimal(v2.get(v2.size() - 1) + dv2.get(dv2.size() - 1)));
        this.v3.add(desimal(v3.get(v3.size() - 1) + dv3.get(dv3.size() - 1)));
        this.b4.add(desimal(b4.get(b4.size() - 1) + db4.get(db4.size() - 1)));
    }

    public void addU123(int iterasike) {
        this.u1.add(desimal(
                (bf.getInput()[iterasike][0] * this.w11.get(w11.size() - 1))
                + (bf.getInput()[iterasike][1] * this.w21.get(w21.size() - 1))
                + (bf.getInput()[iterasike][2] * this.w31.get(w31.size() - 1))
                + (bf.getInput()[iterasike][3] * this.w41.get(w41.size() - 1))));
        this.u2.add(desimal(
                (bf.getInput()[iterasike][0] * this.w12.get(w12.size() - 1))
                + (bf.getInput()[iterasike][1] * this.w22.get(w22.size() - 1))
                + (bf.getInput()[iterasike][2] * this.w32.get(w32.size() - 1))
                + (bf.getInput()[iterasike][3] * this.w42.get(w42.size() - 1))));
        this.u3.add(desimal(
                (bf.getInput()[iterasike][0] * this.w13.get(w13.size() - 1))
                + (bf.getInput()[iterasike][1] * this.w23.get(w23.size() - 1))
                + (bf.getInput()[iterasike][2] * this.w33.get(w33.size() - 1))
                + (bf.getInput()[iterasike][3] * this.w43.get(w43.size() - 1))));
    }

    public void addZ() {
        this.z1.add(new Double(desimal(1 / (1 + Math.exp(-this.u1.get(u1.size() - 1))))));
        this.z2.add(new Double(desimal(1 / (1 + Math.exp(-this.u2.get(u2.size() - 1))))));
        this.z3.add(new Double(desimal(1 / (1 + Math.exp(-this.u2.get(u2.size() - 1))))));
    }

    public void addU4Y() {
        this.u4.add(desimal((this.z1.get(z1.size() - 1) * this.v1.get(v1.size() - 1))
                + (this.z2.get(z2.size() - 1) * this.v2.get(v2.size() - 1))
                + (this.z3.get(z3.size() - 1) * this.v3.get(v3.size() - 1))));
        this.y.add(desimal(1 / (1 + Math.exp(-this.u4.get(u4.size() - 1)))));
    }

    public void addErrDelta(int iterasiKe) {
        this.err.add(desimal(bf.getInput()[iterasiKe][4] - y.get(y.size() - 1)));
//        System.out.println(bacafile.input[iterasiKe][4]+ " << "+iterasiKe);

        this.dw11.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bf.getInput()[iterasiKe][0] * alpha));
        this.dw21.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bf.getInput()[iterasiKe][1] * alpha));
        this.dw31.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bf.getInput()[iterasiKe][2] * alpha));
        this.dw41.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bf.getInput()[iterasiKe][3] * alpha));
        this.db1.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * alpha));
        //
        this.dw12.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bf.getInput()[iterasiKe][0] * alpha));
        this.dw22.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bf.getInput()[iterasiKe][1] * alpha));
        this.dw32.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bf.getInput()[iterasiKe][2] * alpha));
        this.dw42.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bf.getInput()[iterasiKe][3] * alpha));
        this.db2.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * alpha));
        //
        this.dw13.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bf.getInput()[iterasiKe][0] * alpha));
        this.dw23.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bf.getInput()[iterasiKe][1] * alpha));
        this.dw33.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bf.getInput()[iterasiKe][2] * alpha));
        this.dw43.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bf.getInput()[iterasiKe][3] * alpha));
        this.db3.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * alpha));

        this.dv1.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * z1.get(z1.size() - 1) * alpha));
        this.dv2.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * z2.get(z2.size() - 1) * alpha));
        this.dv3.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * z3.get(z3.size() - 1) * alpha));
        this.db4.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * alpha));
    }

    public void hitungMSE() {
        double d = 0;
        for (int i = 0; i < err.size(); i++) {
            d += Math.pow(err.get(i), 2);
            if (i % 16 == 15 && i != 0) {
                this.mse.add(d / 16);
                d = 0;
            }
        }
    }

    public ArrayList<Double> getErr() {
        return err;
    }

    public ArrayList<Double> getMse() {
        return mse;
    }

    public double desimal(double angka) {
        DecimalFormat df = new DecimalFormat(".####");
        return Double.valueOf(df.format(angka));
    }

    @Override
    public String toString() {
        return "Learning :" + "\nw11 = " + w11
                + ", \nw21 = " + w21
                + ", \nw31 = " + w31
                + ", \nw41 = " + w41
                + ", \nb1  = " + b1
                + ", \nw12 = " + w12
                + ", \nw22 = " + w22
                + ", \nw32 = " + w32
                + ", \nw42 = " + w42
                + ", \nb2  = " + b2
                + ", \nw13 = " + w13
                + ", \nw23 = " + w23
                + ", \nw33 = " + w33
                + ", \nw43 = " + w43
                + ", \nb3  = " + b3
                + ", \nu1  = " + u1
                + ", \nu2  = " + u2
                + ", \nu3  = " + u3
                + ", \nz1  = " + z1
                + ", \nz2  = " + z2
                + ", \nz3  = " + z3
                + ", \nv1  = " + v1
                + ", \nv2  = " + v2
                + ", \nv3  = " + v3
                + ", \nb4  = " + b4
                + ", \nu4  = " + u4
                + ", \ny   = " + y
                + ", \nerr = " + err
                + ", \ndw11= " + dw11
                + ", \ndw21= " + dw21
                + ", \ndw31= " + dw31
                + ", \ndw41= " + dw41
                + ", \ndb1 = " + db1
                + ", \ndw12= " + dw12
                + ", \ndw22= " + dw22
                + ", \ndw32= " + dw32
                + ", \ndw42= " + dw42
                + ", \ndb2 = " + db2
                + ", \ndw13= " + dw13
                + ", \ndw23= " + dw23
                + ", \ndw33= " + dw33
                + ", \ndw43= " + dw43
                + ", \ndb3 = " + db3
                + ", \ndv1 = " + dv1
                + ", \ndv2 = " + dv2
                + ", \ndv3 = " + dv3
                + ", \ndb4 = " + db4
                + '}';
    }

    public class TestTing {

        private ArrayList<Double> w11T = new ArrayList<>();
        private ArrayList<Double> w21T = new ArrayList<>();
        private ArrayList<Double> w31T = new ArrayList<>();
        private ArrayList<Double> w41T = new ArrayList<>();
        private ArrayList<Double> b1T = new ArrayList<>();

        private ArrayList<Double> w12T = new ArrayList<>();
        private ArrayList<Double> w22T = new ArrayList<>();
        private ArrayList<Double> w32T = new ArrayList<>();
        private ArrayList<Double> w42T = new ArrayList<>();
        private ArrayList<Double> b2T = new ArrayList<>();

        private ArrayList<Double> w13T = new ArrayList<>();
        private ArrayList<Double> w23T = new ArrayList<>();
        private ArrayList<Double> w33T = new ArrayList<>();
        private ArrayList<Double> w43T = new ArrayList<>();
        private ArrayList<Double> b3T = new ArrayList<>();

        private ArrayList<Double> u1T = new ArrayList<>();
        private ArrayList<Double> u2T = new ArrayList<>();
        private ArrayList<Double> u3T = new ArrayList<>();
        private ArrayList<Double> z1T = new ArrayList<>();
        private ArrayList<Double> z2T = new ArrayList<>();
        private ArrayList<Double> z3T = new ArrayList<>();

        private ArrayList<Double> v1T = new ArrayList<>();
        private ArrayList<Double> v2T = new ArrayList<>();
        private ArrayList<Double> v3T = new ArrayList<>();
        private ArrayList<Double> b4T = new ArrayList<>();

        private ArrayList<Double> u4T = new ArrayList<>();
        private ArrayList<Double> yT = new ArrayList<>();
        private ArrayList<Double> tT = new ArrayList<>();
        private ArrayList<Double> oT = new ArrayList<>();

        private double thr;
        private bacafile b;
        private double persen;
        
        public TestTing() {
            b = new bacafile("dataTest.txt");
//            b.output();
            for (int i = 0; i < b.getInput().length; i++) {
//                System.out.print((i+1)+". ");
                for (int j = 0; j < b.getInput()[i].length; j++) {
                    System.out.print(b.getInput()[i][j]+" ");
                }
                System.out.println("");
            }
//            System.out.println(b.getInput().length);
            System.out.println("------------");
//            thr = 0.40906875;
            this.w11T.add(randomRang(min(w11), max(w11)));
//            System.out.println(min(w11)+" "+max(w11));
            this.w21T.add(randomRang(min(w21), max(w21)));
//            System.out.println(min(w21)+" "+max(w21));
            this.w31T.add(randomRang(min(w31), max(w31)));
//            System.out.println(min(w31)+" "+max(w31));
            this.w41T.add(randomRang(min(w41), max(w41)));
//            System.out.println(min(w41)+" "+max(w41));
            this.b1T.add(randomRang(min(b1), max(b1)));
//            System.out.println(min(w11)+" "+max(w11));
            
            
            this.w12T.add(randomRang(min(w12), max(w12)));
//            System.out.println(min(w12)+" "+max(w12));
            this.w22T.add(randomRang(min(w22), max(w22)));
//            System.out.println(min(w22)+" "+max(w22));
            this.w32T.add(randomRang(min(w32), max(w32)));
//            System.out.println(min(w32)+" "+max(w32));
            this.w42T.add(randomRang(min(w42), max(w42)));
//            System.out.println(min(w42)+" "+max(w42));
            this.b2T.add(randomRang(min(b2), max(b2)));
//            System.out.println(min(b2)+" "+max(b2));
            
            
            this.w13T.add(randomRang(min(w13), max(w13)));
//            System.out.println(min(w13)+" "+max(w13));
            this.w23T.add(randomRang(min(w23), max(w23)));
//            System.out.println(min(w23)+" "+max(w23));
            this.w33T.add(randomRang(min(w33), max(w33)));
//            System.out.println(min(w33)+" "+max(w33));
            this.w43T.add(randomRang(min(w43), max(w43)));
//            System.out.println(min(w43)+" "+max(w43));
            this.b3T.add(randomRang(min(b3), max(b3)));
//            System.out.println(min(b3)+" "+max(b3));
            
            
            this.v1T.add(randomRang(min(v1), max(v1)));
//            System.out.println(min(v1)+" "+max(v1));
            this.v2T.add(randomRang(min(v2), max(v2)));
//            System.out.println(min(v2)+" "+max(v2));
            this.v3T.add(randomRang(min(v3), max(v3)));
//            System.out.println(min(v3)+" "+max(v3));
            this.b4T.add(randomRang(min(b4), max(b4)));
//            System.out.println(min(b4)+" "+max(b4));
            
            for (int i = 0; i < 15; i++) {
                this.w11T.add(w11T.get(w11T.size() - 1));
                this.w21T.add(w21T.get(w21T.size() - 1));
                this.w31T.add(w31T.get(w31T.size() - 1));
                this.w41T.add(w41T.get(w41T.size() - 1));
                this.b1T.add(b1T.get(b1T.size() - 1));

                this.w12T.add(w12T.get(w12T.size() - 1));
                this.w22T.add(w22T.get(w22T.size() - 1));
                this.w32T.add(w32T.get(w32T.size() - 1));
                this.w42T.add(w42T.get(w42T.size() - 1));
                this.b2T.add(b2T.get(b2T.size() - 1));

                this.w13T.add(w13T.get(w13T.size() - 1));
                this.w23T.add(w23T.get(w23T.size() - 1));
                this.w33T.add(w33T.get(w33T.size() - 1));
                this.w43T.add(w43T.get(w43T.size() - 1));
                this.b3T.add(b3T.get(b3T.size() - 1));

                this.v1T.add(v1T.get(v1T.size() - 1));
                this.v2T.add(v2T.get(v2T.size() - 1));
                this.v3T.add(v3T.get(v3T.size() - 1));
                this.b4T.add(b4T.get(b4T.size() - 1));
            }
//            
//            
        }

        public void runTest(){
            for (int i = 0; i < 16; i++) {
                this.addU123T(i);
                this.addZT();
                this.addU4YT();
            }
            
            //hitung thr
            thr = 0;
            for (int i = 0; i < 16; i++) {
                thr += this.yT.get(i);
            }
            thr = thr/16.0;
            DecimalFormat fd = new DecimalFormat(".#");
            thr = Double.parseDouble(fd.format(thr));
//            System.out.println(thr);
            for (int i = 0; i < 16; i++) {
                addOT(i);
            }
            this.hitung();
        }
        
        public void hitung(){
            int jum = 0;
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
            for (int i = 0; i < this.oT.size(); i++) {
                System.out.print(oT.get(i)+" - "+b.getInput()[i][4]);
                String s = oT.get(i).toString();
                if(s.equals(b.getInput()[i][4]+".0")){
                    System.out.print(" sama\n");
                    jum++;
                }
                else
                    System.out.println("");
            }
            
            persen = (jum/16.0)*100;
            System.out.println(persen);
            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        }
        
//        public double randomRang(double min, double max) {
//            Random r = new Random();
//            return min + (max - min) * r.nextDouble();
//        }
        
        public double min(ArrayList<Double> list) {
            double result;
            result = Collections.min(list);
            return result;
        }

        public double max(ArrayList<Double> list) {
            double result;
            result = Collections.max(list);
            return result;
        }

        public void addU123T(int iterasike) {
            this.u1T.add(desimal(
                    (this.b.getInput()[iterasike][0] * this.w11T.get(w11T.size() - 1))
                    + (this.b.getInput()[iterasike][1] * this.w21T.get(w21T.size() - 1))
                    + (this.b.getInput()[iterasike][2] * this.w31T.get(w31T.size() - 1))
                    + (this.b.getInput()[iterasike][3] * this.w41T.get(w41T.size() - 1))));
            this.u2T.add(desimal(
                    (this.b.getInput()[iterasike][0] * this.w12T.get(w12T.size() - 1))
                    + (this.b.getInput()[iterasike][1] * this.w22T.get(w22T.size() - 1))
                    + (this.b.getInput()[iterasike][2] * this.w32T.get(w32T.size() - 1))
                    + (this.b.getInput()[iterasike][3] * this.w42T.get(w42T.size() - 1))));
            this.u3T.add(desimal(
                    (this.b.getInput()[iterasike][0] * this.w13T.get(w13T.size() - 1))
                    + (this.b.getInput()[iterasike][1] * this.w23T.get(w23T.size() - 1))
                    + (this.b.getInput()[iterasike][2] * this.w33T.get(w33T.size() - 1))
                    + (this.b.getInput()[iterasike][3] * this.w43T.get(w43T.size() - 1))));
        }

        public void addZT() {
            this.z1T.add(new Double(desimal(1 / (1 + Math.exp(-this.u1T.get(u1T.size() - 1))))));
            this.z2T.add(new Double(desimal(1 / (1 + Math.exp(-this.u2T.get(u2T.size() - 1))))));
            this.z3T.add(new Double(desimal(1 / (1 + Math.exp(-this.u2T.get(u2T.size() - 1))))));
        }

        public void addU4YT() {
            this.u4T.add(desimal((this.z1T.get(z1T.size() - 1) * this.v1T.get(v1T.size() - 1))
                    + (this.z2T.get(z2T.size() - 1) * this.v2T.get(v2T.size() - 1))
                    + (this.z3T.get(z3T.size() - 1) * this.v3T.get(v3T.size() - 1))));
            this.yT.add(desimal(1 / (1 + Math.exp(-this.u4T.get(u4T.size() - 1)))));
//            this.oT.add(getOT(yT.get(yT.size()-1)));
        }
        
        public void addOT(int iterasike){
              this.oT.add(getOT(yT.get(iterasike)));
        }
        
        public double getOT(double yT){
            if(yT < thr){
                return 0;
            }else
                return 1;
        }

        @Override
        public String toString() {
            return "TestTing{" 
                    + "\nw11T=" + w11T 
                    + "\nw21T=" + w21T 
                    + "\nw31T=" + w31T 
                    + "\nw41T=" + w41T 
                    + "\nb1T=" + b1T 
                    + "\nw12T=" + w12T 
                    + "\nw22T=" + w22T 
                    + "\nw32T=" + w32T 
                    + "\nw42T=" + w42T 
                    + "\nb2T=" + b2T 
                    + "\nw13T=" + w13T 
                    + "\nw23T=" + w23T 
                    + "\nw33T=" + w33T 
                    + "\nw43T=" + w43T 
                    + "\nb3T=" + b3T 
                    + "\nu1T=" + u1T 
                    + "\nu2T=" + u2T 
                    + "\nu3T=" + u3T 
                    + "\nz1T=" + z1T 
                    + "\nz2T=" + z2T 
                    + "\nz3T=" + z3T 
                    + "\nv1T=" + v1T 
                    + "\nv2T=" + v2T 
                    + "\nv3T=" + v3T 
                    + "\nb4T=" + b4T 
                    + "\nu4T=" + u4T 
                    + "\nyT=" + yT 
                    + "\ntT=" + tT 
                    + "\noT=" + oT 
                    + "\npersen : "+this.persen
                    ;
        }
        
    }
}
