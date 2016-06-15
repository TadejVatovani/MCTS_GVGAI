# MCTS_GVGAI
Based on the gvgai framework

Normally i'd recommend the open-loop implementation since most games are non-deterministic,and it's normally fast enough compared to the non-open-loop implementation.

Giving it only 1 round of time isn't enough to make a useful tree so i don't recommend using act1.

When using actforgetn I found that the best n is 3 since it can make decent decisions,and a bigger n would take too much time (it would fail quite due to it's slow reaction time).

As described in the method description i wouldn't recommend using actremembern since the idea didn't really work out.

I was testing this on windows so the elapsedTime wasn't as accurate so i didn't really bother with better time aproximation.

Improvments that could be done:
Dynamically configure n.

Evaluating could be much better since gamescore normally doesn't give enough information.

Try to figure out if the game is deterministic or non-deterministic with a few simulations at start then using the appropiate implementation.

Instead of building MCTS on actions a better idea would be to build it on coordinates and then use path-finding algorithms for better optimization. But this was mostly for introduction to MCTS so i think the execution is quite fine.

