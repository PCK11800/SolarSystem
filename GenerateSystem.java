import java.util.ArrayList;
public class GenerateSystem{
    
    SolarSystem solarSystem;

    public GenerateSystem(int width, int height, ArrayList<Star> starArray, ArrayList<Planet> planetArray, ArrayList<Moon> moonArray, ArrayList<AsteroidBelt> asteroidBeltArray){
        solarSystem = new SolarSystem(1000, 1000);
        animateBodies(starArray, planetArray, moonArray, asteroidBeltArray);
    }

    private void drawStars(ArrayList<Star> starArray){
        for(int i = 0; i < starArray.size(); i++){
            Star thisStar = starArray.get(i);

            double distanceFromCenter = thisStar.getDistanceFromCenter();
            double angle = thisStar.getOrbitalAngle();
            double diameter = thisStar.getObjectDiameter();
            String colour = thisStar.getObjectColour();

            solarSystem.drawSolarObject(distanceFromCenter, angle, diameter, colour);
        }
    }

    private void drawPlanets(ArrayList<Planet> planetArray){
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

    private void drawMoons(ArrayList<Moon> moonArray){
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

    private void drawAsteroidBelts(ArrayList<AsteroidBelt> asteroidBeltArray){
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

    private void animateBodies(ArrayList<Star> starArray, ArrayList<Planet> planetArray, ArrayList<Moon> moonArray, ArrayList<AsteroidBelt> asteroidBeltArray){
        while(true){
            refresh();
            drawStars(starArray);
            drawPlanets(planetArray);
            drawMoons(moonArray);
            drawAsteroidBelts(asteroidBeltArray);
        }
    }
}