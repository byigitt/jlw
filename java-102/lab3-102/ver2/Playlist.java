// ************************************************************************
// Playlist.java
//
// A playlist class with methods for adding and removing songs, changing ratings, and printing song information.
// ************************************************************************
public class Playlist {
    public String name;
    public double rating;
    public int Numberofsongs;

    // ---------------------------------------------------------------
    // Constructor -- initializes name, rating, number of songs
    // ---------------------------------------------------------------

    public Playlist(String name, double rating, int numberOfSongs) {
        this.name = name;
        this.rating = rating;
        this.Numberofsongs = numberOfSongs;
    };
    
    // --------------------------------
    // Decrements songs number by the given parameter
    // --------------------------------
    public int removeSong(int num) {
        if (Numberofsongs >= num) {
            Numberofsongs -= num;
            return Numberofsongs;
        } else {
            System.out.println("There cant be negative songs in a playlist.");
            return -1;
        }
    };

    // --------------------------------
    // Increases song number by the given parameter
    // --------------------------------
    public int addSong(int num) {
        Numberofsongs += num;
        return Numberofsongs;
    };

    // --------------------------------------------------------------------
    // Returns a string containing the name, number of songs.
    // --------------------------------------------------------------------
    public String toString() {
        return "Playlist " + name + " has " + Numberofsongs + " songs and the playlist rating is " + rating;
    };
    
    // --------------------------------------------------
    // Change the rating of the playlist by the given parameter
    // --------------------------------------------------
    public void changeRating(double rating) {
        this.rating = rating;
    };
    
};