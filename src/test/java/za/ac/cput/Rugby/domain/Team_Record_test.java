package za.ac.cput.Rugby.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.Rugby.factory.Team_RecordsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Team_Record_test {
    private Team_Records record;
    private Map<String,String> val;
    private Team_profile team;
    @Before
    public void setUp() throws Exception {
        val = new HashMap<String, String>();
        team = new Team_profile.Builder("sharks").build();
    }
   // @Test
    public void testTeamRec() throws Exception {

          val.put("recordDate","31/11/2011");
          val.put("recordDescription","5 times league winners");

         Assert.assertEquals("31/11/2011",record.getRecordDate());
    }
    ///@Test
    public void testTeamRecUpdate() throws Exception {

        val.put("recordDate", "31/11/2011");
        val.put("recordDescription", "5 times league winners");
        record =  Team_RecordsFactory.getTeam_Record(val/*,team*/);

        Team_Records newRec = new Team_Records.Builder(record.getRecordDate())
                                  .copy(record)
                                  //.recordDate("01/11/2012")
                                  .recordDescription("6 times league winner in a row").build();

        Assert.assertEquals("31/11/2011", record.getRecordDate());
        Assert.assertEquals("6 times league winner in a row",newRec.getRecordDescription());
        Assert.assertEquals("5 times league winners",record.getRecordDescription());
    }
}
