package com.github.kaosgame.kaos.commands;

import com.github.kaosgame.kaos.commands.base.CommandBase;
import com.github.kaosgame.kaos.main.Game;
import com.github.kaosgame.kaos.sound.Sounds;

import javax.swing.JOptionPane;

public class GodModeCommand implements CommandBase {

    @Override
    public void run(String commandText) {

        Game.PLAYER.setGodMode(true);
        Game.PLAYER.setCoins(Integer.MAX_VALUE);

        JOptionPane.showMessageDialog(null, "God mode is now enabled", "Info", JOptionPane.INFORMATION_MESSAGE);

        Game.ANY_VOLUME_SOUNDS.setSound(Sounds.SAVE_FROM_DEATH);
        Game.ANY_VOLUME_SOUNDS.setVolumeScale(4);
        Game.ANY_VOLUME_SOUNDS.setSound(Sounds.SAVE_FROM_DEATH);
        Game.ANY_VOLUME_SOUNDS.loop(4);
        Game.ANY_VOLUME_SOUNDS.setVolumeScale(3);

    }

}
