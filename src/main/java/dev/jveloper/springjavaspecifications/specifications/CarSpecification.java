package dev.jveloper.springjavaspecifications.specifications;

import dev.jveloper.springjavaspecifications.entities.Car;
import dev.jveloper.springjavaspecifications.entities.Car_;
import dev.jveloper.springjavaspecifications.helper.DateHelper;
import org.springframework.data.jpa.domain.Specification;

import java.util.Date;

public class CarSpecification {

   public static Specification<Car> brandFSpec (String brand){
       return (root, query, criteriaBuilder) -> {

           if (brand == null || brand.isEmpty()) {
               return criteriaBuilder.conjunction();
           }

           return criteriaBuilder.like(root.get(Car_.BRAND), brand);
       };
   }
    public static Specification<Car> yearSpec (String startDate, String endDate){

        Date from = DateHelper.stringToDate(startDate);
        Date to = DateHelper.stringToDate(endDate);

        if ((endDate==null || endDate.isEmpty()) && (startDate==null || startDate.isEmpty())){
            return (root, query, criteriaBuilder) -> criteriaBuilder.conjunction();
        }

       else if ((startDate==null || startDate.isEmpty())){
           return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(Car_.DATE), to);
       }

       else if ((endDate==null || endDate.isEmpty())){
           return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(Car_.DATE), from);
       }

        else {
            return (root, query, criteriaBuilder) -> criteriaBuilder. between(root.get(Car_.DATE), from, to);
        }

    }

}
