package com.study.patterns.ch02;

/**
 * Description: ShishD
 * Author: zhumengzhu
 * Create: 2015-12-08 10:35
 */
// 书上的例子中各个类一层层的套在一起，可以理解成一个烤串
abstract class ShishD { //羊肉串
    abstract boolean onlyOnions(); //烤串上是不是只有洋葱

    abstract boolean isVegetarian(); //烤串上是不是全是蔬菜
}

class Skewer extends ShishD { //串，烤肉叉子
    boolean onlyOnions() {
        return true;
    }

    boolean isVegetarian() {
        return true;
    }
}

class Onion extends ShishD { //洋葱
    ShishD s;

    Onion(ShishD _s) {
        s = _s;
    }

    boolean onlyOnions() {
        return s.onlyOnions();
    }

    boolean isVegetarian() {
        return s.isVegetarian();
    }
}

class Lamb extends ShishD { //羔羊肉
    ShishD s;

    Lamb(ShishD _s) {
        s = _s;
    }

    boolean onlyOnions() {
        return false;
    }

    boolean isVegetarian() {
        return false;
    }
}

class Tomato extends ShishD { //西红柿
    ShishD s;

    Tomato(ShishD _s) {
        s = _s;
    }

    boolean onlyOnions() {
        return false;
    }

    boolean isVegetarian() {
        return s.isVegetarian();
    }
}
