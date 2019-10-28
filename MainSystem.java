import java.util.ArrayList;
public class MainSystem{

    private SolarSystem solarSystem;

    //ArrayLists to store CelestialObjects
    public ArrayList<Star> starArray = new ArrayList<>();
    public ArrayList<Planet> planetArray = new ArrayList<>();
    public ArrayList<Moon> moonArray = new ArrayList<>();
    public ArrayList<AsteroidBelt> asteroidBeltArray = new ArrayList<>();

    private Star Sun = new Star(50, "YELLOW");

    //Planet(distanceFromCenter, diameter, speed, star, colour, array)
    private Planet Mercury = new Planet(50, 10, 3, Sun, "GRAY");
    private Planet Venus = new Planet(100, 20, 2, Sun, "ORANGE");
    private Planet Earth = new Planet(150, 25, 1, Sun, "BLUE");
    private Planet Mars = new Planet(200, 15, 0.8, Sun, "RED");
    private Planet Jupiter = new Planet(250, 50, 0.4, Sun, "#DEB887");
    private Planet Saturn = new Planet(300, 34, 0.6, Sun, "#ADD8E6");
    private Planet Uranus = new Planet(350, 40, 0.3, Sun, "#E1EEEE");
    private Planet Neptune = new Planet(400, 40, 0.2, Sun, "#5B5DDF");
    
    //Moon(distance, diameter, speed, planet, colour, array)
    private Moon Luna = new Moon(5, 10, 5, Earth, "DARK_GRAY");
    private Moon Io = new Moon(30, 5, 5, Jupiter, "#FFF49C");
    private Moon Europa = new Moon(40, 5, 10, Jupiter, "#C6C3CC");
    private Moon Ganymede = new Moon(50, 5, 3, Jupiter, "#B58E00");

    //AsteroidBelt(distanceFromCenter, diameter, beltCoherence, diameterCoherence, orbitialSpeed, numberOfAsteroids, orbitingStar, colour)
    private AsteroidBelt JovianBelt = new AsteroidBelt(275, 5, 20, 1, 3, 100, Sun, "WHITE");

    private void createSystem(int width, int height){
        solarSystem = new SolarSystem(width, height);
        starArray.add(Sun);

        planetArray.add(Mercury);
        planetArray.add(Venus);
        planetArray.add(Earth);
        planetArray.add(Mars);
        planetArray.add(Jupiter);
        planetArray.add(Saturn);
        planetArray.add(Uranus);
        planetArray.add(Neptune);

        moonArray.add(Luna);
        moonArray.add(Io);
        moonArray.add(Europa);
        moonArray.add(Ganymede);

        asteroidBeltArray.add(JovianBelt);
    }

    private void drawStars(){
        for(int i = 0; i < starArray.size(); i++){
            Star thisStar = starArray.get(i);

            double distanceFromCenter = thisStar.getDistanceFromCenter();
            double angle = thisStar.getOrbitalAngle();
            double diameter = thisStar.getObjectDiameter();
            String colour = thisStar.getObjectColour();

            solarSystem.drawSolarObject(distanceFromCenter, angle, diameter, colour);
        }
    }

    private void drawPlanets(){
        for(int i = 0; i < planetArray.size(); i++){
            Planet thisPlanet = planetArray.get(i);

            double distanceFromCenter = thisPlanet.getDistanceFromCenter();
            double angle = thisPlanet.getOrbitalAngle();
            double diameter = thisPlanet.getObjectDiameter();
            String colour = thisPlanet.getObjectColour();

            thisPlanet.orbitOnce();
            solarSystem.drawSolarObject(distanceFromCenter, angle, diameter, colour);
        }
    }

    private void drawMoons(){
        for(int i = 0; i < moonArray.size(); i++){
            Moon thisMoon = moonArray.get(i);

            double distanceFromCenter = thisMoon.getDistanceFromCenter();
            double angle = thisMoon.getOrbitalAngle();
            double diameter = thisMoon.getObjectDiameter();
            String colour = thisMoon.getObjectColour();
            double centreOfRotationDistance = thisMoon.getCenterOfRotationDistance();
            double centreOfRotationAngle = thisMoon.getCenterOfRotationAngle();

            thisMoon.orbitOnce();
            solarSystem.drawSolarObjectAbout(distanceFromCenter, angle, diameter, colour, centreOfRotationDistance, centreOfRotationAngle);
        }
    }

    private void drawAsteroidBelts(){
        for(int i = 0; i < asteroidBeltArray.size(); i++){
            AsteroidBelt thisBelt = asteroidBeltArray.get(i);
            for(int a = 0; a < thisBelt.getAsteroids().size(); a++){
                Planet thisAsteroid = thisBelt.getAsteroids().get(a);
                double distanceFromCenter = thisAsteroid.getDistanceFromCenter();
                double angle = thisAsteroid.getOrbitalAngle();
                double diameter = thisAsteroid.getObjectDiameter();
                String colour = thisAsteroid.getObjectColour();
                solarSystem.drawSolarObject(distanceFromCenter, angle, diameter, colour);
            }
            thisBelt.moveBeltOnce();
        }
    }

    private void refresh(){
        solarSystem.finishedDrawing();
    }

    private void animateBodies(){
        while(true){
            refresh();
            drawStars();
            drawPlanets();
            drawMoons();
            drawAsteroidBelts();
        }
    }

    public static void main(String[] args){
        MainSystem mainSystem = new MainSystem();
        mainSystem.createSystem(1000, 1000);
        mainSystem.animateBodies();
    }

}