package com.ibe6.section03.view;

import com.ibe6.section03.dto.CategoryDto;
import com.ibe6.section03.dto.MenuDto;

import java.util.List;

public class ResultView {

    // 조회된 메뉴 목록을 출력해주는 화면
    public static void displayMenuList(List<MenuDto> list){
        if(list.isEmpty()){
            System.out.println("조회된 메뉴가 없습니다😅.");
        }else {
            for (MenuDto menu : list) {
                System.out.printf("%d\t%s\t%d원\t%d\t%s\n",
                        menu.getMenuCode(),
                        menu.getMenuName(),
                        menu.getMenuPrice(),
                        menu.getCategoryCode(),
                        menu.getOrderableStatus());
            }
        }

    }

    // 카테고리목록 출력해주는 화면
    public static void displayCategoryList(List<CategoryDto> list){
        for (CategoryDto category : list) {
            System.out.printf("%d. %s", category.getCategoryCode(),category.getCategoryName());
        }
        System.out.println();
    }

    // 한건의 메뉴 정보 출력해주는 화면
    public static void displayMenu(MenuDto menu){
        if(menu == null){
            System.out.println("조회된 메뉴가 없습니다😅.");
        }else{
            System.out.println("~~~~~~ 메뉴 정보 ~~~~~~");
            System.out.println("Code: " + menu.getMenuCode());
            System.out.println("Name: " + menu.getMenuName());
            System.out.println("Price: " + menu.getMenuPrice() + "원");
            System.out.println("Category: " + menu.getCategoryCode());
            System.out.println("Orderable: " + ("Y".equals(menu.getOrderableStatus()) ? "주문가능" : "주문불가"));
            System.out.println("=======================");
        }
    }

    // 등록, 수정, 삭제 요청시 결과를 출력해주는 화면
    public static void displayResult(String type, int result){ // type:"메뉴 등록"|"메뉴 수정"|"메뉴 삭제" / result:최종결과
        System.out.println("🐨 " + type + " " + (result > 0 ? "성공!" : "실패!") );
    }
}
