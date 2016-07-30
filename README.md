# MCTS_GVGAI

General idea:

A basic implementation of Monte-Carlo tree search based on the gvgai framework. 

I implemented an open-loop and a closed-loop. An open-loop MCTS recalculates values starting from the root, which works better for non-deterministic games where the states change with time. The closed-loop implementation just takes the previously saved state, which doesn't take in account any changes that could have occured.

The methods it uses for determining the action to take are act1 and actforgetn. The act1 just builds a tree for 1 round(so 40 ms) and returns the best action it found. The actforgetn method takes a parameter n, which determines how many rounds the tree will be built for. Bigger n means a bigger tree which can help in making a better decision, but since many games are dependant on speed a smaller n is recommended. While it builds a tree the character does nothing(whichever action in the game is nil).

Testing:

For the tests, each game was ran 4 times. OL stands for openloop, CL stands for closed-loop. The N corresponds to how many round the AI was given to build a tree.

The numbers tested are: (Average score)/(Win/Loss ratio in %)

Aliens:

N 	OL			CL				
	
		
1	65.75/0%		67.5/0%
2	62.25/25%		67.0/25%
3	63.0/0%		50.25/0%
5	35.0/0%		41.5/0%
7	37.0/0%		30.0/0%

At high number of turns the AI reacted too slowly too dodge incoming attack so it lost quite quickly.

Seeing as n=2 was the only one to get wins probably means that it's the best balance between tree size and reaction time. 

Pacman:

N 	OL			CL			
	
1	265.75/0%		286.5/0%
2	200.5/0%		190.0/0%
3	190.25/0%		188.0/0%
5	141.25/0%		164.75/0%
7	133.75/0%		123.5/0%

Open-loop was a bit better at getting out of areas that were already empty(areas without any points to pick up). The AI never won the game since it never entered the exit(it almost did it a few times, but normally it just rotated in the area around the exit). The ideal n is either 2 or 3 since it can still run away from ghosts, but it does mean it's harder to find the exit since the MCTS tree is smaller.

Sherrif:

N 	OL			CL			
	
1	6.25/100%		7.25/100%
2	0.75/25%		2.75/50%
3	1/25%			2.0/50%
5	0.75/25%		1.0/25%
7	0.0/25%		0.0/25%

Open-loop and closed-loop were quite equal, with CL edging out due to speed, since this game requires faster decisions instead of slower and better decisions. This is why the smaller MCTS tree size works better.

While the basic MCTS works there are a few improvements that could be done:

I tried to implement a controller which returned the previous action instead of nil while it's building a tree, but it didn't work out since it would repeat an action n times which would eliminate better solutions. Another improvement i tried was not throwing the whole tree away, but it didn't work out since the tree either got out-dated or became too big, though maybe refreshing it every few decisions might have been a sufficent fix.

A dynamic choice of n, might also be interesting, since i was testing with a constant n.

A better evaluation method, since gamescore normally doesn't give enough information.

Figuring out if the game is deterministic or non-deterministic with a few simulations at start then using the appropriate implementation(either open or closed loop).

Instead of building MCTS on actions a better idea would be to build it on coordinates(so you evaluate objects) and then use path-finding algorithms for better optimization.

A better time evaluation function. But i was testing this on windows so I was limited by the elapsedTime method.
