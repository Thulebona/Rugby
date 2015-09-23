package za.ac.cput.Rugby.services;

import za.ac.cput.Rugby.domain.Player_profile;
import za.ac.cput.Rugby.domain.Team_profile;
import za.ac.cput.Rugby.domain.Teams_log_ranking;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
public interface LogRankingServices {


    List<Teams_log_ranking> getAllTeams();
    Team_profile getTeam(Long id);
    List<Player_profile> getPlayers(Long id);
    Player_profile getPlayer(Long id, Integer index);


}
