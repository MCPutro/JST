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

    public percobaan1() {
        bf = new bacafile();
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

//        this.u1.add((bacafile.input[0][0] * this.w11.get(0))
//                + (bacafile.input[0][1] * this.w21.get(0))
//                + (bacafile.input[0][2] * this.w31.get(0))
//                + (bacafile.input[0][3] * this.w41.get(0)));
//        this.u2.add((bacafile.input[0][0] * this.w12.get(0))
//                + (bacafile.input[0][1] * this.w22.get(0))
//                + (bacafile.input[0][2] * this.w32.get(0))
//                + (bacafile.input[0][3] * this.w42.get(0)));
//        this.u3.add((bacafile.input[0][0] * this.w13.get(0))
//                + (bacafile.input[0][1] * this.w23.get(0))
//                + (bacafile.input[0][2] * this.w33.get(0))
//                + (bacafile.input[0][3] * this.w43.get(0)));
        addU123(0);

//        this.z1.add(new Double(1 / (1 + Math.exp(this.u1.get(u1.size() - 1)))));
//        this.z2.add(new Double(1 / (1 + Math.exp(this.u2.get(u2.size() - 1)))));
//        this.z3.add(new Double(1 / (1 + Math.exp(this.u2.get(u2.size() - 1)))));
        addZ();

        this.v1.add(new Double(desimal(randomRang(-1, 1))));
        this.v2.add(new Double(desimal(randomRang(-1, 1))));
        this.v3.add(new Double(desimal(randomRang(-1, 1))));
        this.b4.add(desimal(randomRang(-1, 1)));

//        this.u4.add((this.z1.get(z1.size() - 1) * this.v1.get(v1.size() - 1))
//                + (this.z2.get(z2.size() - 1) * this.v2.get(v2.size() - 1))
//                + (this.z3.get(z3.size() - 1) * this.v3.get(v3.size() - 1)));
//        this.y.add(1 / (1 + Math.exp(this.u4.get(u4.size() - 1))));
        addU4Y();

//        this.err.add(bacafile.input[0][4] - y.get(y.size() - 1));
//        
//        this.dw11.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
//                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
//                * bacafile.input[0][0] * alpha);
//        this.dw21.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
//                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
//                * bacafile.input[0][1] * alpha);
//        this.dw31.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
//                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
//                * bacafile.input[0][2] * alpha);
//        this.dw41.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
//                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
//                * bacafile.input[0][3] * alpha);
//        this.db1.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
//                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
//                * alpha);
//
//        this.dw12.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
//                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
//                * bacafile.input[0][0] * alpha);
//        this.dw22.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
//                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
//                * bacafile.input[0][1] * alpha);
//        this.dw32.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
//                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
//                * bacafile.input[0][2] * alpha);
//        this.dw42.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
//                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
//                * bacafile.input[0][3] * alpha);
//        this.db2.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
//                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
//                * alpha);
//        //
//        this.dw13.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
//                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
//                * bacafile.input[0][0] * alpha);
//        this.dw23.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
//                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
//                * bacafile.input[0][1] * alpha);
//        this.dw33.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
//                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
//                * bacafile.input[0][2] * alpha);
//        this.dw43.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
//                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
//                * bacafile.input[0][3] * alpha);
//        this.db3.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
//                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
//                * alpha);
//
//        this.dv1.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * z1.get(z1.size() - 1) * alpha);
//        this.dv2.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * z2.get(z2.size() - 1) * alpha);
//        this.dv3.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * z3.get(z3.size() - 1) * alpha);
//        this.db4.add(
//                err.get(err.size() - 1) * y.get(y.size() - 1)
//                * (1 - y.get(y.size() - 1)) * alpha);
        addErrDelta(0);
        hitungMSE();
    }

    public double randomRang(double min, double max) {
        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }

    public void loop(int iterasi) {
        for (int i = 1; i < iterasi; i++) {
            addWV();
            addU123(i%16);
            addZ();
            addU4Y();
            addErrDelta(i%16);
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
                (bacafile.input[iterasike][0] * this.w11.get(w11.size() - 1))
                + (bacafile.input[iterasike][1] * this.w21.get(w21.size() - 1))
                + (bacafile.input[iterasike][2] * this.w31.get(w31.size() - 1))
                + (bacafile.input[iterasike][3] * this.w41.get(w41.size() - 1))));
        this.u2.add(desimal(
                (bacafile.input[iterasike][0] * this.w12.get(w12.size() - 1))
                + (bacafile.input[iterasike][1] * this.w22.get(w22.size() - 1))
                + (bacafile.input[iterasike][2] * this.w32.get(w32.size() - 1))
                + (bacafile.input[iterasike][3] * this.w42.get(w42.size() - 1))));
        this.u3.add(desimal(
                (bacafile.input[iterasike][0] * this.w13.get(w13.size() - 1))
                + (bacafile.input[iterasike][1] * this.w23.get(w23.size() - 1))
                + (bacafile.input[iterasike][2] * this.w33.get(w33.size() - 1))
                + (bacafile.input[iterasike][3] * this.w43.get(w43.size() - 1))));
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
        this.err.add(desimal(bacafile.input[iterasiKe][4] - y.get(y.size() - 1)));
//        System.out.println(bacafile.input[iterasiKe][4]+ " << "+iterasiKe);

        this.dw11.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bacafile.input[iterasiKe][0] * alpha));
        this.dw21.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bacafile.input[iterasiKe][1] * alpha));
        this.dw31.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bacafile.input[iterasiKe][2] * alpha));
        this.dw41.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v1.get(v1.size() - 1)
                * z1.get(z1.size() - 1) * (1 - z1.get(z1.size() - 1))
                * bacafile.input[iterasiKe][3] * alpha));
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
                * bacafile.input[iterasiKe][0] * alpha));
        this.dw22.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bacafile.input[iterasiKe][1] * alpha));
        this.dw32.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bacafile.input[iterasiKe][2] * alpha));
        this.dw42.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v2.get(v2.size() - 1)
                * z2.get(z2.size() - 1) * (1 - z2.get(z2.size() - 1))
                * bacafile.input[iterasiKe][3] * alpha));
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
                * bacafile.input[iterasiKe][0] * alpha));
        this.dw23.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bacafile.input[iterasiKe][1] * alpha));
        this.dw33.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bacafile.input[iterasiKe][2] * alpha));
        this.dw43.add(desimal(
                err.get(err.size() - 1) * y.get(y.size() - 1)
                * (1 - y.get(y.size() - 1)) * v3.get(v3.size() - 1)
                * z3.get(z3.size() - 1) * (1 - z3.get(z3.size() - 1))
                * bacafile.input[iterasiKe][3] * alpha));
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
        return "percobaan1{" + "\nw11 = " + w11
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

}
