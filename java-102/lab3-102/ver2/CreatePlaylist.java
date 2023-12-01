import java.util.Scanner;

public class CreatePlaylist {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        
        String name;
        double rating;
        int numberOfPlaylist;

        System.out.println("Enter the number of playlists: ");
        int playlistNumber = keyboard.nextInt();
        
        Playlist playlists[] = new Playlist[playlistNumber];

        for (int i = 0; i < playlistNumber; i++) {
            System.out.println("Playlist name: ");
            name = keyboard.next();

            System.out.println("Playlist rating: ");
            rating = keyboard.nextDouble();

            System.out.println("Number of songs in the playlist: ");
            numberOfPlaylist = keyboard.nextInt();

            playlists[i] = new Playlist(name, rating, numberOfPlaylist);
        };

        keyboard.close();

        for (int i = 0; i < playlists.length; i++) {
            System.out.println(playlists[i].toString());
        };

        playlists[0].removeSong(50);
        System.out.println("Current number of songs: " + playlists[0].Numberofsongs);
        
        playlists[2].addSong(100);
        System.out.println("Current number of songs: " + playlists[2].Numberofsongs);
        
        playlists[2].changeRating(playlists[2].rating - 0.3);
        playlists[0].changeRating(playlists[0].rating + 0.7);

        for (int i = 0; i < playlists.length; i++) {
            System.out.println(playlists[i].toString());
        };
    };
}
