package cn.jbone.cms.portal.vo;

import lombok.Data;

import java.util.List;

@Data
public class SpecialTreeVo {
    private String text;
    private String href;
    private State state = new State();
    private List<SpecialTreeVo> nodes;

    @Data
    public static class State {
        Boolean checked = false;
        Boolean disabled = false;
        Boolean expanded = true;
        Boolean selected = false;
    }
}
