package shoplist.project.kz.sportshop.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import shoplist.project.kz.sportshop.model.DataTempAuth;

/**
 * Created by Andrey on 3/27/2017.
 */

public class TempAuthResponse {
    @SerializedName("data")
    @Expose
    private List<DataTempAuth> data = null;

    public List<DataTempAuth> getData() {
        return data;
    }

    public void setData(List<DataTempAuth> data) {
        this.data = data;
    }
}
