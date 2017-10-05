public class KochCurve {

	private Pixel start;
	private Pixel end;
	private double depth;

	public KochCurve(){
		//empty constructor that initializes start and end point according to board,
		//also depth 4
		double height = Painter.getFrameHeight()/2;
		double width = Painter.getFrameWidth()/2;
		start = new Pixel(width, height);
		height = (height)*1.5;
		width = (width)*1.5;
		end = new Pixel(width, height);
		depth = 4;
	}

	public KochCurve(Pixel start, Pixel end, double depth){
		//not and empty constructor
		this.start = start;
		this.end = end;
		this.depth = depth;
	}
	//getters
	public Pixel getStart(){
		return start;
	}
	
	public Pixel getEnd(){
		return end;
	}

	public double getDepth(){
		return depth;
	}
	
	public void draw(){
		//draw function, calling the recursive function that draws the curve
		drawKochCurve(start, end, depth);
	}
	
	private void drawKochCurve(Pixel start, Pixel end, double depth){
		//this function finds and points needed to draw lines between - 
		//according to every new line - finding dividing points, top point and then
		//sending every new line to this function until the final depth met,
		//thus drawing line between final given start and end points.
		if(depth<1)
			Painter.drawLine(start, end);
		else{
			Pixel p1 = new Pixel((2.0*start.getX()+end.getX())/3.0, (2.0*start.getY() + end.getY())/3.0);
			Pixel p2 = new Pixel((start.getX()+ 2.0*end.getX())/3.0, (start.getY() + 2.0*end.getY())/3.0);
			Pixel middle = new Pixel((start.getX()+end.getX())/2.0, (start.getY() + end.getY())/2.0);
			double xDelta = p2.getX() - p1.getX();
			double yDelta = p1.getY() - p2.getY();
			double size =1/Math.sqrt(3.0)+0.19;
			Pixel topPoint = new Pixel(middle.getX() + size*yDelta, middle.getY() + size*xDelta);

			drawKochCurve(start, p1, depth -1);
			drawKochCurve(p1, topPoint, depth -1);
			drawKochCurve(topPoint, p2, depth -1);
			drawKochCurve(p2, end, depth -1);
		}
	}
}