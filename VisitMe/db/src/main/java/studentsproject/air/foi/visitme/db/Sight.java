package studentsproject.air.foi.visitme.db;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Filip on 27.1.2016..
 */
public class Sight {

    @SerializedName("sight")
    @Expose
    private List<Sight_> sight = new ArrayList<Sight_>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Sight() {
    }

    /**
     *
     * @param sight
     */
    public Sight(List<Sight_> sight) {
        this.sight = sight;
    }

    /**
     *
     * @return
     * The sight
     */
    public List<Sight_> getSight() {
        return sight;
    }

    /**
     *
     * @param sight
     * The sight
     */
    public void setSight(List<Sight_> sight) {
        this.sight = sight;
    }

}