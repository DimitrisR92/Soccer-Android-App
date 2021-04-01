package e.lenovo.soccerapp.ui.team;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import e.lenovo.soccerapp.R;

public class TeamFragment extends Fragment {

    private TeamViewModel teamViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        teamViewModel =
                new ViewModelProvider(this).get(TeamViewModel.class);
        View root = inflater.inflate(R.layout.fragment_teams, container, false);
        final TextView textView = root.findViewById(R.id.text_team);
        teamViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}