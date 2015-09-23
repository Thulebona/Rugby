package za.ac.cput.Rugby.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Entity
public class Player_profile implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(unique = true)
    private String playerID;
    private String player_name;
    private String DOB;
    private String position;
    private double height;
    private double weight;
    private  int test;
    private  int test_tries;
    @Embedded
    private Player_Records player_record;
   // private Team_profile team_profile;

    private  Player_profile(){}

    public Long getId() {
        return id;
    }

    public Player_profile(Builder builder) {

        player_name = builder.player_name;
        playerID = builder.playerID;
        DOB = builder.DOB;
        position = builder.position;
        height = builder.height;
        weight = builder.weight;
        test = builder.test;
        test_tries = builder.test_tries;
        player_record = builder.player_record;
    //    team_profile = builder.team_profile;
        id =builder.id;
    }
    public String getPlayer_name() {
        return player_name;
    }
    public String getPlayerID() {
        return playerID;
    }
    public String getDOB() {
        return DOB;
    }
    public String getPosition() {
        return position;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public int getTest() {
        return test;
    }
    public int getTest_tries() {
        return test_tries;
    }
    public Player_Records getPlayer_record() {
        return player_record;
    }
 /*   public Team_profile getTeam_profile() {
        return team_profile;
    }*/

    public static class Builder{

        private Long id;
        private String player_name;
        private String playerID;
        private String DOB;
        private String position;
        private double height;
        private double weight;
        private int test;
        private int test_tries;
        private Player_Records player_record;
       // private Team_profile team_profile;



        public Builder(String playerID){
            this.playerID=playerID;
        }

        public Builder player_name(String val){
            this.player_name = val;
            return this;
        }
        public Builder id(Long val){
            this.id = val;
            return this;
        }
        public Builder DOB(String val){
            this.DOB = val;
            return this;
        }
        public Builder position(String val){
            this.position = val;
            return this;
        }
        public Builder height(double val){
            this.height = val;
            return this;
        }
        public Builder weight(double val){
            this.weight = val;
            return this;
        }
        public Builder test(int val){
            this.test = val;
            return this;
        }
        public Builder test_tries(int val){
            this.test_tries = val;
            return this;
        }
        public Builder player_record(Player_Records val){
            this.player_record = val;
            return this;
        }
       /* public Builder team_profile(Team_profile val){
           this.team_profile = val;
            return this;
        }*/
        public Builder copy(Player_profile val) {

            player_name = val.player_name;
            playerID = val.playerID;
            DOB = val.DOB;
            position = val.position;
            height = val.height;
            weight = val.weight;
            test = val.test;
            test_tries = val.test_tries;
            player_record = val.player_record;
           // team_profile = val.team_profile;
            id =val.id;

            return this;
        }
        public Player_profile build(){
            return new Player_profile(this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player_profile that = (Player_profile) o;

        return !(id != null ? !id.equals(that.id) : that.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
