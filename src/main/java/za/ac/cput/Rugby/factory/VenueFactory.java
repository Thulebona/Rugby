package za.ac.cput.Rugby.factory;

import za.ac.cput.Rugby.domain.Venue;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class VenueFactory {

    public static Venue getVenue(Map<String,String> val,int seats ){
        Venue venue = new Venue.Builder(val.get("name")).location(val.get("location"))
                          .number_of_seat(seats).build();
        return venue;
    }
}
