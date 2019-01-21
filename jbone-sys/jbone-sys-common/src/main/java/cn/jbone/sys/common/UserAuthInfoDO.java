package cn.jbone.sys.common;

import cn.jbone.sys.common.dto.response.MenuInfoResponseDTO;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class UserAuthInfoDO {
    private Set<String> permissions;
    private Set<String> roles;
    private List<MenuInfoResponseDTO> menus;
}
