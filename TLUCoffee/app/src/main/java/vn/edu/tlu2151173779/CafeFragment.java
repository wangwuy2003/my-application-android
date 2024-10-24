package vn.edu.tlu2151173779;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CafeFragment extends Fragment {
    private List<CafeItem> cafeItems;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cafe, container, false);

        cafeItems = new ArrayList<>();
        cafeItems.add(new CafeItem(R.drawable.baseline_local_cafe_24, "Cafe Sữa Đá", 2.50));
        cafeItems.add(new CafeItem(R.drawable.baseline_local_cafe_24, "Cafe Đen", 2.00));
        cafeItems.add(new CafeItem(R.drawable.baseline_local_cafe_24, "Cafe Trứng", 3.00));

        ListView listView = view.findViewById(R.id.listView);
        CafeAdapter adapter = new CafeAdapter(getContext(), cafeItems);
        listView.setAdapter(adapter);

        return view;
    }
}
