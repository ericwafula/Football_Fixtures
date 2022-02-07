package tech.ericwathome.footballfixtures.models;

import java.util.Objects;

public class Trophy {
    private String league;
    private String country;
    private String season;
    private String place;

    public Trophy() {
    }

    public Trophy(String league, String country, String season, String place) {
        this.league = league;
        this.country = country;
        this.season = season;
        this.place = place;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trophy)) return false;
        Trophy trophy = (Trophy) o;
        return Objects.equals(getLeague(), trophy.getLeague()) && Objects.equals(getCountry(), trophy.getCountry()) && Objects.equals(getSeason(), trophy.getSeason()) && Objects.equals(getPlace(), trophy.getPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeague(), getCountry(), getSeason(), getPlace());
    }

    @Override
    public String toString() {
        return "Trophy{" +
                "league='" + league + '\'' +
                ", country='" + country + '\'' +
                ", season='" + season + '\'' +
                ", place='" + place + '\'' +
                '}';
    }
}
