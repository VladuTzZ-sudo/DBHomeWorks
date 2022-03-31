package DeutscheBank.Day7;

import spark.Spark;

import java.util.concurrent.atomic.AtomicLong;

public class Solution {
    public static void main(String[] args) {
        AtomicLong carId = new AtomicLong(0);

        Spark.put("/car/:color", (req, res) -> {
            //req.
            //Car car = new Car(carId.getAndIncrement(), CarColor.RED);
            // todo add the car to the 'database'
            return "A car with the color " + req.params(":color") + " was made.";
        });
    }
}
