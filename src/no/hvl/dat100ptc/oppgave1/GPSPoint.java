package no.hvl.dat100ptc.oppgave1;

public class GPSPoint {

	/* Deklarering av objektvariablene:
	 * tid, breddegrad, lengdegrad og høyde. */
	
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
		
	public GPSPoint(int time, double latitude, double longitude, double elevation) {

		/* Implementerer konstruktører for
		initialisering av objektvariablene. */
		   
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	
	}

	
	/* Get-metoden returnerer verdien på variabelen. 
	 * Set-metoden setter verdien på variabelen. */
	
	public int getTime() {
		
		return time;
		
	}

	public void setTime(int time) {
				
		this.time = time;

	}

	public double getLatitude() {
		
		return latitude;
		
	}

	public void setLatitude(double latitude) {
		
		this.latitude = latitude;
		
	}

	public double getLongitude() {
		
		return longitude;
		
	}

	public void setLongitude(double longitude) {
		
		this.longitude = longitude;
		
	}

	public double getElevation() {
		
		return elevation;
		
	}

	public void setElevation(double elevation) {
		
		this.elevation = elevation;
		
	}
	
	
	public String toString() {
		
		/* Deklarerer en String-variabel og gir den en tekst som inneholder:
		 * tid, breddegrad, lengdegrad og høyde. Returnerer så String-variabelen. */
		
		String str = time + " (" +  latitude + "," + longitude + ") " + elevation + "\n";
		
		return str;	 
	}
	
}
