package InnamoratoG;
import robocode.*;

// Mario - a robot by (DeRentner)
public class Mario extends JuniorRobot
{
	int north = 0;
	int east = 90;
	int south = 180;
	int west = 270;
	public void run() {

		setColors(red, white, red);
		if (others < 11) {
		GoToTopLeftCorner();
		}
		while (true) {
			ahead(450); 
			turnGunRight(360); 
			back(400);
			turnGunRight(360); 
		}
	}
	public void onScannedRobot() {
		// Turn gun to point at the scanned robot
		turnGunTo(scannedAngle);

		smartFire();
	}
	public void GoToTopLeftCorner(){
	//  Robot will go to the top left corner with 190 and 165 pixels space between
		int distanceToTop = fieldHeight - robotY;
		int distanceToSide = fieldWidth - robotX;
		turnTo(north);
		ahead(distanceToTop - 190);
		turnTo(west);
		ahead(distanceToSide - 165);
		turnGunRight(360); 
	}
    public void smartFire(){
        if (scannedDistance < 200)
        {
            fire (3);
        } 
        if (scannedDistance < 300)
        {
            fire (2.4);
        } 
        else
        {
            fire (1.9);
        }
    }
	public void onHitByBullet() {
		// Move ahead 280 and in the same time turn left to the bullet
		turnAheadLeft(280, east - hitByBulletBearing);
	}
}
