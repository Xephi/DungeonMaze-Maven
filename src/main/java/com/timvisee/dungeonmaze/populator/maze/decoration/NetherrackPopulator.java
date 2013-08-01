package com.timvisee.dungeonmaze.populator.maze.decoration;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.block.Block;

import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulatorArgs;

public class NetherrackPopulator extends DMMazeRoomBlockPopulator {
	public static final int MIN_LAYER = 1;
	public static final int MAX_LAYER = 2;
	public static final int ITERATIONS = 15;
	public static final int CHANCE = 5;
	public static final int BURNING_NETHERRACK = 20;

	@Override
	public void populateRoom(DMMazeRoomBlockPopulatorArgs args) {
		Chunk c = args.getSourceChunk();
		Random rand = args.getRandom();
		int x = args.getChunkX();
		int y = args.getChunkY();
		int z = args.getChunkZ();
		
		// Iterate
		for (int i = 0; i < ITERATIONS; i++) {
			if (rand.nextInt(100) < CHANCE) {
				Block b = c.getBlock(x + rand.nextInt(8), rand.nextInt(2)+ y, z + rand.nextInt(8));
				if (b.getTypeId() == 4) {
					b.setTypeId(87);
					
					// Decide if the netherrack should be burning
					if(rand.nextInt(100) < BURNING_NETHERRACK) {
						Block burnBlock = c.getBlock(b.getX(), b.getY() + 1, b.getZ());
						if (burnBlock.getTypeId() == 0)
							burnBlock.setTypeId(51);
					}
				}
			}
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