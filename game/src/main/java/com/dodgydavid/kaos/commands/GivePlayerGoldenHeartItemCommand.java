package com.dodgydavid.kaos.commands;

import com.dodgydavid.kaos.commands.base.CommandBase;
import com.dodgydavid.kaos.entities.player.items.GoldenHeart1Item;
import com.dodgydavid.kaos.main.Game;

public class GivePlayerGoldenHeartItemCommand implements CommandBase {

    @Override
    public void run(String commandText) {

        Game.addItemOrItemEntity(new GoldenHeart1Item(1));

    }

}
