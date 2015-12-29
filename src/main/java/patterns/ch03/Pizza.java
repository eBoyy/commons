package patterns.ch03;

/**
 * 披萨
 * Author: zhumengzhu
 * Create: 2015-12-07 19:10
 */
abstract public class Pizza {

    /**
     * 去除比萨饼中的凤尾鱼顶料(因为太咸了)
     *
     * @return 披萨
     */
    abstract protected Pizza removeAnchovy();

    /**
     * 在凤尾鱼顶料上加上奶酪顶料(这样会盖住凤尾鱼的咸味)
     *
     * @return 披萨
     */
    abstract protected Pizza topAnchovyWithCheese();

    /**
     * 将所有的凤尾鱼顶料换成奶酪顶料
     *
     * @return 披萨
     */
    abstract protected Pizza substituteAnchovyByCheese();

    /**
     * 接受一个 visitor, 调用它的 visit(this) 方法, 由 visitor 执行具体的业务逻辑
     *
     * @param visitor 访问者
     * @return 披萨
     */
    abstract public Pizza accept(Visitor visitor);
}

/**
 * 面包片
 */
class Crust extends Pizza {

    @Override
    protected Pizza removeAnchovy() {
        return new Crust();
    }

    @Override
    protected Pizza topAnchovyWithCheese() {
        return new Crust();
    }

    @Override
    protected Pizza substituteAnchovyByCheese() {
        return new Crust();
    }

    @Override
    public Pizza accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

// 以下为各种顶料

/**
 * 奶酪
 */
class Cheese extends Pizza {
    Pizza p;

    Cheese(Pizza p) {
        this.p = p;
    }

    @Override
    protected Pizza removeAnchovy() {
        return new Cheese(p.removeAnchovy());
    }

    @Override
    protected Pizza topAnchovyWithCheese() {
        return new Cheese(p.topAnchovyWithCheese());
    }

    @Override
    protected Pizza substituteAnchovyByCheese() {
        return new Cheese(p.substituteAnchovyByCheese());
    }

    @Override
    public Pizza accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

/**
 * 橄榄
 */
class Olive extends Pizza {
    Pizza p;

    Olive(Pizza p) {
        this.p = p;
    }

    @Override
    protected Pizza removeAnchovy() {
        return new Olive(p.removeAnchovy());
    }

    @Override
    protected Pizza topAnchovyWithCheese() {
        return new Olive(p.topAnchovyWithCheese());
    }

    @Override
    protected Pizza substituteAnchovyByCheese() {
        return new Olive(p.substituteAnchovyByCheese());
    }

    @Override
    public Pizza accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

/**
 * 凤尾鱼
 */
class Anchovy extends Pizza {
    Pizza p;

    Anchovy(Pizza p) {
        this.p = p;
    }

    @Override
    protected Pizza removeAnchovy() {
        return p.removeAnchovy();
    }

    @Override
    protected Pizza topAnchovyWithCheese() {
        return new Cheese(new Anchovy(p.topAnchovyWithCheese()));
    }

    @Override
    protected Pizza substituteAnchovyByCheese() {
        return new Cheese(p.substituteAnchovyByCheese());
    }

    @Override
    public Pizza accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

/**
 * 香肠
 */
class Sausage extends Pizza {
    Pizza p;

    Sausage(Pizza p) {
        this.p = p;
    }

    @Override
    protected Pizza removeAnchovy() {
        return new Sausage(p.removeAnchovy());
    }

    @Override
    protected Pizza topAnchovyWithCheese() {
        return new Sausage(p.topAnchovyWithCheese());
    }

    @Override
    protected Pizza substituteAnchovyByCheese() {
        return new Sausage(p.substituteAnchovyByCheese());
    }

    @Override
    public Pizza accept(Visitor visitor) {
        return visitor.visit(this);
    }
}

/**
 * 菠菜
 */
class Spinach extends Pizza {
    Pizza p;

    Spinach(Pizza _p) {
        p = _p;
    }

    protected Pizza removeAnchovy() {
        return new Spinach(p.removeAnchovy());
    }

    protected Pizza topAnchovyWithCheese() {
        return new Spinach(p.topAnchovyWithCheese());
    }

    protected Pizza substituteAnchovyByCheese() {
        return new Spinach(p.substituteAnchovyByCheese());
    }

    @Override
    public Pizza accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
