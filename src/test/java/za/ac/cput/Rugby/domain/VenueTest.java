package za.ac.cput.Rugby.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.Rugby.factory.VenueFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class VenueTest {
    private Map<String,String> value;
    private Venue venue;
    @Before
    public void setUp() throws Exception {
        value = new HashMap<String, String>();
    }

    @Test
    public void testVenue() throws Exception {
        //Venue.Builder(val.get("name")).location(val.get("location")).number_of_seat(seats).build()
        value.put("name","Newlands Stadium");
        value.put("location","Cape Town");
        venue = VenueFactory.getVenue(value, 51900);

        Assert.assertEquals(51900,venue.getNumber_of_seat());

    }

    @Test
    public void testVenueUpDate() throws Exception {
        //Venue.Builder(val.get("name")).location(val.get("location")).number_of_seat(seats).build()
        value.put("name","Newlands Stadium");
        value.put("location","Nelspruit");
        venue = VenueFactory.getVenue(value, 51900);

        Venue v = new Venue.Builder(venue.getVenueName()).copy(venue).location("Cape Town").build();

        Assert.assertEquals("Nelspruit",venue.getLocation());
        Assert.assertEquals("Cape Town",v.getLocation());

    }
}
