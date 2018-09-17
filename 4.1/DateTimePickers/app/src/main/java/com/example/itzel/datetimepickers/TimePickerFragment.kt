package com.example.itzel.datetimepickers

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.widget.TimePicker;
import java.util.Calendar;

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {


        val c = Calendar.getInstance()

        val hour = c.get(Calendar.HOUR_OF_DAY)

        val minute = c.get(Calendar.MINUTE)


        return TimePickerDialog(activity, this, hour, minute,

                DateFormat.is24HourFormat(activity))

    }

    override fun onTimeSet(view: TimePicker, hourOfDay: Int, minute: Int) {

        val activity = activity as MainActivity?

        activity!!.processTimePickerResult(hourOfDay, minute)

    }

}