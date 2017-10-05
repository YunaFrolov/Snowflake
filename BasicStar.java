public class BasicStar {
	
	private Pixel center;
	private double radius;
	
	public BasicStar(){ //given empty constructor
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		this.center = new Pixel (width, height);
		double maxRadius = Math.min(width, height)/2;
		this.radius = maxRadius/4;
	}
	
	public BasicStar(Pixel center, double radius){
		//non empty constructor
		this.center = center;
		this.radius = radius;
	}
	//getters
	public Pixel getCenter(){
		return center;
	}
	
	public double getRadius(){
		return radius;
	}
	
	public void draw(){
		//drawing six lines from middle to new points
		Pixel endPixel = new Pixel(center.getX()+radius, center.getY()); //move right
		for(int i=0; i<6 ; i=i+1){ //draw and rotate relative to center pixel 
			Painter.drawLine(center, endPixel);
			endPixel.rotateRelativeToPixel(center, ((Math.PI)/3));
		}
	}
}