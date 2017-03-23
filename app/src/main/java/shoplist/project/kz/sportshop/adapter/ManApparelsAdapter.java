package shoplist.project.kz.sportshop.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.model.ProductInfo;

/**
 * Created by Andrey on 3/23/2017.
 */

public class ManApparelsAdapter extends RecyclerView.Adapter<ManApparelsAdapter.ApparelsHolder>{

    private Context context;
    private List<ProductInfo> productInfos;
    private int rowLayout;

    public ManApparelsAdapter(Context context, List<ProductInfo> productInfos, int rowLayout) {
        this.context = context;
        this.productInfos = productInfos;
        this.rowLayout = rowLayout;
    }

    public class ApparelsHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView txtTitle;
        private TextView txtPrice;

        public ApparelsHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.img_item);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title_item);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_price_item);
        }
    }

    @Override
    public ApparelsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ApparelsHolder(view);
    }

    @Override
    public void onBindViewHolder(ApparelsHolder holder, int position) {
        Picasso.with(context).load(productInfos.get(position).getImg1()).into(holder.imageView);
        holder.txtTitle.setText(productInfos.get(position).getName());
        holder.txtPrice.setText(productInfos.get(position).getPrice() + "тг");
    }

    @Override
    public int getItemCount() {
        return productInfos.size();
    }
}
