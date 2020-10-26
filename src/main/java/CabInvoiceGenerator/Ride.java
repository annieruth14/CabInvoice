package CabInvoiceGenerator;

public class Ride{
	private double distance;
	private int time;
	private String rideType;
	

	public Ride(String ride, double distance, int time) {
		this.distance = distance; 
		this.time = time;
		this.rideType = ride;
	}

	public String getRideType() {
		return rideType;
	}

	public void setRideType(String ride) {
		this.rideType = ride;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}
