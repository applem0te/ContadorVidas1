package com.example.contadorvidas.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.contadorvidas.R;

public class MainFragment extends Fragment {

    private Button p1poisonmore;
    private Button p1poisonless;
    private Button p2poisonmore;
    private Button p2poisonless;
    private ImageButton p2lifeless;
    private ImageButton p1lifemore;
    private ImageButton p2lifemore;
    private ImageButton p1lifeless;
    private ImageButton lifetwotoone;
    private ImageButton lifeonetotwo;
    private TextView counter1;
    private TextView counter2;

    private int life1;
    private int life2;
    private int poison1;
    private int poison2;

    private MainViewModel mViewModel;
    private View view;

    public static MainFragment newInstance() {
        return new MainFragment();
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.main_fragment, container, false);

        p1poisonmore = (Button) view.findViewById(R.id.p1poisonmore);
        p1poisonless = (Button) view.findViewById(R.id.p1poisonless);
        p2poisonmore = (Button) view.findViewById(R.id.p2poisonmore);
        p2poisonless = (Button) view.findViewById(R.id.p2poisonless);
        p2lifeless = (ImageButton) view.findViewById(R.id.p2lifeless);
        p1lifemore = (ImageButton) view.findViewById(R.id.p1lifemore);
        p2lifemore = (ImageButton) view.findViewById(R.id.p2lifemore);
        p1lifeless = (ImageButton) view.findViewById(R.id.p1lifeless);
        lifetwotoone = (ImageButton) view.findViewById(R.id.lifetwotoone);
        lifeonetotwo = (ImageButton) view.findViewById(R.id.lifeonetotwo);
        counter1 = (TextView) view.findViewById(R.id.counter1);
        counter2 = (TextView) view.findViewById(R.id.counter2);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(view.getId()){
                    case R.id.lifeonetotwo:
                        life1--;
                        life2++;
                        break;

                    case R.id.lifetwotoone:
                        life2++;
                        life1--;
                        break;

                    case R.id.p1lifeless:
                        life1--;
                        break;

                    case R.id.p1lifemore:
                        life1++;
                        break;

                    case R.id.p1poisonless:
                        poison1--;
                        break;

                    case R.id.p1poisonmore:
                        poison1++;
                        break;

                    case R.id.p2lifeless:
                        life2--;
                        break;

                    case R.id.p2lifemore:
                        life2++;
                        break;

                    case R.id.p2poisonless:
                        poison2--;
                        break;

                    case R.id.p2poisonmore:
                        poison2++;
                        break;
                }
                updateViews();
            }
        };

        reset();

        p1poisonmore.setOnClickListener(listener);
        p1poisonless.setOnClickListener(listener);
        p2poisonmore.setOnClickListener(listener);
        p2poisonless.setOnClickListener(listener);
        p2lifeless.setOnClickListener(listener);
        p1lifemore.setOnClickListener(listener);
        p2lifemore.setOnClickListener(listener);
        p1lifeless.setOnClickListener(listener);
        lifetwotoone.setOnClickListener(listener);
        lifeonetotwo.setOnClickListener(listener);
        counter1.setOnClickListener(listener);
        counter2.setOnClickListener(listener);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.reset){
            reset();
            //Snackbar.make(view, "New Game!", Snackbar.LENGTH_LONG).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    private void reset() {

        poison1 = 0;
        poison2 = 0;
        life1 = 20;
        life2 = 20;

        updateViews();
    }

    private void updateViews() {

        counter1.setText(String.format("%d/%d", life1, poison1));
        counter2.setText(String.format("%d/%d", life2, poison2));

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

}