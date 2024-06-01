package dp;

/**
 *
 * Factory Method -
 * Heavily Realies on Inheritance
 * lets the creator subclasses decides which class to create.
 * Not know the exact idea of dependency of the code will work with
 */
public class FactoryMethod {
    Restaurant veg= new VegPizaRestaurant();

}

interface Piza {

}
class VegPiza implements Piza{

}
class ChicenPiza implements Piza{

}
abstract class Restaurant {
    public Piza orderPiza(String request){
        Piza piza = createPiza();
        //piza.prepare();
        return piza;
//       switch (request){
//           case "veg" : return  new VegPiza();
//           case "chicker" : return  new ChicenPiza();
//       }
//       //piza.pepare()
//       return piza;
    }
    public abstract Piza createPiza();

}
class VegPizaRestaurant extends Restaurant{
    @Override
    public Piza createPiza() {
        return new VegPiza();
    }
}