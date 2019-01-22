package cn.jbone.sys.common;

import cn.jbone.sys.common.dto.response.MenuInfoResponseDTO;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
public class UserAuthInfoDO implements Serializable {
    private Set<String> permissions;
    private Set<String> roles;
    private List<MenuInfoResponseDTO> menus;
}
