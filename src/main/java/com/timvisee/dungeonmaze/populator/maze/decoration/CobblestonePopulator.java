package com.timvisee.dungeonmaze.populator.maze.decoration;

import java.util.Random;


import org.bukkit.Chunk;

import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulatorArgs;

public class CobblestonePopulator extends DMMazeRoomBlockPopulator {
	public static final int MIN_LAYER = 1;
	public static final int MAX_LAYER = 7;
	public static final int CHANCE_OF_COBBLE = 20;
	public static final int CORNER_CHANCE = 75;

	@Override
	public void populateRoom(DMMazeRoomBlockPopulatorArgs args) {
		Chunk c = args.getSourceChunk();
		Random rand = args.getRandom();
		int x = args.getChunkX();
		int z = args.getChunkZ();
		
		// Check chances
		if (rand.nextInt(100) < CHANCE_OF_COBBLE) {
			
			int webX = x + rand.nextInt(6) + 1;
			int webY = args.getFloorY();
			int webCeilingY = args.getCeilingY();
			int webZ = z + rand.nextInt(6) + 1;
			
			if (rand.nextInt(100) < CORNER_CHANCE)
				if(c.getBlock(x + (rand.nextInt(2)*5), webCeilingY, z + (rand.nextInt(2)*5)).getTypeId() == 0)
					c.getBlock(x + (rand.nextInt(2)*5), webCeilingY, z + (rand.nextInt(2)*5)).setTypeId(30);
			
			else
				if(!(c.getBlock(webX, webY - 1, webZ).getTypeId() == 0))
					if(c.getBlock(webX, webY, webZ).getTypeId() == 0)
						c.getBlock(webX, webY, webZ).setTypeId(4);
		}
	}
	
	/**
	 * Get the minimum layer
	 * @return Minimum layer
	 */
	@Override
	public int getMinimumLayer() {
		return MIN_LAYER;
	}
	
	/**
	 * Get the maximum layer
	 * @return Maximum layer
	 */
	@Override
	public int getMaximumLayer() {
		return MAX_LAYER;
	}
}