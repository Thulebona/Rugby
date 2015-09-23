package za.ac.cput.Rugby.services.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.Rugby.domain.Player_profile;
import za.ac.cput.Rugby.domain.Team_profile;
import za.ac.cput.Rugby.domain.Teams_log_ranking;
import za.ac.cput.Rugby.repository.Teams_log_rankingRepository;
import za.ac.cput.Rugby.services.LogRankingServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by THULEBONA on 2015-05-20.
 */
@Service
public class LogRenkingServicesImp implements LogRankingServices {
    @Autowired
    Teams_log_rankingRepository logRankingRepository;
    @Override
    public List<Teams_log_ranking> getAllTeams() {

        List<Teams_log_ranking> ranking = new ArrayList<>();
        Iterable<Teams_log_ranking> teams_log = logRankingRepository.findAll();
        for (Teams_log_ranking rank: teams_log)
        {
         ranking.add(rank);
        }
        return ranking;
    }


    @Override
    public Team_profile getTeam(Long id) {
        return logRankingRepository.findOne(id).getTeam();
    }

    @Override
    public List<Player_profile> getPlayers(Long id) {
        return logRankingRepository.findOne(id).getTeam().getPlayers();
    }

    @Override
    public Player_profile getPlayer(Long id,Integer index) {
        return logRankingRepository.findOne(id).getTeam().getPlayers().get(index.intValue());
    }
}
