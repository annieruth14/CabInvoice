package CabInvoiceGenerator;

import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;

public class InvoiceServiceTest {
	InvoiceService invoiceService = null;
	ArrayList<Ride> rideList = null;

	@Before
	public void loadData() {
		invoiceService = new InvoiceService();
		rideList = new ArrayList<>();
		rideList.add(new Ride(2.0, 5));
		rideList.add(new Ride(0.1, 1));
	}

	@Test
	public void givenDistanceAndTime_shouldReturnTotalFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTime_shouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceService.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRides_shouldReturnInvoiceSummary() {
		InvoiceSummary summary = invoiceService.calculateFare(rideList);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30, 15);
		Assert.assertEquals(expectedSummary, summary);
	}

	@Test
	public void givenUserIdAndRide_shouldReturnInvoiceSummary() {
		String userId = "a@b.com";
		invoiceService.addRides(userId, rideList);
		InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
		InvoiceSummary expectedSummary = new InvoiceSummary(2, 30, 15);
		Assert.assertEquals(expectedSummary, summary);
	}
}
