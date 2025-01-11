package dp;

/**
 * not knwoing in advance what exact object needed in Runtime
 * all Potential classes are similar in nature
 * encapsulate object creation
 * all classes are similar nature or behaviour
 * factory method
 */

public class Factory {

    /**
     *
     * Factory Method -
     * Heavily Realies on Inheritance
     * lets the creator subclasses decides which class to create.
     * Not know the exact idea of dependency of the code will work with
     */
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shape blue = shapeFactory.createBox("BLUE");
        System.out.println(blue.getColor());
    }

}

//same with Burger too
class BurgerFactory{
    public Burger createBurger(String request){
        Burger burger = null;
        if("veg".equals(request)){
            burger =  new VegBurger();
        }
        return burger;
    }
}
interface Burger{

}
class VegBurger implements  Burger{

}
class ShapeFactory{
    shape createBox(String color){
        switch (color){
            case "GREEN" : return  new GreenBox();
            case "BLUE" : return new BlueBox();
        }
        return null;
    }
}
interface shape{
    String getColor();
    String getArea();

}

class BlueBox implements shape{
    @Override
    public String getColor() {
        return "blue";
    }

    @Override
    public String getArea() {
        return null;
    }
}
class GreenBox implements shape{
    @Override
    public String getColor() {
        return "Green";
    }

    @Override
    public String getArea() {
        return "bix";
    }
}