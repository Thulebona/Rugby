package za.ac.cput.Rugby.factory;

import za.ac.cput.Rugby.domain.Player_Records;
import za.ac.cput.Rugby.domain.Player_profile;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Player_profileFactory {


    public static Player_profile getPlayer_profile(Map<String,String> myStings ,Map<String,Integer> myInt,
                                                  Map<String,Double> myDouble, Player_Records rec/*,Team_profile team_profile*/) {

        Player_profile player = new Player_profile.Builder(myStings.get("playerID"))
                                    .player_name(myStings.get("player_name"))
                                    .DOB(myStings.get("DOB"))
                                    .position(myStings.get("position"))
                                    .height(myDouble.get("height"))
                                    .test(myInt.get("test"))
                                    .test_tries(myInt.get("test_tries"))
                                    .weight(myDouble.get("weight"))
                                    .player_record(rec)
                                   // .team_profile(team_profile)
                                    .build();

        return player;

    }

}
