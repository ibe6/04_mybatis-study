package com.ibe6.dao;

import com.ibe6.dto.MenuDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface MenuMapper {

    // if 테스트
    List<MenuDto> selectMenuByNameOrCategory1(Map<String, String> searchMap);

    // <choose, when, otherwise> 테스트
    List<MenuDto> selectMenuByNameOrCategory2(Map<String, String> searchMap);

    // <foreach> 테스트
    //int deleteMenu(List<Integer> deleteMenuCodes);
    int deleteMenu(Map<String, Object> map); // List가 담겨있는 map을 전달하는 case

    // <where> 테스트
    List<MenuDto>selectMenuByCodeOrSearchAll(int menuCode);

    // <> 테스트
    List<MenuDto> selectMenuByNameOrCategory3(Map<String, Object> searchMap);

    int updateMenu(Map<String, Object> map);
}
