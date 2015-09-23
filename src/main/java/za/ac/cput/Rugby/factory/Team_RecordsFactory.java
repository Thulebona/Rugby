package za.ac.cput.Rugby.factory;

import za.ac.cput.Rugby.domain.Team_Records;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Team_RecordsFactory {

    public static Team_Records getTeam_Record( Map<String,String> value/*,Team_profile team*/){
        Team_Records teamProfile = new Team_Records.Builder(value.get("recordDate"))
                                       //.recordDate(value.get("recordDate"))
                                       .recordDescription(value.get("recordDescription"))
                                       .build();
        return teamProfile;
    }
}
