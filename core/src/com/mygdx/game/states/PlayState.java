package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.sprites.Bird;
import com.mygdx.game.sprites.Tube;

import java.util.ArrayList;

/**
 * Created by koolguy on 08.03.2018.
 */

public class PlayState extends State {
    private Bird bird;
    private Texture bg;
    private static final int TUBE_SPACING = 125;
    private static final int TUBE_COUNT = 4;
    private Array<Tube> tubes;
    public PlayState(GameStateManager gsm) {
        super(gsm);
        bird = new Bird(-50,50);
        cam.setToOrtho(false, MyGdxGame.WIDTH/2,MyGdxGame.HEIGHT/2);
        bg = new Texture("bg.png");

        tubes = new Array<Tube>();
        for(int i = 1;i<=TUBE_COUNT;i++ )
        {
            tubes.add(new Tube(i*(TUBE_SPACING+Tube.TUBE_WIDTH)));

        }
    }

    @Override
    protected void handleInput() {
      if(Gdx.input.justTouched())bird.jump();
    }

    @Override
    public void update(float dt) {
            handleInput();
            bird.update(dt);
            cam.position.x = bird.getPosition().x +80;
            for(Tube tube:tubes)
            {
                if(cam.position.x-(cam.viewportWidth/2)>tube.getPosTopTube().x+tube.getTopTube().getWidth())
                {

                    tube.reposition((tube.getPosTopTube().x+((Tube.TUBE_WIDTH+TUBE_SPACING)*TUBE_COUNT)));


                }
                if(tube.collides(bird.getBounds()))
                {

                    gsm.set(new PlayState(gsm));
                }
            }
            cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg,cam.position.x-cam.viewportWidth/2,0);
        sb.draw(bird.getBird(),bird.getPosition().x,bird.getPosition().y);
        for (Tube tube:tubes)
        {
            sb.draw(tube.getTopTube(),tube.getPosTopTube().x,tube.getPosTopTube().y);
            sb.draw(tube.getBottomTube(),tube.getPosBotTube().x,tube.getPosBotTube().y);

        }
        sb.end();

    }

    @Override
    public void dispose() {

    }
}
