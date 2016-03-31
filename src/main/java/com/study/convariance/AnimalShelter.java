package com.study.convariance;

/**
 * Description: AnimalShelter
 * Author: zhumengzhu
 * Create: 2016-01-11 17:59
 */
public class AnimalShelter {

    AnimalShelter getAnimalForAdoption() {
        return new AnimalShelter();
    }

    void putAnimal(Animal animal) {

    }
}

class CatShelter extends AnimalShelter {

    /**
     * 协变的返回值
     *
     * @return 猫的收养所
     */
    @Override
    public CatShelter getAnimalForAdoption() {
        return new CatShelter();
    }

    @Override
    void putAnimal(Animal animal) {
        super.putAnimal(animal);
    }

    /**
     * 重载方法
     *
     * @param obj
     */
    void putAnimal(Object obj) {
    }

    /**
     * 重载的方法, 不是覆盖的方法
     *
     * @param cat 猫
     */
    public void putAnimal(Cat cat) {

    }
}

class Animal {

}

class Cat extends Animal {

}