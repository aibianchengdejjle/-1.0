package com.jjle.sport.mapper;

import com.jjle.sport.pojo.MainMenu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper {
    public List<MainMenu> getMainMenus();
}
