package studentsproject.air.foi.visitme.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by Filip on 9.12.2015..
 */
public class Address extends Model {

    @Column(name = "id_address")
    private int id_address;

    @Column(name = "address", index = true)
    private String address;

    @Column(name = "lng", index = true)
    private long lng;

    @Column(name = "lat", index = true)
    private long lat;

    @Column(name = "id_town", index = true)
    private int id_town;

    public Address() {super();}

    public Address(int id_address, String address, long lng, long lat, int id_town) {
        super();
        this.id_address = id_address;
        this.address = address;
        this.lng = lng;
        this.lat = lat;
        this.id_town = id_town;
    }

    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public int getId_town() {
        return id_town;
    }

    public void setId_town(int id_town) {
        this.id_town = id_town;
    }

    public  void updateAddress(Address updatedAddress){

        this.id_address=updatedAddress.getId_address();
        this.lat=updatedAddress.getLat();
        this.lng=updatedAddress.getLng();
        this.address=updatedAddress.getAddress();
        this.save();


    }
}
