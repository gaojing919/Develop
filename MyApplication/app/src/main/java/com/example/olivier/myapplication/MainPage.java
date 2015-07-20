package com.example.olivier.myapplication;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainPage extends Fragment {

    ImageButton mainRecord;
    ImageButton mainStop;
    ImageButton pause;
    ImageButton pause_play;
    Button save;
    TextView explanation;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentActivity faActivity = (FragmentActivity) super.getActivity();
        RelativeLayout rLayout = (RelativeLayout) inflater.inflate(R.layout.main_page, container, false);


        mainRecord = (ImageButton) rLayout.findViewById(R.id.mainButton_play);
        mainRecord.setVisibility(View.VISIBLE);
        mainRecord.setOnClickListener(globalClick);

        mainStop = (ImageButton) rLayout.findViewById(R.id.mainButton_stop);
        mainStop.setVisibility(View.INVISIBLE);
        mainStop.setOnClickListener(globalClick);

        pause = (ImageButton) rLayout.findViewById(R.id.pause);
        pause.setVisibility(View.VISIBLE);
        pause.setOnClickListener(globalClick);

        pause_play = (ImageButton) rLayout.findViewById(R.id.pause_play);
        pause_play.setVisibility(View.INVISIBLE);
        pause_play.setOnClickListener(globalClick);

        explanation = (TextView) rLayout.findViewById(R.id.recording_text);

        save = (Button) rLayout.findViewById(R.id.save_button);
        save.setVisibility(View.INVISIBLE);
        save.setOnClickListener(globalClick);

        return rLayout;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        super.onCreateOptionsMenu(menu, inflater);
    }


    private final View.OnClickListener globalClick = new View.OnClickListener() {
        @Override
        public void onClick(final View v) {

            switch (v.getId()) {
                case R.id.mainButton_play:
                    //The app is recording
                    mainRecord.setVisibility(View.INVISIBLE);
                    mainStop.setVisibility(View.VISIBLE);
                    save.setVisibility(View.INVISIBLE);
                    explanation.setText("Recording");
                    break;

                case R.id.mainButton_stop:
                    //the recording stop
                    //save button must appear
                    mainRecord.setVisibility(View.VISIBLE);
                    mainStop.setVisibility(View.INVISIBLE);
                    save.setVisibility(View.VISIBLE);
                    explanation.setText("Record");
                    break;

                case R.id.pause:
                    //set the recording in pause mode if the app is playing
                    //stop if stop button is pressed
                    if (explanation.getText() == "Recording") {
                        mainRecord.setVisibility(View.INVISIBLE);
                        mainStop.setVisibility(View.VISIBLE);
                        pause_play.setVisibility(View.VISIBLE);
                        pause.setVisibility(View.INVISIBLE);
                        save.setVisibility(View.INVISIBLE);
                        explanation.setText("Pause");
                    }
                    break;

                case R.id.pause_play:
                    //continue recording after pause
                    if (explanation.getText()=="Pause"){
                        mainRecord.setVisibility(View.INVISIBLE);
                        mainStop.setVisibility(View.VISIBLE);
                        pause.setVisibility(View.VISIBLE);
                        pause_play.setVisibility(View.INVISIBLE);
                        save.setVisibility(View.INVISIBLE);
                        explanation.setText("Recording");
                    }
                    break;

                case R.id.save_button:
                    //save the file
                    //appear only when on stop
                    save.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    };
}
