package no.hvl.dat100ptc.oppgave5;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

import javax.swing.JOptionPane;

public class ShowProfile extends EasyGraphics {

	private static final int MARGIN = 50;  // margin on the sides 
	
	private static int MAXBARHEIGHT = 500; // assume no height above 500 meters
	
	private GPSPoint[] gpspoints;

	public ShowProfile() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		GPSComputer gpscomputer =  new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		int N = gpspoints.length; // number of data points

		makeWindow("Height profile", 2 * MARGIN + 3 * N, 2 * MARGIN + MAXBARHEIGHT);

		// top margin + height of drawing area
		showHeightProfile(MARGIN + MAXBARHEIGHT); 
	}

	public void showHeightProfile(int ybase) {

		// ybase indicates the position on the y-axis where the columns should start
	
		int x = MARGIN;

		// TODO - START
		
			double[]elevat = new double[gpspoints.length];
		for(int i = 0; i < elevat.length; i++) {
			if (gpspoints[i].getElevation() < 0)
				elevat[i] = 0;
			else 
				elevat[i] = gpspoints[i].getElevation();
		}
		int skalering = Integer.parseInt(getText("Skalering: "));
		
		for (double e : elevat) {
		
			
			setColor(3,150,50);
			pause(skalering);
			drawLine(x, ybase, x, ybase-(int)e);
			
			x += 2;
		}
		//throw new UnsupportedOperationException(TODO.method());
	
		// TODO - SLUTT
/* Oppgaven skal visualieres høyde-kurven for ruten gitt ved GPS datapunktene. det finnes allerede en main-metode som setter opp et vindu
* som kan brukes til å tegne hydeprofilen og som ber om navn på datafil som skal vialisere short, medium long og vm. 
* det leses inn data fra GPS datafilen ved oppstart og lagrer GPS i en tabell gpspoints med GPS punktene. (private GPSPoint[] gpspoints;)
* implementerer metoden showHeightProfile(int ybase) som tegner høydeprofilen der parameteren ybase angir hvor på y-aksen bunnen av en søylene skal starte.
*double[]elevat = new double[gpspoints.length];
		*for(int i = 0; i < elevat.length; i++) {
			*if (gpspoints[i].getElevation() < 0)
				*elevat[i] = 0;
*bruker en løkke for å iterer igjennom alle punktene og oppdaterer start (x,ybase)-punkt ig slutt (x,y2)-punkt for linjer som kan tegne med drawline metode i easygraphivs. 
*den symbolske konstaten MARGIN i klassen angir hvor på x-aksen den første vertikale linjen skal tenges.
*else elevat[i] = gpspoints[i].getElevation();. 
	}
}
