package shoplist.project.kz.sportshop.model;

/**
 * Created by Andrey on 3/16/2017.
 */

public class ExpandedMenuModel {
    String iconName = "";
    int iconImg = -1; // menu icon resource id

    public String getIconName() {
        return iconName;
    }
    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
    public int getIconImg() {
        return iconImg;
    }
    public void setIconImg(int iconImg) {
        this.iconImg = iconImg;
    }
}
