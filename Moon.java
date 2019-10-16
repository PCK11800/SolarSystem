public class Moon extends CelestialObject{

    private double orbitalAngle;
    private double orbitalSpeed;
    private Planet orbitingPlanet;
    private double centerOfRotationDistance;
    private double centerOfRotationAngle;

    public Moon(double distanceFromCenter, double objectDiameter, double orbitalSpeed, Planet orbitingPlanet, String objectColour){
        setDistanceFromCenter(distanceFromCenter);
        setObjectDiameter(objectDiameter);
        setColour(objectColour);

        this.orbitalAngle = 0;
        this.orbitalSpeed = orbitalSpeed;
        this.orbitingPlanet = orbitingPlanet;

        this.centerOfRotationDistance = orbitingPlanet.getDistanceFromCenter();
        this.centerOfRotationAngle = orbitingPlanet.getOrbitalAngle();
    }

    public double getOrbitalAngle(){
        return orbitalAngle;
    }

    public void setOrbitalAngle(double orbitalAngle){
        this.orbitalAngle = orbitalAngle;
    }

    public void updateCenterOfRotationAngle(){
        centerOfRotationAngle = orbitingPlanet.getOrbitalAngle();
    }

    public void updateCenterOfRotationDistance(){
        centerOfRotationDistance = orbitingPlanet.getDistanceFromCenter();
    }

    public double getCenterOfRotationAngle(){
        return centerOfRotationAngle;
    }

    public double getCenterOfRotationDistance(){
        return centerOfRotationDistance;
    }

    public void orbitOnce(){
        setOrbitalAngle(getOrbitalAngle() + orbitalSpeed);
        updateCenterOfRotationAngle();
        updateCenterOfRotationDistance();
    }
}