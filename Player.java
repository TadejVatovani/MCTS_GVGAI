package Shazboz;

import core.game.StateObservation;
import java.util.Random;
import tools.ElapsedCpuTimer;

public class Player {

    Random rnd = new Random();
    int counter = 0;
    Node root = null;

    /**
     * Makes a tree for n rounds then acts out, after it acts out it forgets the
     * tree
     */
    public int actforgetn(StateObservation stateObs, ElapsedCpuTimer elapsedTimer, int n) {
        elapsedTimer.setMaxTimeMillis(elapsedTimer.remainingTimeMillis());
        if (counter == 0) {
            root = new Node(null, rnd, stateObs);
            root.expandTree(elapsedTimer);
            counter++;
            return -1;
        } else if (counter < n) {
            if (root == null) {
                System.out.println("Null");
            }
            root.expandTree(elapsedTimer);
            counter++;
            return -1;
        } else {
            int action = root.search(elapsedTimer);
            counter = 0;
            return action;
        }

    }

    /**
     * Makes a tree for 1 round returns the action and forgets the tree
     */
    public int act1(StateObservation stateObs, ElapsedCpuTimer elapsedTimer) {
        elapsedTimer.setMaxTimeMillis(elapsedTimer.remainingTimeMillis());
        root = new Node(null, rnd, stateObs);
        return root.search(elapsedTimer);
    }

}
