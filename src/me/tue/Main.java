package me.tue;

import me.tue.commands.Parser;
import me.tue.playarea.WorldManager;

/**
 * @author Tue & Philip
 * Description:
 * This is the main class. It makes sure that everything is connected and works as it should.
 */
public class Main {

    private WorldManager worldManager;
    private Parser parser;

    /**
     * Constructor
     */
    public Main(){
        this.parser = new Parser();
        this.worldManager = WorldManager.getInstance();
        this.worldManager.createHell();
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
    public static void main(String[] args) {
        new Main();
    }
}
