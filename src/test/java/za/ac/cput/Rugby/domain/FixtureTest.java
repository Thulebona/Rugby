package za.ac.cput.Rugby.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.Rugby.factory.FixturesFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class FixtureTest {
    private Fixtures fixture;
    private Map<String,String> value;
    private Match_Results result;
    private Venue venue;
    @Before
    public void setUp() throws Exception {
        value = new HashMap<String, String>();
    }

   // @Test
    public void testFixtures() throws Exception {
        result = null;

        value.put("date","Friday,12/05/2015");
        value.put("time","15:00PM");
        value.put("A","sharks");
        value.put("B","Loins");
        fixture = FixturesFactory.getFixtures(value, venue, result);
        Assert.assertEquals("15:00PM",fixture.getMatchTime());

    }
  //  @Test
    public void testFixturesUpDate() throws Exception {

        value.put("date","Friday,12/05/2015");
        value.put("time","15:00PM");
        value.put("A","sharks");
        value.put("B","Loins");
        fixture = FixturesFactory.getFixtures(value, venue, result);

        Fixtures fix = new Fixtures.Builder(fixture.getMatchDate())
                            .copy(fixture)
                            .teamAName("WC Province").build();

        Assert.assertEquals("WC Province",fix.getTeamAName());
        Assert.assertEquals("sharks",fixture.getTeamAName());

    }
}
