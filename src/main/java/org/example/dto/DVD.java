package org.example.dto;


/**
 * Object class for representing DVD entities in the collection.
 */
public class DVD {

    //Store substantiations of the DVD's data
    private String title;
    private String releaseDate;
    private String ratingMPAA;
    private String director;
    private String studio;
    private String userNote;

    /**
     * Constructor; instantiates all variables by parameters except userNote, which is set to an empty string.
     * @param title Film title
     * @param releaseDate Release date of film
     * @param ratingMPAA MPAA rating of film
     * @param director Film's director
     * @param studio Film's production studio
     */
    public DVD(String title, String releaseDate, String ratingMPAA, String director, String studio) {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
        this.setRatingMPAA(ratingMPAA);
        this.setDirector(director);
        this.setStudio(studio);
        this.setUserNote("");
    }

    /**
     * Constructor; instantiates all variables by parameters.
     * @param title Film title
     * @param releaseDate Release date of film
     * @param ratingMPAA MPAA rating of film
     * @param director Film's director
     * @param studio Film's production studio
     * @param userNote Note supplied by user about film
     */
    public DVD(String title, String releaseDate, String ratingMPAA, String director, String studio, String userNote) {
        this.setTitle(title);
        this.setReleaseDate(releaseDate);
        this.setRatingMPAA(ratingMPAA);
        this.setDirector(director);
        this.setStudio(studio);
        this.setUserNote(userNote);
    }

    /**
     * Returns a verbose string implementation of the object's parameters.
     * @return String, separated by commas and verbose explanations.
     */
    @Override
    public String toString() {
        String stringValue = getTitle() + ", released on " + getReleaseDate() + ", rated " + getRatingMPAA() + ", directed by "
                + getDirector() + ", and produced by " + getStudio() + ".";
        if (!getUserNote().equals("")) {
            stringValue += (" User note: " + getUserNote());
        }
        return stringValue;
    }

    /**
     * Returns an array containing the object's parameters
     * @return String array. Note that userNote is omitted if it is blank, meaning array is either length 5 or 6.
     */
    public String[] toStringArray(){
        if (userNote.equals("")) {
            return new String[]{title, releaseDate, ratingMPAA, director, studio};
        } else {
            return new String[]{title, releaseDate, ratingMPAA, director, studio, userNote};
        }
    }


    /**
     * Gets title
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title
     * @param title film title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets release date
     * @return release date
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets release date
     * @param releaseDate film's release date
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Gets MPAA rating
     * @return MPAA rating
     */
    public String getRatingMPAA() {
        return ratingMPAA;
    }

    /**
     * Sets MPAA rating
     * @param ratingMPAA film's MPAA rating
     */
    public void setRatingMPAA(String ratingMPAA) {
        this.ratingMPAA = ratingMPAA;
    }

    /**
     * Gets director
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets director
     * @param director film's director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets studio
     * @return studio
     */
    public String getStudio() {
        return studio;
    }

    /**
     * Sets studio
     * @param studio film's studio
     */
    public void setStudio(String studio) {
        this.studio = studio;
    }

    /**
     * Gets user note. Will be an empty string if unsubstantiated
     * @return yser note
     */
    public String getUserNote() {
        return userNote;
    }

    /**
     * Sets user note
     * @param userNote user's note about DVD
     */
    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }

}