package studentsproject.air.foi.visitme.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 27.1.2016..
 */

public class Caffe {

    @SerializedName("caffe")
    @Expose
    private List<Caffe_> caffe = new ArrayList<Caffe_>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Caffe() {
    }

    /**
     *
     * @param caffe
     */
    public Caffe(List<Caffe_> caffe) {
        this.caffe = caffe;
    }

    /**
     *
     * @return
     * The caffe
     */
    public List<Caffe_> getCaffe() {
        return caffe;
    }

    /**
     *
     * @param caffe
     * The caffe
     */
    public void setCaffe(List<Caffe_> caffe) {
        this.caffe = caffe;
    }

}