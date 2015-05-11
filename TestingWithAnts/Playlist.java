import greenfoot.*;
import java.util.ArrayList;


/**
 * This CLASS is currently NOT being used. But if needed, it is here!
 */




/**
 * Write a description of class Playlist here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Playlist extends Actor
{
    public ArrayList<GreenfootSound> playlist;
    public int lastSong; // index of the last played song in the playlist
    public int currentSong; // index of the current song in the playlist
    public boolean isPlayingSong; // boolean if this playlist is currently playing a song
    
    /**
     * Constructor for the playlist (requires the playlist song count)
     */
    public Playlist()
    {
        playlist = new ArrayList<GreenfootSound>();
        lastSong = -1;
        currentSong = 0;
        isPlayingSong = false;
    }
    
    /**
     * Act - do whatever the Playlist wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (playlist.size() > 0 && playlist.get(currentSong).isPlaying() == false)
        {
            isPlayingSong = false;
            playNext();
        }
    }    
    
    /**
     * Adds the given song to the playlist
     */
    public void addSong(String newSong)
    {
        playlist.add(new GreenfootSound(newSong));
    }
    
    /**
     * Plays the next song in the playlist 
     */
    public void playNext()
    {
        // The Playlist isn't empty
        if (playlist.size() > 0)
        {
            if (lastSong == -1) // Never been played yet
            {
                playlist.get(currentSong).play();
            }
            else if (lastSong == playlist.size() - 1) // Last song in the playlist, so loop back to start
            {
                currentSong = 0;
                playlist.get(currentSong).play();
            }
            else
            {
                currentSong++;
                playlist.get(currentSong).play();
            }
            
            isPlayingSong = true;
            lastSong = currentSong;
        }
    }
    
    /**
     * Stops everything and removes this playlist
     */
    public void remove()
    {
        setting w = (setting)getWorld();
        
        playlist.get(currentSong).stop();
        
        w.removeObject(this);
    }
}
