/*******************************************************************************
 * Copyright (c) 2014 Yuuto.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 * 	   cpw - src reference from Iron Chests
 * 	   doku/Dokucraft staff - base chest texture
 *     Yuuto - initial API and implementation
 ******************************************************************************/
package yuuto.enhancedinventories.proxy;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import yuuto.enhancedinventories.EInventoryMaterial;
import yuuto.enhancedinventories.EnhancedInventories;
import yuuto.enhancedinventories.block.BlockImprovedChest;
import yuuto.enhancedinventories.block.BlockLocker;
import yuuto.enhancedinventories.compat.refinedrelocation.TileImprovedSortingChest;
import yuuto.enhancedinventories.compat.refinedrelocation.TileSortingLocker;
import yuuto.enhancedinventories.gui.GuiHandler;
import yuuto.enhancedinventories.item.ItemBlockImprovedChest;
import yuuto.enhancedinventories.item.ItemBlockLocker;
import yuuto.enhancedinventories.tile.TileImprovedChest;
import yuuto.enhancedinventories.tile.TileLocker;
import yuuto.yuutolib.IProxy;

public class ProxyCommon implements IProxy {

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.init(event);
		BlockImprovedChest improvedChest = EnhancedInventories.improvedChest;
		BlockLocker locker = EnhancedInventories.locker;
		GameRegistry.registerItem(EnhancedInventories.sizeUpgrade, "sizeUpgrade");
		GameRegistry.registerItem(EnhancedInventories.functionUpgrade, "functionUpgrade");
		GameRegistry.registerItem(EnhancedInventories.chestConverter, "chestConverter");
		GameRegistry.registerBlock(improvedChest, ItemBlockImprovedChest.class, "improvedChest");
		GameRegistry.registerTileEntity(TileImprovedChest.class, "container.ImprovedChests:ImprovedChest");
		GameRegistry.registerBlock(locker, ItemBlockLocker.class, "locker");
		GameRegistry.registerTileEntity(TileLocker.class, "container.ImprovedChests:locker");
		registerCompatBlocks();
	}
	
	public void registerCompatBlocks(){
		if(EnhancedInventories.refinedRelocation){
			GameRegistry.registerBlock(EnhancedInventories.improvedSortingChest, ItemBlockImprovedChest.class, "improvedSortingChest");
			GameRegistry.registerTileEntity(TileImprovedSortingChest.class, "container.ImprovedChests:ImprovedSortingChest");
			GameRegistry.registerBlock(EnhancedInventories.sortingLocker, ItemBlockLocker.class, "sortingLocker");
			GameRegistry.registerTileEntity(TileSortingLocker.class, "container.ImprovedChests:SortingLocker");
		}
			
	}

	@Override
	public void init(FMLInitializationEvent event) {	
		NetworkRegistry.INSTANCE.registerGuiHandler(EnhancedInventories.instance, new GuiHandler());

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		//System.out.println("EI Post Init");
		
	}
	
	public void registerRecipes(){
		
	}

}
