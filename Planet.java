public class Planet extends CelestialObject{

    private double orbitalAngle;
    private double orbitalSpeed;
    private Star orbitingStar;

    public Planet(double distanceFromCenter, double objectDiameter, double orbitalSpeed, Star orbitingStar, String objectColour){
        setDistanceFromCenter(distanceFromCenter);
        setObjectDiameter(objectDiameter);
        setColour(objectColour);

        this.orbitalAngle = 0;
        this.orbitalSpeed = orbitalSpeed;
        this.orbitingStar = orbitingStar;
    }

    public double getOrbitalAngle(){
        return orbitalAngle;
    }

    public double getOrbitalSpeed(){
        return orbitalSpeed;
    }

    public void setOrbitalAngle(double orbitalAngle){
        this.orbitalAngle = orbitalAngle;
    }

    public void setOrbitalSpeed(double orbitalSpeed){
        this.orbitalSpeed = orbitalSpeed;
    }

    public void orbitOnce(){
        setOrbitalAngle(getOrbitalAngle() + orbitalSpeed);
    }
}