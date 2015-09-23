package za.ac.cput.Rugby.factory;

import za.ac.cput.Rugby.domain.Player_Records;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-25.
 */
public class Player_RecordsFactory {

    public static Player_Records getPlayer_Record(Map<String,String> values/*,Player_profile player*/){
        Player_Records record = new Player_Records.Builder(values.get("recordDate"))
                                   // .recordDate(values.get("recordDate"))
                                    .recordDescription(values.get("recordDescription"))
                                    .build();
        return record;
    }
}
