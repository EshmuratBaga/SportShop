package shoplist.project.kz.sportshop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import pl.polak.clicknumberpicker.ClickNumberPickerListener;
import pl.polak.clicknumberpicker.ClickNumberPickerView;
import pl.polak.clicknumberpicker.PickerClickType;
import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.model.ProductInfo;

/**
 * Created by Andrey on 3/29/2017.
 */

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.BasketHolder> {
    private Context context;
    private List<ProductInfo> productInfos;
    private int row;
    private TextView txtAllPrice;
    private TextView txtDeliver;
    private TextView txtPriceParent;
    private int currentPrice = 0;

    public BasketAdapter(Context context, List<ProductInfo> productInfos, int row, TextView txtPriceParent, TextView txtAllPrice, TextView txtDeliver) {
        this.context = context;
        this.productInfos = productInfos;
        this.row = row;
        this.txtAllPrice = txtAllPrice;
        this.txtDeliver = txtDeliver;
        this.txtPriceParent = txtPriceParent;
    }

    public class BasketHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private TextView txtPrice;
        private ImageView imageView;
        private ClickNumberPickerView pickerView;


        public BasketHolder(View itemView) {
            super(itemView);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_price_basket);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title_basket);
            imageView = (ImageView) itemView.findViewById(R.id.img_basket);
            pickerView = (ClickNumberPickerView) itemView.findViewById(R.id.picker_number);
            pickerView.setPickerValue(1);
            pickerView.setClickNumberPickerListener(new ClickNumberPickerListener() {
                @Override
                public void onValueChange(float previousValue, float currentValue, PickerClickType pickerClickType) {
                    txtPriceParent.setText(String.valueOf ((int) (currentPrice * currentValue)));
                    txtAllPrice.setText(String.valueOf(Integer.parseInt(txtPriceParent.getText().toString()) + Integer.parseInt(txtDeliver.getText().toString())));
                }
            });
        }
    }

    @Override
    public BasketHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(row,parent,false);
        return new BasketHolder(view);
    }

    @Override
    public void onBindViewHolder(BasketHolder holder, int position) {
        Picasso.with(context).load(productInfos.get(position).getImg1()).centerInside().fit().into(holder.imageView);
        holder.txtTitle.setText(productInfos.get(position).getName());
        holder.txtPrice.setText(productInfos.get(position).getPrice() + "тг");

        currentPrice += Integer.parseInt(productInfos.get(position).getPrice());

        txtPriceParent.setText(String.valueOf(currentPrice));
        txtAllPrice.setText(String.valueOf(Integer.parseInt(txtPriceParent.getText().toString()) + Integer.parseInt(txtDeliver.getText().toString())));
    }

    @Override
    public int getItemCount() {
        return productInfos.size();
    }
}
