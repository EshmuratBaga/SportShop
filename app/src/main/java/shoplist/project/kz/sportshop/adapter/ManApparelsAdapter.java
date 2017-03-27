package shoplist.project.kz.sportshop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import shoplist.project.kz.sportshop.R;
import shoplist.project.kz.sportshop.model.ProductInfo;
import shoplist.project.kz.sportshop.screen.details.DetailsActivity;

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

    public class ApparelsHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView imageView;
        private TextView txtTitle;
        private TextView txtPrice;
        private CardView cardView;
        private ImageButton iBtnFavorite;
        private String id;

        public ApparelsHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.rv_grid_item);
            imageView = (ImageView) itemView.findViewById(R.id.img_item);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_title_item);
            txtPrice = (TextView) itemView.findViewById(R.id.txt_price_item);
            iBtnFavorite = (ImageButton) itemView.findViewById(R.id.ibtn_favorite);

            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.rv_grid_item:
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("id",id);
                    context.startActivity(intent);
                    break;
            }
        }
    }

    @Override
    public ApparelsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent,false);
        return new ApparelsHolder(view);
    }

    @Override
    public void onBindViewHolder(final ApparelsHolder holder, final int position) {
        Picasso.with(context).load(productInfos.get(position).getImg1()).into(holder.imageView);
        holder.txtTitle.setText(productInfos.get(position).getName());
        holder.txtPrice.setText(productInfos.get(position).getPrice() + "тг");
        holder.id = productInfos.get(position).getId();

        if (productInfos.get(position).isPress()){
            holder.iBtnFavorite.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
        }else {
            holder.iBtnFavorite.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
        }

        holder.iBtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (productInfos.get(position).isPress()){
                    Log.d("ssss","click" + 123);
                    holder.iBtnFavorite.setBackgroundResource(R.drawable.ic_favorite_border_black_24dp);
                    productInfos.get(position).setPress(false);
                }else {
                    Log.d("ssss","click" + 123456);
                    holder.iBtnFavorite.setBackgroundResource(R.drawable.ic_favorite_black_24dp);
                    productInfos.get(position).setPress(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productInfos.size();
    }
}
