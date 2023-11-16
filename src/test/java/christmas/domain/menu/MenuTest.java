package christmas.domain.menu;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {
    @ParameterizedTest
    @CsvSource(value = {"양송이수프,Appetizer", "바비큐립,MainDish", "초코케이크,Dessert","제로콜라,Beverage"},delimiter = ',')
    @DisplayName("요리 종류가 올바르게 나오는지 확인한다.")
    void createMenuCookType(String menuName, String inputCookType){
        Menu menu = Menu.create(menuName);

        String cookType = menu.cookType();

        assertThat(cookType).isEqualTo(inputCookType);
    }

    @ParameterizedTest
    @ValueSource(strings = {"바비큐립2","12","두부","두유","$@!#", "152","/*2ㄴㅊ"})
    @DisplayName("잘못된 메뉴 입력시 예외가 발생한다.")
    void createMenuWrongCookType(String wrongData){
        assertThatThrownBy(() -> Menu.create(wrongData))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

    @Test
    @DisplayName("메뉴명이 제대로 나오는지 확인한다.")
    void createMenuName(){
        Menu menu = Menu.create("바비큐립");

        String name = menu.name();

        assertThat(name).isEqualTo("바비큐립");
    }

    @Test
    @DisplayName("메뉴에 해당하는 금액이 나오는지 확인한다.")
    void createMenuPrice(){
        Menu menu = Menu.create("바비큐립");

        Integer price = menu.price();

        assertThat(price).isEqualTo(54000);
    }
}
