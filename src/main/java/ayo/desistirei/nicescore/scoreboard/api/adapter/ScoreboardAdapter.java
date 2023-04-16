package ayo.desistirei.nicescore.scoreboard.api.adapter;


import ayo.desistirei.nicescore.NiceScore;
import ayo.desistirei.nicescore.utils.CC;
import ayo.desistirei.nicescore.utils.Ping;
import ayo.desistirei.nicescore.utils.PlayerCount;
import ayo.desistirei.nicescore.scoreboard.api.*;
import ayo.desistirei.nicescore.scoreboard.api.AssembleAdapter;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;

public class ScoreboardAdapter implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return CC.translate(NiceScore.instance.getConfig().getString("scoreboard.title"));
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> list = new ArrayList<String>();

        if(Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")){
            for(String lines : NiceScore.instance.getConfig().getStringList("scoreboard.lines").stream()

                    .map(a -> a.replace("{online}", String.valueOf(PlayerCount.PLAYER_COUNT)))
                    .map(a -> a.replace("{ping}", String.valueOf(Ping.getPing(player))))

                    .collect(Collectors.toList())) {

                list.add(PlaceholderAPI.setPlaceholders(player, lines));
            }
        } else {

            list.addAll(NiceScore.instance.getConfig().getStringList("scoreboard.lines").stream()

                    .map(a -> a.replace("{online}", String.valueOf(PlayerCount.PLAYER_COUNT)))
                    .map(a -> a.replace("{ping}", String.valueOf(Ping.getPing(player))))

                    .collect(Collectors.toList()));

        }

        return list;
    }
}
