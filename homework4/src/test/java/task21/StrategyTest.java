package task21;

import org.junit.Before;
import org.junit.Test;
import timur.task21.Context;
import timur.task21.MoveType;
import timur.task21.entity.Elf;
import timur.task21.entity.Harpy;
import timur.task21.entity.Orc;
import timur.task21.entity.Pegasus;

import static org.junit.Assert.assertEquals;

public class StrategyTest {

    Context context;
    Elf elf;
    Harpy harpy;
    Orc orc;
    Pegasus pegasus;


    @Before
    public void setUp(){

        context = new Context();

        // heroes
        elf = new Elf("Legolas");
        harpy = new Harpy("Harpyna");
        orc = new Orc("Balrog");
        pegasus = new Pegasus("Pega");

    }

    @Test
    public void elfMove(){
        context.setHero(elf);
        assertEquals("Elf Legolas is walking...",context.move(MoveType.WALK));
        assertEquals("Elf's cannot do this move: FLY_WITH_MAGIC",context.move(MoveType.FLY_WITH_MAGIC));
    }

    @Test
    public void harpyMove(){

        context.setHero(harpy);
        assertEquals("Harpy Harpyna is walking...",context.move(MoveType.WALK));
        assertEquals("Harpy's cannot do this move: FLY_WITH_MAGIC",context.move(MoveType.FLY_WITH_MAGIC));
    }

    @Test
    public void orcMove(){
        context.setHero(orc);
        assertEquals("Orc Balrog is walking...",context.move(MoveType.WALK));
        assertEquals("Orc's cannot do this move: FLY_WITH_MAGIC",context.move(MoveType.FLY_WITH_MAGIC));
    }

    @Test
    public void pegasusMove(){
        context.setHero(pegasus);
        assertEquals("Pegasus Pega is walking...",context.move(MoveType.WALK));
        assertEquals("Pegasus Pega is flying...",context.move(MoveType.FLY));
        assertEquals("Pegasus Pega is flying by magic...",context.move(MoveType.FLY_WITH_MAGIC));
    }

}
