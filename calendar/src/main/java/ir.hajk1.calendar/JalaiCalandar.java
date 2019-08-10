package ir.hajk1.calendar;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.Calendar;
import com.ibm.icu.util.ULocale;
import java.text.ParseException;

/**
 * Author: <a href="mailto:k1.tehrani@gmail.com">Kayvan Tehrani</a>
 *
 * Description: <the description of the class for java doc by those that might use it, please use html if possible>
 */
public class JalaiCalandar {

  public static void main(String[] args) throws ParseException {
    ULocale locale = new ULocale("fa_IR@calendar=persian");

    Calendar calendar = Calendar.getInstance(locale);
    DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, locale);
    DateFormat df2 = new SimpleDateFormat("yyyy/MM/dd", locale);

    System.out.println(df.format(calendar));
    System.out.println(df2.format(calendar));
    System.out.println(df2.parse("1359/02/01"));
  }

}
