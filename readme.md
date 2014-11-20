#Trafiksimulering
##By Petrus Jonsson and Adil Arhzane

Description of the program trafiksimulering

* How to build and run the program
The program has a make file that helps the user with building the program.
    - Open the program: terminal
    - Make sure that the current location is the directory trafiksimulation/.
    - Simply write make.
    - the program is now built, run it by writing in the terminal: java Simulation.

* How to use the program.
     - After running the program the user is asked to choose which vehicle that will be used in the simulation. This does not change anything important in the program, just the graphical representation.
     - Next the user gets to chose to use default settings or advanced.
     - If the user wants advanced settings, there are a few concepts that might need to be explained..

       - One cycle is one step in the simulation(default settings uses 100 cycles).
       - The intensity is not 100% accurate, since they occur randomly to  make the simulation more realistic.
       - period is the time interval for the traffic lights.
       - green time is the time the lights are green, light is green if green time is less than the timer, which loops according to the period.
       - The length of a lane is equal to how far a vehicle travels each step, for instance, a car can drive at most 10 length units in 10 steps.
     
* Goals completed with this program
  - A2
  - E11
  - B4
  - D9
  - G16
  - S51
  - B5
  - G15
  - I23

##Further extensions
* A couple of extensions has already been done, for instance:
  - implementing more vehicles.
  - Being able to use default settings for fast and easy runs.

* Extensions that could be done
  - Real graphics.
  - Some kind of file input.
  - File output(getting use of results).