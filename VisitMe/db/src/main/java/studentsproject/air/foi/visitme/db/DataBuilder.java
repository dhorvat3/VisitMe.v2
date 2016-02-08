package studentsproject.air.foi.visitme.db;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by davor on 7.2.2016..
 */
public class DataBuilder {
    private ApiMethods apiMethods = ApiMethods.restAdapter.create(ApiMethods.class);
    private DataInterface call;
    private Object data;

    public DataBuilder(DataInterface caller){
        call = caller;
    }

    /**
     * Metoda koja dohvaća apartmane i poziva buildData metodu klase koja poziva metodu.
     * Klasa koja poziva metodu mora implementirati DataInterface sučelje.
     */
    public void getApartments(){
        apiMethods.getApartments(new Callback<Apartment>() {
            @Override
            public void success(Apartment apartment, Response response) {
                data = apartment;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }

    /**
     * Metoda koja dohvaća kafiće i poziva buildData metodu klase koja poziva metodu.
     * Klasa koja poziva metodu mora implementirati DataInterface sučelje.
     */
    public void getCaffe(){
        apiMethods.getCaffe(new Callback<Caffe>() {
            @Override
            public void success(Caffe caffe, Response response) {
                data = caffe;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }

    /**
     * Metoda koja dohvaća restorane i poziva buildData metodu klase koja poziva metodu.
     * Klasa koja poziva metodu mora implementirati DataInterface sučelje.
     */
    public void getRestaurant(){
        apiMethods.getRestaurant(new Callback<Restaurant>() {
            @Override
            public void success(Restaurant restaurant, Response response) {
                data = restaurant;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }

    /**
     * Metoda koja dohvaća zanimljivosti i poziva buildData metodu klase koja poziva metodu.
     * Klasa koja poziva metodu mora implementirati DataInterface sučelje.
     */
    public void getSight(){
        apiMethods.getSight(new Callback<Sight>() {
            @Override
            public void success(Sight sight, Response response) {
                data = sight;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }

    /**
     * Metoda za login, uspiješan login vraća Owner objekt, neuspješan login vraća null objekt.
     * *Kod neuspješnog ownera idOwner je jednak 0, nije null.
     * @param user String
     * @param pass String
     */
    public void login(String user, String pass){
        apiMethods.login(user, pass, new Callback<Owner>() {
            @Override
            public void success(Owner owner, Response response) {
                data = owner;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }

    public void register(Owner owner){
        apiMethods.register(owner, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                data = response;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }

    public void setApartment(Apartment_ apartment){
        apiMethods.setApartment(apartment, new Callback<Response>() {
            @Override
            public void success(Response response, Response response2) {
                data = response;
                call.buildData(data);
            }

            @Override
            public void failure(RetrofitError error) {
                data = null;
                call.buildData(data);
            }
        });
    }
}
