
import java.awt.geom.*;
public class Main {
    
    public static void main(String[] args) {
        IrregularPolygon testCase = new IrregularPolygon();
		
		System.out.println("Perimeter: " + testCase.perimeter());
		System.out.println("Area: " + testCase.area());
		testCase.draw();
    }
}