public class Pixel{
	private double x;
	private double y;
	
	public Pixel(){
		//empty constructor
		x=0;
		y=0;
	}
	
	public Pixel(double x, double y){
		//non empty constructor
		this.x = x;
		this.y = y;
	}
	//getters
	public double getX(){
		return this.x;
	}
	
	public double getY(){
		return this.y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void translate(Pixel p){
		//adding the new to old point
		x = p.getX() + this.x;
		y = p.getY() + this.y;
	}
	
	public void rotateRelativeToAxesOrigin(double theta){
		//rotating point according to center
		double beforeChangeX = x;
		x = x*Math.cos(theta) - y*Math.sin(theta);
		y = beforeChangeX*Math.sin(theta) + y*Math.cos(theta);
		
	}
	
	public void rotateRelativeToPixel(Pixel p1,double theta){
		//moving aside,
		x = x - p1.getX();
		y = y - p1.getY();
		//rotating from center,
		this.rotateRelativeToAxesOrigin(theta);
		//returning back
		translate(p1);
	}
}