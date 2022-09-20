package py.com.cvs2.controller;

import py.com.cvs2.dao.SistemaDao;
import py.com.cvs2.dao.SubMenuDao;
import py.com.cvs2.dto.MenuDto;

public class MenuController {

    public MenuDto getMenu() {

        SistemaDao sistemaDao = new SistemaDao();

        SubMenuDao subMenuDao = new SubMenuDao();

        MenuDto menu = new MenuDto();

        menu.setSubMenus(subMenuDao.list(false));
        menu.setSistemas(sistemaDao.list(false));

        return menu;
    }
}
