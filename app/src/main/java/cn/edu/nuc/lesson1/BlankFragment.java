package cn.edu.nuc.lesson1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    public static final String TEXT = "text";
    private TextView text;
    //默认构造函数
    public BlankFragment(){}

    public static BlankFragment newInstance(String text) {
        // Required empty public constructor
        BlankFragment ret = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(TEXT, text);
        ret.setArguments(args);
        return ret;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret  = inflater.inflate(R.layout.fragment_blank, container, false);

        return ret;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text = (TextView) view.findViewById(R.id.fragment_text);
        String s = getArguments().getString(TEXT);
        text.setText(s);

    }
}
