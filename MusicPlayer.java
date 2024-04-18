import javax.sound.sampled.*;
import java.io.*;
import java.util.*;

public class MusicPlayer {
    private List<String> Songs;
    private Clip clip;
    private int CurrentSongIndex;

    public MusicPlayer() {
        Songs = new ArrayList<>();
        CurrentSongIndex = -1;
    }

    public void LoadSongsFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Songs.add(file.getAbsolutePath());
                }
            }
        } 
        
        else {
            System.out.println("Folder does not exist.");
        }
    }

    public void playSong(int index) {
        if (index < 0 || index >= Songs.size()) {
            System.out.println("Invalid input.");
            return;
        }

        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }

        String SongFilename = Songs.get(index);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(SongFilename));
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            System.out.println("Now playing: " + SongFilename);
            CurrentSongIndex = index;
        } 
        
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void playNextSong() {
        int nextIndex = CurrentSongIndex + 1;
        if (nextIndex >= 0 && nextIndex < Songs.size()) {
            playSong(nextIndex);
        } 
        
        else {
            System.out.println("The playlist has ended.");
        }
    }

    public void playPreviousSong() {
        int PreviousIndex = CurrentSongIndex - 1;
        if (PreviousIndex >= 0 && PreviousIndex < Songs.size()) {
            playSong(PreviousIndex);
        } 
        
        else {
            System.out.println("There is no previous song.");
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.LoadSongsFromFolder("C:/Users/deidr/Downloads/Software Development 2nd Semester/MusicPlayer/MP3");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter an input from 1 to 5 to play a song, 'forward' for the next song, 'backward' for previous song, or '0' to quit:");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                player.stop();
                break;
            } 
            
            else if (input.equals("forward")) {
                player.playNextSong();
            }
            
            else if (input.equals("backward")) {
                player.playPreviousSong();
            } 
            
            else {
                try {
                    int choice = Integer.parseInt(input);
                    player.playSong(choice - 1);
                } 
                
                catch (NumberFormatException e) {
                    System.out.println("Invalid input.");
                }
            }
        }

        scanner.close();
    }
}