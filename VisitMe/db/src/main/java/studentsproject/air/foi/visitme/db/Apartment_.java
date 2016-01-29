package studentsproject.air.foi.visitme.db;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Apartment_ {

    @SerializedName("apartment_name")
    @Expose
    private String apartmentName;
    @SerializedName("town_name")
    @Expose
    private String townName;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("free")
    @Expose
    private String free;
    @SerializedName("lat")
    @Expose
    private Double lat;
    @SerializedName("lng")
    @Expose
    private Double lng;
    @SerializedName("id_town")
    @Expose
    private String idTown;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("id_owner")
    @Expose
    private String idOwner;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("beds")
    @Expose
    private String beds;


    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBeds() {
        return beds;
    }

    public void setBeds(String beds) {
        this.beds = beds;
    }




    /**
     * No args constructor for use in serialization
     *
     */
    public Apartment_() {
    }

    /**
     *
     * @param free
     * @param price
     * @param address
     * @param description
     * @param idTown
     * @param townName
     * @param apartmentName
     * @param lng
     * @param lat
     * @param idOwner
     */
    public Apartment_(String apartmentName, String townName, String price, String address, String free, Double lat, Double lng, String idTown, String description, String idOwner, String mobile) {
        this.apartmentName = apartmentName;
        this.townName = townName;
        this.price = price;
        this.address = address;
        this.free = free;
        this.lat = lat;
        this.lng = lng;
        this.idTown = idTown;
        this.description = description;
        this.idOwner = idOwner;
        this.mobile = mobile;
    }

    /**
     *
     * @return
     * The apartmentName
     */
    public String getApartmentName() {
        return apartmentName;
    }

    /**
     *
     * @param apartmentName
     * The apartment_name
     */
    public void setApartmentName(String apartmentName) {
        this.apartmentName = apartmentName;
    }

    /**
     *
     * @return
     * The townName
     */
    public String getTownName() {
        return townName;
    }

    /**
     *
     * @param townName
     * The town_name
     */
    public void setTownName(String townName) {
        this.townName = townName;
    }

    /**
     *
     * @return
     * The price
     */
    public String getPrice() {
        return price;
    }

    /**
     *
     * @param price
     * The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     *
     * @return
     * The address
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The free
     */
    public String getFree() {
        return free;
    }

    /**
     *
     * @param free
     * The free
     */
    public void setFree(String free) {
        this.free = free;
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

    /**
     *
     * @return
     * The idTown
     */
    public String getIdTown() {
        return idTown;
    }

    /**
     *
     * @param idTown
     * The id_town
     */
    public void setIdTown(String idTown) {
        this.idTown = idTown;
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
     * The idOwner
     */
    public String getIdOwner() {
        return idOwner;
    }

    /**
     *
     * @param idOwner
     * The id_owner
     */
    public void setIdOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    public String getMobile() {
        return mobile;
    }

}