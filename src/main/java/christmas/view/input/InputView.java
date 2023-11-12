package christmas.view.input;


import static camp.nextstep.edu.missionutils.Console.readLine;

import christmas.config.convert.ConvertToArray;
import christmas.config.convert.ConvertToInt;

public class InputView {
    public static int reserveDay(){
        return ConvertToInt.from(readLine()).get();
    }

    public static String[] receiveOrder() {
        return ConvertToArray.from(readLine()).get();
    }
}
