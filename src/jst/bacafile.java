/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jst;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Mu'ti C Putro
 */
public class bacafile {

    private ArrayList<double[]> temp = new ArrayList<>();
    private ArrayList<int[]> listData = new ArrayList<>();

    public static int[][] input = {{0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {0, 0, 1, 0, 0}, {0, 0, 1, 1, 0}, {0, 1, 0, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 0, 0}, {0, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 0, 0, 1, 0}, {1, 0, 1, 0, 0}, {1, 0, 1, 1, 0}, {1, 1, 0, 0, 0}, {1, 1, 0, 1, 0}, {1, 1, 1, 0, 0}, {1, 1, 1, 1, 0}};

    public bacafile() {
        bacaFile();
        convert();
        cekcek();
    }
    
    public void bacaFile() {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream("D:\\data.txt"));
            String pointer;
            while ((pointer = dis.readLine()) != null) {
                String[] s = pointer.split("\t");
                double[] d = new double[5];
                for (int i = 0; i < d.length; i++) {
                    d[i] = Double.parseDouble(s[i]);
                }
                temp.add(d);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    double getmax(int kolom) {
        double max = temp.get(0)[kolom] - 1;
        try {
            for (int i = 0; i < temp.size(); i++) {
                if (max < temp.get(i)[kolom]) {
                    max = temp.get(i)[kolom];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }

    double getmin(int kolom) {
        double min = temp.get(0)[kolom] + 1;
        try {
            for (int i = 0; i < temp.size(); i++) {
                if (min > temp.get(i)[kolom]) {
                    min = temp.get(i)[kolom];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return min;
    }

    void convert() {
        try {
            double[] tengah = new double[4];
            double[] d = new double[5];
            for (int i = 0; i < 4; i++) {
                tengah[i] = (getmax(i) + getmin(i)) / 2;
            }

            for (int i = 0; i < temp.size(); i++) {
                int[] dd = new int[5];
                for (int j = 0; j < temp.get(i).length; j++) {
                    if (j == temp.get(i).length - 1) {
                        dd[j] = (int) temp.get(i)[temp.get(i).length - 1];
                    } else if (temp.get(i)[j] <= tengah[j]) {
                        dd[j] = 0;
                    } else {
                        dd[j] = 1;
                    }
                }
                listData.add(dd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void cekcek() {
        try {
            for (int i = 0; i < listData.size(); i++) {
                for (int j = 0; j < input.length; j++) {
                    if (listData.get(i)[0] == input[j][0] && listData.get(i)[1] == input[j][1] && listData.get(i)[2] == input[j][2] && listData.get(i)[3] == input[j][3]) {
                        input[j][4] = listData.get(i)[4];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void output(){
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println("");
        }    
    }
    
//    public static void main(String[] args) {
//        bacafile bf = new bacafile();
//        bf.output();
//
//    }
}
