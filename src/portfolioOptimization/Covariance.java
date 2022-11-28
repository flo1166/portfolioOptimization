package portfolioOptimization;

public class Covariance {
	// the name of the asset which the covariances belong to
	private String assetNameCov;
	
	// the covariance of assetNameCov with asset A
	private double assetA;

	// the covariance of assetNameCov with asset B
	private double assetB;
	
	// the covariance of assetNameCov with asset C
	private double assetC;
	
	// the covariance of assetNameCov with asset D
	private double assetD;

	// constructor
	public Covariance(String assetNameCov, double assetA, double assetB, double assetC, double assetD) {
		super();
		this.assetNameCov = assetNameCov;
		this.assetA = assetA;
		this.assetB = assetB;
		this.assetC = assetC;
		this.assetD = assetD;
	}

	// getters
	public String getAssetNameCov() {
		return assetNameCov;
	}

	public double getAssetA() {
		return assetA;
	}

	public double getAssetB() {
		return assetB;
	}

	public double getAssetC() {
		return assetC;
	}

	public double getAssetD() {
		return assetD;
	}
	
	
}
