package patterns.ch03;

/**
 * 访问者
 * <p/>
 * Description: Visitor
 * Author: zhumengzhu
 * Create: 2015-12-08 15:12
 */
abstract public class Visitor {

    abstract public Pizza visit(Crust crust);

    abstract public Pizza visit(Anchovy anchovy);

    abstract public Pizza visit(Cheese cheese);

    abstract public Pizza visit(Olive olive);

    abstract public Pizza visit(Sausage sausage);

    abstract public Pizza visit(Spinach spinach);
}

/**
 * 去除凤尾鱼顶料的访问者
 */
class RemoveAnchovyVisitor extends Visitor {

    @Override
    public Pizza visit(Crust crust) {
        return new Crust();
    }

    @Override
    public Pizza visit(Anchovy anchovy) {
        return anchovy.p.accept(this);
    }

    @Override
    public Pizza visit(Cheese cheese) {
        return new Cheese(cheese.p.accept(this));
    }

    @Override
    public Pizza visit(Olive olive) {
        return new Olive(olive.p.accept(this));
    }

    @Override
    public Pizza visit(Sausage sausage) {
        return new Sausage(sausage.p.accept(this));
    }

    @Override
    public Pizza visit(Spinach spinach) {
        return new Spinach(spinach.p.accept(this));
    }

}

/**
 * 在凤尾鱼上面添加奶酪顶料的访问者
 */
class TopAnchovyWithCheeseVisitor extends Visitor {

    @Override
    public Pizza visit(Crust crust) {
        return new Crust();
    }

    @Override
    public Pizza visit(Anchovy anchovy) {
        return new Cheese(
                new Anchovy(
                        anchovy.p.accept(this)));
    }

    @Override
    public Pizza visit(Cheese cheese) {
        return new Cheese(
                cheese.p.accept(this));
    }

    @Override
    public Pizza visit(Olive olive) {
        return new Olive(olive.p.accept(this));
    }

    @Override
    public Pizza visit(Sausage sausage) {
        return new Sausage(sausage.p.accept(this));
    }

    @Override
    public Pizza visit(Spinach spinach) {
        return new Spinach(spinach.p.accept(this));
    }
}

/**
 * 将所有凤尾鱼顶料换成奶酪顶料的访问者
 */
class SubstituteAnchovyByCheeseVisitor extends Visitor {

    @Override
    public Pizza visit(Crust crust) {
        return new Crust();
    }

    @Override
    public Pizza visit(Anchovy anchovy) {
        return anchovy.p.accept(this);
    }

    @Override
    public Pizza visit(Cheese cheese) {
        return new Cheese(cheese.p.accept(this));
    }

    @Override
    public Pizza visit(Olive olive) {
        return new Olive(olive.p.accept(this));
    }

    @Override
    public Pizza visit(Sausage sausage) {
        return new Sausage(sausage.p.accept(this));
    }

    @Override
    public Pizza visit(Spinach spinach) {
        return new Spinach(spinach.p.accept(this));
    }

}

