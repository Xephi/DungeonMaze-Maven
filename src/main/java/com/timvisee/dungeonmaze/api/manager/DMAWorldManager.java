package com.timvisee.dungeonmaze.api.manager;

import java.util.List;

import com.onarandombox.MultiverseCore.MultiverseCore;
import com.timvisee.dungeonmaze.DungeonMaze;
import com.timvisee.dungeonmaze.manager.DMWorldManager;

/**
 * API layer for the DMWorldManager class
 */
public class DMAWorldManager {
	
	private DungeonMaze dm;
	
	/**
	 * Constructor
	 * @param dm Dungeon Maze
	 */
	public DMAWorldManager(DungeonMaze dm) {
		this.dm = dm;
	}
	
	/**
	 * Get the Dungeon Maze instance
	 * @return Dungeon Maze instance
	 */
	public DungeonMaze getDungeonMaze() {
		return this.dm;
	}
	
	/**
	 * Set the Dungeon Maze instance
	 * @param dm Dungeon Maze instance
	 */
	public void setDungeonMaze(DungeonMaze dm) {
		this.dm = dm;
	}
	
	/**
	 * Get the DMWorldManager instance
	 * @return DMWorldManager instance
	 */
	private DMWorldManager getDMWorldManager() {
		return this.dm.getWorldManager();
	}
	
	/**
	 * Refresh the list with Dungeon Maze worlds
	 */
	public void refresh() {
		getDMWorldManager().refresh();
	}
	
	/**
	 * Get all DM worlds
	 * @return List of all DM worlds
	 */
	public List<String> getDMWorlds() {
		return getDMWorldManager().getDMWorlds();
	}
	
	/**
	 * Get all loaded DM worlds
	 * @return List of all loaded DM worlds
	 */
	public List<String> getLoadedDMWorlds() {
		return getDMWorldManager().getLoadedDMWorlds();
	}
	
	/**
	 * Get all preload worlds of DM
	 * @return all preload worlds
	 */
	public List<String> getPreloadWorlds() {
		return getDMWorldManager().getPreloadWorlds();
	}
	
	/**
	 * Check if a world is a DM world
	 * @param w the world name
	 * @return true if the world is a DM world
	 */
	public boolean isDMWorld(String w) {
		return getDMWorldManager().isDMWorld(w);
	}
	
	/**
	 * Check if a world is a loaded DM world
	 * @param w the world name
	 * @return true if the world is a loaded DM world
	 */
	public boolean isDMWorldLoaded(String w) {
		return getDMWorldManager().isDMWorldLoaded(w);
	}
	
	/**
	 * Preload all 'preload' DM worlds
	 */
	public void preloadWorlds() {
		getDMWorldManager().preloadWorlds();
	}
	
	/**
	 * Get the MultiverseCore instance
	 * @return MultiverseCore instance
	 */
	public MultiverseCore getMultiverseCore() {
		return getDMWorldManager().getMultiverseCore();
    }
}
