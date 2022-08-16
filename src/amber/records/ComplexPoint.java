package amber.records;

public record ComplexPoint(double real, double imaginary) {
	public ComplexPoint {
		if (!Double.isFinite(real) || !Double.isFinite(imaginary)) {
			throw new IllegalArgumentException("arguments must be finite");
		}
	}
}
