package collection.list.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import collection.Point;

public class SortListDemo2 {
	public static void main(String[] args) {
		List<Point> list = new ArrayList<>();
		list.add(new Point(3, 4));
		list.add(new Point(8, 9));
		list.add(new Point(7, 3));
		list.add(new Point(2, 1));
		list.add(new Point(5, 6));
		// 编译不通过
		Collections.sort(list, new PointComparator());
		System.out.println(list);
	}
}

class PointComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		int d1 = o1.getX() * o1.getX() + o1.getY() * o2.getY();
		int d2 = o2.getX() * o2.getY() + o2.getY() * o2.getY();
		return d1 - d2;
	}
	
}