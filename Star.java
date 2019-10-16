public class Star extends CelestialObject{
    
    private double distanceFromCenter = 0;
    private double orbitalAngle = 0;
    
    public Star(double objectDiameter, String objectColour){
        setObjectDiameter(objectDiameter);
        setColour(objectColour);
        setDistanceFromCenter(distanceFromCenter);
    }

    public double getOrbitalAngle(){
        return orbitalAngle;
    }
}