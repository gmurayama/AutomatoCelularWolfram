#The Game of Life
> Also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

> The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input.
> One interacts with the Game of Life by creating an initial configuration and observing how it evolves or, for advanced players,by creating patterns with particular properties. [1]

## Life rules notation


<p align="center">
<img src="https://cloud.githubusercontent.com/assets/6378201/17479626/dcc01fd0-5d73-11e6-9f20-ef1014996bf3.gif" alt="SwingGoL"/>
</p>

Life rules are defined in the "S/B" form, where:
S - defines counts of alive neighbors necessary for a cell to survive,
B - defines counts of alive neighbors necessary for a cell to be born.

Note that the count of colors (states) has no influence on next generations, because Life is a one-bit family of rules.[2]

## Swing GoL 
<p align="center">
<img src="https://cloud.githubusercontent.com/assets/6378201/12917606/e689878e-ceff-11e5-9862-94286c40b6e3.png" alt="SwingGoL"/>
</p>

[Swing GoL in Action](https://www.youtube.com/watch?v=uK3pgeFkfu4)


Swing GoL's purpose is the customization of visual properties such as cell and border colors, the program also accepts the parametrization of user-entered rules. This allows the program to create unique combinations of patterns based on different rule-colors settings.   



# Built-in rule family screenshots 
(Rule descriptions are credited to Mirek Wojtowicz) 

## Replicator (1357/1357)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/17479631/dcd595cc-5d73-11e6-9633-a34f653f5105.gif" alt="Replicator"/>
</p>

In this remarkable universe every pattern is a replicator. After 32 steps every starting pattern is replicated 8 times.
Author unknown.

## Mazectric (1234/3)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/17479630/dcc3b1b8-5d73-11e6-8a91-e827e0f4049f.gif" alt="Mazectric"/>
</p>

"Mazectric" and "Corrosion of Conformity". An interesting variation of the Maze rule which produces longer halls and a highly linear format. Adding B7 to maze (keeping S5) allows some "mice" to run back and forth in the halls. Switching the B3 to B45 though, electrifies the mazes. Dropping S3 gives "Corrosion of Conformity", a slow burn from almost any starting pattern, resulting in a rusting away of the local continuum.
A rule by Charles A. Rockafellor.

## Mamadou (23/345678)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/17479629/dcc27302-5d73-11e6-8273-69d9e73301e3.gif" alt="Mamadou"/>
</p>

A modification of the original Game of Life rules where the birth rules include all values above 3, start with simple patterns such as a cross and watch the automata evolve in very intresting patterns.

## Gnarl (1/1)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/17479627/dcc01490-5d73-11e6-8abe-acf6ce04f0a2.gif" alt="Gnarl"/>
</p>

A simple rule provided by Kellie Evans. To see its beauty start with simple patterns, for example with a single dot.

## Flakes (012345678/3)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/17479632/dcddabea-5d73-11e6-9a20-23fd28dd953c.gif" alt="Flakes"/>
</p>

Also known as Life without Death (LwoD).
The rule produces beautiful flakes, starting from simple groups of cells. Try for example various filled circles with radius > 20 cells. The rule produces also ladders, what allowed David Griffeath and Cris Moore to prove that the rule is P-complete.
A rule by Janko Gravner.

## Diamoeba (5678/35678)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/17479628/dcc073b8-5d73-11e6-93a9-b3600615b1b6.gif" alt="Diamoeba"/>
</p>

Creates solid diamond-shaped "amoeba" patterns that are surprisingly unpredictable. For a long time it was not known whether any diamonds expand forever, or if the tendency toward the catastrophic destruction of corners is too strong. Finally in March 1999 David Eppstein found the  c/7 spaceship, and David Bell made a 100% spacefiller out of it.
A rule by Dean Hickerson.

## Notable life implementations:
* McCell http://www.mirekw.com/ca/whatis_mcell.html
* Golly http://golly.sourceforge.net/
* XLife http://conwaylife.com/wiki/Xlife

### Sources
1. https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life
1. Mirek Wojtowicz at http://www.mirekw.com/ca/rullex_life.html
