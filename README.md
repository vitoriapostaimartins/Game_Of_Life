# Game_Of_Life
## Description
The Game Of Life is an object-oriented program and it is made with JavaFX. 
The purpose of the game is to simulate a simple world.
### Taken from Assignment Instructions:
"The world starts off with Plants and Herbivores (plant eaters) on a grid. The grid displays the plants (green)
and Herbivores (yellow) by filling in the squares where they are found. Blank squares
represent empty areas. Herbivores “graze” by moving around the grid eating plants they
find. Herbivores must find a plant to eat before 5 “turns” have passed or they die. A
“turn” is a step in time which occurs when a user clicks anywhere on the window
displaying the world. Herbivores move by checking neighboring cells and randomly
picking one. They cannot move to a neighboring cell that contains a Herbivore. They
move 1 cell per turn. Plants do not move. Plant however will seed. Each plant will send
seeds to a random neighboring empty cell assuming that there are at least 3 empty cells to
send seeds to and there are exactly 4 other plants to help cross pollenate"
## Object-oriented design
The design of this project was very carefully thought and the entities created behave very much like real-life object.
The implemented code makes it very easy to maintain objects, persue them as stand-alone entities and reuse their components.
### Maintaining Objects
This Game Of Life project makes it very easy to maintain objects. Since each method was designed to do one single thing, the methods are very small, 
which makes the readability easier, as well as code reusage. Changes are also very easy to be done.
### Persuing objects as stand-alone entities
The game is made with a few classes, which represent objects. In this program, objects are as decoupled as possible, making them very independent
and not excessively reliable on one another. This allows us to be able to make changes to a piece of code, which would have 
very little effect on how other pieces of code from other classes work.
### Reusable components
The components, including methods, were designed to be able to be reused as much as possible. This was done to avoid changing the same
in many different places in the future. 
For example, by allowing lifeforms to have a hierarchy of "A lifeform can either be an animal or a plant", the design allows the programmer to
implement similar behaviours and attributes that occur with both types of lifeforms.
## Possible future changes:
* A new type of lifeform could exist, such as a virus. In this case, the virus entity would have to extend Lifeform, which already has the methods 
and attributes that identify a lifeform. The virus would be able to override methods or reuse them and act just like the existing lifeforms.
* A new type of animal could exist, such as a carnivore. In this case, the carnivore would have to extend the abstract class Animal, 
in order to be classified as one, and would be able to use the available methods, as well as override them.
* A movable plant could exist. In that case, the Movable interface would tag the new entity and provide method headers for its possible actions. 
* There could be 3 boards, like the 3D Chess game. In this case, each board would have an ID and would be added to the scene, like it was done in the previous assignment.
* Furthermore, numbers could change, so they were made a constant and it would be very easy to change it in one place.
## Note
* One of the requirements for a plant to be able to seed was modified in this 
program. The original requirement was that a plant had to be around
exactly 4 other plants, which was changed to 3 or more.