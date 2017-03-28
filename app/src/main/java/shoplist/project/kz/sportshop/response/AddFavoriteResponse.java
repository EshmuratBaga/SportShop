package shoplist.project.kz.sportshop.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import shoplist.project.kz.sportshop.model.DataAddProduct;

/**
 * Created by Andrey on 3/27/2017.
 */

public class AddFavoriteResponse {

    @SerializedName("data")
    @Expose
    private List<DataAddProduct> data = null;

    public List<DataAddProduct> getData() {
        return data;
    }

    public void setData(List<DataAddProduct> data) {
        this.data = data;
    }
}
