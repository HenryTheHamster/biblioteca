package com.twu28.biblioteca.library;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 21/07/12
 * Time: 9:33 PM
 */
public class Movie extends LibraryItem {

    private String title;
    private String director;
    private Integer rating;

    public Movie(String title, String director) {
        this.title = title;
        this.director = director;
    }

    public Movie(String title, String director, int rating) {
        this(title, director);
        this.rating = rating;
    }


    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Integer getRating() {
        return rating;
    }

    public String toString() {
        return title + ", directed by " + director + " " + getRatingString();
    }

    public String getRatingString() {
        if(rating != null) {
            return "(" + rating + "/10)";
        } else {
            return "(N/A)";
        }
    }
}
