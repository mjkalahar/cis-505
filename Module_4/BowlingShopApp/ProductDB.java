/* 
 * Kalahar, M. (2024). CIS 505 Intermediate Java Programming. Bellevue University.
 */
package BowlingShopApp;

/*
 * Represent a Product DB with method for getting a queue of products
 */
public class ProductDB {

    /*
     * Returns a GenericQueue of products based on input code for product selection
     * @param code String The code for the product type
     * @return GenericQueue<Product> The generic queue of products
     */
    public static GenericQueue getProducts(String code) {
        //If the product code is b, return the queue of bowling balls
        if("b".equalsIgnoreCase(code)) {
            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow 2.0");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");
            Ball ball2 = new Ball();
            ball2.setCode("B200");
            ball2.setDescription("Axiom Pearl");
            ball2.setPrice(154.95);
            ball2.setColor("Blue and Red");
            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Proton Physix");
            ball3.setPrice(174.95);
            ball3.setColor("Pink and Purple");
            Ball ball4 = new Ball();
            ball4.setCode("B400");
            ball4.setDescription("Force Unleashed");
            ball4.setPrice(139.99);
            ball4.setColor("Red and White");
            Ball ball5 = new Ball();
            ball5.setCode("B500");
            ball5.setDescription("Phaze III");
            ball5.setPrice(154.99);
            ball5.setColor("Purple and Green");
            GenericQueue<Ball> balls = new GenericQueue<>();
            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);
            return balls;
        //if the code is s, return the queue of shoes
        } else if("s".equalsIgnoreCase(code)) {
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S100");
            shoe1.setDescription("Men's Ram Black");
            shoe1.setPrice(39.99);
            shoe1.setSize(10.5);
            Shoe shoe2 = new Shoe();
            shoe2.setCode("S200");
            shoe2.setDescription("Women's Rise Black/Hot Pink");
            shoe2.setPrice(39.99);
            shoe2.setSize(7);
            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99);
            shoe3.setSize(6);
            Shoe shoe4 = new Shoe();
            shoe4.setCode("S400");
            shoe4.setDescription("Men's Tribal White");
            shoe4.setPrice(26.99);
            shoe4.setSize(8.5);
            Shoe shoe5 = new Shoe();
            shoe5.setCode("S500");
            shoe5.setDescription("Youth Skull Green/Black");
            shoe5.setPrice(39.99);
            shoe5.setSize(3);
            GenericQueue<Shoe> shoes = new GenericQueue<>();
            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);
            return shoes;
        //if the code is a, return the queue of bags
        } else if("a".equalsIgnoreCase(code)) {
            Bag bag1 = new Bag();
            bag1.setCode("A100");
            bag1.setDescription("Path Pro Deluxe");
            bag1.setPrice(34.99);
            bag1.setType("Single");
            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Prime Roller Black/Royal Blue");
            bag2.setPrice(54.99);
            bag2.setType("Double");
            Bag bag3 = new Bag();
            bag3.setCode("A300");
            bag3.setDescription("Silver/Royal Blue");
            bag3.setPrice(74.99);
            bag3.setType("Triple");
            GenericQueue<Bag> bags = new GenericQueue<>();
            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);
            return bags;
        //if the code has not matched a product, return an empty product queue
        } else {
            return new GenericQueue<Product>();
        }
    }
}