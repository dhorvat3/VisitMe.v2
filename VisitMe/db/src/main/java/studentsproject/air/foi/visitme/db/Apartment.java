package studentsproject.air.foi.visitme.db;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Apartment {

    @SerializedName("apartment")
    @Expose
    private List<Apartment_> apartment = new ArrayList<Apartment_>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Apartment() {
    }

    /**
     *
     * @param apartment
     */
    public Apartment(List<Apartment_> apartment) {
        this.apartment = apartment;
    }

    /**
     *
     * @return
     * The apartment
     */
    public List<Apartment_> getApartment() {
        return apartment;
    }

    /**
     *
     * @param apartment
     * The apartment
     */
    public void setApartment(List<Apartment_> apartment) {
        this.apartment = apartment;
    }

}