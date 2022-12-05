package portfolioOptimization;

public class Asset {
	// the expected return of an asset
	private String assetName;
	
	// the expected return of an asset
	private double expectedReturn;
	
	// the standard deviation of an asset
	private double standardDeviation;
	
	// constructor
	public Asset(String assetName, double expectedReturn, double standardDeviation) {
		super();
		this.assetName = assetName;
		this.expectedReturn = expectedReturn;
		this.standardDeviation = standardDeviation;
	}
	
	// getters
	public String getAssetName() {
		return assetName;
	}	

	public double getExpectedReturn() {
		return expectedReturn;
	}

	public double getStandardDeviation() {
		return standardDeviation;
	}
}
