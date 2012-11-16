/**
 * 
 */
package ml;
import java.io.*;
import java.util.Arrays;

/**
 * @author Aishraj
 *
 */
public class Perceptron {
	
	final static double learningRate = 0.1;
	static double w1 = 0.45;
	static double w2 = 0.45;
	
	static double signum(double dotValue) {
		double epsilon = 0.000000000000000001;
		if (dotValue > epsilon) {
			return 1.00;
		}
		else {
			return -1.00;
		}
	}
	
	static double getOh(double[] w, double[] x) {
		double sum = 0.00;
		//System.out.println(w.length);
		//System.out.println(x.length);
		for (int i = 0; i < w.length; i++) {
			sum += w[i]*x[i];
		}
		return signum(sum);
	}
		

	
	static double updateWeight(double wi, double t, double o, double xi) {
		wi = wi + getDeltaWi(t,o,xi);
		return wi;
	}
	
	static double getDeltaWi(double t, double o, double xi) {
		double deltaWi = 0.00;
		deltaWi = learningRate * (t - o) * xi;
		return deltaWi;
	}
	
	public static void main(String[] args) throws IOException {
		/*
		 * The first three inputs are w0 (threshold) , x1 and x2 
		 */
		
		/*
		double w0 = Float.parseFloat(args[0]);
		double x1 = Float.parseFloat(args[1]);
		double x2 = Float.parseFloat(args[2]); */
		
		System.out.println("Give the threshold value");
		
		BufferedReader R = new BufferedReader(new InputStreamReader(System.in));
		double w0 = Float.parseFloat(R.readLine());
		
		double w[] = new double[3];
		w[0] = w0;
		w[1] = w1;
		w[2] = w2;
		
		
		double trainingData[][] = new double[4][2];
		trainingData[0][0] = -1.00;
		trainingData[0][1] = -1.00;
		
		trainingData[1][0] = -1.00;
		trainingData[1][1] = 1.00;
		
		trainingData[2][0] = 1.00;
		trainingData[2][1] = -1.00;
		
		trainingData[3][0] = 1.00;
		trainingData[3][1] = 1.00;
		
		double t[] = {-1,-1,-1,1};
		
		System.out.println("Starting the training");
		for (int i = 0; i < 4; i++) {
			for  (int j = 0; j < 2; j++) {
				
				System.out.print("w1:"+w1+"\t");
				System.out.println("w2:"+w2);
				double curX[] = Arrays.copyOf(trainingData[i], 3);
				for (int k =0; k < 2; k++) {
					w[k]= updateWeight(w[k],t[i],getOh(w,curX),trainingData[i][j]);
				}
				//w[i] = updateWeight(w[i],t[i],getOh(w,curX),trainingData[i][j]);
				
				System.out.println("Updated values");
			
			}	
		}
		
		System.out.println("Training Complete");
		
		System.out.println("New values are"+ w1 + " " + w2);
		
		System.out.println("Give Input");
		double x[] = new double[3];
		x[0] = 1;
		x[1] = Double.parseDouble(R.readLine());
		x[2] = Double.parseDouble(R.readLine());
		
		System.out.println("The answer is" + " " + getOh(w,x));
		
	}
	
};
