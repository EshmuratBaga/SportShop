package shoplist.project.kz.sportshop.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import shoplist.project.kz.sportshop.R;

/**
 * Created by Andrey on 3/19/2017.
 */

public class SliderImageAdapter extends PagerAdapter{
    private List<Integer> photo;
    private LayoutInflater inflater;
    private Context context;

    public SliderImageAdapter(Context context) {
        this.context = context;
        photo = new ArrayList<>();
        photo.add(R.drawable.sport1);
        photo.add(R.drawable.sport2);
        photo.add(R.drawable.sport3);
        photo.add(R.drawable.sport4);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return photo.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slider_image_view, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image_slide);
        Picasso.with(context).load(photo.get(position)).fit().centerCrop().into(imageView);

        view.addView(imageLayout, 0);

        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }
}
