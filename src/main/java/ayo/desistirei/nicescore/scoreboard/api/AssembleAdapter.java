package ayo.desistirei.nicescore.scoreboard.api;

import java.util.List;
import org.bukkit.entity.Player;

public interface AssembleAdapter {

    String getTitle(Player player);

    List<String> getLines(Player player);

}