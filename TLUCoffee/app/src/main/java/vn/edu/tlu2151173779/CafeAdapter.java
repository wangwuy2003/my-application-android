package vn.edu.tlu2151173779;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CafeAdapter extends ArrayAdapter<CafeItem> {
    private final List<CafeItem> items;
    private final Context context;

    public CafeAdapter(Context context, List<CafeItem> items) {
        super(context, 0, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_cafe, parent, false);
        }

        CafeItem item = items.get(position);

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemPrice = convertView.findViewById(R.id.item_price);
        Button orderButton = convertView.findViewById(R.id.button_order);

        itemImage.setImageResource(item.getImageResId());
        itemName.setText(item.getName());
        itemPrice.setText(String.format("$%.2f", item.getPrice()));

        orderButton.setOnClickListener(v -> {

        });

        return convertView;
    }
}
