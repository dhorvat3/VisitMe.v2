package studentsproject.air.foi.visitme.db;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by davor on 18.12.2015..
 */
public interface ApiMethods {

    //Get apartments
    @GET("/apartment_address.php")
    void getApartments(Callback<Apartment> callback);

    @GET("/caffe.php")
    void getCaffe(Callback<Caffe> callback);

    @GET("/restaurant.php")
    void getRestaurant(Callback<Restaurant> callback);

    @GET("/sight.php")
    void getSight(Callback<Sight> callback);

    @POST("/owner_insert.php")
    void register(@Body Owner owner, Callback<Response> callback);

    @GET("/login.php")
    void login(@Query("username") String username, @Query("password") String password, Callback<Owner> callback);

    @POST("/unos_apartmana.php")
    void setApartment(@Body Apartment_ apartment, Callback<Response> callback);



    public static final RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://domotehnika.hr/visitme/")
            .build();
}
