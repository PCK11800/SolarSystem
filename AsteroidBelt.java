import java.util.ArrayList;
public class AsteroidBelt extends CelestialObject{

    //Variables describing the overall distanceFromCenter and number
    //of objects in an asteroid belt

    private String beltColour;
    private double beltCoherence;
    private int numberOfAsteroids;
    private double orbitalSpeed;
    private double orbitalSpeedCoherence;
    private Star orbitingStar;
    private double diameterCoherence;

    //An asteroid is a very very small planet anyway - Function the same way
    private ArrayList<Planet> asteroidList = new ArrayList<>();

    public AsteroidBelt(double distanceFromCenter, double objectDiameter, double beltCoherence, double diameterCoherence, double orbitalSpeed, double orbitalSpeedCoherence, int numberOfAsteroids, Star orbitingStar, String beltColour){
        setDistanceFromCenter(distanceFromCenter);
        setObjectDiameter(objectDiameter);
        this.beltCoherence = beltCoherence;
        this.diameterCoherence = diameterCoherence;
        this.orbitalSpeed = orbitalSpeed;
        this.orbitalSpeedCoherence = orbitalSpeedCoherence;
        this.numberOfAsteroids = numberOfAsteroids;
        this.orbitingStar = orbitingStar;
        setColour(beltColour);

        generateBelt();
    }

    public void generateBelt(){
        for(int i = 0; i < numberOfAsteroids; i++){
            double normalizedObjectDistance = getDistanceFromCenter() + (Math.random() * ((2 * beltCoherence) + 1)) - beltCoherence;
            double normalizedDiameter = getObjectDiameter() + (Math.random() * ((2 * diameterCoherence) + 1)) - diameterCoherence;
            double normalizedOrbitalSpeed = orbitalSpeed + (Math.random() * ((2 * orbitalSpeedCoherence) + 1)) - orbitalSpeedCoherence;
            Planet asteroid = new Planet(normalizedObjectDistance, normalizedDiameter, normalizedOrbitalSpeed, orbitingStar, getObjectColour());
            asteroid.setOrbitalAngle(Math.random() * 361);
            asteroidList.add(asteroid);
        }
    }

    public void moveBeltOnce(){
        for(int i = 0; i < numberOfAsteroids; i++){
            Planet thisAsteroid = asteroidList.get(i);
            thisAsteroid.orbitOnce();
        }
    }
    
    public double getBeltCoherence(){
        return beltCoherence;
    }

    public int getNumberOfAsteroids(){
        return numberOfAsteroids;
    }

    public ArrayList<Planet> getAsteroids(){
        return asteroidList;
    }
}