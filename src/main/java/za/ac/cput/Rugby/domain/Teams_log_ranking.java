package za.ac.cput.Rugby.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class Teams_log_ranking implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Team_profile team ;
    private int gamesPlayed;
    private int win;
    private int lose;
    private int draw;
    private int pointFor;
    private int pointAgainst;
    private int pointDiff;
    private int bonusPoint;
    private int total;

    private Teams_log_ranking() {
    }

    public Long getId() {
        return id;
    }

    public Team_profile getTeam() {
        return team;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getDraw() {
        return draw;
    }

    public int getPointFor() {
        return pointFor;
    }

    public int getPointAgainst() {
        return pointAgainst;
    }

    public int getPointDiff() {
        return getPointFor()-getPointAgainst();
    }

    public int getBonusPoint() {
        return bonusPoint;
    }

    public int getTotal() {
        return getBonusPoint()+ getDraw()+(getWin()*4);
    }

    public Teams_log_ranking(Builder builder) {
        team = builder.team ;
        gamesPlayed = builder.gamesPlayed;
        win = builder.win;
        lose = builder.lose;
        draw = builder.draw;
        pointFor = builder.pointFor;
        pointAgainst = builder.pointAgainst;
        pointDiff = builder.pointDiff;
        bonusPoint = builder.bonusPoint;
        total= builder.total;
        id = builder.id;
    }

    public static class Builder{

        private Long id;
        private Team_profile team ;
        private int gamesPlayed;
        private int win;
        private int lose;
        private int draw;
        private int pointFor;
        private int pointAgainst;
        private int pointDiff;
        private int bonusPoint;
        private int total;

        public Builder(Team_profile team){
           this.team = team;
        }
        public Builder gamasPlayed(int val){
            this.gamesPlayed = val;
            return this;
        }
        public Builder id(Long val){
            this.id = val;
            return this;
        }
        public Builder win(int val){
            this.win = val;
            return this;
        }
        public Builder lose(int val){
            this.lose = val;
            return this;
        }
        public Builder draw(int val){
            this.draw = val;
            return this;
        }
        public Builder pointFor(int val){
            this.pointFor = val;
            return this;
        }
        public Builder pointAgainst(int val){
            this.pointAgainst = val;
            return this;
        }
        public Builder pointDiff(int val){
            this.pointDiff = val;
            return this;
        }
        public Builder bonusPoint(int val){
            this.bonusPoint = val;
            return this;
        }
        public Builder total(int val){
            this.total = val;
            return this;
        }
        public Builder copy(Teams_log_ranking builder){
            team = builder.team ;
            gamesPlayed = builder.gamesPlayed;
            win = builder.win;
            lose = builder.lose;
            draw = builder.draw;
            pointFor = builder.pointFor;
            pointAgainst = builder.pointAgainst;
            pointDiff = builder.pointDiff;
            bonusPoint = builder.bonusPoint;
            total= builder.total;
            id =builder.id;
            return this;
        }
        public Teams_log_ranking build(){ return new Teams_log_ranking(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teams_log_ranking that = (Teams_log_ranking) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
