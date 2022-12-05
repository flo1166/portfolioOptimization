package loesungVorlesung;

import portfolioOptimization.Asset;

public class Solver {

	public static void main(String[] args) {
		
		Asset[] assets = new Asset[4];
		assets[0] = new Asset("A", 1.4, 0.8);
		assets[1] = new Asset("B", 1.2, 0.5);
		assets[2] = new Asset("C", 1.6, 0.9);
		assets[3] = new Asset("D", 1.1, 0.5);
		
		Covariance[] covariances = new Covariance[assets.length * assets.length];
		covariances[0] = new Covariance(assets[0], assets[0], 1);
		covariances[1] = new Covariance(assets[0], assets[1], -0.2);
		covariances[2] = new Covariance(assets[0], assets[2], 0.8);
		covariances[3] = new Covariance(assets[0], assets[3], -0.5);
		covariances[4] = new Covariance(assets[1], assets[0], -0.2);
		covariances[5] = new Covariance(assets[1], assets[1], 1);
		covariances[6] = new Covariance(assets[1], assets[2], 0.4);
		covariances[7] = new Covariance(assets[1], assets[3], 0.2);
		covariances[8] = new Covariance(assets[2], assets[0], 0.8);
		covariances[9] = new Covariance(assets[2], assets[1], 0.4);
		covariances[10] = new Covariance(assets[2], assets[2], 1);
		covariances[11] = new Covariance(assets[2], assets[3], -0.2);
		covariances[12] = new Covariance(assets[3], assets[0], -0.5);
		covariances[13] = new Covariance(assets[3], assets[1], 0.2);
		covariances[14] = new Covariance(assets[3], assets[2], -0.2);
		covariances[15] = new Covariance(assets[3], assets[3], 1);
		
		Portfolio bestPortfolio = null;
		
		for(int i = 0; i < 10000000; i++) {
			Portfolio portfolio = new Portfolio(assets, covariances);
			if(portfolio.expectedVariance() <= 0.52 && 
					(bestPortfolio == null || portfolio.expectedReturn() > bestPortfolio.expectedReturn())) {
				bestPortfolio = portfolio;
			}
		}
		System.out.println(bestPortfolio.expectedReturn());
	}

}
