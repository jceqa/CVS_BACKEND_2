package py.com.cvs2.dto;

import py.com.cvs2.model.Sistema;
import py.com.cvs2.model.SubMenu;

import java.io.Serializable;
import java.util.List;

public class MenuDto implements Serializable {

    private List<Sistema> sistemas;

    private List<SubMenu> subMenus;

    public MenuDto() {
    }

    public MenuDto(List<Sistema> sistemas, List<SubMenu> subMenus) {
        this.sistemas = sistemas;
        this.subMenus = subMenus;
    }

    public List<Sistema> getSistemas() {
        return sistemas;
    }

    public void setSistemas(List<Sistema> sistemas) {
        this.sistemas = sistemas;
    }

    public List<SubMenu> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<SubMenu> subMenus) {
        this.subMenus = subMenus;
    }

    @Override
    public String toString() {
        return "MenuDto{" +
                "sistemas=" + sistemas +
                ", subMenus=" + subMenus +
                '}';
    }
}
