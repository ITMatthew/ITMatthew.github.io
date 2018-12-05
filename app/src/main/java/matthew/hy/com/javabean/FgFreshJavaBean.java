package matthew.hy.com.javabean;

/**
 * author : Heyang
 * e-mail : 15258836173@163.com
 * date   : 2018/12/516:59
 * desc   :
 * version: 1.0
 */
public class FgFreshJavaBean {
    private String mTitle;
    private String mGoods;
    private String mNums;

    @Override
    public String toString() {
        return "FgFreshJavaBean{" +
                "mTitle='" + mTitle + '\'' +
                ", mGoods='" + mGoods + '\'' +
                ", mNums='" + mNums + '\'' +
                '}';
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmGoods() {
        return mGoods;
    }

    public void setmGoods(String mGoods) {
        this.mGoods = mGoods;
    }

    public String getmNums() {
        return mNums;
    }

    public void setmNums(String mNums) {
        this.mNums = mNums;
    }

//    public FgFreshJavaBean(String mTitle, String mGoods, String mNums) {
//        this.mTitle = mTitle;
//        this.mGoods = mGoods;
//        this.mNums = mNums;
//    }
}
