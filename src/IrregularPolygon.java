import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool
import java.lang.Math;

public class IrregularPolygon{
  //instance variable(s)
  private ArrayList <Point2D.Double> myPolygon;
  // constructors
  
  public IrregularPolygon() 
  { 
    myPolygon = new ArrayList <Point2D.Double>();
  }
  // public methods
  public void add(Point2D.Double aPoint)
  { 
    myPolygon.add(aPoint);
  }
  public void addlst(Point2D.Double[] points){
    for(Point2D.Double k:points){
      myPolygon.add(k);
    }
  }
  public void draw() 
  {
    DrawingTool pencil = new DrawingTool();
    for(int u = 0;u<myPolygon.size();u++){
      if(u == 0){
        pencil.up();
      }
      else if(u>0){
        pencil.down();
      }
      Point2D.Double cord = myPolygon.get(u);
      pencil.move(cord.getX(), cord.getY());
    }
    pencil.move(myPolygon.get(0).getX(),myPolygon.get(0).getY());
  }
  public double perimeter() 
  { 
    double o = 0;
    for(int j = 0;j<myPolygon.size()-1;j++){
      Point2D.Double pt1 = myPolygon.get(j);
      Point2D.Double pt2 = myPolygon.get(j+1);
      o+=pt1.distance(pt2);
    }
    Point2D.Double lstpt = myPolygon.get(myPolygon.size()-1);
    Point2D.Double fstpt = myPolygon.get(0);
    o+=lstpt.distance(fstpt);
    return o;
  }
  
  public double area()
  {
    Double sum1 = 0.0;
    for(int y = 0;y<myPolygon.size()-1;y++){
      Double x0 = myPolygon.get(y).getX();
      Double y1 = myPolygon.get(y+1).getY();
      sum1+=(x0*y1);
    }
    Double xn = myPolygon.get(myPolygon.size()-1).getX();
    Double y0 = myPolygon.get(0).getY();
    sum1+=(xn*y0);
    Double sum2 = 0.0;
    for(int d = 0;d<myPolygon.size()-1;d++){
      Double x2 = myPolygon.get(d+1).getX();
      Double y3 = myPolygon.get(d).getY();
      sum2+=(x2*y3);
    }
    Double x43 = myPolygon.get(0).getX();
    Double y23 = myPolygon.get(myPolygon.size()-1).getY();
    sum2+=(x43*y23);
    Double area = sum1-sum2;
    area /=2;
    return Math.abs(area);
  }
}
