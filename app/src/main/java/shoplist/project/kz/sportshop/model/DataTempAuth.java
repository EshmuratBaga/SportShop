package shoplist.project.kz.sportshop.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Andrey on 3/27/2017.
 */

public class DataTempAuth {
    private int id;
    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("object")
    @Expose
    private InfoTemp tempId = null;
    @SerializedName("errors")
    @Expose
    private List<Object> errors = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public InfoTemp getTempId() {
        return tempId;
    }

    public void setTempId(InfoTemp tempId) {
        this.tempId = tempId;
    }

    public List<Object> getErrors() {
        return errors;
    }

    public void setErrors(List<Object> errors) {
        this.errors = errors;
    }
}
