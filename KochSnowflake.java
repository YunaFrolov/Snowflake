public class KochSnowflake {

	private Pixel point1;
	private Pixel point2;
	private Pixel point3;

	public KochSnowflake(){
		//empty constructor
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		Pixel center = new Pixel(width, height);
		point3 = new Pixel(center.getX(), 40);
		double p3fromCenter = center.getY() - point3.getY();
		double topFromCenter = p3fromCenter/2;
		point1 = new Pixel(center.getX()-p3fromCenter, center.getY()+topFromCenter);
		point2 = new Pixel(center.getX()+p3fromCenter, center.getY()+topFromCenter);
		
	}

	public KochSnowflake(Pixel point1, Pixel point2, Pixel point3){
		//not and empty constructor
		this.point1 = point1;
		this.point2 = point2;
		this.point3 = point3;
	}
	//getters
	public Pixel getPoint1(){
		return point1;
	}
	public Pixel getPoint2(){
		return point2;
	}
	public Pixel getPoint3(){
		return point3;
	}

	public void draw(){
		//creating three curves and using draw on them
		KochCurve curve1 = new KochCurve(point1, point2, 4);
		KochCurve curve2 = new KochCurve(point2, point3, 4);
		KochCurve curve3 = new KochCurve(point3, point1, 4);
		curve1.draw();
		curve2.draw();
		curve3.draw();
	}
}