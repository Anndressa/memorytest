package test.com.memorytest;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MemoryTestFragment extends Fragment {
    public static final String COUNT_ACTIVITY_PARAM = "count_activity";
    public static final String COUNT_FRAGMENT_PARAM = "count_fragment";

    private byte[] var;

    public static MemoryTestFragment newInstance(int countActivity, int countFragment) {
        MemoryTestFragment fragment = new MemoryTestFragment();
        Bundle args = new Bundle(2);
        args.putInt(COUNT_ACTIVITY_PARAM, countActivity);
        args.putInt(COUNT_FRAGMENT_PARAM, countFragment);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_memory_test, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final int countActivity = getArguments().getInt(COUNT_ACTIVITY_PARAM);
        final int countFragment = getArguments().getInt(COUNT_FRAGMENT_PARAM);

        ((TextView) view.findViewById(R.id.message))
                .setText(String.format("Activity %d, Fragment %d",
                        countActivity,
                        countFragment));

        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).newFragment(countActivity, countFragment + 1, false);
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).newFragment(countActivity, countFragment + 1, true);
            }
        });

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), MainActivity.class);
                i.putExtra(COUNT_ACTIVITY_PARAM, countActivity + 1);
                startActivity(i);
            }
        });

        var = new byte[1 * 1024 * 1024];
    }
}
