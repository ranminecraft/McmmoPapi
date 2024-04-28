package cc.ranmc.mcmmo;

import cc.ranmc.papi.bean.PapiHandler;
import com.gmail.nossr50.datatypes.player.McMMOPlayer;
import com.gmail.nossr50.datatypes.skills.PrimarySkillType;
import com.gmail.nossr50.util.player.UserManager;
import org.bukkit.entity.Player;

public class Papi extends PapiHandler {

    public Papi(String prefix) {
        super(prefix);
    }

    @Override
    public String handle(Player player, String identifier) {
        if (player == null) return "未知玩家";
        McMMOPlayer mcMMOPlayer = UserManager.getPlayer(player);
        if (mcMMOPlayer == null) return "获取失败";
        if (identifier.contains("level_")) {
            PrimarySkillType type = PrimarySkillType.valueOf(
                    identifier.replace("level_", "").toUpperCase());
            return String.valueOf(mcMMOPlayer.getSkillLevel(type));
        }
        if (identifier.equals("power_level")) {
            return String.valueOf(mcMMOPlayer.getPowerLevel());
        }
        return "未知变量";
    }
}

