//Cameron Mendez
//11/30/2025
//Module-7
//CircleStylesTest.java


public class CircleStylesTest {
    public static void main(String[] args) {
        Circle c = new Circle(50);
        c.getStyleClass().add("plaincircle");

        assert c.getStyleClass().contains("plaincircle") 
            : "plaincircle style class NOT applied";

        Circle r = new Circle(50);
        r.setId("redcircle");

        assert "redcircle".equals(r.getId()) 
            : "redcircle ID NOT applied";

        System.out.println("Style tests passed.");
    }
}
