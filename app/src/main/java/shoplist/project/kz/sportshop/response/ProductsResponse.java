package shoplist.project.kz.sportshop.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import shoplist.project.kz.sportshop.model.DataProducts;

/**
 * Created by Andrey on 3/23/2017.
 */

public class ProductsResponse {
    @SerializedName("data")
    @Expose
    private List<DataProducts> data = null;

    public List<DataProducts> getData() {
        return data;
    }

    public void setData(List<DataProducts> data) {
        this.data = data;
    }
}
