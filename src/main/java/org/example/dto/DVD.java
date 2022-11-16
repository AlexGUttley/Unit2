package org.example.dto;


public class DVD {

    //Store substantiations of the DVD's data
    private String title;
    private String releaseDate;
    private String ratingMPAA;
    private String director;
    private String studio;
    private String userNote;

    public DVD(String title, String releaseDate, String ratingMPAA, String director, String studio) {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
        this.setRatingMPAA(ratingMPAA);
        this.setDirector(director);
        this.setStudio(studio);
        this.setUserNote("");
    }

    public DVD(String title, String releaseDate, String ratingMPAA, String director, String studio, String userNote) {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
        this.setRatingMPAA(ratingMPAA);
        this.setDirector(director);
        this.setStudio(studio);
        this.setUserNote(userNote);
    }

    @Override
    public String toString() {
        String stringValue = getTitle() + ", released on " + getReleaseDate() + ", rated " + getRatingMPAA() + ", directed by "
                + getDirector() + ", and produced by " + getStudio() + ".";
        if (!getUserNote().equals("")) {
            stringValue += (" User note: " + getUserNote());
        }
        return stringValue;
    }

    public String[] toStringArray(){
        if (userNote.equals("")) {
            return new String[]{title, releaseDate, ratingMPAA, director, studio};
        } else {
            return new String[]{title, releaseDate, ratingMPAA, director, studio, userNote};
        }
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getRatingMPAA() {
        return ratingMPAA;
    }

    public void setRatingMPAA(String ratingMPAA) {
        this.ratingMPAA = ratingMPAA;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

}

//Auto-generated encapsulation gave this class a weird fixation with using its own mutator methods, even when it's not necessary.