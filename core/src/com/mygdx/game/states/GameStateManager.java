package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Stack;

/**
 * Created by koolguy on 08.03.2018.
 */

public class GameStateManager {
    private Stack<State>states;
    public GameStateManager()
    {
    states=new Stack<State>();
    }
    public void push(State state)
    {
        states.push(state);
    }
    public void pop()
    {

        states.pop();
    }
    public void set(State state)
    {
        states.pop();
        states.push(state);
    }
    public void update(float dt)
    {
        states.peek().update(dt);

    }
    public void render(SpriteBatch sb)
    {

          states.peek().render(sb);
    }
}
