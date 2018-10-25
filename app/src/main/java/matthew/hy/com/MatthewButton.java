package matthew.hy.com;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;


@SuppressLint("AppCompatCustomView")
public class MatthewButton extends Button {

    public MatthewButton(Context context) {
        super(context);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }
}
