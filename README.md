#The Game of Life
> Also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.

> The "game" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input.
> One interacts with the Game of Life by creating an initial configuration and observing how it evolves or, for advanced players,by creating patterns with particular properties. [1]

## Life rules notation

Life rules are defined in the "S/B" form, where:
S - defines counts of alive neighbors necessary for a cell to survive,
B - defines counts of alive neighbors necessary for a cell to be born.

Note that the count of colors (states) has no influence on next generations, because Life is a one-bit family of rules.[2]

## Swing GoL 
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12917606/e689878e-ceff-11e5-9862-94286c40b6e3.png" alt="SwingGoL"/>
</p>

The program allows graphical customization for border color as well as for the state of the cells.


# Built-in rule family screenshots 
(All descriptions are credited to Mirek Wojtowicz) 

## Replicator (1357/1357)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12784421/c7e35ac4-ca4c-11e5-9230-5402ff2126ae.png" alt="Replicator"/>
</p>

In this remarkable universe every pattern is a replicator. After 32 steps every starting pattern is replicated 8 times.
Author unknown.

## Mazectric (1234/3)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12784422/c7ffaf80-ca4c-11e5-9fe3-c3ced6591fa7.png" alt="Mazectric"/>
</p>

"Mazectric" and "Corrosion of Conformity". An interesting variation of the Maze rule which produces longer halls and a highly linear format. Adding B7 to maze (keeping S5) allows some "mice" to run back and forth in the halls. Switching the B3 to B45 though, electrifies the mazes. Dropping S3 gives "Corrosion of Conformity", a slow burn from almost any starting pattern, resulting in a rusting away of the local continuum.
A rule by Charles A. Rockafellor.

## Mamadou (23/345678)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12784424/c802e218-ca4c-11e5-934a-009de3191f31.png" alt="Mamadou"/>
</p>

A modification of the original Game of Life rules where the birth rules include all values superior to 3, start with simple patterns such as a cross and watch the automata evolve in lovely patterns.

## Gnarl (1/1)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12784423/c800449a-ca4c-11e5-85e6-27aeec601426.png" alt="Gnarl"/>
</p>

A simple rule provided by Kellie Evans. To see its beauty start with simple patterns, for example with a single dot.

## Flakes (012345678/3)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12784425/c804b548-ca4c-11e5-8653-636472059f0b.png" alt="Flakes"/>
</p>

Also known as Life without Death (LwoD).
The rule produces beautiful flakes, starting from simple groups of cells. Try for example various filled circles with radius > 20 cells. The rule produces also ladders, what allowed David Griffeath and Cris Moore to prove that the rule is P-complete.
A rule by Janko Gravner.

## Diamoeba (5678/35678)
<p align="center">
  <img src="https://cloud.githubusercontent.com/assets/6378201/12784426/c806dc1a-ca4c-11e5-840a-39c3845b5d5f.png" alt="Diamoeba"/>
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
