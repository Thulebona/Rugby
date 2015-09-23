package za.ac.cput.Rugby.factory;

import za.ac.cput.Rugby.domain.Player_profile;
import za.ac.cput.Rugby.domain.Team_Records;
import za.ac.cput.Rugby.domain.Team_profile;

import java.util.List;
import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Team_profileFactory {

    public static Team_profile getTeamProfile( Map<String,String> val,
                                         Team_Records team_rec,
                                               List<Player_profile> player){
        Team_profile team = new Team_profile
                           .Builder(val.get("teamName"))
                           .league(val.get("league"))
                           .home_Ground(val.get("home_Ground"))
                           .headCoach(val.get("headCoach"))
                           .records(team_rec)
                           .players(player)
                           .build();

        return team;
    }
}
