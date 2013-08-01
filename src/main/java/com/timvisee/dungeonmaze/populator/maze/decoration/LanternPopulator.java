package com.timvisee.dungeonmaze.populator.maze.decoration;

import java.util.Random;

import org.bukkit.Chunk;
import org.bukkit.block.Block;

import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulatorArgs;

public class LanternPopulator extends DMMazeRoomBlockPopulator {
	public static final int MIN_LAYER = 3;
	public static final int MAX_LAYER = 7;
	public static final int CHANCE_1 = 30;
	public static final double CHANCE_1_ADDITION_PER_LEVEL = 7.5; /* to 75 */
	public static final int ITERATIONS_1 = 2;
	public static final int CHANCE_2 = 10;
	public static final double CHANCE_2_ADDITION_PER_LEVEL = 4.167; /* to 35 */
	public static final int ITERATIONS_2 = 2;

	@Override
	public void populateRoom(DMMazeRoomBlockPopulatorArgs args) {
		Chunk c = args.getSourceChunk();
		Random rand = args.getRandom();
		int x = args.getChunkX();
		int y = args.getChunkY();
		int z = args.getChunkZ();
		int floorOffset = args.getFloorOffset();
		
		// Apply chances
		if(rand.nextInt(100) < CHANCE_1 + (CHANCE_1_ADDITION_PER_LEVEL * (y - 30) / 6)) {
			for(int i = 0; i < ITERATIONS_1; i++) {
				int lanternX = x + rand.nextInt(8);
				int lanternY = y + rand.nextInt(4 - floorOffset) + 2 + floorOffset;
				int lanternZ = z + rand.nextInt(8);
				
				Block lanternBlock = c.getBlock(lanternX, lanternY, lanternZ);
				if(lanternBlock.getTypeId() == 4 || lanternBlock.getTypeId() == 48 || lanternBlock.getTypeId() == 98)
					lanternBlock.setTypeId(91);
			}
		}
		
		if(rand.nextInt(100) < CHANCE_2 + (CHANCE_2_ADDITION_PER_LEVEL * (y - 30) / 6)) {
			for(int i = 0; i < ITERATIONS_2; i++) {
				int lanternX = x + rand.nextInt(8);
				int lanternY = rand.nextInt(4 - floorOffset) + 2 + floorOffset;
				int lanternZ = z + rand.nextInt(8);
				
				Block lanternBlock2 = c.getBlock(lanternX, lanternY, lanternZ);
				if(lanternBlock2.getTypeId() == 4 || lanternBlock2.getTypeId() == 48)
					lanternBlock2.setTypeId(86);
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

	// Depricated, might use later again to rotate pumpkins correctly
	/*private byte getData(int x, int z, int x2, int z2, Material type) {
		if (x == x2) {
			if (z < z2)
				return (byte) (type == Material.JACK_O_LANTERN ? 0 : 2);
			return (byte) (type == Material.JACK_O_LANTERN ? 2 : 0);
		}
		if (x < x2)
			return (byte) (type == Material.JACK_O_LANTERN ? 3 : 1);
		return (byte) (type == Material.JACK_O_LANTERN ? 1 : 3);
	}*/
}
