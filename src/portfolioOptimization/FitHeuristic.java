package portfolioOptimization;

public class FitHeuristic {

	public static void main(String[] args) {
		// example input data
		// create the assets
		
		Asset[] assets = new Asset[4];
		assets[0] = new Asset("A", 1.4, 0.8);
		assets[1] = new Asset("B", 1.2, 0.5);
		assets[2] = new Asset("C", 1.6, 0.9);
		assets[3] = new Asset("D", 1.1, 0.5);
		
		// create the covariance
		Covariance[] covariances = new Covariance[4];
		covariances[0] = new Covariance("A", 1, -0.2, 0.8, -0.5);
		covariances[1] = new Covariance("B", -0.2, 1, 0.4, 0.2);
		covariances[2] = new Covariance("C", 0.8, 0.4, 1, -0.2);
		covariances[3] = new Covariance("D", -0.5, 0.2, -0.2, 1);
		
		// calc portfolio
		calcPortfolio(assets, covariances, 10000000, 0.52);		
	}
	
	// this method is to generate weights for the portfolio
	public static double[] generatePortfolioWeights() {
		double[] weights = new double[4];
		double sumWeights = 0;
		
		// get random numbers for each of the four assets
		for(int i = 0; i < weights.length; i++) {
			weights[i] = Math.random();
			sumWeights += weights[i];
		}
		
		// normalize weights so that the sum is 1
		for(int i = 0; i < weights.length; i++) {
			weights[i] = weights[i] / sumWeights;
		}
		
		return weights;
	}
	
	// this method is to calculate the return of assets in a given portfolio
	public static double calcReturn(Asset[] assets, double[] weights) {
		double sumReturn = 0;
		
		for(int i = 0; i < weights.length; i++) {
			sumReturn += weights[i] * assets[i].getExpectedReturn();
		}

		return sumReturn;
	}
	
	// this method caluclates the combined variance of two assets
	public static double calcVariance(Asset[] assets, double[] weights, Covariance[] covariances) {
		double sumVariance = 0;
		double covarianceCombi = 0;
		
		// go through all combination of assets
		for(int i = 0; i < assets.length; i++) {
			for(int j = 0 + i; j < assets.length; j++) {
				if(i == j) {
					sumVariance += weights[i] * weights[i] * assets[i].getStandardDeviation() * assets[i].getStandardDeviation();
				} else {
					// choose covariance
					covarianceCombi = covariances[i].getAssetD();
					if(j == 0) {
						covarianceCombi = covariances[i].getAssetA();
					} else if (j == 1) {
						covarianceCombi = covariances[i].getAssetB();
					} else if (j == 2) {
						covarianceCombi = covariances[i].getAssetC();
					} 
					
					// calculate variance of all combinations
					sumVariance += (weights[i] * assets[i].getStandardDeviation() * weights[j] * assets[j].getStandardDeviation() * covarianceCombi) * 2;
				}
			}
		}
		return sumVariance;
	}
	
	// this method calls calcReturn and calcVariance on a given portfolio weight
	public static void calcPortfolio(Asset[] assets, Covariance[] covariances, double repetation, double maxVariance) {
		// initialize variables
		double expectedReturn = 0;
		double expectedVariance = 0;
		double bestReturn = 0;
		double[] bestPortfolio = new double[6];
		double[] weightsMethod = new double[4];
		int i = 0;
		
		while(i <= repetation) {
			// calculate return and variance of those assets
			weightsMethod = generatePortfolioWeights();
			expectedReturn = calcReturn(assets, weightsMethod);
			expectedVariance = calcVariance(assets, weightsMethod, covariances);
			
			// if better portfolio found, save it in the fields
			if((bestReturn < expectedReturn) & (expectedVariance <= maxVariance)) {
				bestReturn = expectedReturn;
				bestPortfolio[0] = weightsMethod[0];
				bestPortfolio[1] = weightsMethod[1];
				bestPortfolio[2] = weightsMethod[2];
				bestPortfolio[3] = weightsMethod[3];
				bestPortfolio[4] = expectedReturn;
				bestPortfolio[5] = expectedVariance;
			}
			i++;
		}	
		// print statement
		printPortfolio(bestPortfolio);
}
	
	// method to print out results
	public static void printPortfolio(double[] bestPortfolio) {
		System.out.println("The best portfolio is:");
		System.out.println("1. Weight: " + bestPortfolio[0] + ", 2. Weight: " + bestPortfolio[1] + ", 3. Weight: " + bestPortfolio[2] + ", 4. Weight: " + bestPortfolio[3]);
		System.out.println("Expected Return: " + bestPortfolio[4] + ", Expected Variance: " + bestPortfolio[5]);
	}
}
