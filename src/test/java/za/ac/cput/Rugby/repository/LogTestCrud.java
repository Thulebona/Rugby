package za.ac.cput.Rugby.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import za.ac.cput.Rugby.App;
import za.ac.cput.Rugby.domain.*;
import za.ac.cput.Rugby.factory.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-05-10.
 */
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class LogTestCrud extends AbstractTestNGSpringContextTests {

    private Teams_log_ranking log_ranking;
    private Team_profile team ;
    private Map<String,String> value;
    private Map<String,String> playRec_value;
    private Map<String,String> recvalue;
    private Map<String,String> myString;
    private Map<String,Integer> myInt;
    private Map<String,Integer> logValues;
    private Map<String,Double> myDouble;

    private Team_Records team_rec;

    private Player_profile player;
    private Player_profile player2;
    private Player_Records player_rec;
    private List<Player_profile> players;
    private Long id;
    @Autowired
    Teams_log_rankingRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {
        value = new HashMap<String, String>();
        recvalue = new HashMap<String, String>();
        myString = new HashMap<String, String>();
        myInt = new HashMap<String, Integer>();
        logValues = new HashMap<String, Integer>();
        myDouble = new HashMap<String, Double>();
        players = new ArrayList<Player_profile>();
        playRec_value = new HashMap<String, String>();
    }

   // @Test
    public void testCreate() throws Exception {
        //add team profile map;
        value.put("teamName", "Sharks");
        value.put("league", "Currie Cup");
        value.put("home_Ground", "Kings Park Stadium in Durban");
        value.put("headCoach", " Matt Todd");

        // add team record map
        recvalue.put("recordDate", "01/05/2010");
        recvalue.put("recordDescription","6 times currie cup winners");


        // add Player_profile 1
        myString.put("playerID", "851206 5367 088");
        myString.put("player_name","tendai mtawarira");
        myString.put("DOB"," August-1-1985");
        myString.put("position","Lock");
        myDouble.put("height",1.8);
        myDouble.put("weight",116.0);
        myInt.put("test",50);
        myInt.put("test_tries", 8);
        player = Player_profileFactory.getPlayer_profile(myString, myInt, myDouble, player_rec/*,team*/);

        // add Player_profile 1
        myString.put("playerID", "841206 6951 088");
        myString.put("player_name","bismarck du plessis");
        myString.put("DOB"," May-22-1984");
        myString.put("position", "Hooker");
        myDouble.put("height",1.89);
        myDouble.put("weight",114.0);
        myInt.put("test",40);
        myInt.put("test_tries", 10);

        playRec_value.put("recordDate", "01/08/2010");
        playRec_value.put("recordDescription","best player of the year");

        player_rec = Player_RecordsFactory.getPlayer_Record(playRec_value/*, player*/);
        player2 = Player_profileFactory.getPlayer_profile(myString, myInt, myDouble, player_rec/*,team*/);
        team_rec = Team_RecordsFactory.getTeam_Record(recvalue/*, team*/);

        players.add(player);
        players.add(player2);
        team = Team_profileFactory.getTeamProfile(value, team_rec, players);
        /// add log

        logValues.put("played",0);
        logValues.put("win",0);
        logValues.put("lose",0);
        logValues.put("draw",0);
        logValues.put("pointFor",0);
        logValues.put("pointAgainst",0);
        logValues.put("bonusPoint",0);

        log_ranking = Teams_logFactory.getTeams_log_ranking(team, logValues);
        repository.save(log_ranking);
        id = team.getId();
        Assert.assertNotNull(id);

    }

   // @Test(dependsOnMethods = "testCreate")
    public void testRead() throws Exception {
        log_ranking = repository.findOne(id);
        Assert.assertEquals("tendai mtawarira", log_ranking.getTeam().getPlayers().get(0).getPlayer_name());
    }

    //@Test(dependsOnMethods = "testRead")
    public void testUpdate() throws Exception {

        log_ranking = repository.findOne(id);
       Teams_log_ranking log =new Teams_log_ranking.Builder(team)
                                  .copy(log_ranking).build();
        repository.save(log);
        Assert.assertEquals(0,log.getTotal());

    }

   // @Test(dependsOnMethods = "testUpdate")
    public void testDelete() throws Exception {
        log_ranking = repository.findOne(id);
        repository.delete(log_ranking);
        Teams_log_ranking log = repository.findOne(id);
        Assert.assertNull(log);
    }
}
