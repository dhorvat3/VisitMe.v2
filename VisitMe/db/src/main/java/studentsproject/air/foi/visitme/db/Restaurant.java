package studentsproject.air.foi.visitme.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 27.1.2016..
 */
public class Restaurant {

    @SerializedName("restaurant")
    @Expose
    private List<Restaurant_> restaurant = new ArrayList<Restaurant_>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Restaurant() {
    }

    /**
     *
     * @param restaurant
     */
    public Restaurant(List<Restaurant_> restaurant) {
        this.restaurant = restaurant;
    }

    /**
     *
     * @return
     * The restaurant
     */
    public List<Restaurant_> getRestaurant() {
        return restaurant;
    }

    /**
     *
     * @param restaurant
     * The restaurant
     */
    public void setRestaurant(List<Restaurant_> restaurant) {
        this.restaurant = restaurant;
    }

}