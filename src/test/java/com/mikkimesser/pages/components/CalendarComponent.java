package com.mikkimesser.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String _day, String _month, String _year){
        $(".react-datepicker__month-select").selectOption(_month);
        $(".react-datepicker__year-select").selectOption(_year);
        $(".react-datepicker__day--0"+_day+":not(.react-datepicker__day--outside-month)").click();
    }
}
