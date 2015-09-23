package za.ac.cput.Rugby.domain;

import org.junit.Assert;
import org.junit.Before;
import za.ac.cput.Rugby.factory.Team_profileFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Team_profile_test {

    private List<Player_profile> player;
    private Map<String,String> val;
    private Team_Records rec;
    private Team_profile team;
    @Before
    public void setUp() throws Exception {
        val = new HashMap<String, String>();
        player = new ArrayList<Player_profile>();

        val.put("teamName","sharks");
        val.put("league", "ABSA Currie Cup");
    }

  //  @Test
    public void testProfile() throws Exception {

       // rec = new Team_Records.Builder(player.getTeam_profile()).build();
        Team_profile team = Team_profileFactory.getTeamProfile(val, rec, player);
        Assert.assertEquals("ABSA Currie Cup",team.getLeague());
    }
    //@Test
    public void testProfileUpdate() throws Exception {

        team = Team_profileFactory.getTeamProfile(val, rec, player);
        Team_profile newTeam = new Team_profile
                .Builder(team.getTeamName())
                .copy(team)
                .league("RFU Championship")
                .build();

        Assert.assertEquals(newTeam.getTeamName(),team.getTeamName());
        Assert.assertEquals("RFU Championship",newTeam.getLeague());
        Assert.assertEquals("ABSA Currie Cup",team.getLeague());
    }

}
