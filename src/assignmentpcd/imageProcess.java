/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentpcd;

import java.util.Random;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

/**
 *
 * @author Badrus
 */
public class imageProcess {
    //atributnya
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    
    public static Mat toGray(Mat mat) {
        Mat matGs = new Mat(mat.height(), mat.width(), CvType.CV_8U);
        
        for (int i = 0; i < mat.height(); i++) {
            for (int j = 0; j < mat.width(); j++) {
                double[] data = mat.get(i, j);

                double avg = 0;
                double r = data[0];
                double g = data[1];
                double b = data[2];
                
                avg = (r + g + b) / 3;
                matGs.put(i, j, avg);
            }
        }

        return matGs;
    }
    public static Mat toSaltPepper(Mat mat, double pa, double pb) {
        Mat matNew = new Mat(mat.width(), mat.height(), CvType.CV_8U);
        mat.copyTo(matNew);
        int amount1 = (int) (mat.rows() * mat.cols() * pa);
        int amount2 = (int) (mat.rows() * mat.cols() * pb);
        for (int counter = 0; counter < amount1; ++counter) {

            int x = getRandomNumberInRange(0, mat.rows());
            int y = getRandomNumberInRange(0, mat.cols());
            matNew.put(x, y, 0);

        }
        for (int counter = 0; counter < amount2; ++counter) {
            int x = getRandomNumberInRange(0, mat.rows());
            int y = getRandomNumberInRange(0, mat.cols());
            matNew.put(x, y, 255);
        }
        
        return matNew;
    }
}


