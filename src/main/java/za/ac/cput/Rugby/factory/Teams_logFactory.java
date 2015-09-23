package za.ac.cput.Rugby.factory;

import za.ac.cput.Rugby.domain.Team_profile;
import za.ac.cput.Rugby.domain.Teams_log_ranking;

import java.util.Map;

/**
 * Created by THULEBONA on 2015-04-26.
 */
public class Teams_logFactory {
    public static Teams_log_ranking getTeams_log_ranking(Team_profile team,Map<String,Integer> values){
              Teams_log_ranking ranking = new Teams_log_ranking.Builder(team)
                                   .gamasPlayed(values.get("played"))
                                   .win(values.get("win"))
                                   .lose(values.get("lose"))
                                   .draw(values.get("draw"))
                                   .pointFor(values.get("pointFor"))
                                   .pointAgainst(values.get("pointAgainst"))
                                 //  .pointDiff(values.get("pointDiff"))
                                   .bonusPoint(values.get("bonusPoint"))
                                 //  .total(values.get("total"))
                                   .build();
        return ranking;
    }
}
