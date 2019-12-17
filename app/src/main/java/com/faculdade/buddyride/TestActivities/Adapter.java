package com.faculdade.buddyride.TestActivities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.faculdade.buddyride.R;
import java.util.List;

public class Adapter extends ArrayAdapter {

    //lista de atributos de usuario
    List<ItemsListView> listItems;
    LayoutInflater inflater;

    //A LayoutInflater instantiates a layout XML file into its corresponding View objects

    public Adapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        listItems = objects;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;

        if(view == null){
            view = inflater.inflate(R.layout.signup_listview, null);
            viewHolder = new ViewHolder();

            viewHolder.name = view.findViewById(R.id.name_field);
            viewHolder.lastname = view.findViewById(R.id.lastname_field);
            viewHolder.dateOfBirth = view.findViewById(R.id.birthday_field);
            viewHolder.email = view.findViewById(R.id.email_field);
            viewHolder.password = view.findViewById(R.id.password_field);
            viewHolder.confirmPassword = view.findViewById(R.id.confirmPassword_field);
            viewHolder.secretQuestion = view.findViewById(R.id.secretQuestion_field);
            viewHolder.secretAnswer = view.findViewById(R.id.secretAnswer_field);

            // getTag() and setTag() allows to keep any object
            view.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        ItemsListView items = listItems.get(position);
        viewHolder.setDataIntoViewHolder(items);

        return view;
    }
}
