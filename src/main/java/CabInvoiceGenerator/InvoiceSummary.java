package CabInvoiceGenerator;

public class InvoiceSummary {

	private double averageFare;
	private double fare;
	private int rides;

	public InvoiceSummary(int rides, double totalFare, double averageFare) {
		this.fare = totalFare;
		this.rides = rides;
		this.averageFare = totalFare/totalFare;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (Double.doubleToLongBits(fare) != Double.doubleToLongBits(other.fare))
			return false;
		if (rides != other.rides)
			return false;
		return true;
	}
}
