import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int pts = 0;
        for (Point currPt : s.getPoints()) {
          pts++;
        }
        return pts;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double avg = getPerimeter(s)/getNumPoints(s);
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Start with largestSide = 0
        double largestSide = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update largestSide if necessary
            if (currDist > largestSide) {largestSide = currDist;}
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // largestSide is the answer
        return largestSide;
    }

    // /*
    public double getLargestX(Shape s) {
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // Start with largestX = x coord of prevPt
        double largestX = prevPt.getX();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find currX 
            double currX = currPt.getX();
            // Update largestSide if necessary
            if (currX > largestX) {largestX = currX;}
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // largestX is the answer
        return largestX;
    } // */

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double maxLength = 0;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
          FileResource fr = new FileResource(f);
          Shape s = new Shape(fr);
          double currLength = getPerimeter(s);
          if (currLength > maxLength) {maxLength = currLength;}
        }
        return maxLength;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
        return temp.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int pts = getNumPoints(s);
        double avg = getAverageLength(s);
        double sSide = getLargestSide(s);
        double sX = getLargestX(s);
        System.out.println("perimeter = " + length);
        System.out.println("num points = " + pts);
        System.out.println("avg length = " + avg);
        System.out.println("largest side = " + sSide);
        System.out.println("largest X = " + sX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        double result = getLargestPerimeterMultipleFiles();
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
          FileResource fr = new FileResource(f);
          Shape s = new Shape(fr);
          double currLength = getPerimeter(s);
          System.out.println(f);
          System.out.println(currLength);
        }
        System.out.println(result);

    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
