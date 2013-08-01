package com.timvisee.dungeonmaze.populator.maze.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;
import org.bukkit.inventory.ItemStack;

import com.timvisee.dungeonmaze.DungeonMaze;
import com.timvisee.dungeonmaze.event.generation.DMGenerationChestEvent;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulator;
import com.timvisee.dungeonmaze.populator.maze.DMMazeRoomBlockPopulatorArgs;
import com.timvisee.dungeonmaze.populator.maze.DMMazeStructureType;
import com.timvisee.dungeonmaze.util.DMChestUtils;

public class AbandonedDefenceCastleRoomPopulator extends DMMazeRoomBlockPopulator {
	public static final int MIN_LAYER = 2;
	public static final int MAX_LAYER = 6;
	public static final int CHANCE_OF_CASTLE = 1; // Promile
	public static final int MOSS_ITERATIONS = 80;
	public static final int MOSS_CHANCE = 70;
	public static final int CRACKED_ITERATIONS = 80;
	public static final int CRACKED_CHANCE = 70;

	@Override
	public void populateRoom(DMMazeRoomBlockPopulatorArgs args) {
		World W = args.getWorld();
		Chunk c = args.getSourceChunk();
		Random rand = args.getRandom();
		int x = args.getChunkX();
		int y = args.getChunkY();
		int floorOffset = args.getFloorOffset();
		int yFloor = args.getFloorY();
		int yCeiling = args.getCeilingY();
		int z = args.getChunkZ();
		
		// Apply chances
		if (rand.nextInt(1000) < CHANCE_OF_CASTLE) {
								
			// Register the room as constant room
			DungeonMaze.instance.registerConstantRoom(W.getName(), c, x, y, z);
			
			// Break out the orriginal walls
			for(int xx = 1; xx < 7; xx++) {
				for(int yy = yFloor + 1; yy <= yCeiling - 1; yy++) {
					c.getBlock(x + xx, yy, z + 0).setTypeId(0);
					c.getBlock(x + xx, yy, z + 7).setTypeId(0);
					c.getBlock(x + 0, yy, z + xx).setTypeId(0);
					c.getBlock(x + 7, yy, z + xx).setTypeId(0);
				}
			}
			
			// Walls
			for(int xx = 1; xx < 7; xx++) {
				for(int yy = floorOffset + 1; yy <= floorOffset + 2; yy++) {
					c.getBlock(x + xx, y + yy, z + 1).setTypeId(98);
					c.getBlock(x + xx, y + yy, z + 6).setTypeId(98);
					c.getBlock(x + 1, y + yy, z + xx).setTypeId(98);
					c.getBlock(x + 6, y + yy, z + xx).setTypeId(98);
				}
			}
			
			// Generate merlons
			for(int xx = 0; xx < 7; xx++) {
				c.getBlock(x + xx, yFloor + 3, z + 0).setTypeId(98);
				c.getBlock(x + xx, yFloor + 3, z + 7).setTypeId(98);
				c.getBlock(x + 0, yFloor + 3, z + xx).setTypeId(98);
				c.getBlock(x + 7, yFloor + 3, z + xx).setTypeId(98);
			}
			
			c.getBlock(x + 0, yFloor + 4, z + 1).setTypeId(44);
			c.getBlock(x + 0, yFloor + 4, z + 1).setData((byte) 5);
			c.getBlock(x + 0, yFloor + 4, z + 3).setTypeId(44);
			c.getBlock(x + 0, yFloor + 4, z + 3).setData((byte) 5);
			c.getBlock(x + 0, yFloor + 4, z + 5).setTypeId(44);
			c.getBlock(x + 0, yFloor + 4, z + 5).setData((byte) 5);
			c.getBlock(x + 7, yFloor + 4, z + 2).setTypeId(44);
			c.getBlock(x + 7, yFloor + 4, z + 2).setData((byte) 5);
			c.getBlock(x + 7, yFloor + 4, z + 4).setTypeId(44);
			c.getBlock(x + 7, yFloor + 4, z + 4).setData((byte) 5);
			c.getBlock(x + 7, yFloor + 4, z + 6).setTypeId(44);
			c.getBlock(x + 7, yFloor + 4, z + 6).setData((byte) 5);
			c.getBlock(x + 1, yFloor + 4, z + 0).setTypeId(44);
			c.getBlock(x + 1, yFloor + 4, z + 0).setData((byte) 5);
			c.getBlock(x + 3, yFloor + 4, z + 0).setTypeId(44);
			c.getBlock(x + 3, yFloor + 4, z + 0).setData((byte) 5);
			c.getBlock(x + 5, yFloor + 4, z + 0).setTypeId(44);
			c.getBlock(x + 5, yFloor + 4, z + 0).setData((byte) 5);
			c.getBlock(x + 2, yFloor + 4, z + 7).setTypeId(44);
			c.getBlock(x + 2, yFloor + 4, z + 7).setData((byte) 5);
			c.getBlock(x + 4, yFloor + 4, z + 7).setTypeId(44);
			c.getBlock(x + 4, yFloor + 4, z + 7).setData((byte) 5);
			c.getBlock(x + 6, yFloor + 4, z + 7).setTypeId(44);
			c.getBlock(x + 6, yFloor + 4, z + 7).setData((byte) 5);
			
			// Place torches
			c.getBlock(x + 1, yFloor + 3, z + 1).setTypeId(50);
			c.getBlock(x + 1, yFloor + 3, z + 1).setData((byte) 5);
			c.getBlock(x + 1, yFloor + 3, z + 6).setTypeId(50);
			c.getBlock(x + 1, yFloor + 3, z + 6).setData((byte) 5);
			c.getBlock(x + 6, yFloor + 3, z + 1).setTypeId(50);
			c.getBlock(x + 6, yFloor + 3, z + 1).setData((byte) 5);
			c.getBlock(x + 6, yFloor + 3, z + 6).setTypeId(50);
			c.getBlock(x + 6, yFloor + 3, z + 6).setData((byte) 5);
			
			// Place ladders
			c.getBlock(x + 2, yFloor + 1, z + 5).setTypeId(65);
			c.getBlock(x + 2, yFloor + 1, z + 5).setData((byte) 2);
			c.getBlock(x + 2, yFloor + 2, z + 5).setTypeId(65);
			c.getBlock(x + 2, yFloor + 2, z + 5).setData((byte) 2);
			
			// Place crafting table, chests and furnaces
			c.getBlock(x + 2, yFloor + 1, z + 2).setTypeId(58);
			c.getBlock(x + 5, yFloor + 1, z + 2).setTypeId(54);
			c.getBlock(x + 5, yFloor + 1, z + 2).setData((byte) 2);
			
			//Call the Chest generation event
			DMGenerationChestEvent event = new DMGenerationChestEvent(c.getBlock(x + 5, yFloor + 1, z + 2), rand, genChestContent(rand), DMMazeStructureType.ABANDONED_DEFENCE_CASTLE_ROOM);
			Bukkit.getServer().getPluginManager().callEvent(event);
			
			// Do the event
			if(!event.isCancelled()) {
				// Make sure the chest is still there, a developer could change the chest through the event!
				if(event.getBlock().getTypeId() == 54)
				// Add the contents to the chest
				DMChestUtils.addItemsToChest(event.getBlock(), event.getContents(), !event.getAddContentsInOrder(), rand);
			}

			c.getBlock(x + 5, yFloor + 1, z + 3).setTypeId(54);
			c.getBlock(x + 5, yFloor + 1, z + 3).setData((byte) 2);
			
			//Call the Chest generation event
			DMGenerationChestEvent event2 = new DMGenerationChestEvent(c.getBlock(x + 5, yFloor + 1, z + 3), rand, genChestContent(rand), DMMazeStructureType.ABANDONED_DEFENCE_CASTLE_ROOM);
			Bukkit.getServer().getPluginManager().callEvent(event2);
			
			// Do the event
			if(!event2.isCancelled()) {
				// Make sure the chest is still there, a developer could change the chest through the event!
				if(event2.getBlock().getTypeId() == 54)
				// Add the contents to the chest
				DMChestUtils.addItemsToChest(event.getBlock(), event.getContents(), !event.getAddContentsInOrder(), rand);
			}
			
			c.getBlock(x + 5, yFloor + 1, z + 4).setTypeId(61);
			c.getBlock(x + 5, yFloor + 1, z + 4).setData((byte) 4);
			addItemsToFurnace(rand, (Furnace) c.getBlock(x + 5, yFloor + 1, z + 4).getState());
			c.getBlock(x + 5, yFloor + 1, z + 5).setTypeId(61);
			c.getBlock(x + 5, yFloor + 1, z + 5).setData((byte) 4);
			addItemsToFurnace(rand, (Furnace) c.getBlock(x + 5, yFloor + 1, z + 5).getState());
			
			// Place cake (with random pieces eaten)
			c.getBlock(x + 5, yFloor + 2, z + 5).setTypeId(92);
			c.getBlock(x + 5, yFloor + 2, z + 5).setData((byte) rand.nextInt(4));
			
			// TODO: Place painting
			
			// Place some cobweb
			c.getBlock(x + 2, yFloor + 2, z + 2).setTypeId(30);
			c.getBlock(x + 3, yFloor + 1, z + 2).setTypeId(30);
			c.getBlock(x + 6, yFloor + 3, z + 6).setTypeId(30);
			c.getBlock(x + 6, yFloor + 4, z + 6).setTypeId(30);
			c.getBlock(x + 5, yFloor + 3, z + 6).setTypeId(30);
			c.getBlock(x + 6, yFloor + 3, z + 5).setTypeId(30);
			c.getBlock(x + 0, yFloor + 4, z + 6).setTypeId(30);
			
			// Add some moss and cracked stone bricks
			for (int i = 0; i < MOSS_ITERATIONS; i++) {
				if (rand.nextInt(100) < MOSS_CHANCE) {
					
					Block block = c.getBlock(x + rand.nextInt(8), rand.nextInt((y + 6) - y + 1) + y, z + rand.nextInt(8));
					if (block.getTypeId() == 4)
						block.setTypeId(48);
						
					if (block.getTypeId() == 98)
						block.setData((byte) 1);
				}
			}
			
			for (int i = 0; i < CRACKED_ITERATIONS; i++) {
				if (rand.nextInt(100) < CRACKED_CHANCE) {
					
					Block block = c.getBlock(x + rand.nextInt(8), rand.nextInt((y + 6) - y + 1) + y, z + rand.nextInt(8));
					if (block.getTypeId() == 98)
						block.setData((byte) 2);
				}
			}
		}
	}
	
