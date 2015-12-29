package patterns.ch02;

/**
 * Description: KebabaD
 * Author: zhumengzhu
 * Create: 2015-12-08 10:30
 */
abstract class KebabD { //烤肉
    abstract boolean isVeggie(); //是否以纯蔬菜为辅料的烤肉

    abstract Object whatHolder(); //烤肉的摆放工具是什么
}

class Holder extends KebabD { //烤肉摆放工具（意译）
    Object o;

    Holder(Object _o) {
        o = _o;
    }

    boolean isVeggie() {
        return true;
    }

    Object whatHolder() {
        return o;
    }
}

class Shallot extends KebabD { //葱
    KebabD k;

    Shallot(KebabD _k) {
        k = _k;
    }

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

class Shrimp extends KebabD { //小虾
    KebabD k;

    Shrimp(KebabD _k) {
        k = _k;
    }

    boolean isVeggie() {
        return false;
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

class Radish extends KebabD { //萝卜
    KebabD k;

    Radish(KebabD _k) {
        k = _k;
    }

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

class Pepper extends KebabD { //胡椒粉
    KebabD k;

    Pepper(KebabD _k) {
        k = _k;
    }

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}

class Zucchini extends KebabD { //西葫芦
    KebabD k;

    Zucchini(KebabD _k) {
        k = _k;
    }

    boolean isVeggie() {
        return k.isVeggie();
    }

    Object whatHolder() {
        return k.whatHolder();
    }
}
