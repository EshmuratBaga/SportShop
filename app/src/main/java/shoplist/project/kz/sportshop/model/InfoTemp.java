package shoplist.project.kz.sportshop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrey on 3/27/2017.
 */

public class InfoTemp extends RealmObject{
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
