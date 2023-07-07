package com.github.kaosgame.kaos.entities.player.items.tools.weapon;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import com.github.kaosgame.kaos.collision.objects.ChestTransparentObject;
import com.github.kaosgame.kaos.collision.objects.PlayerObject;
import com.github.kaosgame.kaos.collision.objects.base.CollisionObject;
import com.github.kaosgame.kaos.collision.objects.base.ObjectType;
import com.github.kaosgame.kaos.entities.base.DamageableEntity;
import com.github.kaosgame.kaos.entities.base.Entity;
import com.github.kaosgame.kaos.entities.base.EntityID;
import com.github.kaosgame.kaos.entities.player.items.base.ItemID;
import com.github.kaosgame.kaos.entities.player.items.base.WeaponItem;
import com.github.kaosgame.kaos.loot.tables.handler.LootTableHandler;
import com.github.kaosgame.kaos.loot.tables.handler.LootTableID;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.particles.ParticleTypes;
import com.github.kaosgame.kaos.particles.images.ImageParticleTypes;
import com.github.kaosgame.kaos.particles.images.ParticleImages;
import com.github.kaosgame.kaos.sound.Sounds;

public class AxeItem extends WeaponItem<AxeItem> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6791978238671428013L;

	private AxeItem(int count, ItemID id, BufferedImage image, float damage) {
		
		super(count, id, image, damage);
		
		
	}
	
	public AxeItem(int count, ItemID id, BufferedImage image) {
		
		super(count, id, image, 2f);
		
		
	}
	
	private void makeWoodParticle() {
		
		ParticleTypes.FALL_1.make((double) (Game.PLAYER.getX() + 32), (double) (Game.PLAYER.getY() + 32), 8, 8, new Color(0x6e4b00), null, null);
		
	}
	
	private void makeTreeParticle() {
		
		ParticleTypes.FALL_2.make((double) (Game.PLAYER.getX() + 32), (double) (Game.PLAYER.getY() + 80), 8, 8, new Color(0xa55500), null, null);
		
	}
	
	private void makeDamageParticle(float x, float y) {
		
		ParticleTypes.FALL_3.make(x, y, 8, 8, new Color(160, 0, 0), null, null);
		
	}

	@Override
	public void use() {
		
		LinkedList<CollisionObject> tempObjList = Game.MAP_HANDLER().currentMap().getObjectList();
		
		for (int i = 0; i < tempObjList.size(); i++) {
			
			CollisionObject tempObj = tempObjList.get(i);
			
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.TREE_1 &&
					Math.random() < 0.50
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				LootTableHandler.createLootAtRandom(LootTableID.TREE_1_LOOT);
				this.makeTreeParticle();
				
				Game.SE_SOUND.setSound(Sounds.BREAK);
				Game.SE_SOUND.play();
				
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.WOOD_1 &&
					Math.random() < 0.50 &&
					tempObj instanceof PlayerObject
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				
				LootTableHandler.createLootAtRandom(LootTableID.WOOD_1_LOOT);
				this.makeWoodParticle();
				Game.SE_SOUND.setSound(Sounds.BREAK);
				Game.SE_SOUND.play();
				
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.APPLE_TREE_1 &&
					Math.random() < 0.50
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				LootTableHandler.createLootAtRandom(LootTableID.APPLE_TREE_1_LOOT);
				this.makeTreeParticle();
				Game.SE_SOUND.setSound(Sounds.BREAK);
				Game.SE_SOUND.play();
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.CHEST &&
					Math.random() < 0.50 && tempObj instanceof ChestTransparentObject
				) {
				
				ChestTransparentObject chest = (ChestTransparentObject) tempObj;
				
				LootTableHandler.createLootAtRandom(LootTableID.CHEST_1);
				
				chest.breakItem();
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				this.makeWoodParticle();
				Game.SE_SOUND.setSound(Sounds.BREAK);
				Game.SE_SOUND.play();
				
			}
			
			if (
					Game.getRectangle(
									(int) Game.PLAYER.getX(),
									(int) Game.PLAYER.getY(),
									Game.PLAYER.getWidth(),
									Game.PLAYER.getHeight()
					).intersects(tempObj.getRectangle()) &&
					tempObj.getType() == ObjectType.SIGN_1 &&
					Math.random() < 0.50
				) {
				
				Game.MAP_HANDLER().currentMap().removeObject(tempObj);
				
				LootTableHandler.createLootAtRandom(LootTableID.SIGN_1);
				this.makeWoodParticle();
				Game.SE_SOUND.setSound(Sounds.BREAK);
				Game.SE_SOUND.play();
				
			}
			
		}
		
		LinkedList<Entity> tempEList = Game.MAP_HANDLER().currentMap().getEntityHandler().getList();
		
		for (int i = 0; i < tempEList.size(); i++) {
			
			Entity e = tempEList.get(i);
			
			if (e.equals(Game.PLAYER)) continue;
			
			if (e instanceof DamageableEntity && Game.PLAYER.getRectangle().intersects(e.getRectangle()) && Math.random() < 0.50) {
				
				((DamageableEntity) e).damage(Game.PLAYER.calculateAttackDamage(this.damage));
				
				if (!e.getId().equals(EntityID.MONSTER_LEATH)) {
					
					this.makeDamageParticle(e.getX(), e.getY());
					
				} else {
					
					ImageParticleTypes.FALL_1.make((int) (e.getX() + e.getWidth()), e.getY(), 16, 16, null, null, ParticleImages.MONSTER_LEATH_ATTACK_1);
					
				}
				
			}
			
		}
		
	}

	@Override
	public AxeItem cloneType() {
		
		return new AxeItem(this.count, this.id, this.image, this.damage);
		
	}


}
