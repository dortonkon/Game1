package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.MyGdxGame;

/**
 * Created by koolguy on 08.03.2018.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playbtn;
    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.png");
         playbtn = new Texture("playbtn.png");
    }

    @Override
    public void handleInput() {
                if(Gdx.input.justTouched())
                {

                    gsm.set((new PlayState(gsm)));
                    dispose();
                }
    }

    @Override
    public void update(float dt) {
               handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background,0,0, MyGdxGame.WIDTH,MyGdxGame.HEIGHT);
        sb.draw(playbtn,(MyGdxGame.WIDTH/2)-(playbtn.getWidth()/2),(MyGdxGame.HEIGHT/2));
        sb.end();

    }

    @Override
    public void dispose() {
        background.dispose();
        playbtn.dispose();
    }
}
