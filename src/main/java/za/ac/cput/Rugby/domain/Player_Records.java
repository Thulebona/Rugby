package za.ac.cput.Rugby.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/04/18.
 */
@Embeddable
public class Player_Records implements Serializable {

   // private Player_profile player;
    private String recordDate;
    private String recordDescription;

    private Player_Records() {
    }
    public Player_Records(Builder builder) {
      //  player = builder.player;
        recordDate = builder.recordDate;
        recordDescription = builder.recordDescription;
    }

   /* public Player_profile getPlayer() {
        return player;
    }*/
    public String getRecordDate() {
        return recordDate;
    }
    public String getRecordDescription() {
        return recordDescription;
    }

    public static class Builder {
     //   private Player_profile player;
        private String recordDate;
        private String recordDescription;

        public Builder(String val) {
            this.recordDate = val;
           // this.player = s;
        }
       /* public Builder recordDate(String val){
            this.recordDate = val;
            return this;
        }*/
        public Builder recordDescription(String val){
            this.recordDescription = val;
            return this;
        }
        public Builder copy(Player_Records val){
            this.recordDate = val.recordDate;
            this.recordDescription = val.recordDescription;
            //this.player = val.player;
            return  this;
        }
        public Player_Records build(){return new Player_Records(this);}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player_Records that = (Player_Records) o;
        return !(recordDate != null ? !recordDate.equals(that.recordDate) : that.recordDate != null);
    }

    @Override
    public int hashCode() {
        return recordDate != null ? recordDate.hashCode() : 0;
    }

  /*  public void setPlayer(Player_profile player) {
        this.player = player;
    }*/
}
