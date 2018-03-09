package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by koolguy on 08.03.2018.
 */

public class Tube {
     private Texture topTube,bottomTube;
     private Vector2 posTopTube,posBotTube;
     private Random rand;
     private static final int TUBE_GAP = 100;
     private static final int FLUCTUATION=130;
     private static final int LOWEST_OPENING=120;
     public static final int TUBE_WIDTH = 52;
     private Rectangle boundsTop,boundsBot;
    public Texture getTopTube() {
        return topTube;
    }

    public Texture getBottomTube() {
        return bottomTube;
    }

    public Vector2 getPosTopTube() {
        return posTopTube;
    }

    public Vector2 getPosBotTube() {
        return posBotTube;
    }

    public Tube(float x)
     {
         topTube = new Texture("toptube.png");
         bottomTube = new Texture("bottomtube.png");
         rand = new Random();
         posTopTube = new Vector2(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);

         posBotTube= new Vector2(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
         boundsTop= new Rectangle(posTopTube.x,posTopTube.y,topTube.getWidth()-30,topTube.getHeight());
         boundsBot = new Rectangle(posBotTube.x,posBotTube.y,bottomTube.getWidth()-30,bottomTube.getHeight());
     }
     public void  reposition(float x)
     {
       posTopTube.set(x,rand.nextInt(FLUCTUATION)+TUBE_GAP+LOWEST_OPENING);
       posBotTube.set(x,posTopTube.y-TUBE_GAP-bottomTube.getHeight());
       boundsTop.setPosition(posTopTube.x+30,posTopTube.y);
       boundsBot.setPosition(posBotTube.x+30,posBotTube.y);

     }
     public boolean collides(Rectangle player)
     {
         return player.overlaps(boundsBot)||player.overlaps(boundsTop);
     }

}
