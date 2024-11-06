import java.io.*;
import java.util.ArrayList;

public class Playlist {
    private ArrayList<Track> tracks;
    private int currentTrack;

    public Playlist() {
        tracks = new ArrayList<>();
        currentTrack = 0;
    }

    public void viewSongs() {
        for (int i = 0; i < tracks.size(); i++) {
            System.out.println((i + 1) + ". " + tracks.get(i).getTitle());
        }
    }

    public void addSong(Track song) {
        tracks.add(song);
    }

    public void removeSong(int index) {
        if (index >= 0 && index < tracks.size()) {
            tracks.remove(index);
        }
    }

    public int getTotalNumberOfTracks() {
        return tracks.size();
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public int getCurrentTrack() {
        return currentTrack;
    }

    public void setCurrentTrack(int currentTrack) {
        this.currentTrack = currentTrack;
    }

    public void loadTracksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                addSong(new Track(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveTracksToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (Track track : tracks) {
                bw.write(track.getTitle());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}