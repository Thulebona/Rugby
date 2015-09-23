package za.ac.cput.Rugby.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Embeddable
public class Team_Records implements Serializable {
    //@Column(unique = true)
    //private Team_profile team;
    private String recordDate;
    private String recordDescription;

    private Team_Records(){
    }
    public Team_Records(Builder builder) {
      //  team = builder.team;
        recordDate = builder.recordDate;
        recordDescription = builder.recordDescription;
    }

  /*  public Team_profile getTeamName() {
        return team;
    }*/
    public String getRecordDate() {
        return recordDate;
    }
    public String getRecordDescription() {
        return recordDescription;
    }

    public static class Builder {
       // private Team_profile team;
        private String recordDate;
        private String recordDescription;

        public Builder(String val){
            this.recordDate = val;
           // this.team = val;
        }
        /*public Builder recordDate(String val){
            this.recordDate = val;
            return this;
        }*/
        public Builder recordDescription(String val){
            this.recordDescription = val;
            return this;
        }
        public Builder copy(Team_Records val){
          //  this.team = val.team;
            this.recordDate = val.recordDate;
            this.recordDescription = val.recordDescription;
            return  this;
        }
        public Team_Records build(){return new Team_Records(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team_Records records = (Team_Records) o;

        return !(recordDate != null ? !recordDate.equals(records.recordDate) : records.recordDate != null);

    }

    @Override
    public int hashCode() {
        return recordDate != null ? recordDate.hashCode() : 0;
    }
}
