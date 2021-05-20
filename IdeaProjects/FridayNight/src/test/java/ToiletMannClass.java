
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeAll;

public class ToiletMannClass {

    private int toiletPaperStock;
    private static ToiletMan toiletMan;

@BeforeAll
    public static void ToiletMan() {
        toiletMan = new ToiletMan("RonnyFlex",0);
    }



    public void setToiletPaperStock(int toiletPaperStock) {
        this.toiletPaperStock = toiletPaperStock;
    }

    @Test
    public void ToiletPaperException(){

    Assertions.assertThrows(ToiletPaperException.class, ()->toiletMan.fillToiletStallsWithToiletPaper(1));
    }

    @Test
    public void fillToiletStallsWithToiletPaper() throws ToiletPaperException {
    int amountOfStalls=0;
    Assertions.assertEquals(0,amountOfStalls);
        if (amountOfStalls > 0) {
            for (int i = toiletPaperStock; i >= amountOfStalls; i--) {
                System.out.println("ToiletPaper Stock: " + i);
            }
            if (toiletPaperStock == 0) throw new ToiletPaperException("You are out of stock with ToiletPaper.");
            System.out.println("Stock: " + toiletPaperStock);
            ToiletPaperException();
        }
    }
    //remove the amount of your stock
    //this method will throw a selfmade Exception if you're
    //out of toilet paper

    @Test
    public void promoteSafeFun() {
    Customer customer = new Customer();
    customer.isDTF();
    customer.setHasCondom(false);
    customer.setBeersThatTheyDrunk(2);

        if (customer.isDTF() && !customer.isHasCondom() && customer.getBeersThatTheyDrunk() < 3) {
            customer.setHasCondom(true);
            System.out.println("You now have a RubberDuck for your FreeWillie");
        }
    }
    //check if Customer is DTF and if he has no condom
    //AND if he had less than 3 drinks
    //give them a condom



}
