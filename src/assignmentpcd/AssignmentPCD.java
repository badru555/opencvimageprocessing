/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignmentpcd;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**00
 *
 * @author Badrus
 */
public class AssignmentPCD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat mat = Imgcodecs.imread("fruits.png", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        Mat matPlus = Imgcodecs.imread("balloons_noisy.png", Imgcodecs.CV_LOAD_IMAGE_COLOR);
        
        Mat toGray = imageProcess.toGray(mat);
        Mat toSaltPepper = imageProcess.toSaltPepper(toGray, 0.01, 0.05);

        Mat matrikKosong = new Mat();
        Mat matrikKosong2 = new Mat();

        Imgproc.medianBlur(toSaltPepper, matrikKosong, 5);
        Imgproc.medianBlur(matPlus, matrikKosong2, 5);
        
        //HighGui.imshow("Gambar Asli",mat);
        HighGui.imshow("RGB to Gray", toGray); //1
        HighGui.imshow("Gray to Pepper", toSaltPepper); //2
        HighGui.imshow("medianFilter", matrikKosong); //3
        //HighGui.imshow("Gambar Asli dri Google",matPlus);
        HighGui.imshow("medianFilter From Google", matrikKosong2); //5
              
        HighGui.waitKey(0);

    }
    
}