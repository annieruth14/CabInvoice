package CabInvoiceGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InvoiceService {
	RideRepository rideRepository = new RideRepository();

	private static final double NORMAL_MINIMUM_COST_PER_KM = 10;
	private static final int NORMAL_COST_PER_MIN = 1;
	private static final double NORMAL_MINIMUM_FARE = 5;
	private static final double PREMIUM_MINIMUM_COST_PER_KM = 15;
	private static final int PREMIUM_COST_PER_MIN = 2;
	private static final double PREMIUM_MINIMUM_FARE = 20;
	
	public double calculateFareforNormalRide(double distance, int time) {
		double totalFare = (distance * NORMAL_MINIMUM_COST_PER_KM) + (time * NORMAL_COST_PER_MIN);
		return Math.max(totalFare, NORMAL_MINIMUM_FARE);
	}
	
	public double calculateFareforPremiumRide(double distance, int time) {
		double totalFare = (distance * PREMIUM_MINIMUM_COST_PER_KM) + (time * PREMIUM_COST_PER_MIN);
		return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
	}
 
	public InvoiceSummary calculateFare(ArrayList<Ride> rideList) {
		double totalFare = 0;
		for(Ride ride : rideList) {
			if(ride.getRideType().equals("Normal"))
				totalFare = totalFare + calculateFareforNormalRide(ride.getDistance(), ride.getTime());
			else 
				totalFare = totalFare + calculateFareforPremiumRide(ride.getDistance(), ride.getTime());
		}
		System.out.println(rideList.size());
		System.out.println(totalFare);
		System.out.println(totalFare/rideList.size());
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
