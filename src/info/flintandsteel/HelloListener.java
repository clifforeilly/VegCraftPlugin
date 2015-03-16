package info.flintandsteel;

import net.canarymod.api.entity.living.humanoid.Player;
import net.canarymod.api.inventory.CanaryPlayerCraftingMatrix;
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
        //player.message("Something was made, " + player.getDisplayName() + "!");
        //player.message(player.getItemHeld().getDisplayName());
        //String g = hook.getMatchingRecipe()
        //player.message(g);
        if(hook.getMatchingRecipe()!=null)
        {
            if(hook.getMatchingRecipe().getResult().getDisplayName().contains("Shears") && hook.getMatchingRecipe().getRecipeSize()==3)
            {
                player.message("You made Easy " + hook.getMatchingRecipe().getResult().getDisplayName());


                //CanaryPlayerCraftingMatrix gh = new CanaryPlayerCraftingMatrix();



                //getLogman().info(r.getRecipeSize());
            }
        }
    }

}