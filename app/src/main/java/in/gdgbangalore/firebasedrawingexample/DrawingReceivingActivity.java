package in.gdgbangalore.firebasedrawingexample;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class DrawingReceivingActivity extends ActionBarActivity {

    CustomDrawableView mCustomDrawableView;
    Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawing_receiving);
        mCustomDrawableView = (CustomDrawableView) findViewById(R.id.customView);
        firebase = new Firebase("https://gdg-bangalore-event.firebaseio.com/position");
        firebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseDrawingPosition position = dataSnapshot.getValue(FirebaseDrawingPosition.class);
                float old_x = mCustomDrawableView.x;
                float old_y = mCustomDrawableView.y;
                float dx = position.x - old_x;
                float dy = position.y - old_y;
                ObjectAnimator moveX = ObjectAnimator.ofFloat(mCustomDrawableView, "translationX", dx);
                ObjectAnimator moveY = ObjectAnimator.ofFloat(mCustomDrawableView, "translationY", dy);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(moveX, moveY);
                animatorSet.setDuration(300);
                animatorSet.start();
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_drawing_receiving, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
