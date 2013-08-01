package com.timvisee.dungeonmaze.populator.maze.decoration;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.block.Block;

import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulatorArgs;

public class LavaOutOfWallPopulator extends DMMazeRoomBlockPopulator {
	public static final int MIN_LAYER = 1;
	public static final int MAX_LAYER = 4;
	public static final int CHANCE_OF_LAVA = 5;
	public static final double CHANCE_OF_LAVA_ADDITION_PER_LEVEL = -0.833; /* to 0 */

	@Override
	public void populateRoom(DMMazeRoomBlockPopulatorArgs args) {
		Chunk c = args.getSourceChunk();
		Random rand = args.getRandom();
		int x = args.getChunkX();
		int y = args.getChunkY();
		int z = args.getChunkZ();
		int floorOffset = args.getFloorOffset();
		
		if(rand.nextInt(100) < CHANCE_OF_LAVA + (CHANCE_OF_LAVA_ADDITION_PER_LEVEL * (y - 30) / 6)) {
			int lanternX = x + rand.nextInt(8);
			int lanternY = y + rand.nextInt(4 - floorOffset) + 2 + floorOffset;
			int lanternZ = z + rand.nextInt(8);
			
			Block lanternBlock = c.getBlock(lanternX, lanternY, lanternZ);
			if(lanternBlock.getTypeId() == 4 || lanternBlock.getTypeId() == 48 || lanternBlock.getTypeId() == 98)
				lanternBlock.setTypeId(10);
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
