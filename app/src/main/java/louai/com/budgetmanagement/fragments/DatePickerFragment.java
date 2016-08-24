package louai.com.budgetmanagement.fragments;


import android.app.DatePickerDialog;
import android.app.Dialog;
import  java.util.Calendar;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.format.DateTimeFormatter;

import louai.com.budgetmanagement.R;

public  class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private String date;
    public TextView textView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        if(month<10)
            date=Integer.toString(day)+"-0"+Integer.toString(month)+"-"+Integer.toString(year);
        else
            date=Integer.toString(day)+"-"+Integer.toString(month)+"-"+Integer.toString(year);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime time = LocalTime.now();
        String f = formatter.format(time);
        textView.setText(date+" "+f);
    }
    public void setTextView (TextView textView)
    {
        this.textView=textView;
    }

}