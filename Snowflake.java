public class Snowflake {

	private BasicStar center;
	private double depth;

	public Snowflake(){
		//empty constructor
		center = new BasicStar();
		depth = 4;
	}
	
	public Snowflake(BasicStar center, double depth){
		//non empty constructor
		this.center = center;
		this.depth = depth;
	}
	//getters
	public BasicStar getCenter(){
		return center;
	}

	public double getDepth(){
		return depth;
	}

	public void draw(){
		callDraw(center, depth); //Initializing the recursive call
	}

	private void callDraw(BasicStar center, double depth){
		//the function finds the new center and rotating stars around it, while the depth is not 0
		if(depth == 0){
			return;
		}
		center.draw(); //draw middle
	
		double theRadius = center.getRadius()/3;
		Pixel theCenter = new Pixel(center.getCenter().getX()+center.getRadius(), (center.getCenter().getY()));
		BasicStar newCenter = new BasicStar(theCenter, theRadius);

		//draw all around the middle
		for(int i=0; i<6 ; i=i+1){
			callDraw(newCenter, depth-1); //recursive call
			newCenter.getCenter().rotateRelativeToPixel(center.getCenter(), ((Math.PI)/3));
		}
	}
}