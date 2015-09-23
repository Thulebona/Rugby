package za.ac.cput.Rugby.domain;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.Rugby.factory.Player_profileFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Player_profile_test extends TestCase{

    private Player_profile player;
    private Map<String,Integer> myInt;
    private Map<String,String> myString;
    private Map<String,Double> myDouble;
    private Player_Records rec;
    //private Team_profile prof;

    @Before
    public void setUp() throws Exception {
        myInt = new HashMap<String, Integer>();
        myString = new HashMap<String, String>();
        myDouble = new HashMap<String, Double>();
     //   prof = new Team_profile.Builder("sharks").build();
    }
    //@Test
    public void testPlayer() throws Exception {

        myInt.put("playerID",506);
        myString.put("player_name","john you");
        myString.put("DOB","19/02/1993");
        myDouble.put("weight",50.00);
        myDouble.put("height",1.8);
        myInt.put("test",5);
        myInt.put("test_tries",6);
        myString.put("position","block");

        //rec = new Player_Records.Builder(player).build();
        player = Player_profileFactory.getPlayer_profile(myString, myInt, myDouble, rec/*, prof*/);

        assertEquals(50.00,player.getWeight());
    }
    //@Test
    public void testPlayerUpdate() throws Exception {

        myInt.put("playerID",506);
        myString.put("player_name","john you");
        myString.put("DOB","19/02/1993");
        myDouble.put("weight",50.00);
        myDouble.put("height",1.8);
        myInt.put("test",5);
        myInt.put("test_tries",6);
        myString.put("position","block");
        player = Player_profileFactory.getPlayer_profile(myString, myInt, myDouble, rec/*, prof*/);

        Player_profile newPlayer = new Player_profile.Builder(player.getPlayerID())
                                       .copy(player)
                                       .DOB("06/12/1993")
                                        .position("forward")
                                        .height(1.6).build();
       // rec = new Player_Records.Builder(player).build();

        assertEquals(1.8, player.getHeight());
        assertEquals(1.6, newPlayer.getHeight());
        Assert.assertEquals("06/12/1993", newPlayer.getDOB());
        Assert.assertEquals("19/02/1993", player.getDOB());
        Assert.assertEquals("forward", newPlayer.getPosition());
        Assert.assertEquals("block", player.getPosition());
    }
}
