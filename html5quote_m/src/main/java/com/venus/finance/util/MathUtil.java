package com.venus.finance.util;

import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

public class MathUtil {
	public double[] generateFormula(Double[] arrayX, Double[] arrayY, int degree) {
		WeightedObservedPoints points = new WeightedObservedPoints();
		for(int i=0;i<arrayX.length;i++){
			points.add(arrayX[i], arrayY[i]);
		}
		PolynomialCurveFitter fitter = PolynomialCurveFitter.create(degree);   
		double[] result = fitter.fit(points.toList());
		return result; 
	}

}
