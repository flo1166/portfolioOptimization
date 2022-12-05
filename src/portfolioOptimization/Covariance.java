package portfolioOptimization;

public class Covariance {
	// the name of the asset which the covariances belong to
	private String assetNameCov;
	
	// the covariance of assetNameCov with asset A
	private double[] covarianceABCD;

	// constructor
	public Covariance(String assetNameCov, double[] covarianceABCD) {
		super();
		this.assetNameCov = assetNameCov;
		this.covarianceABCD = covarianceABCD;
	}	

	// getters
	public String getAssetNameCov() {
		return assetNameCov;
	}

	public double[] getcovarianceABCD() {
		return covarianceABCD;
	}
}
