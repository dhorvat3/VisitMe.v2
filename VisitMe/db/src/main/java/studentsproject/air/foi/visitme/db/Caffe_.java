package studentsproject.air.foi.visitme.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Filip on 27.1.2016..
 */
public class Caffe_ {

    @SerializedName("id_caffe")
    @Expose
    private String idCaffe;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private Object address;
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
    public Caffe_() {
    }

    /**
     *
     * @param idCaffe
     * @param address
     * @param description
     * @param name
     * @param lng
     * @param lat
     */
    public Caffe_(String idCaffe, String name, Object address, String description, Double lat, Double lng) {
        this.idCaffe = idCaffe;
        this.name = name;
        this.address = address;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
    }

    /**
     *
     * @return
     * The idCaffe
     */
    public String getIdCaffe() {
        return idCaffe;
    }

    /**
     *
     * @param idCaffe
     * The id_caffe
     */
    public void setIdCaffe(String idCaffe) {
        this.idCaffe = idCaffe;
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
     * The address
     */
    public Object getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(Object address) {
        this.address = address;
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
