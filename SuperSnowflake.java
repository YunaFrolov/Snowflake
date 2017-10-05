public class SuperSnowflake {

	private Snowflake snowflake;
	private double depth;

	public SuperSnowflake(){
		//empty constructor
		snowflake = new Snowflake();
		depth = 4;
	}

	public SuperSnowflake(Snowflake snowflake, double depth){
		//non empty constructor
		this.snowflake = snowflake;
		this.depth = depth;
	}
	//getters
	public Snowflake getCenter(){
		return snowflake;
	}

	public double getDepth(){
		return depth;
	}
	
	public void draw(){
		//the function draws six snowflakes in a given depth circle until depth is done
		snowflake.draw();
		//initialize all temporary variables
		double apartRadius = snowflake.getCenter().getRadius()*3;
		double newSnowRadius = snowflake.getCenter().getRadius()/2;
		Pixel newCenter = new Pixel(snowflake.getCenter().getCenter().getX() + apartRadius, snowflake.getCenter().getCenter().getY());
		BasicStar newBacis = new BasicStar(newCenter, newSnowRadius);
		Snowflake newSnowflake = new Snowflake(newBacis, depth);
		
		//repeat until depth
		while(depth>1){
			//draw circle
			for(int i=0; i<6 ; i=i+1){
				newSnowflake.draw();
				newSnowflake.getCenter().getCenter().rotateRelativeToPixel(snowflake.getCenter().getCenter(), ((Math.PI)/3));
			}
			
			//set for next circle
			apartRadius = apartRadius + newSnowRadius*3;
			newSnowRadius = newSnowRadius/2;
			newCenter =  new Pixel(snowflake.getCenter().getCenter().getX() + apartRadius, snowflake.getCenter().getCenter().getY());
			newBacis = new BasicStar(newCenter, newSnowRadius);
			newSnowflake = new Snowflake(newBacis, depth);
			
			depth = depth-1;
		}
	}
}