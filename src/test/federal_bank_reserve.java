package test;

import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class federal_bank_reserve {

    public int[] calculate(int[] nums, int target) {
        
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int temp = target - nums[i];
            if (!map.containsKey(temp)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(temp), i};
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        federal_bank_reserve app = new federal_bank_reserve();
        System.out.println(Arrays.toString(app.calculate(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(app.calculate(new int[]{2,3,4}, 7)));
    }    
}

// select 
//     c.id, c.name, o.id
// from 
//     Customers c
//         left join Order o on c.id *= o.customerId



//         function drive(car, miles) {
//             car.miles += miles;
//             return car;
//           };
          
//           let car = {
//             miles: 0,
//             transmission: 'manual',
//             bodyStyle: 'sedan'
//           };
           
          
//           let johnCar = drive(car, 50);
//           console.log(johnCar.miles); // 50
//           let maryCar = drive(car, 100);
//           console.log(maryCar.miles); //  150
//           let lindaCar = drive(johnCar, 25);  
//           console.log(lindaCar.miles); //  75
//           console.log(car.miles); //  150
//           console.log(johnCar.miles); // 75
//           console.log(maryCar.miles); // 150


