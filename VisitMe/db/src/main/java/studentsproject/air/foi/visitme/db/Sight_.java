package studentsproject.air.foi.visitme.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Filip on 27.1.2016..
 */
public class Sight_ {

    @SerializedName("id_sight")
    @Expose
    private String idSight;
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
    public Sight_() {
    }

    /**
     *
     * @param description
     * @param name
     * @param lng
     * @param lat
     * @param idSight
     */
    public Sight_(String idSight, String name, String description, Double lat, Double lng) {
        this.idSight = idSight;
        this.name = name;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     *
     * @return
     * The idSight
     */
    public String getIdSight() {
        return idSight;
    }

    /**
     *
     * @param idSight
     * The id_sight
     */
    public void setIdSight(String idSight) {
        this.idSight = idSight;
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
