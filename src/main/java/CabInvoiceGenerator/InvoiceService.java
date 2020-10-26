package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceService {
	RideRepository rideRepository = new RideRepository();

	private static final double MINIMUM_COST_PER_KM = 10;
	private static final int COST_PER_MIN = 1;
	private static final double MINIMUM_FARE = 5;

	public double calculateFare(double distance, int time) {
		double totalFare = (distance * MINIMUM_COST_PER_KM) + (time * COST_PER_MIN);
		return Math.max(totalFare, MINIMUM_FARE);
	}
 
	public InvoiceSummary calculateFare(ArrayList<Ride> rideList) {
		double totalFare = 0;
		for(Ride ride : rideList) {
			totalFare = totalFare + calculateFare(ride.getDistance(), ride.getTime());
		}
		return new InvoiceSummary(rideList.size(), totalFare , totalFare/rideList.size());
	}

	public void addRides(String userId, ArrayList<Ride> rideList) {
		rideRepository.addRides(userId, rideList);
	}

	public InvoiceSummary getInvoiceSummary(String userId) {
		ArrayList<Ride> rideList = rideRepository.getRidesData(userId);
		return calculateFare(rideList); 
	}

}
