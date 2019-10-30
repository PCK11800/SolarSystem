import java.util.ArrayList;
public class Main{
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

    //AsteroidBelt(distanceFromCenter, diameter, beltCoherence, diameterCoherence, orbitialSpeed, orbitalSpeedCoherence, numberOfAsteroids, orbitingStar, colour)
    private AsteroidBelt JovianBelt = new AsteroidBelt(275, 5, 20, 1, 5, 3, 200, Sun, "WHITE");

    public void addPlanets(){
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

    public void run(){
        addPlanets();
        GenerateSystem SolarSystem = new GenerateSystem(1000, 1000, starArray, planetArray, moonArray, asteroidBeltArray);
    }

    public static void main(String[] args){
        Main main = new Main();
        main.run();
    }
}