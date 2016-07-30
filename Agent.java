package Shazboz;

import core.game.Observation;
import core.game.StateObservation;
import core.player.AbstractPlayer;
import ontology.Types;
import tools.ElapsedCpuTimer;

import java.util.ArrayList;
import java.util.Random;

public class Agent extends AbstractPlayer {

    public static int NUM_ACTIONS;
    public static Types.ACTIONS[] actions;

    Node root;
    //PlayerOL player = new PlayerOL();
    Player player = new Player();
    
    public Agent(StateObservation so, ElapsedCpuTimer elapsedTimer) {
        ArrayList<Types.ACTIONS> act = so.getAvailableActions();
        actions = new Types.ACTIONS[act.size()];
        for (int i = 0; i < actions.length; ++i) {
            actions[i] = act.get(i);
        }
        NUM_ACTIONS = actions.length;
    }

    public Types.ACTIONS act(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
        int action = 0;
        ArrayList<Observation> obs[] = stateObs.getFromAvatarSpritesPositions();
        ArrayList<Observation> grid[][] =
        stateObs.getObservationGrid();

        //select the action
        //action = player.act1(stateObs, elapsedTimer);
        //action = player.actforgetn(stateObs, elapsedTimer, 2);
        //action = player.actforgetn(stateObs, elapsedTimer, 3);
        //action = player.actforgetn(stateObs, elapsedTimer, 5);
        action = player.actforgetn(stateObs, elapsedTimer, 7);
        
        
        
        
        //if the returned action is -1 do nothing,since it's still building a tree 
        if (action == -1) {
            return Types.ACTIONS.ACTION_NIL;
        }

        return actions[action];
    }

}
