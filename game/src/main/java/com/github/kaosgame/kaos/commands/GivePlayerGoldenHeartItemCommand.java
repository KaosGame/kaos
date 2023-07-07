package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.entities.player.items.GoldenHeart1Item;
import com.github.kaosgame.kaos.main.Game;

public class GivePlayerGoldenHeartItemCommand implements CommandBase {

    @Override
    public void run(String commandText) {

        Game.addItemOrItemEntity(new GoldenHeart1Item(1));

    }

}
