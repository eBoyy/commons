package com.study.patterns.ch03;

/**
 * Description: Test
 * Author: zhumengzhu
 * Create: 2015-12-07 19:19
 */
public class Test {

    public static void main(String[] args) {
        visitorTest();
    }

    private static void visitorTest() {
        Anchovy anchovy = new Anchovy(
                new Olive(
                        new Anchovy(
                                new Anchovy(
                                        new Cheese(
                                                new Crust())))));

        Pizza removeAnchovy = anchovy.accept(new RemoveAnchovyVisitor());
        Pizza topAnchovyWithCheese = anchovy.accept(new TopAnchovyWithCheeseVisitor());
        Pizza substituteAnchovyByCheese = anchovy.accept(new SubstituteAnchovyByCheeseVisitor());

        System.out.println(substituteAnchovyByCheese);
    }

    private static void substituteAnchovyByCheese() {
        Pizza pizza = new Olive(
                new Anchovy(
                        new Cheese(
                                new Anchovy(
                                        new Crust()
                                )
                        )
                )
        ).substituteAnchovyByCheese();

        System.out.println(pizza);
    }

    private static void mix() {
        Pizza pizza = (new Olive(
                new Anchovy(
                        new Cheese(
                                new Anchovy(
                                        new Crust()
                                )
                        )
                )
        ).removeAnchovy())
                .topAnchovyWithCheese();
        System.out.println(pizza);
    }

    private static void removeAnchovyTest() {
        Anchovy anchovy = new Anchovy(
                new Olive(
                        new Anchovy(
                                new Anchovy(
                                        new Cheese(
                                                new Crust())))));
        Pizza pizza = anchovy.removeAnchovy();
        System.out.println(pizza);
    }

    private static void TopAnchovyWithCheeseTest() {
        Olive olive = new Olive(
                new Anchovy(
                        new Cheese(
                                new Anchovy(
                                        new Crust()
                                )
                        )
                )
        );

        Pizza pizza = olive.topAnchovyWithCheese();
        System.out.println(pizza);
    }

}
