package amber.records;

public class RecordUse {
	public static void main(String[] args) {
		ComplexPoint p = new ComplexPoint(1, 1);
		System.out.println(p.real());
		System.out.println(p.imaginary());
		System.out.println(p);
		ComplexPoint illegalPoint = new ComplexPoint(Double.NaN, 0);// exception
	}
}
