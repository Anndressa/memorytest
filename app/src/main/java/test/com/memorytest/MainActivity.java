package test.com.memorytest;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newFragment(getIntent().getIntExtra(MemoryTestFragment.COUNT_ACTIVITY_PARAM, 1), 1, false);
    }

    public void newFragment(int countActivity, int countFragment, boolean addToBackStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment, MemoryTestFragment.newInstance(countActivity, countFragment));
        if (addToBackStack) ft.addToBackStack(null);
        ft.commit();
    }
}
