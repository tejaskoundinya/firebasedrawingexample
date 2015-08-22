package in.gdgbangalore.firebasedrawingexample;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.HashMap;
import java.util.Map;

/**
 * A placeholder fragment containing a simple view.
 */
public class SelectionActivityFragment extends Fragment {

    Button sendButton;
    Button receiveButton;

    public SelectionActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_selection, container, false);
        sendButton = (Button) rootView.findViewById(R.id.button_draw_send);
        receiveButton = (Button) rootView.findViewById(R.id.button_draw_receive);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DrawingSendActivity.class);
                startActivity(intent);
            }
        });
        receiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), DrawingReceivingActivity.class);
                startActivity(intent);
            }
        });
        
        return rootView;
    }
}
