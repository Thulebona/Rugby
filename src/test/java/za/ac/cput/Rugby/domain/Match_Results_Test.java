package za.ac.cput.Rugby.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.Rugby.factory.FixturesFactory;
import za.ac.cput.Rugby.factory.Match_ResultsFactory;
import za.ac.cput.Rugby.factory.VenueFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class Match_Results_Test {
    private Map<String,Integer> intValues;
    private Map<String,String> values;
    private Map<String,String> val;
    private Fixtures fixtures;
    private Venue venue;
    private Match_Results result;
    private int seats  = 50000;
    @Before
    public void setUp() throws Exception {
        intValues = new HashMap<>();
        values = new HashMap<>();
        val = new HashMap<>();
    }

   /// @Test
      public void testResult() throws Exception {

        intValues.put("teamAGoal",40);
        intValues.put("teamBGoal", 36);

        values.put("time","15:00PM");
        values.put("A", "Sharks");
        values.put("B", "Blue Bulls");

        val.put("name","green point");
        val.put("location", "Cape Town");

        venue = VenueFactory.getVenue(val, seats);
        fixtures = FixturesFactory.getFixtures(values, venue, result);
        result = Match_ResultsFactory.getMatch_Result(intValues);

        Assert.assertEquals(40,result.getTeamAGoal());
    }
   // @Test
    public void testResultUpdate() throws Exception {
        intValues.put("teamAGoal",40);
        intValues.put("teamBGoal", 36);
        result = Match_ResultsFactory.getMatch_Result(intValues);

       Match_Results res = new Match_Results.Builder(result.getTeamAGoal())
                               .copy(result)
                               .teamBGoal(65).build();

        Assert.assertEquals(40,result.getTeamAGoal());
        Assert.assertEquals(50,res.getTeamAGoal());
        Assert.assertEquals(36,result.getTeamBGoal());
        Assert.assertEquals(65,res.getTeamBGoal());
    }
}
