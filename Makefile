JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java
CLASSES = Fordon.java \
	Car.java \
	Bike.java \
	Light.java \
	Lane.java \
	Trafficsystem.java \
	Simulation.java
TCLASSES = CarTest.java \
	BikeTest.java \
	LightTest.java \
	LaneTest.java \
	TrafficsystemTest.java \
	SimulationTest.java \
	allTests.java

default: classes

classes: $(CLASSES:.java=.class)
clean: 
	$(RM) *.class
