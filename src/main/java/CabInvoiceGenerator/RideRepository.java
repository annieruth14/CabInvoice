package CabInvoiceGenerator;

import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RideRepository {
	HashMap<String, ArrayList<Ride>> userRides = new HashMap<String, ArrayList<Ride>>();

	public void addRides(String userId, ArrayList<Ride> rideList) {
		if(userRides.get(userId) == null ) {
			userRides.put(userId, rideList);
		}
	}

	public ArrayList<Ride> getRidesData(String userId) {
		return userRides.get(userId);
	}
}
 