package com.ibe6.section03.controller;

import com.ibe6.section03.dto.CategoryDto;
import com.ibe6.section03.dto.MenuDto;
import com.ibe6.section03.service.MenuService;
import com.ibe6.section03.view.ResultView;

import java.util.List;
import java.util.Map;

public class MenuController {

    private MenuService menuService = new MenuService();

    public void selectMenuList() {
        List<MenuDto> list = menuService.selectMenuList();
        ResultView.displayMenuList(list);
    }

    public void selectSubCategoryList() {
        List<CategoryDto> list = menuService.selectSubCategoryList();
        ResultView.displayCategoryList(list);
    }

    public void selectMenu(String code) {
        MenuDto menu = menuService.selectMenuByMenuCode(Integer.parseInt(code));
        ResultView.displayMenu(menu);
    }

    public void selectMenuListByCategoryCode(String code){
        List<MenuDto> list = menuService.selectMenuListByCategoryCode(Integer.parseInt(code));
        ResultView.displayMenuList(list);
    }

    public void registMenu(Map<String, String> requestParam) {
        // 요청시 전달된 데이터 => MenuDto 옮기기
        MenuDto menu = MenuDto.builder()
                .menuName(requestParam.get("name"))
                .menuPrice(Integer.parseInt(requestParam.get("price")))
                .categoryCode(Integer.parseInt(requestParam.get("category")))
                .orderableStatus(requestParam.get("orderable"))
                .build();

        int result = menuService.registMenu(menu);
        ResultView.displayResult("메뉴 등록", result);
    }

    public void modifyMenu(Map<String, String> requestParam) {
        MenuDto menu = MenuDto.builder()
                .menuCode( Integer.parseInt(requestParam.get("code")) )
                .menuName( requestParam.get("name") )
                .menuPrice( Integer.parseInt(requestParam.get("price")) )
                .categoryCode( Integer.parseInt(requestParam.get("category")) )
                .orderableStatus( requestParam.get("orderable") )
                .build();

        int result = menuService.modifyMenu(menu);
        ResultView.displayResult("메뉴 수정", result);
    }

    public void removeMenu(String code) {

        int result = menuService.removeMenu( Integer.parseInt(code) );
        ResultView.displayResult("메뉴 삭제", result);
    }
}
