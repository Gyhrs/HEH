package me.tue;

import me.tue.commands.Command;
import me.tue.commands.CommandManager;
import me.tue.commands.Parser;
import me.tue.playarea.World;
import me.tue.playarea.WorldManager;
import me.tue.player.Player;

/**
 * @author Tue & Philip
 * Description:
 * This is the main class. It makes sure that everything is connected and works as it should.
 */
public class Main {

    private WorldManager worldManager;
    private Parser parser;
    private boolean running;
    private Player player;
    private static Main instance;
    private CommandManager commandManager;

    /**
     * Constructor
     */
    public Main(){
        instance = this;
        this.player = new Player();
        this.parser = new Parser();
        this.worldManager = WorldManager.getInstance();
        World hell = this.worldManager.createHell();
        this.worldManager.addWorld(hell);
        player.setLocation(hell.getStartLocation());
        this.commandManager = new CommandManager();
        play();
    }

    private void play(){
        running = true;
        while(running) {
            Command command = parser.getCommand();
            commandManager.run(command);
        }
    }

    public Player getPlayer() {
        return player;
    }

    /**
     * Get the world manager
     * @return Instance of WorldManager
     */
    public WorldManager getWorldManager(){
        return this.worldManager;
    }

    /**
     * Get the parser
     * @return Instance of Parser
     */
    public Parser getParser(){
        return this.parser;
    }

    /**
     * Stuff to run on start
     */
    public static void main(String[] args) { new Main();}

    /**
     * Get running
     * @return
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * Sets running to true or false
     * @param running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    public static Main getInstance() {
        return instance;
    }
}
