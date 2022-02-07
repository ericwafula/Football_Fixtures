package tech.ericwathome.footballfixtures.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Objects;


public class Player {
    @SerializedName("results")
    private int trophyCount;
    @SerializedName("response")
    private List<Trophy> trophies;

    public Player() {
    }

    public int getTrophyCount() {
        return trophyCount;
    }

    public void setTrophyCount(int trophyCount) {
        this.trophyCount = trophyCount;
    }

    public List<Trophy> getTrophies() {
        return trophies;
    }

    public void setTrophies(List<Trophy> trophies) {
        this.trophies = trophies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getTrophyCount() == player.getTrophyCount() && Objects.equals(getTrophies(), player.getTrophies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrophyCount(), getTrophies());
    }

    @Override
    public String toString() {
        return "Player{" +
                "trophyCount=" + trophyCount +
                ", trophies=" + trophies +
                '}';
    }
}
