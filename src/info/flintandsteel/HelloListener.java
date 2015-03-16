package info.flintandsteel;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.chat.TextFormat;
import net.canarymod.hook.HookHandler;
import net.canarymod.hook.player.BlockRightClickHook;
import net.canarymod.hook.player.ConnectionHook;
import net.canarymod.hook.player.CraftHook;
import net.canarymod.plugin.PluginListener;

/**
 * Created by cliff on 09/02/15.
 */


public class HelloListener implements PluginListener {

    @HookHandler
    public void onLogin(ConnectionHook hook) {
        hook.getPlayer().message(TextFormat.LIGHT_GREEN+"Hello World, "+hook.getPlayer().getName());
        hook.getPlayer().message(TextFormat.CYAN+"Welcome to the game!");
    }

    @HookHandler
    public void onRightClick(BlockRightClickHook hook)
    {
        //Player player = hook.getPlayer();
        String blockname = hook.getBlockClicked().getType().getMachineName();
        hook.getPlayer().message(TextFormat.CYAN+"s");
        hook.getPlayer().message(TextFormat.GREEN+blockname);
        hook.getPlayer().message(TextFormat.CYAN+"e");
    }

    @HookHandler
    public void onCraft(CraftHook hook) {
        Player player = hook.getPlayer();
        //Integer rs = hook.getMatchingRecipe().getRecipeSize();
        //String h = hook.getPlayer().
        player.message("Something was made, " + player.getDisplayName() + "!");
        //player.message(player.getItemHeld().getDisplayName());
        //String g = hook.getMatchingRecipe()
        //player.message(g);
        if(hook.getMatchingRecipe()!=null)
        {
            player.message("matching recipe item " + hook.getMatchingRecipe().getResult().getDisplayName());
        }
    }

    /*
    @HookHandler
    public void notifyPlayer(String msg) {
        //ConnectionHook hook = ConnectionHook;
        hk.getPlayer().message(Colors.CYAN+msg);
    }
    */

    /*
    @HookHandler
    public void ig(IgnitionHook hook)   {
        String o;
        o = String.valueOf(hook.getBlock().getType().getId());
        notifyPlayer(o);
    }
    */

    /*
    @HookHandler
    public void onWalk(PlayerMoveHook hook) {
        String x = String.valueOf(hook.getPlayer().getPosition().getBlockX());
        String y = String.valueOf(hook.getPlayer().getPosition().getBlockY());
        String z = String.valueOf(hook.getPlayer().getPosition().getBlockZ());
        hook.getPlayer().message(Colors.CYAN+"["+x+":"+y+":"+z+"]");
        //notifyPlayer(Colors.RED+"["+x+":"+y+":"+z+"]");
    }
    */

    /*
    @HookHandler
    public void onChunkCreate(ChunkCreationHook hook) {
        BiomeType[] bt = new BiomeType[2];
        bt[0]=BiomeType.FOREST;
        bt[1]=BiomeType.HELL;
        notifyPlayer("hey!");
        hook.setBiomeData(bt);
    }
    */



}