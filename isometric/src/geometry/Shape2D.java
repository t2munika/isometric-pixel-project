package geometry;

//import java.awt.Color;
//import java.awt.Graphics2D;
import java.util.Vector;

public class Shape2D {
	Vector<Point2D> vertices;
	Vector<int[]> edges;

	public Shape2D() {
		vertices = new Vector<Point2D>();
		edges = new Vector<int[]>();
	}

	public Shape2D(Point2D[] vs, int[][] es) {
		this();
		for(int i=0; i<vs.length; i++) addVertex(vs[i]);
		for(int i=0; i<es.length; i++) addEdge(es[i]);
	}

	public void addVertex(Point2D v) {
		vertices.add((Point2D) v.clone());
	}

	public void addEdge(int[] e) {
		int[] e_ = {e[0], e[1]};
		edges.add(e_);
	}
	
	public int getNumEdges() {
		return (edges==null) ? 0 : edges.size();
	}

	public int[] getEdge(int i) {
		int[] edge = {edges.get(i)[0], edges.get(i)[1]};
		return edge;
	}

	public int getNumVertices() {
		return (vertices==null) ? 0 : vertices.size();
	}

	public Point2D getVertex(int i) {
		return (Point2D) vertices.get(i).clone();
	}

	public static class Rectangle extends Shape2D {
		private static final Point2D[] vs =
			   {new Point2D(0,0),
				new Point2D(1,0),
				new Point2D(1,1),
				new Point2D(0,1)};
		private static final int[][] es = 
			   {{0,1},{1,2},{2,3},{3,0}};
		
		public Rectangle() {			
			super(vs, es);			
		}
		
		public Rectangle(Point2D from, Point2D to) {
			super();
			for(int i=0; i<vs.length; i++) {
				Point2D p = (Point2D) vs[i].clone();
				//p.translate(from.x, from.y, from.z);
				p.scale(to.x-from.x, to.y-from.y);
				addVertex(p);
			}
			for(int i=0; i<es.length; i++) addEdge(es[i]);
		}
	}
}