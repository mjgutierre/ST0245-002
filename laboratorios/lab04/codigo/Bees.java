
/**
 * Bees 
 * @author Maria Paulina Ocampo Duque,Maria Jose Gutierrez Estrada
 * @version 25/10/2020
 */
public class Bees
{
    private double latitude;
    private double longitude;
    private double altitude;
     public Bees(double latitude, double longitude, double altitude){
        this.latitude=latitude;
        this.longitude=longitude;
        this.altitude=altitude;
    }
     public double getLatitude(){
        return latitude;
    }
     public double getLongitude(){
        return longitude;
    }
     public double getAltitude(){
        return altitude;
    }
}
