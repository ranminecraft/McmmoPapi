package cc.ranmc.mcmmo;

import cc.ranmc.papi.PapiAPI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        print("&e-----------------------");
        print("&bMcmmoPapi &dBy阿然");
        print("&b插件版本:" + getDescription().getVersion());
        print("&b服务器版本:"+getServer().getVersion());
        print("&chttps://www.ranmc.cc/");
        print("&e-----------------------");

        if (Bukkit.getPluginManager().getPlugin("Ranmc") == null) {
            print("§b[McmmoPapi] §a无法找到Ranmc，插件关闭");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        if (Bukkit.getPluginManager().getPlugin("mcMMO") == null) {
            print("§b[McmmoPapi] §a无法找到mcMMO，插件关闭");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }

        PapiAPI.registerHandler(new Papi("mcmmo"));

        super.onEnable();
    }

    /**
     * 文本颜色
     */
    private static String color(String text){
        return text.replace("&","§");
    }

    /**
     * 后台信息
     */
    public void print(String msg){
        Bukkit.getConsoleSender().sendMessage(color(msg));
    }

}
