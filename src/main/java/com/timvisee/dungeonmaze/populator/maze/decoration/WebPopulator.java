package com.timvisee.dungeonmaze.populator.maze.decoration;

import java.util.Random;

import org.bukkit.Chunk;

import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulatorArgs;

public class WebPopulator extends DMMazeRoomBlockPopulator {
	public static final int MIN_LAYER = 1;
	public static final int MAX_LAYER = 7;
	public static final int CHANCE_OF_WEB = 40;
	public static final double CHANCE_OF_WEB_ADDITION_PER_LEVEL = -1.667; /* to 30 */
	public static final int CORNER_CHANCE = 40;

	@Override
	public void populateRoom(DMMazeRoomBlockPopulatorArgs args) {
		Chunk c = args.getSourceChunk();
		Random rand = args.getRandom();
		int x = args.getChunkX();
		int y = args.getChunkY();
		int z = args.getChunkZ();
		
		if(rand.nextInt(100) < CHANCE_OF_WEB + (CHANCE_OF_WEB_ADDITION_PER_LEVEL * (y - 30) / 6)) {
			int webX = x + rand.nextInt(6) + 1;
			int webY = args.getFloorY() + 1;
			int webCeilingY = args.getCeilingY() - 1;
			int webZ = z + rand.nextInt(6) + 1;
			
			if(rand.nextInt(100) < CORNER_CHANCE)
				if(c.getBlock(x + (rand.nextInt(2)*5), webCeilingY, z + (rand.nextInt(2)*5)).getTypeId() == 0)
					c.getBlock(x + (rand.nextInt(2)*5), webCeilingY, z + (rand.nextInt(2)*5)).setTypeId(30);
			else
				if(c.getBlock(webX, webY, webZ).getTypeId() == 0)
					c.getBlock(webX, webY, webZ).setTypeId(30);
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