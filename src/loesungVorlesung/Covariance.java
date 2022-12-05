package loesungVorlesung;

import portfolioOptimization.Asset;

public class Covariance {
	
	Asset assetI;
	Asset assetJ;
	double covariance;
	
	// constructor
	public Covariance(Asset assetI, Asset assetJ, double covariance) {
		super();
		this.assetI = assetI;
		this.assetJ = assetJ;
		this.covariance = covariance;
	}
	
	
}
