package testCode;

import java.util.Scanner;

public class LatLongDistanceCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		final double MILES_TO_FEET = 5280;
		double length, oldLat, newLat, oldLng, newLng, absHeight, absLength;
		
		oldLat = 39.981484;
		oldLng = -75.153157;
		
		Scanner sc = new Scanner(System.in);
		
		newLat = sc.nextDouble();
		newLng = sc.nextDouble();
		
		double theta = oldLng - newLng;
		double dist = Math.sin(deg2rad(oldLat)) * Math.sin(deg2rad(newLat)) + Math.cos(deg2rad(oldLat)) * Math.cos(deg2rad(newLat)) * Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		
		System.out.println("Distance: " + dist);
		System.out.println("Distance in Ft: " + (dist*MILES_TO_FEET));	
		
		sc.close();

	}
	
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts decimal degrees to radians						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	/*::	This function converts radians to decimal degrees						 :*/
	/*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}

}
