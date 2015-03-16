package info.flintandsteel;

import net.canarymod.Canary;
import net.canarymod.api.Server;
import net.canarymod.api.inventory.Item;
import net.canarymod.api.inventory.ItemType;
import net.canarymod.api.inventory.recipes.CraftingRecipe;
import net.canarymod.api.inventory.recipes.Recipe;
import net.canarymod.api.inventory.recipes.RecipeRow;
import net.canarymod.plugin.Plugin;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by cliff on 09/02/15.
 */
public class HelloWorld extends Plugin {

    //static Logger log = Logger.getLogger("Minecraft");
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
        getLogman().info("Enabling " + getName() + " Version " + getVersion()); //getName() returns the class name, in this case HelloWorld
        getLogman().info("Authored by " + getAuthor());
        createRecipes();
        listRecipes("nothing");
    }

    public void listRecipes(String name)
    {
        List<Recipe> recipes = svr.getServerRecipes();
        int c = 0;

        for (Recipe r : recipes)
        {
            if(r.getResult().getDisplayName().contains("Shears"))
            {
                c++;
                getLogman().info(c + ":" + r.toString());
                getLogman().info(r.getResult().getDisplayName());
                getLogman().info(r.getRecipeSize());
            }
        }
    }

    public void createRecipes(){

        CraftingRecipe crEasyShears = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Shears, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.Stick, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.Cobble, 0, 1)})
        );
        Canary.getServer().addRecipe(crEasyShears);
        getLogman().info("Added 'Easy Shears'");

        CraftingRecipe crFauxLeatherAcacia = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Leather, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.AcaciaLeaves, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.OrangeDye, 0, 1)})
        );
        Canary.getServer().addRecipe(crFauxLeatherAcacia);
        getLogman().info("Added 'Faux Leather Acacia'");

        CraftingRecipe crFauxLeatherBirch = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Leather, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.BirchLeaves, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.OrangeDye, 0, 1)})
        );
        Canary.getServer().addRecipe(crFauxLeatherBirch);
        getLogman().info("Added 'Faux Leather Birch'");

        CraftingRecipe crFauxLeatherDarkOak = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Leather, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.DarkOakLeaves, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.OrangeDye, 0, 1)})
        );
        Canary.getServer().addRecipe(crFauxLeatherDarkOak);
        getLogman().info("Added 'Faux Leather DarkOak'");

        CraftingRecipe crFauxLeatherJungle = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Leather, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.JungleLeaves, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.OrangeDye, 0, 1)})
        );
        Canary.getServer().addRecipe(crFauxLeatherJungle);
        getLogman().info("Added 'Faux Leather Jungle'");

        CraftingRecipe crFauxLeatherOak = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Leather, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.OakLeaves, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.OrangeDye, 0, 1)})
        );
        Canary.getServer().addRecipe(crFauxLeatherOak);
        getLogman().info("Added 'Faux Leather Oak'");

        CraftingRecipe crFauxLeatherPine = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Leather, 0, 1),
                new RecipeRow("yxy", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.PineLeaves, 0, 1), Canary.factory().getItemFactory().newItem(ItemType.OrangeDye, 0, 1)})
        );
        Canary.getServer().addRecipe(crFauxLeatherPine);
        getLogman().info("Added 'Faux Leather Pine'");

        CraftingRecipe VegArrows = new CraftingRecipe(
                Canary.factory().getItemFactory().newItem(ItemType.Arrow, 0, 4),
                new RecipeRow(" x ", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.Flint, 0, 1)}),
                new RecipeRow(" y ", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.Stick, 0, 1)}),
                new RecipeRow(" z ", new Item[]{Canary.factory().getItemFactory().newItem(ItemType.Lilypad, 0, 1)})
        );
        Canary.getServer().addRecipe(VegArrows);
        getLogman().info("Added 'VegArrows'");

    }

}

