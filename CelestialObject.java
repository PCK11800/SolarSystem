public class CelestialObject{

    //Variables included in stars, planets and moons
    //All celesitial objects includes these
    private double distanceFromCenter; //Distance from center of rotation
    private double objectDiameter; //Diameter of object
    private String objectColour;

    public double getDistanceFromCenter(){
        return distanceFromCenter;
    }

    public double getObjectDiameter(){
        return objectDiameter;
    }

    public String getObjectColour(){
        return objectColour;
    }

    public void setDistanceFromCenter(double distanceFromCenter){
        this.distanceFromCenter = distanceFromCenter;
    }

    public void setObjectDiameter(double objectDiameter){
        this.objectDiameter = objectDiameter;
    }

    public void setColour(String colour){
        this.objectColour = colour;
    }

}