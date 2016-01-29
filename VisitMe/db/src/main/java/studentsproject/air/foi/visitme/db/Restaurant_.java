package studentsproject.air.foi.visitme.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Filip on 27.1.2016..
 */
public class Restaurant_ {

    @SerializedName("id_restaurant")
    @Expose
    private String idRestaurant;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;

    /**
     * No args constructor for use in serialization
     *
     */
    public Restaurant_() {
    }

    /**
     *
     * @param description
     * @param name
     * @param idRestaurant
     * @param lng
     * @param lat
     */
    public Restaurant_(String idRestaurant, String name, String description, Double lat, Double lng) {
        this.idRestaurant = idRestaurant;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     *
     * @return
     * The idRestaurant
     */
    public String getIdRestaurant() {
        return idRestaurant;
    }

    /**
     *
     * @param idRestaurant
     * The id_restaurant
     */
    public void setIdRestaurant(String idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The lat
     */
    public Double getLat() {
        return lat;
    }

    /**
     *
     * @param lat
     * The lat
     */
    public void setLat(Double lat) {
        this.lat = lat;
    }

    /**
     *
     * @return
     * The lng
     */
    public Double getLng() {
        return lng;
    }

    /**
     *
     * @param lng
     * The lng
     */
    public void setLng(Double lng) {
        this.lng = lng;
    }

}
