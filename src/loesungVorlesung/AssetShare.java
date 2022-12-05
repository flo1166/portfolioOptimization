package loesungVorlesung;

import portfolioOptimization.Asset;

public class AssetShare {
	
	Asset asset;
	double share;
	
	// constructor
	public AssetShare(Asset asset, double share) {
		this.asset = asset;
		this.share = share;
	}
	
	public AssetShare(Asset asset) {
		this(asset, Math.random());
	}
	
	public static AssetShare[] randomAssetShares(Asset[] assets) {
		AssetShare[] assetShares = new AssetShare[assets.length];
		
		double sum = 0;
		
		for(int i = 0; i < assets.length; i++) {
			assetShares[i] = new AssetShare(assets[i]);
			sum += assetShares[i].share;
		}
		
		for(int i = 0; i < assets.length; i++) {
			assetShares[i].share = assetShares[i].share / sum;
		}
		
		return assetShares;
	}
}
