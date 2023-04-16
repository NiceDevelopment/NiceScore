package ayo.desistirei.nicescore.utils;

import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class PlayerCount {

    @Setter
    public static int PLAYER_COUNT = Bukkit.getOnlinePlayers().size();

}
