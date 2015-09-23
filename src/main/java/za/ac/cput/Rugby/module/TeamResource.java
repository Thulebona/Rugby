package za.ac.cput.Rugby.module;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.Rugby.domain.Player_profile;
import za.ac.cput.Rugby.domain.Team_Records;

import java.util.List;

/**
 * Created by THULEBONA on 2015-05-19.
 */
public class TeamResource extends ResourceSupport{

    private Long resid;
    private String teamName;
    private String league;
    private String home_Ground;
    private String headCoach;
    private Team_Records records;
    private List<Player_profile> players;

    private TeamResource(){
    }
    public TeamResource(Builder builder){
        this.resid = builder.resid;
        this.teamName = builder.teamName;
        this.league = builder.league;
        this.home_Ground = builder.home_Ground;
        this.headCoach = builder.headCoach;
        this.records = builder.records;
        this.players =builder.players;
    }

    public Long getresid() {
        return resid;
    }
    public String getTeamName() {
        return teamName;
    }
    public String getLeague() {
        return league;
    }
    public String getHome_Ground() {
        return home_Ground;
    }
    public String getHeadCoach() {
        return headCoach;
    }
    public Team_Records getRecords() {
        return records;
    }
    public List<Player_profile> getPlayers() {
        return players;
    }
    public static class Builder{
        private Long resid;
        private String teamName;
        private String league;
        private String home_Ground;
        private String headCoach;
        private Team_Records records;
        private List<Player_profile> players;

        public Builder(String teamName) {
            this.teamName = teamName;
        }
        public Builder resid(Long val){
            this.resid = val;
            return this;
        }
        public Builder league(String val){
            this.league = val;
            return this;
        }
        public Builder home_Ground(String val){
            this.home_Ground = val;
            return this;
        }
        public Builder headCoach(String val){
            this.headCoach = val;
            return this;
        }
        public Builder records(Team_Records val){
            this.records = val;
            return this;
        }
        public Builder players(List<Player_profile> val){
            this.players = val;
            return this;
        }

        public Builder copy(TeamResource val){
            this.teamName = val.teamName;
            this.league = val.league;
            this.home_Ground = val.home_Ground;
            this.headCoach = val.headCoach;
            this.records = val.records;
            this.players =val.players;
            this.resid = val.resid;

            return this;
        }

        public TeamResource build(){return new TeamResource(this);}
    }
}
