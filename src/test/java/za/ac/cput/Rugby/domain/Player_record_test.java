package za.ac.cput.Rugby.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.Rugby.factory.Player_RecordsFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Player_record_test {
    private Player_Records record;
    private Map<String,String> values;
    private Player_profile player;
    @Before
    public void setUp() throws Exception {
        values = new HashMap<String, String>();
    }
  //  @Test
    public void testRecords() throws Exception {
       // player = new Player_profile.Builder("kt93").player_name("john you").build();
        values.put("recordDate","19/02/2014");
        values.put("recordDescription","player of the tournament");

        record = Player_RecordsFactory.getPlayer_Record(values/*,player*/);
        Assert.assertEquals("19/02/2014", record.getRecordDate());
    }
  //  @Test
    public void testRecordsUpdate() throws Exception {
       // player = new Player_profile.Builder("kt93").player_name("john you").build();
        values.put("recordDate","19/02/2014");
        values.put("recordDescription","player of the tournament");

        record = Player_RecordsFactory.getPlayer_Record(values/*,player*/);

        Player_Records newPlayerRec = new Player_Records.Builder(record.getRecordDate())
                                          .copy(record)
                                          .recordDescription("player of the season")
                                          //.recordDate("12/8/2009")
                                          .build();

        Assert.assertEquals("player of the season", newPlayerRec.getRecordDescription());
        Assert.assertEquals("player of the tournament", record.getRecordDescription());

        Assert.assertEquals("12/8/2009", newPlayerRec.getRecordDate());
        Assert.assertEquals("19/02/2014", record.getRecordDate());

    }
}
