package loesungVorlesung;

import portfolioOptimization.Asset;

public class Portfolio {

	AssetShare[] assetShares;
	Covariance[] covariances;
	
	// constructor
	public Portfolio(Asset[] assets, Covariance[] covariances) {
		this(AssetShare.randomAssetShares(assets), covariances);
	}
		
	public Portfolio(AssetShare[] assetShares, Covariance[] covariances) {
		this.assetShares = assetShares;
		this.covariances = covariances;
	}
		
	public double expectedReturn() {
		double sum = 0;
		for(int i = 0; i < assetShares.length; i++) {
			sum += assetShares[i].share * assetShares[i].asset.getExpectedReturn();
		}
		return sum;
	}
	
	public double expectedVariance() {
		double variance = 0;
		
		for(int i = 0; i < assetShares.length; i++) {
			for(int j = 0; j < assetShares.length; j++) {
				variance += assetShares[i].share * assetShares[i].asset.getStandardDeviation() * assetShares[j].share * assetShares[j].asset.getStandardDeviation() * findCovariance(assetShares[i].asset, assetShares[j].asset).covariance;
			}
		}
		
		return variance;
	}
	
	private Covariance findCovariance(Asset assetI, Asset assetJ) {
		for(int i = 0; i < covariances.length; i++) {
			if(assetI == covariances[i].assetI && assetJ == covariances[i].assetJ) {
				return covariances[i];
			}
		}
		return null;
	}
}
