package patterns.ch02;

/**
 * Description: PointD
 * Author: zhumengzhu
 * Create: 2015-12-08 10:34
 */
abstract class PointD {
    int x;
    int y;

    PointD(int _x, int _y) {
        x = _x;
        y = _y;
    }

    abstract int distanceTo0();

    boolean closerTo0(PointD p) {
        return distanceTo0() <= p.distanceTo0();
    }
}

class CartesianPt extends PointD { //笛卡尔坐标
    CartesianPt(int _x, int _y) {
        super(_x, _y);
    }

    int distanceTo0() {
        return (int) Math.sqrt(x * x + y * y);
    }
}

class ManhattanPt extends PointD { //曼哈顿坐标
    ManhattanPt(int _x, int _y) {
        super(_x, _y);
    }

    int distanceTo0() {
        return x + y;
    }
}
