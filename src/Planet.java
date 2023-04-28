public enum Planet {
    MERCURY(1, 0, 2439.7, null),
    VENUS(2, 5029, 6051.8, MERCURY ),
    EARTH(3, 4140, 6371, VENUS),
    MARS(4, 7834, 3389.5, EARTH),
    JUPITER(5, 55039, 69911, MARS),
    SATURN(6, 64627,58232, JUPITER),
    URANUS(7, 144895,25362, SATURN),
    NEPTUNE(8, 116745, 24622, URANUS);

    private final int order;
    private final double distanceFromPrevious;
    private final double radius;
    private final double distanceFromSun;
    private final Planet previousPlanet;
    private Planet nextPlanet;

    Planet (int order, double distanceFromPrevious, double radius, Planet previousPlanet){
        this.order = order;
        this.radius = radius;
        this.distanceFromPrevious = distanceFromPrevious;
        this.previousPlanet = previousPlanet;

        this.distanceFromSun = (previousPlanet == null) ? distanceFromPrevious : previousPlanet.distanceFromSun + distanceFromPrevious;

        if(previousPlanet != null){
            previousPlanet.nextPlanet = this;
        }
    }

    public int getOrder(){
        return order;
    }

    public double getRadius(){
        return radius;
    }

    public double getDistanceFromPrevious(){
        return distanceFromPrevious;
    }

    public Planet getPreviousPlanet(){
        return previousPlanet;
    }

    public Planet getNextPlanet(){
        return nextPlanet;
    }

    public double getDistanceFromSun(){
        return distanceFromSun;
    }
}