	public void addItemsToFurnace(Random random, Furnace furnace) {
		List<ItemStack> items = new ArrayList<ItemStack>();
		
		if(random.nextInt(100) < 5)
			items.add(new ItemStack(41, 1, (short) 0));
		
		if(random.nextInt(100) < 5)
			items.add(new ItemStack(42, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(45, 1, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(263, 1, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(263, 1, (short) 1));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(265, 2, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(265, 4, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(266, 2, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(266, 4, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(297, 1, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(325, 1, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(366, 2, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(366, 4, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(318, 3, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(318, 5, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(320, 1, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(350, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(368, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(369, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(370, 1, (short) 0));
		
		if(random.nextInt(100) < 45)
			items.add(new ItemStack(371, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(372, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(375, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(377, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(378, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(381, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(382, 1, (short) 0));
		
		// Add the selected items into the furnace
		if(random.nextInt(100) < 70)
			furnace.getInventory().setResult(/*random.nextInt(furnace.getInventory().getSize()), */items.get(random.nextInt(items.size())));
		furnace.update();
	}
	
	public List<ItemStack> genChestContent(Random random) {
		List<ItemStack> items = new ArrayList<ItemStack>();
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(50, 4, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(50, 8, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(50, 12, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(260, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(262, 16, (short) 0));
		
		if(random.nextInt(100) < 5)
			items.add(new ItemStack(262, 24, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(264, 1, (short) 0));
		
		if(random.nextInt(100) < 50)
			items.add(new ItemStack(265, 1, (short) 0));
		
		if(random.nextInt(100) < 60)
			items.add(new ItemStack(266, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(267, 1, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(268, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(272, 1, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(296, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(296, 2, (short) 0));
		
		if(random.nextInt(100) < 5)
			items.add(new ItemStack(296, 3, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(297, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(298, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(299, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(300, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(301, 1, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(302, 1, (short) 0)); 
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(303, 1, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(304, 1, (short) 0));
		
		if(random.nextInt(100) < 40)
			items.add(new ItemStack(305, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(306, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(307, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(308, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(309, 1, (short) 0));
		
		if(random.nextInt(100) < 30)
			items.add(new ItemStack(318, 3, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(318, 5, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(318, 7, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(319, 1, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(320, 1, (short) 0));
		
		if(random.nextInt(100) < 15)
			items.add(new ItemStack(331, 5, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(331, 8, (short) 0));
		
		if(random.nextInt(100) < 5)
			items.add(new ItemStack(331, 13, (short) 0));
		
		if(random.nextInt(100) < 3)
			items.add(new ItemStack(331, 21, (short) 0));
		
		if(random.nextInt(100) < 10)
			items.add(new ItemStack(345, 1, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(349, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(350, 1, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(350, 1, (short) 0));
		
		if(random.nextInt(100) < 20) 			
			items.add(new ItemStack(351, 1, (short) 3));
		
		if(random.nextInt(100) < 5)
			items.add(new ItemStack(354, 1, (short) 0));
		
		if(random.nextInt(100) < 80)
			items.add(new ItemStack(357, 3, (short) 0));
		
		if(random.nextInt(100) < 20)
			items.add(new ItemStack(357, 5, (short) 0));
		
		int itemCountInChest = 3;
		switch (random.nextInt(8)) {
		case 0:
			itemCountInChest = 2;
			break;
		case 1:
			itemCountInChest = 2;
			break;
		case 2:
			itemCountInChest = 3;
			break;
		case 3:
			itemCountInChest = 3;
			break;
		case 4:
			itemCountInChest = 3;
			break;
		case 5:
			itemCountInChest = 4;
			break;
		case 6:
			itemCountInChest = 4;
			break;
		case 7:
			itemCountInChest = 5;
			break;
		default:
			itemCountInChest = 3;
			break;
		}
		
		List<ItemStack> result = new ArrayList<ItemStack>();
		
		// Add the selected items randomly
		for (int i = 0; i < itemCountInChest; i++)
			result.add(items.get(random.nextInt(items.size())));
		return result;
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