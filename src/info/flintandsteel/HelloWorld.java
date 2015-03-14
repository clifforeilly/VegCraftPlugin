package info.flintandsteel;

import net.canarymod.Canary;
import net.canarymod.api.Server;
import net.canarymod.api.inventory.CanaryItem;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.recipes.CraftingRecipe;
import net.canarymod.api.inventory.recipes.RecipeRow;
import net.canarymod.plugin.Plugin;

import java.util.logging.Logger;

/**
 * Created by cliff on 09/02/15.
 */
public class HelloWorld extends Plugin {

    static Logger log = Logger.getLogger("Minecraft");
    Server svr = Canary.getServer();

    @Override
    public boolean enable() {
        Canary.hooks().registerListener(new HelloListener(), this);
        initialize();
        return true;
    }

    @Override
    public void disable() {
        // TODO Auto-generated method stub
    }

    public void initialize(){
        getLogman().info("Enabling "+getName() + " Version " + getVersion()); //getName() returns the class name, in this case HelloWorld
        getLogman().info("Authored by "+getAuthor());
        createRecipes();
    }

    Integer IDArrow = 262;
    Integer IDFlint = 318;
    Integer IDStick = 280;
    Integer IDLilyPad = 111;
    Integer IDShears = 359;
    Integer IDLeather = 343;
    Integer IDOrangeDye = 359;

    public void createRecipes(){

        //Veg arrows
        String rsVegArrows1 = " X ";
        String rsVegArrows2 = " Y ";
        String rsVegArrows3 = " Z ";
        Item itemOutVegArrows = new CanaryItem(IDArrow,1,0);
        Item[] itemInVegArrowsFlint = {new CanaryItem(IDFlint,1,0)};
        Item[] itemInVegArrowsStick = {new CanaryItem(IDStick,1,0)};
        Item[] itemInVegArrowsLilyPad = {new CanaryItem(IDLilyPad,1,0)};
        RecipeRow rrVegArrows1 = new RecipeRow(rsVegArrows1, itemInVegArrowsFlint);
        RecipeRow rrVegArrows2 = new RecipeRow(rsVegArrows2, itemInVegArrowsStick);
        RecipeRow rrVegArrows3 = new RecipeRow(rsVegArrows3, itemInVegArrowsLilyPad);
        RecipeRow[] rrArrayVegArrows = {rrVegArrows1,rrVegArrows2,rrVegArrows3};
        CraftingRecipe crVegArrows = new CraftingRecipe(itemOutVegArrows,rrArrayVegArrows);
        svr.addRecipe(crVegArrows);


        //Easy shears
        String rsEasyShears1 = "XYX";
        String rsEasyShears2 = "XYX";
        Item itemOutEasyShears = new CanaryItem(IDShears,1,0);
        Item[] itemInEasyShearsStickFlint = {new CanaryItem(IDStick,1,0), new CanaryItem(IDFlint,1,0)};
        RecipeRow rrEasyShears1 = new RecipeRow(rsEasyShears1, itemInEasyShearsStickFlint);
        RecipeRow rrEasyShears2 = new RecipeRow(rsEasyShears2, itemInEasyShearsStickFlint);
        RecipeRow[] rrArrayEasyShears = {rrEasyShears1, rrEasyShears2};
        CraftingRecipe crEasyShears = new CraftingRecipe(itemOutEasyShears, rrArrayEasyShears);
        svr.addRecipe(crEasyShears);


        //faux leather
        String rsFauxLeather1 = " X ";
        String rsFauxLeather2 = " Y ";
        Item itemOutFauxLeather = new CanaryItem(IDLeather,1,0);
        Item[] itemInFauxLeatherOrangeDye = {new CanaryItem(IDOrangeDye,1,0)};
        Item[] itemInFauxLeatherLilyPad = {new CanaryItem(IDLilyPad,1,0)};
        RecipeRow rrFauxLeather1 = new RecipeRow(rsFauxLeather1, itemInFauxLeatherOrangeDye);
        RecipeRow rrFauxLeather2 = new RecipeRow(rsFauxLeather2, itemInFauxLeatherLilyPad);
        RecipeRow[] rrArrayFauxLeather = {rrFauxLeather1,rrFauxLeather2};
        CraftingRecipe crFauxLeather = new CraftingRecipe(itemOutFauxLeather,rrArrayFauxLeather);
        svr.addRecipe(crFauxLeather);

    }

}

